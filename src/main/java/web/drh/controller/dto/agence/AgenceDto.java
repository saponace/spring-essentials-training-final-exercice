package web.drh.controller.dto.agence;

import web.drh.controller.dto.employewithsalaire.EmployeWithSalaireDto;

import java.util.List;

public class AgenceDto {

    private Long id;
    private int version;
    private String nom;
    private EmployeWithSalaireDto directeur;
    private List<EmployeWithSalaireDto> employes;

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

    public EmployeWithSalaireDto getDirecteur() {
        return directeur;
    }

    public void setDirecteur(EmployeWithSalaireDto directeur) {
        this.directeur = directeur;
    }

    public List<EmployeWithSalaireDto> getEmployes() {
        return employes;
    }

    public void setEmployes(List<EmployeWithSalaireDto> employes) {
        this.employes = employes;
    }
}
