package business.drh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employe {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    @Version
    private int version;

    @Length(min = 3)
    private String nom;

    private String prenom;

    @JsonIgnore
    @OneToMany(mappedBy = "employe")
    private Set<Salaire> salaires = new HashSet<Salaire>();

    @JsonIgnore
    @JoinColumn(nullable = false, updatable = false, insertable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Agence agence;

    @Column(name = "agence_id")
    private Long agenceId;


    public Employe() {
    }

    public Employe(String nom, String prenom) {
        super();
        this.nom = nom;
        this.prenom = prenom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Set<Salaire> getSalaires() {
        return salaires;
    }

    public void setSalaires(Set<Salaire> salaires) {
        this.salaires = salaires;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
        if (agence != null) {
            this.agenceId = agence.getId();
        }
    }

    public Long getAgenceId() {
        return agenceId;
    }

    public void setAgenceId(Long agenceId) {
        this.agenceId = agenceId;
    }

    @Override public String toString() {
        return "Employe{" + "id=" + id + ", version=" + version + ", nom='" + nom + '\'' + ", prenom='" + prenom + '\''
                + ", salaires=" + salaires + ", agence=" + agence + ", agenceId=" + agenceId + '}';
    }
}
