package br.com.surb.gamesearch.modules.record.useCase.RecordFindAllDatePage;

import br.com.surb.gamesearch.modules.record.dto.RecordDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping(value = "/records-date-page")
public class RecordFindAllDatePageResource {

  private final RecordFindAllDatePageService recordFindAllDatePageService;

  public RecordFindAllDatePageResource(RecordFindAllDatePageService recordFindAllDatePageService){
    this.recordFindAllDatePageService = recordFindAllDatePageService;
  }

  @GetMapping
  public ResponseEntity<Page<RecordDTO>> handle(
    @RequestParam(value = "minDate", defaultValue = "") String min,
    @RequestParam(value = "maxDate", defaultValue = "") String max,
    @RequestParam(value = "page", defaultValue = "0") Integer page,
    @RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
    @RequestParam(value = "orderBy", defaultValue = "createdAt") String orderBy,
    @RequestParam(value = "direction", defaultValue = "DESC") String direction)
  {

    Instant minDate = ("".equals(min)) ? null : Instant.parse(min);
    Instant maxDate = ("".equals(max)) ? null : Instant.parse(max);

    if(linesPerPage == 0){
      linesPerPage = Integer.MAX_VALUE;
    }

    PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

    Page<RecordDTO> list = recordFindAllDatePageService.execute(minDate, maxDate, pageRequest);
    return ResponseEntity.ok().body(list);
  }
}
