package br.com.surb.gamesearch.modules.record.useCase.RecordCreate;

import br.com.surb.gamesearch.modules.game.infra.jpa.entities.Game;
import br.com.surb.gamesearch.modules.game.infra.jpa.repositories.GameRepository;
import br.com.surb.gamesearch.modules.record.dto.RecordCreateDTO;
import br.com.surb.gamesearch.modules.record.dto.RecordDTO;
import br.com.surb.gamesearch.modules.record.jpa.entities.Record;
import br.com.surb.gamesearch.modules.record.jpa.repositories.RecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecordCreateService {

  private final RecordRepository recordRepository;
  private final GameRepository gameRepository;

  public RecordCreateService(RecordRepository recordRepository, GameRepository gameRepository){
    this.recordRepository = recordRepository;
    this.gameRepository = gameRepository;
  }

  @Transactional
  public RecordDTO execute(RecordCreateDTO recordCreateDTO){
    Record record = new Record();
    record.setName(recordCreateDTO.getName());
    record.setAge(recordCreateDTO.getAge());

    Game game = gameRepository.getReferenceById(recordCreateDTO.getGameId());
    record.setGame(game);
    record = recordRepository.save(record);
    return new RecordDTO(record);
  }

}
