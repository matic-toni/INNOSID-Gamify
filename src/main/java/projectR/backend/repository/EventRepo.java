package projectR.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import projectR.backend.model.Event;

public interface EventRepo extends JpaRepository<Event, Long> {

	@Transactional
	public Long removeByEventID(long id);
}
