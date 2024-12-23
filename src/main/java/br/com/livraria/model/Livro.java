package br.com.livraria.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    private String idioma;

    private double numeroDeDawnload;

    @ManyToOne
    private Autor autor;

    public Livro(){}

    public Livro (DadosLivro dadosLivro){
        this.titulo = dadosLivro.titulo();
        this.idioma = dadosLivro.idioma().get(0);
        this.numeroDeDawnload = dadosLivro.numeroDeDawnload();
    }

    public Autor getAuto() {
        return autor;
    }

    public void setAutor(Autor auto) {
        this.autor = auto;
    }

    public Autor pegaAutor(DadosLivro dadosLivro) {
        DadosAutor dadosAutor = dadosLivro.autor().get(0);
        return new Autor(dadosAutor);
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public double getNumeroDeDawnload() {
        return numeroDeDawnload;
    }

    public void setNumeroDeDawnload(double numeroDeDawnload) {
        this.numeroDeDawnload = numeroDeDawnload;
    }

    @Override
    public String toString() {
        return """
            ---Livro---
            Titulo: %s
            Autor: %s
            Idioma: %s
            Numero de downloads: %.1f
            ----------
            """.formatted(titulo, autor.getNome(), idioma,numeroDeDawnload);
    }
}
