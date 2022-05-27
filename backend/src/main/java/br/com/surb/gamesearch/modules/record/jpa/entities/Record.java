package br.com.surb.gamesearch.modules.record.jpa.entities;

import br.com.surb.gamesearch.modules.game.infra.jpa.entities.Game;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
@Entity
@Table(name = "tb_record")
public class Record implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Integer age;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;
  @ManyToOne
  @JoinColumn(name = "game_id")
  private Game game;

  public Record(){}

  public Record(Long id, String name, Integer age, Instant createdAt, Instant updatedAt, Game game) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.game = game;
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

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }

  @PrePersist
  public void prePersist(){
    createdAt = Instant.now();
  }

  @PreUpdate
  public void preUpdate(){
    updatedAt = Instant.now();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Record record = (Record) o;
    return id.equals(record.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
