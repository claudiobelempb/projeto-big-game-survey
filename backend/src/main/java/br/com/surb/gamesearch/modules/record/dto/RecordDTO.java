package br.com.surb.gamesearch.modules.record.dto;

import br.com.surb.gamesearch.modules.game.infra.jpa.entities.Game;
import br.com.surb.gamesearch.modules.record.jpa.entities.Record;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class RecordDTO implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;
  private Integer age;
  private Instant createdAt;
  private Game game;

  public RecordDTO(){}

  public RecordDTO(Long id, String name, Integer age, Instant createdAt, Game game) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.createdAt = createdAt;
    this.game = game;
  }

  public RecordDTO(Record record){
    id = record.getId();
    name = record.getName();
    age = record.getAge();
    createdAt = record.getCreatedAt();
    game = record.getGame();
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

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }
}
