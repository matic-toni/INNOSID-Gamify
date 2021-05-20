package projectR.backend.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import projectR.backend.DTO.EventsDTO;
import projectR.backend.DTO.EventDTO;

import projectR.backend.service.EventService;

@RestController
public class EventRestController {

	@Autowired
	private EventService eventService;
	

	@GetMapping("/events")
	public List<EventsDTO> retrieveAll() {
		return eventService.retrieveAll();
	}
	
	@GetMapping("events/{id}")
	@ResponseBody
	public List<EventDTO> retrieveByID(@PathVariable("id") Long id) {
		return eventService.retrieveByID(id);
	}

}
