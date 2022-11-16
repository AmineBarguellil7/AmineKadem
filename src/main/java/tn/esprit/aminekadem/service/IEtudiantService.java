package tn.esprit.aminekadem.service;

import tn.esprit.aminekadem.Generic.IGenericService;
import tn.esprit.aminekadem.entity.Etudiant;

import java.util.List;
import java.util.Set;

public interface IEtudiantService extends IGenericService<Etudiant,Integer> {
    public Etudiant assignEtudiantToDepartement (Integer etudiantId, Integer
            departementId) ;

    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat,
                                                     Integer idEquipe);

    Set<Etudiant> getEtudiantsByDepartement (Integer idDepartement);
}
