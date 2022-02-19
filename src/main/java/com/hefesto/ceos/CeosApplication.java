package com.hefesto.ceos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CeosApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(CeosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
