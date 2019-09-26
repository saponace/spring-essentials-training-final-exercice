package business.drh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Agence {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    @Version
    private int version;

    private String nom;

    @OneToOne
    @JoinColumn(nullable = false, updatable = false, insertable = false)
    private Employe directeur;

    @JsonIgnore
    @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
    private List<Employe> employes = new ArrayList<>();

    public Agence() {
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

    public Employe getDirecteur() {
        return directeur;
    }

    public void setDirecteur(Employe directeur) {
        this.directeur = directeur;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    @Override public String toString() {
        return "Agence{" + "id=" + id + ", version=" + version + ", nom='" + nom + '\'' + ", directeur=" + directeur
                + ", employes=" + employes + '}';
    }
}
