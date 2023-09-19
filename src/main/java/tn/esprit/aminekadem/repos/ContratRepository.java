package tn.esprit.aminekadem.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.aminekadem.entity.Contrat;
import tn.esprit.aminekadem.entity.Departement;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface ContratRepository extends JpaRepository<Contrat,Integer> {
    List<Contrat> findByArchiveIsFalse();

    List<Contrat> findByArchiveIsFalseAndDateFinContrat(LocalDate localDate);
    List<Contrat> findByArchiveIsFalseAndEtudiantcontrDepartement(Departement departement);

    Integer countByArchiveIsFalseAndDateDebutContratAfterAndDateFinContratBefore(Date startDate, Date endDate);
}
