package business.drh.service.impl;

import business.drh.model.Salaire;
import business.drh.repository.SalaireRepository;
import business.drh.service.SalaireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@ConfigurationProperties(prefix = "salaire")
public class SalaireServiceImpl implements SalaireService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SalaireRepository salaireRepository;

    /**
     * Montant Max autorisé
     * Recupere depuis la config
     */
    private int montantMax;

    @Override
    public void save(Salaire salaire) {
        if (salaire.getMontant() > montantMax) {
            throw new RuntimeException("Le montant " + salaire.getMontant() + " ne doit pas dépasser:" + montantMax);
        }
        else {
            salaireRepository.save(salaire);
        }
    }

    public List<Salaire> findSalairesByEmployeId(Long idEmploye) {
        return salaireRepository.findSalairesByEmployeId(idEmploye);
    }

    public int getMontantMax() {
        return montantMax;
    }

    public void setMontantMax(int montantMax) {
        this.montantMax = montantMax;
    }
}
