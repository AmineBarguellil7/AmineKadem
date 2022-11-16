package tn.esprit.aminekadem.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.aminekadem.entity.Etudiant;

import java.util.Set;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {
    Set<Etudiant> findByDepartementIdDepart(Integer id);
    Etudiant findByNomEAndPrenomE(String nomE,String PrenomE);
}
