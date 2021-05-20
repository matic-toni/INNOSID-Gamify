package projectR.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import projectR.backend.model.App;

public interface AppRepo extends JpaRepository<App, Long> {

	Optional<App> findByName(String name);

}
