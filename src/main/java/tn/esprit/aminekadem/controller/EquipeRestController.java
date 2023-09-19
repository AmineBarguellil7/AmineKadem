package tn.esprit.aminekadem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.aminekadem.Generic.GenericController;
import tn.esprit.aminekadem.entity.Equipe;
import tn.esprit.aminekadem.service.EquipeService;

@RestController
@RequestMapping("/equipe")
public class EquipeRestController extends GenericController<Equipe,Integer> {


    @Autowired
    EquipeService equipeService;
    @PostMapping("/addEquipe")
    public Equipe addEquipe(@RequestBody Equipe equipe) {
        return equipeService.addEquipe(equipe);
    }
}
