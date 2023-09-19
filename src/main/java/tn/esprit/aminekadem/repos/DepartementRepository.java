package tn.esprit.aminekadem.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.aminekadem.entity.Departement;



public interface DepartementRepository extends JpaRepository<Departement,Integer> {
}
