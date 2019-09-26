package web.drh.controller;

import business.drh.model.Agence;
import business.drh.service.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.drh.controller.dto.agence.AgenceDto;
import web.drh.controller.dto.agence.AgenceMapper;
import web.drh.controller.dto.employe.EmployeMapper;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agence")
public class AgenceController {

    @Autowired
    private AgenceService agenceService;
    @Autowired
    private AgenceMapper agenceMapper;

    /**
     * findAll returning an Agence
     * GET
     * http://localhost:8080/agence/{id}
     */
    @GetMapping(path = "/{id}")
    public AgenceDto findById(@PathVariable Long id) {
        Optional<Agence> agence = agenceService.findById(id);
        if (!agence.isPresent()) {
            throw new EntityNotFoundException();
        }
        else {
        Agence agenceGet = agence.get();
            final AgenceDto retVal = agenceMapper.agenceToAAgenceDto(agenceGet);
            return (retVal);
        }
    }

    /**
     * findById returning a list of Agence
     * GET
     * http://localhost:8080/agence
     */
    @GetMapping
    public List<Agence> findAll() {
        List<Agence> retVal = agenceService.findAll();
        return retVal;
    }

}
