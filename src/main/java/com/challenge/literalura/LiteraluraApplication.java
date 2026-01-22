package com.challenge.literalura;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.challenge.literalura.Principal.Principal;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	private final Principal principal;

	public LiteraluraApplication(Principal principal) {
		this.principal = principal;
	}
	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		principal.iniciar();
		
	}
}
