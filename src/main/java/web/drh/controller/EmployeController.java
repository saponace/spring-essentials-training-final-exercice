package web.drh.controller;

import business.drh.service.EmployeService;
import web.drh.controller.annotation.Secured;
import business.drh.model.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import web.drh.controller.dto.employe.EmployeMapper;
import web.drh.controller.dto.employewithsalaire.EmployeWithSalaireDto;
import web.drh.controller.dto.employewithsalaire.EmployeWithSalaireMapper;
import web.drh.controller.dto.employe.EmployeDto;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employe")
public class EmployeController {

    @Autowired
    private EmployeService employeService;
    @Autowired
    private EmployeMapper employeMapper;
    @Autowired
    private EmployeWithSalaireMapper employeWithSalaireMapper;

    /**
     * findById eturning an Entity Employe as-is
     * So potential pb with lazy init and Jackson.
     * It depends on configuration.
     * <p>
     * GET
     * http://localhost:8080/entity/employe/-200
     * http://localhost:8080/entity/employe/-250
     */
    @GetMapping(path = "/entity/{idEmploye}")
    public Employe findById(@PathVariable Long idEmploye) {
        Optional<Employe> employe = employeService.findById(idEmploye);
        if (!employe.isPresent()) {
            throw new EntityNotFoundException();
        }
        return employe.get();
    }

    /**
     * findById returning an EmployeDto
     * GET
     * http://localhost:8080/employe/{idEmploye}
     */
    @GetMapping(path = "/{idEmploye}")
    public EmployeDto findByIdDto(@PathVariable Long idEmploye) {
        Optional<Employe> employeOptional = employeService.findById(idEmploye);
        if (!employeOptional.isPresent()) {
            throw new EntityNotFoundException();
        }
        EmployeDto employeDto = employeMapper.employeToEmployeDto(employeOptional.get());
        return employeDto;
    }

    /**
     * findById returning an EmployeDto
     * GET
     * http://localhost:8080/employe/with-salaires/{idEmploye}
     */
    @GetMapping(path = "/with-salaires/{idEmploye}")
    public EmployeWithSalaireDto findByIdWithSalaireDto(@PathVariable Long idEmploye) {
        Employe employe = employeService.findbyIdFetchSalaires(idEmploye);
        if (employe == null) {
            throw new EntityNotFoundException();
        }
        EmployeWithSalaireDto employeDto = employeWithSalaireMapper.employeWithSalaireToEmployeWithSalaireDto(employe);
        return employeDto;
    }

    /**
     * findAll returning an EmployeFindAllDto
     * GET
     * http://localhost:8080/repo/employe
     *
     * @return
     */
    @GetMapping()
    public List<EmployeDto> findAllDto(HttpServletRequest request) {
        List<Employe> employes = employeService.findAll();
        List<EmployeDto> retVal = employes.stream()
                .map(e -> employeMapper.employeToEmployeDto(e))
                .collect(Collectors.toList());
        return retVal;
    }

    /**
     * create
     * POST
     * http://localhost:8080/employe
     * <p>
     * If no Exception => status=201 (CREATED)
     * But with
     * If id!=null => I would like a BAD_REQUEST (400)
     * But @Repository generates an INSERT
     */
    @Secured
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employe create(@RequestBody @Valid Employe employe) {
        Employe retVal = employeService.save(employe);
        return retVal;

    }

    /**
     * update
     * PUT
     * http://localhost:8080/employe
     * But with
     * If id==null => SERVER_ERROR(500) I would rather have a BAD_REQUEST (400)
     * For
     * employe.id/version not found => I would like a 404 with a nice message.
     * Here it just creates a new Entity, so beware !
     */
    @Secured
    @PutMapping
    public Employe update(@RequestBody Employe employe) {
        if (employe.getId() == null) {
            throw new RuntimeException("id should not be null for an ENTITY update");
        }
        Employe retVal = employeService.save(employe);
        return retVal;
    }

    /**
     * delete
     * DELETE
     * http://localhost:8080/employe
     * <p>
     * If id==null => silent return + insert+delete SQLs ... not fantastic!
     * If employe.id/version not found => if it is just a version mismatch => OptimistLockFailure
     * If employe.id/version not found => if it is an id nof found => silent return + insert+delete SQLs ... not
     * fantastic!
     * I would prefer:
     * If id==null => BAD_REQUEST (400)
     * If employe.id/version not found => 404
     */
    @Secured
    @DeleteMapping
    public void delete(@RequestBody Employe employe) {
        employeService.delete(employe);
    }

    @Secured
    @DeleteMapping("/{id}/{version}")
    public long delete(@PathVariable Long id, @PathVariable int version) {
        return employeService.deleteByIdAndVersion(id, version);
    }

}
