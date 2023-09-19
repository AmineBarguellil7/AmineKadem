package tn.esprit.aminekadem.service;

import tn.esprit.aminekadem.Enum.Specialite;
import tn.esprit.aminekadem.Generic.IGenericService;
import tn.esprit.aminekadem.entity.Universite;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;


public interface IUniversiteService extends IGenericService<Universite,Integer> {
    Map<Specialite,Float> getMontantContartEntreDeuxDate(int idUniv, Date startDate, Date endDate);
}
