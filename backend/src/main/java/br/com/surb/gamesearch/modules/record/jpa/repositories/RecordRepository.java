package br.com.surb.gamesearch.modules.record.jpa.repositories;

import br.com.surb.gamesearch.modules.record.jpa.entities.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
//  @Query("SELECT obj FROM Record obj WHERE " +
//    "(:min IS NULL OR obj.createdAt >= :min) AND " +
//    "(:max IS NULL OR obj.createdAt <= :max)")
//  Page<Record> findAllDatePage(Instant min, Instant max, Pageable pageable);
  @Query("SELECT obj FROM Record obj WHERE " +
    "(COALESCE(:min, NULL) IS NULL OR obj.createdAt >= :min) AND " +
    "(COALESCE(:max, NULL) IS NULL OR obj.createdAt <= :max)")
  Page<Record> findAllDatePage(Instant min, Instant max, Pageable pageable);
}
