package br.com.livraria;

import br.com.livraria.principal.Principal;
import br.com.livraria.repository.AutorRepositorio;
import br.com.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivrariaApplication implements CommandLineRunner {

	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private AutorRepositorio autorRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(livroRepository,autorRepositorio);
		principal.exibirPainel();
	}
}
