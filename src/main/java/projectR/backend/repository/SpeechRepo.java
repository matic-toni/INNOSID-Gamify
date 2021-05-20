package projectR.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projectR.backend.model.Speech;

public interface SpeechRepo extends JpaRepository<Speech, Long>{

}
