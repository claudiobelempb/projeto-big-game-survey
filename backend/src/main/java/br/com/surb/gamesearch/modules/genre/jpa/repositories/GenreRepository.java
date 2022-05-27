package br.com.surb.gamesearch.modules.genre.jpa.repositories;

import br.com.surb.gamesearch.modules.genre.jpa.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
