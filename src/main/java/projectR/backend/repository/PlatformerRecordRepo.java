package projectR.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projectR.backend.model.PlatformerRecord;

public interface PlatformerRecordRepo extends JpaRepository<PlatformerRecord, Long>{

}
