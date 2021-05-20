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
import projectR.backend.model.Form;
import projectR.backend.service.FormService;

@RolesAllowed({"ADMIN"})
@Controller
@RequestMapping("/forms")
public class FormController {
	
	@Autowired
	private FormService formService;
	
	@GetMapping("/add")
	public ModelAndView addForm(@RequestParam(value="saved") Optional<String> saved) {
		String message = null;
		String result = null;
		
		if(!saved.isEmpty()) {
			result = saved.get();		
			if(result.equals("true")) {
				message = "Form saved successfully!";
			} else if (result.equals("false")){
				message = "All fields must be filled correctly!";
			}
		}
	
		ModelAndView mv = new ModelAndView("addForm");
		mv.addObject("message", message);
	    return mv;
	}
	
	@PostMapping("/add")
	public ModelAndView addEvent(@RequestBody Form form) {
		try {
			if(formService.addForm(form)) {
				return new ModelAndView("redirect:" + "/forms/add?saved=true");
			} else {
				throw new Exception("failed");
			}
			} catch (Exception e) {
				System.out.println(e);
				return new ModelAndView("redirect:" + "/forms/add?saved=false");
		}
	}
	
	@GetMapping("/manage")
	public ModelAndView manageForms(@RequestParam(value="saved") Optional<String> saved) {
		String message = null;
		String result = null;
		
		if(!saved.isEmpty()) {
			result = saved.get();		
			if(result.equals("true")) {
				message = "Form saved successfully!";
			} else if (result.equals("false")){
				message = "All fields must be filled!";
			}
		}
		
		ModelAndView mv =  new ModelAndView("manageForms");
		List<Form> list = new ArrayList<>();
		list = formService.retrieveAll();
		
		mv.addObject("list", list);
		mv.addObject("message", message);
        return mv;
    }
	
	@GetMapping("/update/{id}")
	public ModelAndView updateForm(@PathVariable("id") Long id, @RequestParam(value="saved") Optional<String> saved) {
		String message = null;
		String result = null;
		
		if(!saved.isEmpty()) {
			result = saved.get();		
			if(result.equals("true")) {
				message = "Form saved successfully!";
			} else if (result.equals("false")){
				message = "All fields must be filled!";
			}
		}
		return formService.getUpdateForm(id, message);
	}
	
	@PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView updateForm(@ModelAttribute Form form) {
		String id = form.getFormID().toString();
		try {
			if(!formService.updateForm(form)) {
				throw new Exception("Update failed.");
			}
			return new ModelAndView("redirect:" + "/forms/manage?saved=true");
		} catch (Exception ex) {
			System.out.println(ex);
			return new ModelAndView("redirect:" + "/forms/update/" + id + "?saved=false");
		}
			
	}
	
	@PostMapping("/delete/{id}")
	@ResponseBody
	public ModelAndView deleteForm(@PathVariable("id") long id) {
		formService.removeForm(id);
		return new ModelAndView("redirect:" + "/forms/manage");
	}
}
