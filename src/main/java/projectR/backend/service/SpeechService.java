package projectR.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.servlet.ModelAndView;
import projectR.backend.DTO.*;
import projectR.backend.model.*;
import projectR.backend.repository.EventRepo;
import projectR.backend.repository.SpeechRepo;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpeechService {

    @Autowired
    private SpeechRepo speechRepo;

    @Autowired
    private EventService eventService;

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private SpeakerService speakerService;


    public List<DeleteSpeechRequest> retrieveAllForDelete() {
        return speechRepo
                .findAll()
                .stream()
                .map(speech -> new DeleteSpeechRequest(speech))
                .collect(Collectors.toList());
    }

    public ModelAndView getAddSpeechForm(String message) {
        ModelAndView mv = new ModelAndView("addSpeech");

        List<EventsDTO> events = new ArrayList<>();
        events = eventService.retrieveAll();

        List<SpeakerDTO> speakers = new ArrayList<>();
        speakers = speakerService.retrieveAll();

        mv.addObject("eventsList",events);
        mv.addObject("speakersList",speakers);
        mv.addObject("message", message);

        return mv;
    }

    public ModelAndView addSpeech(AddSpeechRequest s) {

        Speech speech = new Speech();

        Event event = eventRepo.findById(s.getEventID()).get();

        List<Speaker> speakers = new ArrayList<>();

        speakers = s
                .getSpeakerID()
                .stream()
                .map(id -> speakerService.retrieveSpeakerById(id))
                .collect(Collectors.toList());

        speech.setName(s.getTitle());
        speech.setStartTime(Time.valueOf(s.getStartTime()));
        speech.setEndTime(Time.valueOf(s.getEndTime()));
        speech.setEvent(event);
        speech.setSpeakers(speakers);

        if(speech.getStartTime().before(speech.getEndTime())) {
        	speechRepo.save(speech);
            return new ModelAndView("redirect:/speeches/add?saved=true");
        } else {
        	System.out.println("startTime must be before endTime");
        	return new ModelAndView("redirect:/speeches/add?saved=false");
        }
        
    }

    public ModelAndView getDeleteSpeechForm(String message) {
        ModelAndView mv =  new ModelAndView("manageSpeeches");

        List<DeleteSpeechRequest> speeches = new ArrayList<>();
        speeches= retrieveAllForDelete();

        mv.addObject("speechList", speeches);
        mv.addObject("message", message);

        return mv;
    }

    public ModelAndView deleteSpeechById(Long id) {
        Optional<Speech> speech = speechRepo.findById(id);
        if(speech.isPresent()) {
            speechRepo.delete(speech.get());
        }
        return new ModelAndView("redirect:" + "/speeches/manage");
    }

    public ModelAndView getUpdateSpeechForm(Long id, String message) {
        ModelAndView mv = new ModelAndView("updateSpeech");

        Optional<Speech> speech = speechRepo.findById(id);

        if(speech.isPresent()) {
            DeleteSpeechRequest speechRequest = new DeleteSpeechRequest(speech.get());
            mv.addObject("speech",speechRequest);

            List<EventsDTO> events = new ArrayList<>();
            events = eventService.retrieveAll();

            List<SpeakerDTO> speakers = new ArrayList<>();
            speakers = speakerService.retrieveAll();

            mv.addObject("eventsList",events);
            mv.addObject("speakersList",speakers);
            mv.addObject("message", message);
        }

        return mv;
    }

    public ModelAndView updateSpeech(UpdateSpeechRequest speechRequest) {
    	String speechID = speechRequest.getSpeechID().toString();
    	try {
    		
        	Speech speech = speechRepo.getOne(speechRequest.getSpeechID());
        
            Event event = eventRepo.getOne(speechRequest.getEventID());
            
            List<Speaker> speakers = new ArrayList<>();

            speakers = speechRequest
                    .getSpeakerID()
                    .stream()
                    .map(id-> speakerService.retrieveSpeakerById(id))
                    .collect(Collectors.toList());

            speech.setName(speechRequest.getTitle());
            speech.setStartTime(Time.valueOf(speechRequest.getStartTime()));
            speech.setEndTime(Time.valueOf(speechRequest.getEndTime()));
            speech.setEvent(event);
            speech.setSpeakers(speakers);

            if(!speech.getStartTime().before(speech.getEndTime())) {
            	throw new Exception("Wrong times");
            }
            
            speechRepo.save(speech);
            
            return new ModelAndView("redirect:" + "/speeches/update/" + speechID + "?saved=true");
            
    	} catch (Exception ex) {
    		System.out.println(ex);
    		return new ModelAndView("redirect:" + "/speeches/update/" + speechID + "?saved=false");
    	}
    }


}
