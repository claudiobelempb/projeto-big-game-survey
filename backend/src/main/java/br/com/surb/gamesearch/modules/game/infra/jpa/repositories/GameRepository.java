package br.com.surb.gamesearch.modules.game.infra.jpa.repositories;

import br.com.surb.gamesearch.modules.game.infra.jpa.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
