package tn.esprit.aminekadem.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.aminekadem.Generic.GenericController;
import tn.esprit.aminekadem.entity.Contrat;
import tn.esprit.aminekadem.service.IContratService;

import java.util.Date;


@RestController
@RequestMapping("/contrat")
public class ContratRestController extends GenericController<Contrat,Integer> {
    @Autowired
    IContratService contratService;


    @PutMapping("/assign/{nomE}/{prenomE}")
    public Contrat affectContratToEtudiant(@RequestBody Contrat ce, @PathVariable String nomE,@PathVariable String prenomE){
        return contratService.affectContratToEtudiant(ce,nomE,prenomE);
    }

    @GetMapping("/nbcontratsvalides")
    public int nbContratsValides(@RequestBody Date startDate,@RequestBody Date endDate){
        return contratService.nbContratsValides(startDate,endDate);
    }
}
