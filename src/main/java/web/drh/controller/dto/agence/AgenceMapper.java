package web.drh.controller.dto.agence;

import business.drh.model.Agence;
import business.drh.model.Employe;
import business.drh.model.Salaire;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import web.drh.controller.dto.employe.EmployeDto;
import web.drh.controller.dto.employewithsalaire.EmployeWithSalaireDto;
import web.drh.controller.dto.employewithsalaire.SalaireDto;

/**
 * Only one-way mapper
 * from
 * business.drh.model.Agence.java
 * to
 * AgenceDto
 */
@Mapper(componentModel = "spring")
public interface AgenceMapper {

    @Mappings({
            @Mapping(target = "employes", source = "agence.employes"),
    })
    AgenceDto agenceToAAgenceDto(Agence agence);
}

