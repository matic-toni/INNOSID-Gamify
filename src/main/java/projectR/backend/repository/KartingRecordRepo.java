package projectR.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projectR.backend.model.KartingRecord;

public interface KartingRecordRepo extends JpaRepository<KartingRecord, Long> {

}
