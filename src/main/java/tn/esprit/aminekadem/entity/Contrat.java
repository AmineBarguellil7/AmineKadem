package tn.esprit.aminekadem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import tn.esprit.aminekadem.Enum.Specialite;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer idContrat;
    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;
    @Temporal(TemporalType.DATE)
    private Date dateFinContrat;
    private Integer montantContrat;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private Boolean archive;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Etudiant etudiantcontr;
}
