package config.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
// import org.springframework.boot.web.support.SpringBootServletInitializer;
// import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * This is THE starting point for config with TOMCAT WAR deployment
 * <p>
 * Thss class scans automatically all COnfiguration files inside this package :
 * So : BootedDebugFilterInit and WebConfig are automatically imported.
 * <p>
 * I can't do that for BOTH configuration starting poins (ie ApplicationForWar and ApplicationForEmbedded)
 * because they would import each other ...
 * So ApplicationForEmbedded does the import explicitely (it is cleaner) through WebConfig
 */
@SpringBootApplication
public class ApplicationForWar extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // Customize the application or call application.sources(...) to add sources
        // ConfigurableApplicationContext context = application.context(); => KO context is null here
        SpringApplication application = builder.build();
        // application.setAdditionalProfiles("h2");
        application.setAdditionalProfiles("postgres");
        return builder;
    }
}
