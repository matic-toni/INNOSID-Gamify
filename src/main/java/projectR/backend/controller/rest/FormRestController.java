package projectR.backend.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import projectR.backend.model.Form;
import projectR.backend.service.FormService;

@RestController
public class FormRestController {
	
	@Autowired
	private FormService formService;
	
	@GetMapping("/forms")
	public ResponseEntity<List<Form>> getForms() {
		return ResponseEntity.ok(formService.retrieveAll());
	}

}
