package projectR.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectR.backend.DTO.AppDTO;
import projectR.backend.repository.AppRepo;
import projectR.backend.model.App;

@Service
public class AppService {
	
	@Autowired
	private AppRepo appRepo;

	public AppDTO retrieveByName(String name) {
		Optional<App> app = appRepo.findByName(name);
		if(app.isEmpty()) {
			return null;
		} else {
			return new AppDTO(app.get());
		}
	}

}
