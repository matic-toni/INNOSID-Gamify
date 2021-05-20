package projectR.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projectR.backend.model.FPSRecord;

public interface FPSRecordRepo extends JpaRepository<FPSRecord, Long> {

}
