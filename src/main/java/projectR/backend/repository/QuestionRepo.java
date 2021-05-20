package projectR.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import projectR.backend.model.Question;

public interface QuestionRepo extends JpaRepository <Question, Long> {
	
	@Transactional
	public Long removeByQuestionID(long id);
	
	List<Question> findAll();
}
