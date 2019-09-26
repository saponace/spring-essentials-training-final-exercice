package business.drh.service;

import business.drh.model.Agence;

import java.util.List;
import java.util.Optional;

public interface AgenceService {
    List<Agence> findAll();

    Optional<Agence> findById(Long id);
}
