package web.drh.controller.dto.employewithsalaire;

public class SalaireDto {

    private Long id;
    private int montant;
    private int version;

    public SalaireDto() {
    }

    public SalaireDto(int montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "SalaireDto [id=" + id + ", version=" + version + ", montant=" + montant + ", version=" + version + "]";
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
