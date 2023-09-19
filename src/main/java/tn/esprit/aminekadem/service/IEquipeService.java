package tn.esprit.aminekadem.service;

import tn.esprit.aminekadem.Generic.IGenericService;
import tn.esprit.aminekadem.entity.Equipe;

public interface IEquipeService extends IGenericService<Equipe,Integer> {
    Equipe addEquipe(Equipe e);
}
