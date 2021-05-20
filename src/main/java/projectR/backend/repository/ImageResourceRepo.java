package projectR.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projectR.backend.model.ImageResource;

public interface ImageResourceRepo extends JpaRepository<ImageResource, Long> {

}
