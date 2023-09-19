package tn.esprit.aminekadem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.aminekadem.Generic.IGenericServiceImpl;
import tn.esprit.aminekadem.entity.DetailEquipe;
import tn.esprit.aminekadem.entity.Equipe;
import tn.esprit.aminekadem.repos.DetailEquipeRepository;
import tn.esprit.aminekadem.repos.EquipeRepository;



@Service
public class EquipeService extends IGenericServiceImpl<Equipe,Integer> implements IEquipeService{

    @Autowired
    EquipeRepository equipeRepository;
    @Autowired
    DetailEquipeRepository detailEquipeRepository;
    @Override
    public Equipe addEquipe(Equipe e) {
        DetailEquipe detailEquipe=new DetailEquipe();
        detailEquipeRepository.save(detailEquipe);
        e.setDetailEquipe(detailEquipe);
        equipeRepository.save(e);
        return e;
    }
}
