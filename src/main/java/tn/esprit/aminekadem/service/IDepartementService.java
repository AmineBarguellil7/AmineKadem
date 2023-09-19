package tn.esprit.aminekadem.service;

import tn.esprit.aminekadem.Generic.IGenericService;
import tn.esprit.aminekadem.entity.Departement;


import java.util.Set;

public interface IDepartementService extends IGenericService<Departement,Integer> {
    public void assignUniversiteToDepartement(Integer idUniversite, Integer
            idDepartement);

    public Set<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}
