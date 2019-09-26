package business.drh.service;

import business.drh.model.Salaire;

import java.util.List;

public interface SalaireService {
    List<Salaire> findSalairesByEmployeId(Long idEmploye);

    void save(Salaire salaire);
}
