package br.com.surb.gamesearch.modules.game.dto;

import br.com.surb.gamesearch.modules.game.infra.jpa.entities.Game;
import br.com.surb.gamesearch.modules.genre.jpa.entities.Genre;
import br.com.surb.gamesearch.shared.enums.EnumPlatform;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GamePageDTO extends GameDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Genre genre;

  private final List<Record> records = new ArrayList<>();

  public GamePageDTO(){}

  public GamePageDTO(Long id, String title, EnumPlatform platform, Genre genre) {
    super(id, title, platform);
    this.genre = genre;
  }
  public GamePageDTO(Game game) {
    super(game);
//    game.getRecords().forEach(record -> this.records.add(new RecordDTO(record)));
  }

  public GamePageDTO(Game game, Genre genre) {
    super(game);
    this.genre = genre;
//    game.getRecords().forEach(record -> this.records.add(new RecordDTO(record)));
  }

  public Genre getGenre() {
    return genre;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
  }

  public List<Record> getRecords() {
    return records;
  }

}
