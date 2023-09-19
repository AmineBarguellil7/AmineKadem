package tn.esprit.aminekadem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.aminekadem.Generic.IGenericServiceImpl;
import tn.esprit.aminekadem.entity.Departement;
import tn.esprit.aminekadem.entity.Universite;
import tn.esprit.aminekadem.repos.DepartementRepository;
import tn.esprit.aminekadem.repos.UniversiteRepository;


import java.util.Set;


@Service
public class DepartementService extends IGenericServiceImpl<Departement,Integer> implements IDepartementService{

    @Autowired
    UniversiteRepository universiteRepository;

    @Autowired
    DepartementRepository departementRepository;





    @Override
    public Set<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite universite=universiteRepository.findById(idUniversite).orElse(null);
        if(universite!=null){
            return  universite.getDepartements();
        }
        return null;
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite universite= universiteRepository.findById(idUniversite).orElse(null);
        Departement departement= departementRepository.findById(idDepartement).orElse(null);
        if(universite !=null && departement!=null){
            universite.getDepartements().add(departement);
            universiteRepository.save(universite);
        }
    }
}
