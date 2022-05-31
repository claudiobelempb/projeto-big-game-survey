package br.com.surb.gamesearch.modules.record.useCase.RecordCreate;

import br.com.surb.gamesearch.modules.record.dto.RecordCreateDTO;
import br.com.surb.gamesearch.modules.record.dto.RecordDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/records")
public class RecordCreateResource {

  private final RecordCreateService recordCreateService;

  public RecordCreateResource(RecordCreateService recordCreateService) {
    this.recordCreateService = recordCreateService;
  }

  @PostMapping
  public ResponseEntity<RecordDTO> handle(@RequestBody RecordCreateDTO recordCreateDTO){
    RecordDTO recordDTO = recordCreateService.execute(recordCreateDTO);
    URI uri =
      ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(recordDTO.getId()).toUri();
    return ResponseEntity.created(uri).body(recordDTO);
  }
}
