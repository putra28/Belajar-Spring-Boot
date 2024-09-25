package com.retiel_restfulapi.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.retiel_restfulapi.restapi.repository")
@SpringBootApplication(scanBasePackages = "com.retiel_restfulapi.restapi")
public class RestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

}
