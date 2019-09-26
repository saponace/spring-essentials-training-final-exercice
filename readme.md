## Using QueryDSL with custom extension
* with extension you can use joins with QueryDSL, look at business.drh.repository.testng.EmployeRepositoryTest_2_QueryDsl_extension
         
        JPQLQuery<?> query = employeRepository.createJPQLQuery();
        query.leftJoin(employe.salaires).fetchJoin();

        // ARRANGE
        BooleanExpression predicate = employe.nom.contains("to").and(employe.prenom.endsWith("_i"));
        PageRequest pageRequest = PageRequest.of(0, 5, Direction.DESC, "nom");

        // ACT
        // extension HERE ! it WORKS !!!
        Page<Employe> page = employeRepository.findAll(query, predicate, pageRequest);   
        

* install
    
        public interface EmployeRepository extends TworkQueryDslRepository<Employe, Long> {
 * config
  
        @SpringBootApplication
        @ComponentScan(basePackageClasses = {_Dao.class, _Service.class})
        @EnableJpaRepositories(basePackageClasses = _Repository.class, repositoryBaseClass = TworkQueryDslJpaRepositoryImpl.class)
        @EntityScan(basePackageClasses = _Model.class)
        @Import(
            {ChronoAspectConfig.class}
        )
public class BusinessConfig {}
     
* pom.xml 


        <dependency>
            <groupId>twork</groupId>
            <artifactId>twork-data-jpa-boot-2.0.x</artifactId>
            <version>0.5-SNAPSHOT</version>
        </dependency>
        
                           
## GOAL
* QueryD
