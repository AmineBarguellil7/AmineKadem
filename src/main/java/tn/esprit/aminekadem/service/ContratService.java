package tn.esprit.aminekadem.service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.aminekadem.Generic.IGenericServiceImpl;
import tn.esprit.aminekadem.Util.HelperClass;
import tn.esprit.aminekadem.entity.Contrat;
import tn.esprit.aminekadem.entity.Etudiant;
import tn.esprit.aminekadem.repos.ContratRepository;
import tn.esprit.aminekadem.repos.EtudiantRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


@Slf4j
@Service
public class ContratService extends IGenericServiceImpl<Contrat,Integer> implements IContratService{


    @Autowired
    ContratRepository contratRepository;
    @Autowired
    EtudiantRepository etudiantRepository;


    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        log.info("affectation avec succes");
        log.debug("This is Debug Test");
        Etudiant e=etudiantRepository.findByNomEAndPrenomE(nomE,prenomE);
        int nbrContratActifs=0;
        if(e!=null){
            for (Contrat c : e.getContrat()){
                if (c.getArchive().equals(false)) {
                    nbrContratActifs++;
                }
            }
            if(nbrContratActifs<5){
                ce.setEtudiantcontr(e);
            }
        }
        return contratRepository.save(ce);
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        /*List<Contrat> contrats=contratRepository.findAll();
        int i=0;
        for (Contrat c:contrats) {
            if ((c.getDateDebutContrat().after(startDate) && c.getDateDebutContrat().before(endDate)) &&
            (c.getDateFinContrat().after(startDate) && c.getDateFinContrat().before(endDate)))
            {
                if (!c.getArchive()) {
                 i++;
                }
            }
        }
        return i;*/
        log.info("IN method nbContratsValides");
        Integer var = contratRepository.countByArchiveIsFalseAndDateDebutContratAfterAndDateFinContratBefore(startDate,endDate);
        log.info("out of method nbContratsValides");
        return var;
    }


    @Transactional
    public void archiveAllExpiredContracts() {
        contratRepository.findByArchiveIsFalseAndDateFinContrat(LocalDate.now()).stream().forEach(contrat -> contrat.setArchive(true));
    }

    @Override
    public void retrieveAndUpdateStatusContrat() {
        this.archiveAllExpiredContracts();
        contratRepository.findByArchiveIsFalse().stream().filter(contrat -> HelperClass.getDate(LocalDate.now(),contrat.getDateFinContrat().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate())<16).forEach(
             contrat -> System.out.println("le contrat de l'etudiant "+contrat.getEtudiantcontr().getNomE()+" va expirer")
        );
    }
}
