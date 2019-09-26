package web.drh.controller.dto.employe;

import business.drh.model.Employe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Only one-way mapper
 * from
 * business.drh.model.Employe.java
 * to
 * EmployeDto
 * <p>
 * Since the DTO does not contain the salaires field => MapStuct does not generate the copy of that field
 */
@Mapper(componentModel = "spring")
public interface EmployeMapper {

    // Also works OK, but not necessary for out business case
    @Mappings({
            @Mapping(target = "id", source = "employe.id"),
            @Mapping(target = "version", source = "employe.version"),
            @Mapping(target = "nom", source = "employe.nom"),
            @Mapping(target = "prenom", source = "employe.prenom"),
    })
    EmployeDto employeToEmployeDto(Employe employe);

}
