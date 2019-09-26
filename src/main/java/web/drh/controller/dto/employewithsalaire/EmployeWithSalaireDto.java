package web.drh.controller.dto.employewithsalaire;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

public class EmployeWithSalaireDto {

    private Long id;
    private int version;
    private String nom;
    private String prenom;
    private Set<SalaireDto> salaireDto = new HashSet<>();

    @JsonProperty("salaires")
    public Set<SalaireDto> getSalairesDto() {
        return salaireDto;
    }

    public void setSalairesDto(Set<SalaireDto> salairesDto) {
        this.salaireDto = salairesDto;
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

}
