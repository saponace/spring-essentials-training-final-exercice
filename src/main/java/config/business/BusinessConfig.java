package config.business;

import bpp.DebugBpp;
import business.drh.model._Model;
import business.drh.repository._Repository;
import business.drh.service._Service;
import config.aspect.AspectsConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = {_Service.class})
@EnableJpaRepositories(basePackageClasses = _Repository.class)
@EntityScan(basePackageClasses = _Model.class)
@Import(
    { AspectsConfig.class}
)
public class BusinessConfig {

    @Bean
    DebugBpp debugBpp() {
        return new DebugBpp();
    }

}


