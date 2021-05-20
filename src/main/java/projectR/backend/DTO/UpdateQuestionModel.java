package projectR.backend.DTO;

import projectR.backend.model.Question;

public class UpdateQuestionModel {

    private Long questionID;
    private String text;
    private String correctAnswer;
    private String wrongAnswer1;
    private String wrongAnswer2;

    public UpdateQuestionModel() {
    }

    public UpdateQuestionModel(Long questionID, String text, String correctAnswer, String wrongAnswer1, String wrongAnswer2) {
        this.questionID = questionID;
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer1 = wrongAnswer1;
        this.wrongAnswer2 = wrongAnswer2;
    }

    public UpdateQuestionModel(Question q) {
        this.questionID = q.getQuestionID();
        this.text = q.getQuestionText();
        this.correctAnswer = q.getCorrectAnswer();
        this.wrongAnswer1 = q.getWrongAnswer1();
        this.wrongAnswer2 = q.getWrongAnswer2();
    }

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getWrongAnswer1() {
        return wrongAnswer1;
    }

    public void setWrongAnswer1(String wrongAnswer1) {
        this.wrongAnswer1 = wrongAnswer1;
    }

    public String getWrongAnswer2() {
        return wrongAnswer2;
    }

    public void setWrongAnswer2(String wrongAnswer2) {
        this.wrongAnswer2 = wrongAnswer2;
    }
}
