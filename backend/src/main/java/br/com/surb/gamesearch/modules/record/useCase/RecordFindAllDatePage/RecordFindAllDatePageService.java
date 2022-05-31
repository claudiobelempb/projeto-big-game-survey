package br.com.surb.gamesearch.modules.record.useCase.RecordFindAllDatePage;

import br.com.surb.gamesearch.modules.record.dto.RecordDTO;
import br.com.surb.gamesearch.modules.record.jpa.repositories.RecordRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class RecordFindAllDatePageService {

  private final RecordRepository recordRepository;


  public RecordFindAllDatePageService(RecordRepository recordRepository){
    this.recordRepository = recordRepository;
  }

  @Transactional(readOnly = true)
  public Page<RecordDTO> execute(Instant minDate, Instant maxDate, PageRequest pageRequest){
    return recordRepository.findAllDatePage(minDate, maxDate, pageRequest).map(x -> new RecordDTO(x));

  }
}
