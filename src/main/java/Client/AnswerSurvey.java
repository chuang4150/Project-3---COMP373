package Client;

import Bridge.CreateSurvey;
import Data.Surveys;
import Observer.Observer;


import java.util.ArrayList;
import java.util.Scanner;

//Observer class to display to the user when there is a new survey to answer

public class AnswerSurvey implements Observer {

    private String response;
    Scanner scan = new Scanner(System.in);

    //shows all the surveys
    public void answerAll(ArrayList<CreateSurvey> surveys){
        for (int i = 0; i < surveys.size(); i++){
            printQuestion(surveys.get(i));
            printAnswer(surveys.get(i));
            getResponse();
        }
    }

    //shows the newest surveys
    public void answerNew(CreateSurvey survey){
        printQuestion(survey);
        printAnswer(survey);
        getResponse();
    }

    public void printQuestion(CreateSurvey survey){
        System.out.println(survey.getQuestion());
    }

    public void printAnswer(CreateSurvey survey){
        System.out.println(survey.getAnswer().toString());
    }

    public void getResponse(){
        System.out.print("Your Answer:");
        response = scan.next();
    }

    //when there is a new survey this is called and it shows the surveys how the user wants them (all surveys, or just the newest)
    public void update(Object o){
        if (o instanceof Surveys){
            Surveys so = (Surveys) o;
            String State = "go";
            while (State != "stop") {
                System.out.println("There is a new survey!, what would you like to do?");
                System.out.println("1: See Newest Survey");
                System.out.println("2: See All Surveys");
                System.out.print("1 or 2: ");
                int choice = scan.nextInt();
                if (choice == 1) {
                    answerNew(so.surveys.get(so.surveys.size() - 1));
                    break;
                }
                if (choice == 2){
                    answerAll(so.surveys);
                    break;
                }
                else{
                    System.out.println("Not a valid choice try again.");
                }
            }
        }
    }
}
