package projectR.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import projectR.backend.DTO.SpeakerDTO;
import projectR.backend.model.Speaker;
import projectR.backend.service.ImageService;
import projectR.backend.service.SpeakerService;

@RolesAllowed({"ADMIN"})
@Controller
@RequestMapping("/speakers")
public class SpeakerController {

    @Autowired
    SpeakerService speakerService;
    
    @Autowired
    ImageService imageService;
    
    @GetMapping("/add")
    public ModelAndView addSpeaker(@RequestParam(value="saved") Optional<String> saved) {
		String message = null;
		String result = null;
		
		if(!saved.isEmpty()) {
			result = saved.get();		
			if(result.equals("true")) {
				message = "Speaker saved successfully!";
			} else if (result.equals("false")){
				message = "All fields must be filled correctly!";
			}
		}
		ModelAndView mv = new ModelAndView("addSpeaker");

		mv.addObject("images", imageService.retrieveAll());
		mv.addObject("message", message);
	    return mv;
	}
	
	@GetMapping("/manage")
	public ModelAndView manageSpeakers(@RequestParam(value="saved") Optional<String> saved) {
		String message = null;
		String result = null;
		
		if(!saved.isEmpty()) {
			result = saved.get();		
			if(result.equals("true")) {
				message = "Speaker saved successfully!";
			} else if (result.equals("false")){
				message = "All fields must be filled correctly!";
			}
		}
		ModelAndView mv =  new ModelAndView("manageSpeakers");
		List<SpeakerDTO> list = new ArrayList<>();
		list = speakerService.retrieveAll();
		
		mv.addObject("images", imageService.retrieveAll());
		mv.addObject("list", list);
		mv.addObject("message", message);
	    return mv;
	}
	
	@PostMapping("/delete/{id}")
	@ResponseBody
	public ModelAndView deleteSpeaker(@PathVariable("id") long id) {
		speakerService.deleteSpeakerById(id);
		return new ModelAndView("redirect:" + "/speakers/manage");
	}
	
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView addSpeaker(@ModelAttribute Speaker s) {
    	try {
			if(speakerService.addSpeaker(s)) {
				return new ModelAndView("redirect:" + "/speakers/add?saved=true");
			} else {
				throw new Exception("failed");
			}
			} catch (Exception e) {
				System.out.println(e);
				return new ModelAndView("redirect:" + "/speakers/add?saved=false");
		}
	}
    

    @GetMapping("/update/{id}")
    public ModelAndView getUpdateSpeakerForm(@PathVariable("id") Long id, @RequestParam(value="saved") Optional<String> saved) {
    	String message = null;
		String result = null;
		
		if(!saved.isEmpty()) {
			result = saved.get();		
			if(result.equals("true")) {
				message = "Question saved successfully!";
			} else if (result.equals("false")){
				message = "All fields must be filled!";
			}
		}
        return speakerService.getUpdateSpeakerForm(id, message);
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView updateSpeaker(@ModelAttribute Speaker s) {
    	String id = s.getSpeakerID().toString();
    	try {
    		if(!speakerService.updateSpeaker(s)) {
				throw new Exception("Update failed.");
			}
    		return new ModelAndView("redirect:" + "/speakers/manage?saved=true");
		} catch (Exception ex) {
			System.out.println(ex);
			return new ModelAndView("redirect:" + "/speakers/update/" + id + "?saved=false");
		}
       
        }


}
