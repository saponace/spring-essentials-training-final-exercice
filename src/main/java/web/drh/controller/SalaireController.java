package web.drh.controller;

import business.drh.model.Salaire;
import business.drh.service.SalaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/salaire")
public class SalaireController {

    private @Autowired SalaireService salaireService;

    /**
     * http://localhost:8080/salaire/forEmployeId/-250
     * OK returns 2 Salaires
     * http://localhost:8080/salaire/forEmployeId/-ttttt280
     * => KO 400 BAD_REQUEST
     * because :
     * MethodArgumentTypeMismatchException =>
     * NumberFormatException: For input string: "-ttttt280"
     * BUT we don't have ant message YET
     * Customize the MyGlobalExceptionHandler to return a message in taht case
     * <p>
     * salaire.employe are stil proxy => so not serialized by Jacskson Module
     * But you can't remove easily the "employe": null ... Jackson is not very flexible.
     */
    @GetMapping(path = "/forEmployeId/{idEmploye}")
    public List<Salaire> findById(@PathVariable Long idEmploye) {
        List<Salaire> salaires = salaireService.findSalairesByEmployeId(idEmploye);
        return salaires;
    }

}
