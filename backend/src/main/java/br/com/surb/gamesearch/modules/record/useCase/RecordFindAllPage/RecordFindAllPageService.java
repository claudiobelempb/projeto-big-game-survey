package br.com.surb.gamesearch.modules.record.useCase.RecordFindAllPage;

import br.com.surb.gamesearch.modules.game.dto.GamePageDTO;
import br.com.surb.gamesearch.modules.game.infra.jpa.entities.Game;
import br.com.surb.gamesearch.modules.record.dto.RecordDTO;
import br.com.surb.gamesearch.modules.record.jpa.entities.Record;
import br.com.surb.gamesearch.modules.record.jpa.repositories.RecordRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecordFindAllPageService {

  private final RecordRepository recordRepository;


  public RecordFindAllPageService(RecordRepository recordRepository){
    this.recordRepository = recordRepository;
  }

  @Transactional(readOnly = true)
  public Page<RecordDTO> execute(Pageable pageable){
    Page<Record> records = recordRepository.findAll(pageable);
    return records.map(record -> new RecordDTO(record));
  }
}
