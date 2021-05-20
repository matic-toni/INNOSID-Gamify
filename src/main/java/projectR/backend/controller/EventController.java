package projectR.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import projectR.backend.DTO.AddForeignImageRequest;
import projectR.backend.DTO.AddImageRequest;
import projectR.backend.DTO.EventDTO;
import projectR.backend.DTO.EventsDTO;
import projectR.backend.model.Event;
import projectR.backend.service.EventService;
import projectR.backend.service.ImageService;

@RolesAllowed({"ADMIN"})
@Controller
@RequestMapping("/events")
public class EventController {
	
	@Autowired
    private EventService eventService;
	
	@Autowired
	private ImageService imageService;
	
	
	@GetMapping("/add")
	public ModelAndView addEvent(@RequestParam(value="saved") Optional<String> saved) {
		String message = null;
		String result = null;
		
		if(!saved.isEmpty()) {
			result = saved.get();		
			if(result.equals("true")) {
				message = "Event saved successfully!";
			} else if (result.equals("false")){
				message = "All fields must be filled correctly!";
			}
		}
	
		ModelAndView mv = new ModelAndView("addEvent");
		mv.addObject("message", message);
	    return mv;
	}
	
	@PostMapping("/add")
	public ModelAndView addEvent(@RequestBody EventDTO eDTO) {
		try {
			Event e = new Event(eDTO.getDate(), eDTO.getTime(), eDTO.getLocation(), eDTO.getDescription());
			if(eventService.addEvent(e)) {
				return new ModelAndView("redirect:" + "/events/add?saved=true");
			} else {
				throw new Exception("failed");
			}
			} catch (Exception e) {
				System.out.println(e);
				return new ModelAndView("redirect:" + "/events/add?saved=false");
		}
	}
	
	@GetMapping("/manage")
	public ModelAndView manageEvent(@RequestParam(value="saved") Optional<String> saved) {
		String message = null;
		String result = null;
		
		if(!saved.isEmpty()) {
			result = saved.get();		
			if(result.equals("true")) {
				message = "Event saved successfully!";
			} else if (result.equals("false")){
				message = "All fields must be filled correctly!";
			}
		}
	
		ModelAndView mv =  new ModelAndView("manageEvents");
		List<EventsDTO> list = new ArrayList<>();
		list = eventService.retrieveAll();
		
		mv.addObject("list", list);
		mv.addObject("message", message);
	    return mv;
	}
	public ModelAndView manageEvents() {
		ModelAndView mv =  new ModelAndView("manageEvents");
		List<EventsDTO> list = new ArrayList<>();
		list = eventService.retrieveAll();
		
		mv.addObject("list", list);
		return mv;
	}
	
	
	
	
	@GetMapping("/images/manage/{id}")
	public ModelAndView manageImage(@PathVariable("id") Long eventID) {
		ModelAndView mv =  new ModelAndView("addImageToEvent");
		
		mv.addObject("images", imageService.retrieveAll());
		mv.addObject("event", eventService.retrieveWithImagesByID(eventID));
		return mv;
	}
	
	@PostMapping(value="/images/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView addImage(@ModelAttribute AddImageRequest request) {
		eventService.addImageToEvent(request);
		return new ModelAndView("redirect:" + "/events/images/manage/" + request.getEventID());
	}
	
	@PostMapping(value="/images/add/foreign", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView addImage(@ModelAttribute AddForeignImageRequest request) {
		eventService.addForeignImageToEvent(request);
		return new ModelAndView("redirect:" + "/events/images/manage/"+ request.getEventID());
	}
	
	@PostMapping("/images/remove")
	@ResponseBody
	public ModelAndView removeImage(@RequestParam Long eventID, @RequestParam Long imageResourceID) {
		eventService.removeImageFromEvent(eventID, imageResourceID);
		return new ModelAndView("redirect:" + "/events/images/manage/" + eventID);
	}
	
	
	
	@PostMapping("/delete/{id}")
	@ResponseBody
	public ModelAndView deleteEvent(@PathVariable("id") long id) {
		eventService.removeEvent(id);
		return new ModelAndView("redirect:" + "/events/manage");
	}

	@GetMapping("/update/{id}")
	public ModelAndView getUpdateEventForm(@PathVariable("id") Long id, @RequestParam(value="saved") Optional<String> saved) {
		String message = null;
		String result = null;
		
		if(!saved.isEmpty()) {
			result = saved.get();		
			if(result.equals("true")) {
				message = "Event saved successfully!";
			} else if (result.equals("false")){
				message = "All fields must be filled correctly!";
			}
		}
		
		try {
			return eventService.getUpdateEventForm(id, message);
		} catch(Exception ex) {
			System.out.println(ex);
		}
		return eventService.getUpdateEventForm(id, message);
		
	}

	@PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView updateEvent(@ModelAttribute EventDTO eDTO) {
		String id = eDTO.getEventID().toString();
		try {
			Event e = new Event(eDTO.getDate(), eDTO.getTime(), eDTO.getLocation(), eDTO.getDescription());
			if(!eventService.updateEvent(e)) {
				throw new Exception("Update failed.");
			}
			return new ModelAndView("redirect:" + "/events/update/" + id + "?saved=true");
		} catch (Exception ex) {
			System.out.println(ex);
			return new ModelAndView("redirect:" + "/events/update/" + id + "?saved=false");
		}
	}
}
