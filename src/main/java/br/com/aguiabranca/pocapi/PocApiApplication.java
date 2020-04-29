package br.com.aguiabranca.pocapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.aguiabranca")
@EntityScan(basePackages = { "br.com.aguiabranca.model" })
@EnableJpaRepositories(basePackages = { "br.com.aguiabranca.repository" })
public class PocApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocApiApplication.class, args);
	}

}
