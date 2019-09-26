package web.drh.controller.dto.employewithsalaire;

import business.drh.model.Employe;
import business.drh.model.Salaire;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Only one-way mapper
 * from
 * business.drh.model.Employe.java + Set<Salaire>
 * into
 * EmployeWithSalaireDto + List<Salaire>
 * <p>
 */
@Mapper(componentModel = "spring")
public interface EmployeWithSalaireMapper {

    @Mappings({
        @Mapping(target = "salairesDto", source = "employe.salaires")
    })
    EmployeWithSalaireDto employeWithSalaireToEmployeWithSalaireDto(Employe employe);

    SalaireDto salaireToSalaireDto(Salaire salaire);
}
