package projectR.backend.DTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import projectR.backend.model.Question;

public class QuestionDTO {
	private long questionID;
    private String questionText;
    private List<String> answers = new ArrayList<>();
    private int correctIdx;
    
    public QuestionDTO (Question question) {
    	this.questionID = question.getQuestionID();
    	this.questionText = question.getQuestionText();
    	this.answers = randomize(question.getCorrectAnswer(), question.getWrongAnswer1(), question.getWrongAnswer2());
    	this.correctIdx = answers.indexOf(question.getCorrectAnswer());
    }

	private List<String> randomize(String correctAnswer, String wrongAnswer1, String wrongAnswer2) {
		List<String> randomized = new ArrayList<>();
		randomized.add(correctAnswer);
		randomized.add(wrongAnswer1);
		randomized.add(wrongAnswer2);
		Collections.shuffle(randomized);
		return randomized;
	}

	public long getQuestionID() {
		return questionID;
	}

	public void setQuestionID(long questionID) {
		this.questionID = questionID;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

	public int getCorrectIdx() {
		return correctIdx;
	}

	public void setCorrectIdx(int correctIdx) {
		this.correctIdx = correctIdx;
	}
    
    
}
