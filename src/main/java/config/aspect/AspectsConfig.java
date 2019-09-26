package config.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AspectsConfig {

    @Bean
    ChronoAspect chronoAspect() {
        return new ChronoAspect();
    }

    @Bean
    SecurityAspect securityAspect() {
        return new SecurityAspect();
    }

}
