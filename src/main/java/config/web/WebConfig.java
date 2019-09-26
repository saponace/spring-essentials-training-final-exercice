package config.web;

import config.business.BusinessConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import web.drh.controller._Controller;

// @Import
// @ComponentScan

// @SpringBootApplication

// @SpringBootConfiguration

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = {_Controller.class})
@Import(
    {
        BusinessConfig.class
    }
)
public class WebConfig implements WebMvcConfigurer {

}
