package quiz.com.quiz;

public class Questions  {

    private int id;
    private String questions;
    private String opta;
    private String optb;
    private String optc;
    private String answer;


    Questions(){

        id=0;
        questions="";
        opta="";
        optb="";
        optc="";
        answer="";
    }

    public Questions(String questions, String opta, String optb, String optc, String answer) {

        this.answer = answer;
        this.opta = opta;
        this.optb = optb;
        this.optc = optc;
        this.questions = questions;
    }

    public String getAnswer() {
        return answer;
    }

    public int getId() {
        return id;
    }

    public String getOpta() {
        return opta;
    }

    public String getOptc() {
        return optc;
    }

    public String getOptb() {
        return optb;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public void setOptc(String optc) {
        this.optc = optc;
    }

    public void setOptb(String optb) {
        this.optb = optb;
    }

    public void setOpta(String opta) {
        this.opta = opta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
