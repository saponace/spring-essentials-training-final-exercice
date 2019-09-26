package business.drh.repository;

import business.drh.model.Salaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaireRepository extends JpaRepository<Salaire, Long> {

    List<Salaire> findSalairesByEmployeId(Long idEmploye);
}
