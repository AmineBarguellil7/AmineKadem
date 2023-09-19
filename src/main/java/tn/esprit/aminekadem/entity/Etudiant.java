package tn.esprit.aminekadem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.aminekadem.Enum.Option;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEtudiant;
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option option;
    @ManyToMany
    @JsonIgnore
    private Set<Equipe> equipe_etud;
    @ManyToOne
    @JsonIgnore
    private Departement departement;
    @OneToMany(mappedBy = "etudiantcontr",cascade = CascadeType.ALL)
    private Set<Contrat> contrat;
}
