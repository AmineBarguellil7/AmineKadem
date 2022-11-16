package tn.esprit.aminekadem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepart;
    private String nomDepart;
    @OneToMany(mappedBy = "departement",cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants_depar;
}
