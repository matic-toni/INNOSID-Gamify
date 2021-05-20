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
import projectR.backend.DTO.QuestionDTO;
import projectR.backend.model.Question;
import projectR.backend.service.QuestionService;

@RolesAllowed({"ADMIN"})
@Controller
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
    private QuestionService questionService;
	
	@GetMapping("/add")
	public ModelAndView addQuestions(@RequestParam(value="saved") Optional<String> saved) {
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
		
		ModelAndView mv = new ModelAndView("addQuestion");
		mv.addObject("message", message);
        return mv;
    }
	
	@PostMapping("/add")
	public ModelAndView addQuestion(@RequestBody Question q) {
		return questionService.addQuestion(q);
	}
	
	@GetMapping("/manage")
	public ModelAndView manageQuestions(@RequestParam(value="saved") Optional<String> saved) {
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
		
		ModelAndView mv =  new ModelAndView("manageQuestions");
		List<QuestionDTO> list = new ArrayList<>();
		list = questionService.getQuestionsSorted();
		
		mv.addObject("list", list);
		mv.addObject("message", message);
        return mv;
    }
	
	@PostMapping("/delete/{id}")
	@ResponseBody
	public ModelAndView deleteQuestion(@PathVariable("id") long id) {
		questionService.removeQuestion(id);
		return new ModelAndView("redirect:" + "/questions/manage");
	}

	@GetMapping("/update/{id}")
	public ModelAndView updateQuestionForm(@PathVariable("id") Long id, @RequestParam(value="saved") Optional<String> saved) {
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
		return questionService.getUpdateQuestionForm(id, message);
	}

	@PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView updateQuestion(@ModelAttribute Question question) {
		String id = question.getQuestionID().toString();
		try {
			if(!questionService.updateQuestion(question)) {
				throw new Exception("Update failed.");
			}
			return new ModelAndView("redirect:" + "/questions/manage?saved=true");
		} catch (Exception ex) {
			System.out.println(ex);
			return new ModelAndView("redirect:" + "/questions/update/" + id + "?saved=false");
		}
			
	}
}
