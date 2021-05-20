package projectR.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import projectR.backend.DTO.SpeakerDTO;
import projectR.backend.model.Speaker;
import projectR.backend.model.Speech;
import projectR.backend.repository.SpeakerRepo;
import projectR.backend.repository.SpeechRepo;

@Service
public class SpeakerService {

    @Autowired
    SpeakerRepo speakerRepo;

    @Autowired
	SpeechRepo speechRepo;
    
    @Autowired
    ImageService imageService;

    public boolean addSpeaker(Speaker s) {
    	try {
	    	if(s.getName().strip() == "" || s.getSurname().strip() == "" || s.getRole().strip() == "" || s.getInstitution().strip() == "" || s.getPictureURL().strip() == "")
	    		throw new Exception("Some fields are empty.");
	    
	    	s.setPictureURL("http://161.53.19.210:8080/images/" + s.getPictureURL());
	        speakerRepo.save(s);
	        return true;
    	} catch (Exception e) {
    		System.out.println(e);
    		return false;
    	}
    }

	public List<SpeakerDTO> retrieveAll() {
		return speakerRepo
				.findAll()
				.stream()
				.map(speaker -> new SpeakerDTO(speaker))
				.collect(Collectors.toList());
	}


	public Speaker retrieveSpeakerById(Long id) {
    	Optional<Speaker> speaker = speakerRepo.findById(id);
    	return speaker.get();
	}

	@Transactional
	public boolean deleteSpeakerById(Long speakerId) {
		Optional<Speaker> speakerOpt = speakerRepo.findById(speakerId);
		
		if(speakerOpt.isEmpty()) {
			return false;
		} else {
			Speaker speaker =  speakerOpt.get();

			List<Speech> speeches = speechRepo
					.findAll()
					.stream()
					.filter(s -> s.getSpeakers()
							.contains(speaker))
					.collect(Collectors.toList());

			for (Speech s : speeches) {
				if(s.getSpeakers().size() == 1) {
					speechRepo.delete(s);
				}
			}

			speakerRepo.delete(speaker);
			return true;
		}
	}

	public ModelAndView getUpdateSpeakerForm(Long id, String message) {
    	ModelAndView mv = new ModelAndView("updateSpeaker");

    	Optional<Speaker> speaker = speakerRepo.findById(id);

    	if(speaker.isPresent()) {
    		SpeakerDTO speakerDTO = new SpeakerDTO(speaker.get());
    		
    		mv.addObject("images", imageService.retrieveAll());
    		mv.addObject("speaker", speakerDTO);
    		mv.addObject("message", message);
		}

    	return mv;
	}

	public boolean updateSpeaker(Speaker s) {
		try {
    		if(s.getName().strip() == "" || s.getSurname().strip() == "" || s.getRole().strip() == "" || s.getInstitution().strip() == "" || s.getPictureURL().strip() == "") {
    			throw new Exception("Some fields are empty.");
    		}
    		s.setPictureURL("http://161.53.19.210:8080/images/" + s.getPictureURL());
    		speakerRepo.save(s);
    		return true;
    	} catch (Exception ex) {
    		System.out.println(ex);
    		return false;
    	}
	}
}
