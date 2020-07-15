public class ObjectiveQuestion extends Question{
  protected String correctAnswer;

  public ObjectiveQuestion(int points, int difficulty, int answerSpace, String questionText, String correctAnswer){
    super(points, difficulty, answerSpace, questionText);
    this.correctAnswer = correctAnswer;
  }

  public String getCorrectAnswer(){
    return correctAnswer;
  }

  public String toString(){
    return this.questionText + "\n\n" +
    createAnswerSpace();
  }

  public String answerKey(){
    return this.questionText + "\n\n" +
    "***"+ this.correctAnswer + "***"+
    createAnswerSpace();
  }
}
