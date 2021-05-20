package projectR.backend.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import projectR.backend.DTO.QuestionDTO;
import projectR.backend.DTO.UpdateQuestionModel;
import projectR.backend.model.Question;
import projectR.backend.repository.QuestionRepo;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;
    
    public List<QuestionDTO> getQuestions() {
    	return getQuestions(questionRepo.count());
    }
    
    public List<QuestionDTO> getQuestions(long numOfQuestions) {
    	List<Question> questions = questionRepo.findAll();
        
    	questions = getRandom(numOfQuestions, questions);

        List <QuestionDTO> questionsDTO = new ArrayList<>();
        
        for(Question q : questions) {
        	QuestionDTO qDTO = new QuestionDTO(q);
        	questionsDTO.add(qDTO);
        }
        return questionsDTO;
    }

    
    public ModelAndView addQuestion(Question q) {
    	if(q.getQuestionText().strip() == "" || q.getCorrectAnswer().strip() == "" || q.getWrongAnswer1().strip() == "" || q.getWrongAnswer2().strip() == "") {
    		return new ModelAndView("redirect:" + "/questions/add?saved=false");
    	} else {
	        this.questionRepo.save(q);
	        return new ModelAndView("redirect:" + "/questions/add?saved=true");
    	}
    }
    
    
    /**
     * Picks random questions from the initially given list and returns a list of them.
     * If given a number of questions bigger than the size of the initial array, returns all questions from the initial array.
     * @param num number of questions in a new list
     * @param questions the given list from which random questions will be retrieved
     * @return list consisting of a specified number of questions chosen randomly from the initially given list.
     * @throws IllegalArgumentException if number of questions is negative
     */
    private List<Question> getRandom(long num, List<Question> questions){
    	List<Question> random = new ArrayList<>();
    	
    	SecureRandom rand = new SecureRandom();
    	
        int total = questions.size();
        for(int i = 0; i < Math.min(num, total); i++) {
        	int randIndex =  rand.nextInt(questions.size());
            random.add(questions.remove(randIndex));
        }
        
        return random;
    }

	public List<QuestionDTO> getQuestionsSorted() {
		List<Question> questions = questionRepo.findAll();

        List <QuestionDTO> questionsDTO = new ArrayList<>();
        
        for(Question q : questions) {
        	QuestionDTO qDTO = new QuestionDTO(q);
        	List<String> answersSorted = new ArrayList<>();
        	answersSorted.add("Correct: " + q.getCorrectAnswer());
        	answersSorted.add("Wrong1: " + q.getWrongAnswer1());
        	answersSorted.add("Wrong2: " + q.getWrongAnswer2());
        	qDTO.setAnswers(answersSorted);
        	questionsDTO.add(qDTO);
        }
        return questionsDTO;
	}


	public void removeQuestion(long id) {
		questionRepo.removeByQuestionID(id);
		return;
	}

	public ModelAndView getUpdateQuestionForm(Long id, String message){
        ModelAndView mv = new ModelAndView("updateQuestion");

        UpdateQuestionModel question = new UpdateQuestionModel(questionRepo.getOne(id));

        mv.addObject("question", question);
        mv.addObject("message", message);

        return mv;
    }

    public boolean updateQuestion(Question q) {
    	try {
    		if(q.getQuestionText().strip() == "" || q.getCorrectAnswer().strip() == "" || q.getWrongAnswer1().strip() == "" || q.getWrongAnswer2().strip() == "") {
    			throw new Exception("Some fields are empty.");
    		}
    		questionRepo.save(q);
    		return true;
    	} catch (Exception ex) {
    		System.out.println(ex);
    		return false;
    	}
    }
    
}
