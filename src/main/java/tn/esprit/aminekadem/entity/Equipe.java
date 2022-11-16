package tn.esprit.aminekadem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.aminekadem.Enum.Niveau;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @ManyToMany(mappedBy = "equipe_etud")
    @JsonIgnore
    private Set<Etudiant> etudiants_equi;
    @OneToOne(mappedBy = "equipe_detail")
    private DetailEquipe detailEquipe;
}
