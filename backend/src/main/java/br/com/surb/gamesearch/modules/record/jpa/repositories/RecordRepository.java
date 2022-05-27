package br.com.surb.gamesearch.modules.record.jpa.repositories;

import br.com.surb.gamesearch.modules.record.jpa.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
}
