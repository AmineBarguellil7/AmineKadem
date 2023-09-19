package tn.esprit.aminekadem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.aminekadem.Enum.Specialite;
import tn.esprit.aminekadem.Generic.IGenericServiceImpl;
import tn.esprit.aminekadem.entity.Contrat;
import tn.esprit.aminekadem.entity.Departement;
import tn.esprit.aminekadem.entity.Universite;
import tn.esprit.aminekadem.repos.ContratRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UniversiteService  extends IGenericServiceImpl<Universite,Integer> implements IUniversiteService{

    @Autowired
    DepartementService departementService;
    @Autowired
    ContratRepository contratRepository;

    public List<Contrat> getContractsByDepartement(Departement departement) {
        return contratRepository.findByArchiveIsFalseAndEtudiantcontrDepartement(departement);
    }

    public Boolean isContractBetween(Contrat contrat, LocalDate startDate,LocalDate endDate) {
        // java.util.Date before&after
        if(contrat.getDateDebutContrat().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate().isAfter( startDate) && contrat.getDateFinContrat().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate().isBefore(endDate)
                || contrat.getDateFinContrat().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate().isAfter(startDate) && contrat.getDateFinContrat().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate().isBefore(endDate)
                || contrat.getDateDebutContrat().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate().isBefore(startDate) && contrat.getDateFinContrat().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate().isAfter(endDate) ){
            return true;
        }
        return false;
    }

    public long getMontantContract(Contrat contrat, Date startDate, Date endDate){

        long nbJoursContrat = ChronoUnit.DAYS.between(contrat.getDateDebutContrat().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate(), contrat.getDateFinContrat().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());
        long nbJoursBetweenDebutContratAndStartDate = ChronoUnit.DAYS.between((Temporal) startDate,contrat.getDateDebutContrat().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());
        long nbJoursBetweenFinContratAndEndDate = ChronoUnit.DAYS.between(contrat.getDateFinContrat().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate(),(Temporal) endDate);

        if(nbJoursBetweenDebutContratAndStartDate<0) nbJoursContrat -= Math.abs(nbJoursBetweenDebutContratAndStartDate);
        if(nbJoursBetweenFinContratAndEndDate<0) nbJoursContrat -= Math.abs(nbJoursBetweenFinContratAndEndDate);

        return nbJoursContrat>0 ? contrat.getMontantContrat() * nbJoursContrat/30 : 0;
    }
    @Override
    public Map<Specialite, Float> getMontantContartEntreDeuxDate(int idUniv, Date startDate, Date endDate) {
        // get all active contracts between the start and end date
        Set<Departement> departements = departementService.retrieveDepartementsByUniversite(idUniv);
        List<Contrat> contrats = departements.stream()
                .map(departement -> this.getContractsByDepartement(departement))
                .flatMap(List::stream)
                .filter(contrat -> contrat.getArchive().equals(false) && isContractBetween(contrat,startDate.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate(),endDate.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate()))
                .collect(Collectors.toList());

        // get price per sepcialite
        Map<Specialite, Float> map = new HashMap<>();
        if (!contrats.isEmpty()){
            for (Specialite specialite : Specialite.values()) {
                float price = contrats.stream()
                        .filter(contrat -> contrat.getSpecialite().equals(specialite))
                        .map(contrat -> getMontantContract(contrat,startDate,endDate))
                        .collect(Collectors.summarizingLong(Long::longValue))
                        .getSum();

                map.put(specialite,price);
            }
        }
        return map;
    }
}

