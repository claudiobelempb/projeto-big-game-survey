package br.com.surb.gamesearch.modules.record.dto;

import java.io.Serial;
import java.io.Serializable;

public class RecordCreateDTO  implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private Long gameId;
  private String name;
  private Integer age;

  public RecordCreateDTO(){}

  public RecordCreateDTO(Long gameId, String name, Integer age) {
    this.gameId = gameId;
    this.name = name;
    this.age = age;
  }


  public Long getGameId() {
    return gameId;
  }

  public void setGameId(Long gameId) {
    this.gameId = gameId;
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
}
