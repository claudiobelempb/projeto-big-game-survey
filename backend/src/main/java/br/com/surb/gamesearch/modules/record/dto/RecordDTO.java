package br.com.surb.gamesearch.modules.record.dto;

import br.com.surb.gamesearch.modules.record.jpa.entities.Record;
import br.com.surb.gamesearch.shared.enums.EnumPlatform;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class RecordDTO implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;
  private Integer age;
  private String gameTitle;
  private EnumPlatform gamePlatform;
  private String genreName;
  private Instant createdAt;
//  private Instant updatedAt;


  public RecordDTO(){}

//  public RecordDTO(Long id, String name, Integer age, String gameTitle, EnumPlatform gamePlatform, String genreName,
//                   Instant createdAt) {
//    this.id = id;
//    this.name = name;
//    this.age = age;
//    this.gameTitle = gameTitle;
//    this.gamePlatform = gamePlatform;
//    this.genreName = genreName;
//    this.createdAt = createdAt;
//  }

  public RecordDTO(Record record){
    id = record.getId();
    name = record.getName();
    age = record.getAge();
    gameTitle = record.getGame().getTitle();
    gamePlatform = record.getGame().getPlatform();
    genreName = record.getGame().getGenre().getName();
    createdAt = record.getCreatedAt();
//    updatedAt = record.getUpdatedAt();

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

  public String getGameTitle() {
    return gameTitle;
  }

  public void setGameTitle(String gameTitle) {
    this.gameTitle = gameTitle;
  }

  public EnumPlatform getGamePlatform() {
    return gamePlatform;
  }

  public void setGamePlatform(EnumPlatform gamePlatform) {
    this.gamePlatform = gamePlatform;
  }

  public String getGenreName() {
    return genreName;
  }

  public void setGenreName(String genreName) {
    this.genreName = genreName;
  }

}
