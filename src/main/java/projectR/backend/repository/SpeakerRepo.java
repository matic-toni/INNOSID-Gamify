package projectR.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import projectR.backend.model.Speaker;

public interface SpeakerRepo extends JpaRepository<Speaker, Long> {

	@Transactional
	public Long removeBySpeakerID(long id);

}
