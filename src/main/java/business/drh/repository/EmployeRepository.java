package business.drh.repository;

import business.drh.model.Employe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// public interface EmployeRepository extends JpaRepository<Employe, Long>, QuerydslPredicateExecutor<Employe> {
public interface EmployeRepository extends JpaRepository<Employe, Long> {

    List<Employe> findByNomContaining(String nom);

    Page<Employe> findByNomStartingWith(String nom, Pageable pageable);

    @Modifying
    @Transactional
    long deleteByIdAndVersion(Long id, int version);

    @Query("select e from Employe as e left join fetch e.salaires where  e.id=:id")
    Employe findbyIdFetchSalaires(@Param("id") Long id);

    Employe findByNomAndPrenom(String nom, String prenom);

    @Query("select e from Employe e where e.nom like %:nom%")
    List<Employe> findByMyOwnCustomQuery(@Param("nom") String nom);

    @Query(value = "select e from Employe e where e.nom like %:nom")
    Page<Employe> findByMyOwnCustomQuery(@Param("nom") String nom, Pageable _pageable);

    List<Employe> findDistinctEmployeByNomIgnoreCaseOrPrenomLike(String nom, String prenom);

    Page<Employe> findByNomContainsIgnoreCase(String _nom, Pageable _pageable);

    @Query("select c from Employe c where upper(c.nom) like %:nom%")
    Page<Employe> findByNomCustom(@Param("nom") String _nom, Pageable _pageable);

}


