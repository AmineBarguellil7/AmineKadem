package tn.esprit.aminekadem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.aminekadem.Generic.GenericController;
import tn.esprit.aminekadem.entity.Etudiant;
import tn.esprit.aminekadem.service.IEtudiantService;

import java.util.Set;

@RestController
@RequestMapping("/etudiant")
public class EtudiantRestController extends GenericController<Etudiant,Integer> {
    @Autowired
    IEtudiantService etudiantService;

    @GetMapping("/assign/{etudiantId}/{departementId}")
    public Etudiant assignEtudiantToDepartement(@PathVariable Integer etudiantId, @PathVariable Integer departementId){
        return this.etudiantService.assignEtudiantToDepartement(etudiantId,departementId);
    }

    @PostMapping("/assignetud/{idContrat}/{idEquipe}")
    public Etudiant AssignEtudiantToEquipeAndContrat(@RequestBody Etudiant e , @PathVariable Integer idContrat , @PathVariable Integer idEquipe) {
        return etudiantService.addAndAssignEtudiantToEquipeAndContract(e, idContrat, idEquipe);
    }
    @GetMapping("etudBydep/{idDepartment}")
    public Set<Etudiant> findEtudByDep(@PathVariable int idDepartment){
        return etudiantService.getEtudiantsByDepartement(idDepartment);
    }


}
