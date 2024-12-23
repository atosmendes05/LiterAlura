package br.com.livraria.repository;

import br.com.livraria.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor,Long> {

    @Query("SELECT a FROM Autor a WHERE LOWER(a.nome) = LOWER(:nomeAutor)")
    Optional<Autor> buscarAutor(String nomeAutor);

    @Query("SELECT a FROM Autor a WHERE :ano < a.anoFalecimento ")
    List<Autor> listaAutoresPorAno(int ano);
}
