package Bridge;

import Bridge.Question.QuestionType;
import Observer.Observer;
import Observer.Subject;

import java.util.ArrayList;

//Refined class or implementation to create a survey with the passed question type

public class CreateSurvey extends Survey{

    private String question;
    private ArrayList answer;

    public CreateSurvey(final String question, final  ArrayList answer,
                        final QuestionType questionType){
        super(questionType);
        this.question = question;
        this.answer = answer;
        //setQuestionType();
    }

    public void setQuestionType(){
        questionType.setQuestion(question);
        questionType.setAnswer(answer);
    }

    public String getQuestion(){
        return questionType.getQuestion();
    }

    public ArrayList getAnswer() {
        return questionType.getAnswer();
    }



}
