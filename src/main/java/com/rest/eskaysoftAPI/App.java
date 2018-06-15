package com.rest.eskaysoftAPI;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaAuditing
@EnableAutoConfiguration
@EnableJpaRepositories("com.rest.eskaysoftAPI.dao")
@EntityScan(basePackages = "com.rest.eskaysoftAPI.entity")
public class App extends SpringBootServletInitializer {
	public static void main(String[] args) {
		new App().configure(new SpringApplicationBuilder(App.class)).run(args);
		//SpringApplication.run(App.class, args);
	}
}