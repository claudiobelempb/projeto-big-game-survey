package br.com.surb.gamesearch.modules.game.useCase.GameFindAll;

import br.com.surb.gamesearch.modules.game.dto.GameDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameFindAllResource {

  private final GameFindAllService gameFindAllService;

  public GameFindAllResource(GameFindAllService gameFindAllService){
    this.gameFindAllService = gameFindAllService;
  }

  //  @GetMapping
  //  public ResponseEntity<Page<GameDTO>> handle(Pageable pageable){
  //    Page<GameDTO> page = gameFindAllService.execute(pageable);
  //    return ResponseEntity.ok(page);
  //  }

  @GetMapping
  public ResponseEntity<List<GameDTO>> handle(){
    List<GameDTO> list = gameFindAllService.execute();
    return ResponseEntity.ok().body(list);
  }
}
