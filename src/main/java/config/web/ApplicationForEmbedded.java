package config.web;

import org.springframework.boot.SpringApplication;

/**
 * This is THE starting point for config with EMBEDDED deployment
 */
public class ApplicationForEmbedded {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(WebConfig.class);
        springApplication.setAdditionalProfiles("postgres");
        // springApplication.setAdditionalProfiles("h2");

        springApplication.run();
    }
}
