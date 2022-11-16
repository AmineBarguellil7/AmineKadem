package tn.esprit.aminekadem.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.aminekadem.entity.Departement;
import tn.esprit.aminekadem.entity.Universite;

import java.util.List;

public interface UniversiteRepository extends JpaRepository<Universite,Integer> {
}
