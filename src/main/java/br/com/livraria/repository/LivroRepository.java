package br.com.livraria.repository;

import br.com.livraria.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Long> {

    @Query("SELECT l FROM Livro l WHERE LOWER(l.titulo) = LOWER(:nomeLivro)")
    Optional<Livro> buscaLivro(String nomeLivro);


    @Query("SELECT l FROM Livro l WHERE LOWER(l.idioma) = LOWER(:idioma)")
    List<Livro> listaLivroPorIdioma(String idioma);
}
