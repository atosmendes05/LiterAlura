package br.com.livraria.principal;

import br.com.livraria.model.Autor;
import br.com.livraria.model.DadosApi;
import br.com.livraria.model.DadosLivro;
import br.com.livraria.model.Livro;
import br.com.livraria.repository.AutorRepositorio;
import br.com.livraria.repository.LivroRepository;
import br.com.livraria.service.ConsumirApi;
import br.com.livraria.service.ConverteDados;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner ler = new Scanner(System.in);
    private String  API_ENDERECO = "http://gutendex.com/books/?search=";
    private ConsumirApi consumirDados = new ConsumirApi();
    private ConverteDados converso = new ConverteDados();


    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepositorio autorRepositorio;

    public Principal(LivroRepository repository, AutorRepositorio autorRepositorio){
        this.livroRepository = repository;
        this.autorRepositorio = autorRepositorio;
    }


    public void exibirPainel(){

       var i = 1;
        while (i == 1){
            var mensagem = """
                Escola o numero da opção:
                1 - buscar livro pelo titulo
                2 - lista livros registrados
                3 - lista autores registrados 
                4 - lista autores vivos em um determinado ano
                5 - lista livros em um determinado idioma
                0 - sair
                """;

            System.out.println(mensagem);
            var opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao){
                case 1:
                    buscaLivro();
                    break;
                case 2:
                    listaLivros();
                    break;
                case 3:
                    listaAutores();
                    break;
                case 4:
                    listaAutoresPorAno();
                    break;
                case 5:
                    listraLivroPorIdioma();
                    break;
                case 0:
                    i = 0;
                    System.out.println("Saindo.....");
                    break;
            }
        }

    }


    private DadosApi buscaLivroNaWeb(String nomeLivro){

        var json =  consumirDados.DadosApi(API_ENDERECO + nomeLivro.replace(" ","%20"));

        return converso.obterDados(json,DadosApi.class);
    }


    private void buscaLivro() {
        System.out.println("Digite o nome do livro:");
        var nomeLivro = ler.nextLine();

        Optional<Livro> dadoLivro = livroRepository.buscaLivro(nomeLivro);
        if (dadoLivro.isPresent()){
            System.out.println(dadoLivro.get());
        }else {
            DadosApi dados = buscaLivroNaWeb(nomeLivro);
            if (dados.results().isEmpty()) {
                System.out.println("filme não encontrado");
            } else {
                DadosLivro dadosLivro = dados.results().get(0);

                Livro livro = new Livro(dadosLivro);
                Autor autor = new Autor(dadosLivro.autor().get(0));


                Optional<Autor> buscaAutor = autorRepositorio.buscarAutor(autor.getNome());
                if (buscaAutor.isPresent()){
                   autor = buscaAutor.get();
                }else {
                    autorRepositorio.save(autor);
                }

                livro.setAutor(autor);
                livroRepository.save(livro);

            }
        }



    }

    private void listaLivros() {
        List<Livro> listaLivros =  livroRepository.findAll();
        listaLivros.forEach(System.out::println);
    }


    private void listaAutores() {
        List<Autor> listaAutores = autorRepositorio.findAll();
        listaAutores.forEach(System.out::println);
    }


    private void listaAutoresPorAno() {
        System.out.println("digite o ano que deseja:");
        var ano = ler.nextInt();
        List<Autor> listaAutoreAno = autorRepositorio.listaAutoresPorAno(ano);
        listaAutoreAno.forEach(System.out::println);
    }


    private void listraLivroPorIdioma() {
        System.out.println("""
                digite o idioma desejado:
                es - espanhol
                en - ingles
                fr - frances
                pt - portugues
                """);
        var idioma = ler.nextLine();
        List<Livro> listaLivroPorIdioma = livroRepository.listaLivroPorIdioma(idioma);
        if (listaLivroPorIdioma.isEmpty()){
            System.out.println("não existir livro com esse idioma no banco de dados");
        }
        listaLivroPorIdioma.forEach(System.out::println);
    }






}
