package tn.esprit.aminekadem.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.aminekadem.Generic.IGenericServiceImpl;
import tn.esprit.aminekadem.entity.Contrat;
import tn.esprit.aminekadem.entity.Etudiant;
import tn.esprit.aminekadem.repos.ContratRepository;
import tn.esprit.aminekadem.repos.EtudiantRepository;

import java.util.Date;
import java.util.List;


@Service
public class ContratService extends IGenericServiceImpl<Contrat,Integer> implements IContratService{


    @Autowired
    ContratRepository contratRepository;
    @Autowired
    EtudiantRepository etudiantRepository;


    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant e=etudiantRepository.findByNomEAndPrenomE(nomE,prenomE);
        int nbrContratActifs=0;
        if(e!=null){
            for (Contrat c : e.getContrat()){
                if (c.getArchive().equals(false)) {
                    nbrContratActifs++;
                }
            }
            if(nbrContratActifs<5){
                ce.setEtudiant_contr(e);
            }
        }
        return contratRepository.save(ce);
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        List<Contrat> contrats=contratRepository.findAll();
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
        return i;
    }

    @Override
    public float montantApayerEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> contrats = contratRepository.findAll();
        long diff = endDate.getTime() - startDate.getTime(); //ms
        double chiffreAffaire =0 ;
        for (Contrat c : contrats) {
            if (!c.getArchive()) {
                if ((c.getDateDebutContrat().before(startDate)) && (c.getDateFinContrat().after(endDate))) {
                    double diffMois = diff / (1000 * 60 * 60 * 24 * 30);
                    switch (c.getSpecialite()) {
                        case IA:
                            chiffreAffaire =+ diffMois * 300;
                            break;
                        case RESEAUX:
                            chiffreAffaire =+ diffMois * 350;
                            break;
                        case CLOUD:
                            chiffreAffaire =+ diffMois * 400;
                            break;
                        case SECURITE:
                            chiffreAffaire =+ diffMois * 450;
                            break;
                    }
                    return (float) chiffreAffaire;
                }
            }
        }
        return (float) chiffreAffaire;
    }
}
