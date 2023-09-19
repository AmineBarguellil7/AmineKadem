package tn.esprit.aminekadem.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.aminekadem.Generic.IGenericServiceImpl;
import tn.esprit.aminekadem.entity.Contrat;
import tn.esprit.aminekadem.entity.Departement;
import tn.esprit.aminekadem.entity.Equipe;
import tn.esprit.aminekadem.entity.Etudiant;
import tn.esprit.aminekadem.repos.ContratRepository;
import tn.esprit.aminekadem.repos.DepartementRepository;
import tn.esprit.aminekadem.repos.EquipeRepository;
import tn.esprit.aminekadem.repos.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class EtudiantService extends IGenericServiceImpl<Etudiant,Integer> implements IEtudiantService{

    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    DepartementRepository departementRepository;

    @Autowired
    ContratRepository contratRepository;

    @Autowired
    EquipeRepository equipeRepository;

    @Override
    public Etudiant assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
        /*recuperation des objets*/
        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElse(null);
        Departement departement = departementRepository.findById(departementId).orElse(null);
        /*verification*/
        if (etudiant != null && departement != null) {
            //traitement
            etudiant.setDepartement(departement);
            return etudiantRepository.save(etudiant);
        }
        return null;
    }

    @Transactional
    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Contrat contrat=contratRepository.findById(idContrat).orElse(null);
        Equipe equipe=equipeRepository.findById(idEquipe).orElse(null);
        if (contrat!=null && equipe!=null) {
            Etudiant etudiant=etudiantRepository.save(e);
            contrat.setEtudiantcontr(etudiant);
            if(etudiant.getEquipe_etud()!= null) {
                etudiant.getEquipe_etud().add(equipe);
            } else{
                Set<Equipe> equipe1 = new HashSet<>();
                equipe1.add(equipe);
                etudiant.setEquipe_etud(equipe1);
            }
            return etudiant;
        }
        return null;
    }

    @Override
    public Set<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
        return etudiantRepository.findByDepartementIdDepart(idDepartement);
    }
}
