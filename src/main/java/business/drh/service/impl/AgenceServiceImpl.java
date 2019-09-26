package business.drh.service.impl;

import business.drh.model.Agence;
import business.drh.repository.AgenceRepository;
import business.drh.service.AgenceService;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AgenceServiceImpl implements AgenceService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AgenceRepository agenceRepository;

    @Override public List<Agence> findAll() {
        return agenceRepository.findAll();
    }

    @Override public Optional<Agence> findById(Long id) {
        final Optional<Agence> retVal = agenceRepository.findById(id);
        if(retVal.isPresent()) {
            Agence retValGet = retVal.get();
            // Manually load lazily-initialized employes
            Hibernate.initialize(retValGet.getEmployes());
            return Optional.of(retValGet);
        }
        else
            return Optional.empty();
    }
}
