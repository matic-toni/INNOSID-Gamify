package projectR.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import projectR.backend.model.Form;

public interface FormRepo extends JpaRepository<Form, Long> {
	@Transactional
	void removeByFormID(long id);

}
