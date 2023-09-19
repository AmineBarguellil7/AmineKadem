package tn.esprit.aminekadem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.aminekadem.Enum.Specialite;
import tn.esprit.aminekadem.Generic.GenericController;
import tn.esprit.aminekadem.entity.Universite;
import tn.esprit.aminekadem.service.IUniversiteService;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/universite")
public class UniversiteRestController extends GenericController<Universite,Integer> {
    @Autowired
    IUniversiteService universiteService;
    @GetMapping("/{idUniv}/{startDate}/{endDate}")
    public Map<Specialite,Float> getMontantContartEntreDeuxDate(@PathVariable int idUniv,
                                                                @PathVariable @DateTimeFormat(pattern ="yyyy-MM-dd") Date startDate,
                                                                @PathVariable @DateTimeFormat(pattern ="yyyy-MM-dd") Date endDate){
        return universiteService.getMontantContartEntreDeuxDate(idUniv,startDate,endDate);
    }

}
