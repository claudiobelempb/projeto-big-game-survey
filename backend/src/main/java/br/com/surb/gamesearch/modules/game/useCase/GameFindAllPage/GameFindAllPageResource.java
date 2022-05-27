package br.com.surb.gamesearch.modules.game.useCase.GameFindAllPage;

import br.com.surb.gamesearch.modules.game.dto.GamePageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/page-games")
public class GameFindAllPageResource {

  private final GameFindAllPageService gameFindAllPageService;

  public GameFindAllPageResource(GameFindAllPageService gameFindAllPageService){
    this.gameFindAllPageService = gameFindAllPageService;
  }

    @GetMapping
    public ResponseEntity<Page<GamePageDTO>> handle(Pageable pageable){
      Page<GamePageDTO> page = gameFindAllPageService.execute(pageable);
      return ResponseEntity.ok(page);
    }

}
