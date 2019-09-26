package business.drh.service.impl;

import business.drh.model.Agence;
import business.drh.model.Employe;
import business.drh.model.Salaire;
import business.drh.repository.EmployeRepository;
import business.drh.repository.SalaireRepository;
import business.drh.service.AgenceService;
import business.drh.service.EmployeService;
import business.drh.service.SalaireService;
import org.hibernate.action.internal.EntityActionVetoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeServiceImpl implements EmployeService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * alaire verse en cas de mutation
     * Recupere depuis la config
     */
    @Value("${salaire.salaire-mutation}")
    private int salaireMutation;

    @Autowired
    private AgenceService agenceService;
    @Autowired
    private SalaireService salaireService;
    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public void payerSalaire(Long employeId, int montant) {
        logger.info("IN idEmploye = " + employeId + " montant = " + montant);

        Optional<Employe> employeOptional = employeRepository.findById(employeId);
        if (!employeOptional.isPresent()) {
            throw new RuntimeException("L'id  de l'employé: " + employeId + " n'existe pas en bd");
        }
        Salaire salaire = new Salaire(montant);
        salaire.setEmploye(employeOptional.get());
        salaireService.save(salaire);
        logger.info("OUT");
    }

    @Override
    public Optional<Employe> findById(Long idEmploye) {
        return employeRepository.findById(idEmploye);
    }

    @Override public Employe findbyIdFetchSalaires(Long idEmploye) {
        return employeRepository.findbyIdFetchSalaires(idEmploye);
    }

    @Override public List<Employe> findAll() {
        return employeRepository.findAll();
    }

    @Override public Employe save(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override public void delete(Employe employe) {
        employeRepository.delete(employe);

    }

    @Override public long deleteByIdAndVersion(Long id, int version) {
        return employeRepository.deleteByIdAndVersion(id, version);
    }

    @Override
    public Employe muter(Long employeId, Long agenceId){
        Optional<Agence> nouvelleAgence = agenceService.findById(agenceId);
        Optional<Employe> employe = findById(employeId);
        if (nouvelleAgence.isPresent() && employe.isPresent()) {
            Employe employeGet = employe.get();
            employeGet.setAgence(nouvelleAgence.get());
            payerSalaire(employeGet.getId(), salaireMutation);
            return employeGet;
        }
        else {
            throw new EntityNotFoundException("Employe " + employeId + " or agence " + agenceId + " does not exist");
        }

    }

}
