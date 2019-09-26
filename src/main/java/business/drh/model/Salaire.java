package business.drh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Salaire {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    @Version
    private int version;

    private int montant;

    private String seuilImposition;

    @JsonIgnore
    @JoinColumn(nullable = false, updatable = false, insertable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Employe employe;

    @Column(name = "employe_id")
    private Long employeId;

    public Salaire() {
    }

    public Salaire(int montant) {
        this.montant = montant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
        if (employe != null) {
            this.employeId = employe.getId();
        }
    }

    public Long getEmployeId() {
        return employeId;
    }

    public void setEmployeId(Long employeId) {
        this.employeId = employeId;
    }

    public String getSeuilImposition() {
        return seuilImposition;
    }

    public void setSeuilImposition(String seuilImposition) {
        this.seuilImposition = seuilImposition;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override public String toString() {
        return "Salaire{" + "id=" + id + ", version=" + version + ", montant=" + montant + ", seuilImposition="
                + seuilImposition + ", employe=" + employe + ", employeId=" + employeId + '}';
    }
}
