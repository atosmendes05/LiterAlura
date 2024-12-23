package br.com.livraria.model;

import com.fasterxml.jackson.annotation.JsonAlias;
public record DadosAutor(@JsonAlias("name") String nome,
                         @JsonAlias("birth_year") int anoNascimento,
                         @JsonAlias("death_year") int anoFalecimento) {
}
