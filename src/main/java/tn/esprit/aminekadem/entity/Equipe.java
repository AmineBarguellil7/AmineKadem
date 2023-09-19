package tn.esprit.aminekadem.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.aminekadem.Enum.Niveau;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    private int salle;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @ManyToMany(mappedBy = "equipe_etud")
    private Set<Etudiant> etudiants_equi;
    @OneToOne
    private DetailEquipe detailEquipe;
}
