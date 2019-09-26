package business.drh.service;

import business.drh.model.Employe;

import java.util.List;
import java.util.Optional;

public interface EmployeService {
    void payerSalaire(Long employeId, int montant);

    Employe muter(Long employeId, Long agenceId);

    Optional<Employe> findById(Long idEmploye);

    Employe findbyIdFetchSalaires(Long idEmploye);

    List<Employe> findAll();

    Employe save(Employe employe);

    void delete(Employe employe);

    long deleteByIdAndVersion(Long id, int version);
}
