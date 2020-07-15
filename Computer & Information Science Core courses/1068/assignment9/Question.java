public class Question{
  protected final int MIN_DIFFICULTY = 1;
  protected final int MAX_DIFFICULTY = 10;
  protected int points;
  protected int difficulty;
  protected int answerSpace;
  protected String questionText;

  public Question(int points, int difficulty, int answerSpace, String questionText){
    this.points = points; //Makes sure points are within the min-max range;
    this.difficulty = ensureDifficultyRange(difficulty);
    this.answerSpace = answerSpace;
    this.questionText = questionText;
  }

  public String toString(){
    return this.questionText + "\n" + createAnswerSpace();
  }

  public String answerKey(){
    return "";
  }

  protected String createAnswerSpace(){
    String spaces = "";

    for(int i = 0; i < this.answerSpace; i++){
      spaces+= "\n";
    }
    return spaces;
  }

  public int getPoints(){
    return this.points;
  }
  public int getDifficulty(){
    return this.difficulty;
  }
  public int getAnswerSpace(){
    return this.answerSpace;
  }
  public String getQuestionText(){
    return this.questionText;
  }

  public int ensureDifficultyRange(int difficulty){
  	    if (difficulty < MIN_DIFFICULTY){
  	      return MIN_DIFFICULTY;
  	    }else if(difficulty > MAX_DIFFICULTY){
  	      return MAX_DIFFICULTY;
  	    }else{
  	      return difficulty;
  	    }
  	  }
}//Question
