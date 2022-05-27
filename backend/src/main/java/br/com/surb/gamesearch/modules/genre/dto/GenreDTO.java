package br.com.surb.gamesearch.modules.genre.dto;

import br.com.surb.gamesearch.modules.game.dto.GameDTO;
import br.com.surb.gamesearch.modules.game.infra.jpa.entities.Game;
import br.com.surb.gamesearch.modules.genre.jpa.entities.Genre;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenreDTO implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;
  private final List<Game> games = new ArrayList<>();

  public GenreDTO(){}

  public GenreDTO(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public GenreDTO(Genre genre) {
    id = genre.getId();
    name = genre.getName();
//    genre.getGames().forEach(game -> this.games.add(new GameDTO(game)));
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Game> getGames() {
    return games;
  }
}
