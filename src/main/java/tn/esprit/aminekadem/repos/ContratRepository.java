package tn.esprit.aminekadem.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.aminekadem.entity.Contrat;


public interface ContratRepository extends JpaRepository<Contrat,Integer> {
}
