package br.com.surb.gamesearch.modules.game.infra.jpa.entities;

import br.com.surb.gamesearch.modules.genre.jpa.entities.Genre;
import br.com.surb.gamesearch.modules.record.jpa.entities.Record;
import br.com.surb.gamesearch.shared.enums.EnumPlatform;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "tb_game")
public class Game implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private EnumPlatform platform;
  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "genre_id")
  private Genre genre;
  @JsonIgnore
  @OneToMany(mappedBy = "game")
  private final List<Record> records = new ArrayList<>();

  public Game(){}

  public Game(Long id, String title, EnumPlatform platform) {
    this.id = id;
    this.title = title;
    this.platform = platform;
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

  public Genre getGenre() {
    return genre;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
  }

  public List<Record> getRecords() {
    return records;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Game game = (Game) o;
    return id.equals(game.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
