package br.com.surb.gamesearch.modules.game.useCase.GameFindAllPage;

import br.com.surb.gamesearch.modules.game.dto.GamePageDTO;
import br.com.surb.gamesearch.modules.game.infra.jpa.entities.Game;
import br.com.surb.gamesearch.modules.game.infra.jpa.repositories.GameRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameFindAllPageService {

  private final GameRepository gameRepository;

  public GameFindAllPageService(GameRepository gameRepository){
    this.gameRepository = gameRepository;
  }

    @Transactional(readOnly = true)
    public Page<GamePageDTO> execute(Pageable pageable){
      Page<Game> games = gameRepository.findAll(pageable);
      return games.map(game -> new GamePageDTO(game));
    }

}
