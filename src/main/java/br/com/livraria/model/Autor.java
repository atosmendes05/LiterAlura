package br.com.livraria.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    private int anoNascimento;

    private int anoFalecimento;

    @OneToMany(mappedBy = "autor" ,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livro> livros = new ArrayList<>();

    public Autor(){}
    public Autor (DadosAutor dadosAutor){
        this.nome = dadosAutor.nome();
        this.anoNascimento = dadosAutor.anoNascimento();
        this.anoFalecimento = dadosAutor.anoFalecimento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public int getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(int anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        String tituloLivros  = livros.stream()
                .map(Livro::getTitulo)
                .collect(Collectors.joining(", "));


        return """
            ---Autor---
            Nome: %s
            Ano de nascimento: %s
            Ano de falecimento: %s
            Livros: %s
            ----------
            """.formatted(nome,anoNascimento,anoFalecimento,tituloLivros);
    }
}
