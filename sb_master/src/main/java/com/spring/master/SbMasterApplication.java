package com.spring.master;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SbMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMasterApplication.class, args);
		System.out.println("\n*\n *\n  *\n   *");
	}

	@Bean
	public CommandLineRunner printJavaVersion() {
		return args -> {
			String javaVersion = System.getProperty("java.version");
			System.out.println("\n#############################\n");
			System.out.println("JAVA VERSION: " + javaVersion);
			System.out.println("\n#############################\n");
		};
	}

}
