package br.com.surb.gamesearch.modules.record.useCase.RecordFindAllPage;

import br.com.surb.gamesearch.modules.game.dto.GamePageDTO;
import br.com.surb.gamesearch.modules.record.dto.RecordDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/page-records")
public class RecordFindAllPageResource {

  private final RecordFindAllPageService recordFindAllPageService;

  public RecordFindAllPageResource(RecordFindAllPageService recordFindAllPageService){
    this.recordFindAllPageService = recordFindAllPageService;
  }

  @GetMapping
  public ResponseEntity<Page<RecordDTO>> handle(Pageable pageable){
    Page<RecordDTO> page = recordFindAllPageService.execute(pageable);
    return ResponseEntity.ok(page);
  }
}
