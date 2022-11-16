package tn.esprit.aminekadem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.aminekadem.Generic.GenericController;
import tn.esprit.aminekadem.entity.Departement;
import tn.esprit.aminekadem.service.IDepartementService;

import java.util.Set;

@RestController
@RequestMapping("/departement")
public class DepartementRestController extends GenericController<Departement,Integer> {

    @Autowired
    IDepartementService iDepartementService;

    @PostMapping("/assign/{idUniversite}/{idDepartement}")
    public void addAndAssignDepartement(@PathVariable int idUniversite, @PathVariable int idDepartement) {
        iDepartementService.assignUniversiteToDepartement(idUniversite,idDepartement);
    }
    @GetMapping("/retrieveDepByUniv/{idUniversity}")
    public Set<Departement> retrieveDepartementByUniversity(@PathVariable Integer idUniversity){
        return iDepartementService.retrieveDepartementsByUniversite(idUniversity);
    }


}
