 package projectR.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import projectR.backend.model.Image;

public interface ImageRepo extends JpaRepository<Image, Long> {
	
	Optional<Image> findByName(String name);
	
	List<Image> findByNameContaining(String partOfName);
}