public class Test{
  Question[] questions;
  int totalPoints;

  public Test(Question[] questions){
    this.questions = questions;
    this.totalPoints = setTotalPoints();
  }

  public int setTotalPoints(){
    int sum = 0;
    for(int i = 0; i < this.questions.length; i++){
      sum += questions[i].points;
    }
    return sum;
  }

  public String toString(){
    return  "************TEST************\n" +
            createTest(this.questions) +
            "****************************";
  }//toString

  public String createTest(Question[] q){
    int numQuestions = this.questions.length;
    String testString = "";
    for(int i = 0; i < numQuestions; i++){
      testString += q[i];
    }
    return testString;
  }//createTest



  public String createAnswerKey(){
    int numQuestions = this.questions.length;
    Question[] q = this.questions;
    String testString = "";
    testString += "**********ANSWER KEY**********\n";
    for(int i = 0; i < numQuestions; i++){
      testString += q[i].answerKey();
    }
    testString += "******************************\n";
    return testString;
  }

}
