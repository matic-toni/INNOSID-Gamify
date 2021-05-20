package projectR.backend.model;

import javax.persistence.*;

@Entity
@Table(name="questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionID;

    @Column(name = "questionText")
    private String questionText;

    @Column(name = "correctAnswer")
    private String correctAnswer;

    @Column(name = "wrongAnswer1")
    private String wrongAnswer1;

    @Column(name = "wrongAnswer2")
    private String wrongAnswer2;

    public Question() {
    }

    public Question(String questionText, String correctAnswer, String wrongAnswer1, String wrongAnswer2) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer1 = wrongAnswer1;
        this.wrongAnswer2 = wrongAnswer2;
    }

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
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

    @Override
    public String toString() {
        return  "Question [questionID = " + questionID + ", questionText = " + questionText
                + ", correctAnswer = " + correctAnswer + ", wrongAnswer1 = " + wrongAnswer1
                + ", wrongAnswer2 = " + wrongAnswer2 + "]";
    }
    
}
