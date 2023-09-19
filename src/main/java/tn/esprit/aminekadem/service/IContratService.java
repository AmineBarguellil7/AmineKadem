package tn.esprit.aminekadem.service;

import tn.esprit.aminekadem.Generic.IGenericService;
import tn.esprit.aminekadem.entity.Contrat;

import java.time.LocalDate;
import java.util.Date;


public interface IContratService extends IGenericService<Contrat,Integer> {
    Contrat affectContratToEtudiant(Contrat ce,String nomE,String prenomE);

    Integer nbContratsValides(Date startDate, Date endDate);

    void retrieveAndUpdateStatusContrat();
}
