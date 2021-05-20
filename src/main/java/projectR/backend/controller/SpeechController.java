package projectR.backend.controller;

import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import projectR.backend.DTO.AddSpeechRequest;
import projectR.backend.DTO.UpdateSpeechRequest;
import projectR.backend.service.SpeechService;


@RolesAllowed({"ADMIN"})
@Controller
@RequestMapping("/speeches")
public class SpeechController {

    @Autowired
    private SpeechService speechService;

    @GetMapping("/add")
    public ModelAndView addSpeech(@RequestParam(value="saved") Optional<String> saved) {
    	String message = null;
		String result = null;
		
		if(!saved.isEmpty()) {
			result = saved.get();		
			if(result.equals("true")) {
				message = "Speech saved successfully!";
			} else if (result.equals("false")){
				message = "All fields must be filled correctly!";
			}
		}
        return speechService.getAddSpeechForm(message);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView addSpeech(@ModelAttribute AddSpeechRequest s) {
    	try {
    		return speechService.addSpeech(s);
    	} catch (Exception e) {
    		System.out.println(e);
    		return new ModelAndView("redirect:/speeches/add?saved=false");
    	}
        
    }

    @GetMapping("/manage")
    public ModelAndView manageSpeakers(@RequestParam(value="saved") Optional<String> saved) {
    	String message = null;
		String result = null;
		
		if(!saved.isEmpty()) {
			result = saved.get();		
			if(result.equals("true")) {
				message = "Speech saved successfully!";
			} else if (result.equals("false")){
				message = "All fields must be filled correctly!";
			}
		}
        return speechService.getDeleteSpeechForm(message);
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public ModelAndView deleteSpeechById(@PathVariable("id") Long id) {
        return speechService.deleteSpeechById(id);
    }

    @GetMapping("/update/{id}")
    public ModelAndView getUpdateSpeech(@PathVariable("id") Long id, @RequestParam(value="saved") Optional<String> saved) {
    	String message = null;
		String result = null;
		
		if(!saved.isEmpty()) {
			result = saved.get();		
			if(result.equals("true")) {
				message = "Speech saved successfully!";
			} else if (result.equals("false")){
				message = "All fields must be filled correctly!";
			}
		}
        return speechService.getUpdateSpeechForm(id, message);
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView updateSpeech(@ModelAttribute UpdateSpeechRequest speechRequest) {
    	return speechService.updateSpeech(speechRequest);
    }
}
