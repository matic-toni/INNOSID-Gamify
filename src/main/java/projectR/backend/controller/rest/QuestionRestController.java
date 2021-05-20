package projectR.backend.controller.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projectR.backend.DTO.QuestionDTO;
import projectR.backend.service.QuestionService;

@RestController
public class QuestionRestController {

    @Autowired
    private QuestionService questionService;
    
    @GetMapping("/questions")
    public List<QuestionDTO> getAllQuestions(@RequestParam(value="num") Optional<Long> numOfQuestions) {
       if(numOfQuestions.isEmpty()) {
        	return questionService.getQuestions();
        } else {
        	return questionService.getQuestions(numOfQuestions.get());
        }
    }
	
}
