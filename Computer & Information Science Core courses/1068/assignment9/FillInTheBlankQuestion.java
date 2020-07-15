public class FillInTheBlankQuestion extends ObjectiveQuestion{

  public FillInTheBlankQuestion(int points, int difficulty, int answerSpace, String questionText, String correctAnswer){
    super(points, difficulty, answerSpace, questionText, correctAnswer);
  }//Constructor

  public String toString(){
    return this.questionText + "\n\n";
  }

  public String answerKey(){
    return replaceBlank(this.questionText) + "\n\n";
  }

  //returns start point of blank
  private int findBlankIndex(String s){
    if(s.contains("_")){
      return s.indexOf("_");
    }else{
      return -1;
    }
  }//findBlankIndex

  //returns end point of blank
  private int findBlankEnd(String s){
    int index = -1;
    if(findBlankIndex(s) !=-1){
      for(int i = s.length() -1; i >=0; i--){
        if(s.charAt(i) == '_'){
          index = i +1;
          return index;
        }
      }
    }
    return index;
  }//findBlankEnd

  private String insertAnswer(){
    return "___" + this.correctAnswer + "___";
  }

  private String replaceBlank(String s){
    String beforeBlank = s.substring(0, findBlankIndex(s));
    String afterBlank = s.substring(findBlankEnd(s), s.length());
    return beforeBlank + insertAnswer() + afterBlank;
  }//replaceBlank

}//FillInTheBlankQuestion
