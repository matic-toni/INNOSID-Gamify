package projectR.backend.controller.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import projectR.backend.DTO.AppDTO;
import projectR.backend.service.AppService;

@RestController
public class AppRestController {

	@Autowired
	private AppService appService;
	
	@GetMapping("/apps/{name}")
	public ResponseEntity<AppDTO> getByName(@PathVariable("name") String name) {
		AppDTO app = appService.retrieveByName(name);
		return app == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok().body(app);
	}
}
