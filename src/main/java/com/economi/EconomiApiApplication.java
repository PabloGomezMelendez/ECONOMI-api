package com.economi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication(scanBasePackages = "com.economi")
@EnableJdbcRepositories(basePackages = "com.economi.repositorio")
@EntityScan(basePackages = "com.economi.modelo")
public class EconomiApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(EconomiApiApplication.class, args);
	}
}
