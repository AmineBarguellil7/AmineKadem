package tn.esprit.aminekadem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.aminekadem.Generic.GenericController;
import tn.esprit.aminekadem.entity.Equipe;

@RestController
@RequestMapping("/equipe")
public class EquipeRestController extends GenericController<Equipe,Integer> {
}
