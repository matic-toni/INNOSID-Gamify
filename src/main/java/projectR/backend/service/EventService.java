package projectR.backend.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import projectR.backend.DTO.AddForeignImageRequest;
import projectR.backend.DTO.AddImageRequest;
import projectR.backend.DTO.EventDTO;
import projectR.backend.DTO.EventWithImageResourcesIds;
import projectR.backend.DTO.EventsDTO;
import projectR.backend.model.Event;
import projectR.backend.model.Image;
import projectR.backend.model.ImageResource;
import projectR.backend.repository.EventRepo;
import projectR.backend.repository.ImageRepo;
import projectR.backend.repository.ImageResourceRepo;

@Service
public class EventService {
	
	@Autowired
	private EventRepo eventRepo;
	
	@Autowired
	private ImageRepo imageRepo;
	
	@Autowired
	private ImageResourceRepo resourceRepo;
	

	
	public List<EventsDTO> retrieveAll() {
		return eventRepo
				.findAll()
				.stream()
				.map(event -> new EventsDTO(event))
				.collect(Collectors.toList());
	}

	public boolean addEvent(Event e) {
		try {
			if(e.getDescription().strip() == "" || e.getLocation().strip() == "")
				throw new Exception("Fill all fields!");
			this.eventRepo.save(e);
			return true;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
		
	}

	public List<EventDTO> retrieveByID(Long id) {
		List<EventDTO> list = new ArrayList<>();
		list.add(new EventDTO(eventRepo.getOne(id)));
		return list;
	}
	
	public EventWithImageResourcesIds retrieveWithImagesByID(Long id) {
		return new EventWithImageResourcesIds(eventRepo.getOne(id));
	}

	public void removeEvent(long id) {
		eventRepo.removeByEventID(id);
		return;
	}


	public ModelAndView getUpdateEventForm(Long id, String message) {
		ModelAndView mv = new ModelAndView("updateEvent");
		EventsDTO eventsDTO = new EventsDTO(eventRepo.getOne(id));
		try {
			
			String startDateString = eventsDTO.getDate();
		    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		    String date2 = sdf2.format(sdf.parse(startDateString));
		    
		    String time2 = eventsDTO.getTime() + ":00";
		    
		    eventsDTO.setDate(date2);
		    eventsDTO.setTime(time2);
		    
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		mv.addObject("event", eventsDTO);
		mv.addObject("message", message);
		return mv;
	}

	public boolean updateEvent(Event event) {
		try {
			if (event.getLocation().strip() == "" || event.getDescription().strip() == "") {
				throw new Exception("Empty fields.");
			}
			eventRepo.save(event);
			return true;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}

	public void removeImageFromEvent(Long eventID, Long imageResourceID) {
		Optional<Event> eventOpt = eventRepo.findById(eventID);
		
		if(eventOpt.isEmpty()) {
			System.out.println("event is empty!");
			return;
		}
		
		Event event = eventOpt.get();
		ImageResource found = null;
		for (ImageResource resource : event.getImageResources()) {
			if(resource.getImageResourceID().equals(imageResourceID)) {
				found = resource;
				break;
			}
		}
		if(found == null) {
			return;
		}
		
		event.getImageResources().remove(found);
		eventRepo.save(event);
		
	}

	@Transactional
	public boolean addImageToEvent(AddImageRequest request) {
		Optional<Event> eventOpt = eventRepo.findById(request.getEventID());
		
		if(eventOpt.isEmpty()) {
			return false;
		}
		
		Event event = eventOpt.get();
		
		for(String name : request.getImageNames()) {
			Optional<Image> img = imageRepo.findByName(name);
		
			if(img.isEmpty()) {
				return false;
			}
		
			ImageResource resource = new ImageResource("http://161.53.19.210:8080/images/" + name);
			
			resourceRepo.save(resource);
			event.getImageResources().add(resource);
			eventRepo.save(event);
		}
		return true;
	}

	public void addForeignImageToEvent(AddForeignImageRequest request) {
		Optional<Event> eventOpt = eventRepo.findById(request.getEventID());
		
		if(eventOpt.isEmpty()) {
			return;
		}
		
		Event event = eventOpt.get();
		
		ImageResource resource = new ImageResource(request.getImageURL());
		
		resourceRepo.save(resource);
		event.getImageResources().add(resource);
		eventRepo.save(event);
	}

}
