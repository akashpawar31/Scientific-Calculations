package com.example.scientific_calculator_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableAutoConfiguration
@EntityScan(basePackages =" com.example.scientific_calculator_spring.model")
@EnableJpaRepositories(basePackages = "com.example.scientific_calculator_spring.repository")
public class ScientificCalculatorSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScientificCalculatorSpringbootApplication.class, args);
		System.out.println("application started");
	}

}
