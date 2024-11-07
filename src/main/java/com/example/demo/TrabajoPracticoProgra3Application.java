package com.example.demo;

import org.neo4j.cypherdsl.core.renderer.Configuration;
import org.neo4j.cypherdsl.core.renderer.Dialect;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.GraphDatabase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories
public class TrabajoPracticoProgra3Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TrabajoPracticoProgra3Application.class, args);
	}

	@Bean
	Configuration cypherDslConfiguration() {
		return Configuration.newConfig().withDialect(Dialect.NEO4J_5).build();
	}

	@Override
	public void run(String... args) throws Exception {
		try (var driver = GraphDatabase.driver("bolt://localhost:7687",
				AuthTokens.basic("neo4j",
						"programacion3"))) {
			driver.verifyConnectivity();
			System.out.println("Connection established.");
		}
	}
}
