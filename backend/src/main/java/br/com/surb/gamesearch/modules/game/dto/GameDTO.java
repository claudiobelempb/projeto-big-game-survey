package br.com.surb.gamesearch.modules.game.dto;

import br.com.surb.gamesearch.modules.game.infra.jpa.entities.Game;
import br.com.surb.gamesearch.shared.enums.EnumPlatform;

import java.io.Serial;
import java.io.Serializable;

public class GameDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;
  private String title;
  private EnumPlatform platform;

  public GameDTO(){}

  public GameDTO(Long id, String title, EnumPlatform platform) {
    this.id = id;
    this.title = title;
    this.platform = platform;
  }

  public GameDTO(Game game){
    this.id = game.getId();
    this.title = game.getTitle();
    this.platform = game.getPlatform();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public EnumPlatform getPlatform() {
    return platform;
  }

  public void setPlatform(EnumPlatform platform) {
    this.platform = platform;
  }

}
