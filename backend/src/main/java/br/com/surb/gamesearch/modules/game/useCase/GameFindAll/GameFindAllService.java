package br.com.surb.gamesearch.modules.game.useCase.GameFindAll;

import br.com.surb.gamesearch.modules.game.dto.GameDTO;
import br.com.surb.gamesearch.modules.game.infra.jpa.entities.Game;
import br.com.surb.gamesearch.modules.game.infra.jpa.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameFindAllService {

  private final GameRepository gameRepository;

  public GameFindAllService(GameRepository gameRepository){
    this.gameRepository = gameRepository;
  }

  @Transactional(readOnly = true)
  public List<GameDTO> execute() {
    List<Game> games = gameRepository.findAll();
    return games.stream().map(game -> new GameDTO(game)).collect(Collectors.toList());
  }

}
