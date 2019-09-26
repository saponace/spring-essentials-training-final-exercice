package config;

import business.drh.model.Employe;
import business.drh.service.EmployeService;
import config.business.BusinessConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        // ConfigurableApplicationContext context = SpringApplication.run(BusinessConfig.class, args);

        // using WebConfig is not needed for http://localhost:8080/h2-console
        // since by default tomcat is launched
        // SpringApplication springApplication = new SpringApplication(WebConfig.class);
        SpringApplication springApplication = new SpringApplication(BusinessConfig.class);
         springApplication.setAdditionalProfiles("postgres");
        // springApplication.setAdditionalProfiles("h2");

        // to stop Tomcat
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("spring.main.web-application-type", "none");
        springApplication.setDefaultProperties(map);

        ConfigurableApplicationContext context = springApplication.run();
        EmployeService employeService = context.getBean(EmployeService.class);

        employeService.payerSalaire(1L, 734);

        // do not close the context, if you want to access the H2-Console on http://localhost:8080/h2-console
        //context.close();
    }
}
