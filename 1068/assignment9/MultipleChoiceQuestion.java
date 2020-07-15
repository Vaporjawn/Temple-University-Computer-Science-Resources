public class MultipleChoiceQuestion extends ObjectiveQuestion{
  String[] possibleAnswers;

  public MultipleChoiceQuestion(int points, int difficulty, int answerSpace, String questionText, String correctAnswer, String[] possibleAnswers){
    super(points, difficulty, answerSpace, questionText, correctAnswer);
    this.possibleAnswers = possibleAnswers;
  }

  public String[] getPossibleAnswers(){
    return possibleAnswers;
  }

  public String toString(){
    return this.questionText + "\n" +
    createList(this.possibleAnswers) +
    createAnswerSpace();
  }

  public String answerKey(){
    return this.questionText + "\n" +
    createAnswerList(this.possibleAnswers) +
    createAnswerSpace();
  }

  private String createList(String[] arr){
    String list = "";
    for(int i = 0; i < arr.length; i++){
        list += (i + 1) + ". " + arr[i] + "\n";
    }
    return list;
  }//createAnswerList

  private String createAnswerList(String[] arr){
    String answerList = "";
    for(int i = 0; i < arr.length; i++){
      if(arr[i].equals(this.correctAnswer)){
        answerList += (i +1) + ". ***" + arr[i] + "***\n";
      }else{
        answerList += (i + 1) + ". " + arr[i] + "\n";
      }
    }
    return answerList;
  }//createAnswerList


}
