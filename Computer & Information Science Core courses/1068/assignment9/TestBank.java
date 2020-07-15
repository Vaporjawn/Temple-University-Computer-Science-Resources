import java.io.*;
import java.util.*;

public class TestBank {

  protected Question[] questions;


  public TestBank(){
    this.questions = questionBank();
  }


//******************QUESTIONS STORAGE**********************//
  public Question[] questionBank(){
    ObjectiveQuestion q1 = new ObjectiveQuestion(3, 3, 3, "What color is the sky?", "Blue");

    FillInTheBlankQuestion q2 = new FillInTheBlankQuestion(3, 3, 3, "The color of the sky is _______.", "blue");

    String[] possibleAns = {"Red", "Blue", "Green"};
    MultipleChoiceQuestion q3 = new MultipleChoiceQuestion(3, 3, 1, "What color is the sky?", "Blue", possibleAns);

    ObjectiveQuestion q4 = new ObjectiveQuestion(3, 3, 3, "What color is grass?", "Green");

    FillInTheBlankQuestion q5 = new FillInTheBlankQuestion(3, 3, 3, "The color of grass is _______.", "green");

    String[] possibleAns2 = {"Red", "Blue", "Green"};
    MultipleChoiceQuestion q6 = new MultipleChoiceQuestion(3, 3, 1, "What color is grass?", "Green", possibleAns2);

    Question[] questions = {q1, q2, q3, q4, q5, q6};

    return questions;
  }

  //*******************WRITING TO FILES***********************//

  public void writeTest(Scanner in) throws FileNotFoundException{
    int totalQuestions = this.questions.length;
    int testLength = findTestLength(this.questions, in);

    //Choose random questions from the bank
    Question[] questions = chooseQuestions(totalQuestions, testLength);
    Test assessment = new Test(questions);

    //create a test string and answer key string
    String test = assessment.toString();
    String answers = assessment.createAnswerKey();

    //get test file name, and write the file
    System.out.println("Choose a file name for the test...");
    String testName = askForFileName(in);
    writeFile(testName, test);

    //get answer file name, and write the file
    System.out.println("Choose a file name for the answer key...");
    String answersName = askForFileName(in);
    writeFile(answersName, answers);
  }

  //Asks user for the amount of quesitons to add to test
  private int findTestLength(Question[] questions, Scanner in){
    int numQuestions = questions.length;
    System.out.println("How many questions would you like? (You may choose up to " + numQuestions+ " )");
    int testLength = in.nextInt();

    //Accounts for invalid input
    while(testLength < 0 || testLength > numQuestions){
      System.out.println("Incorrect range, try again...");
      System.out.println("How many questions would you like? (You may choose up to " + numQuestions+ " )");
      testLength = in.nextInt();
    }
    return testLength;
  }//findTestLength

  //Chooses questions to add to test and returns an array of questions
  private Question[] chooseQuestions(int totalQuestions, int testLength){
    int[] availableQuestions = new int[totalQuestions];
    Question[] testQuestions = new Question[testLength];
    //fill availableQuestions up to the number of questions
    //keeps track of chosen questions (no repeats)
    for(int i = 0; i < totalQuestions; i++){
      availableQuestions[i] = i;
    }

    //fill test question array with random questions
    //checks for no duplicates
    for(int i = 0; i < testLength; i++){
      int rnd =  (int) Math.round(Math.random()* (totalQuestions -1));
      while(availableQuestions[rnd] == -1){
        rnd = (int) Math.round(Math.random()* (totalQuestions -1));
      }
      testQuestions[i] = this.questions[rnd];
      availableQuestions[rnd] = -1;
    }

    return testQuestions;
  }//chooseQuestions

  //Prompts user for a file name and returns it
  public String askForFileName(Scanner in){
    System.out.print("Provide a file name here (no .txt, etc...): ");
    String fileName = in.next();
    return fileName;
  }

  //Takes in a name and input, and creates a file
  public void writeFile(String fileName, String input) throws FileNotFoundException{
    PrintStream out = new PrintStream(new File(fileName + ".txt"));
    out.println(input);
  }

//******************READING FROM FILES************************//

  public void readFile(Scanner in) throws FileNotFoundException{
    System.out.println("What file would you like to open?");
    String fileName = askForFileName(in);
    Scanner file = new Scanner(new File(fileName + ".txt"));
    while(file.hasNextLine()){
      System.out.println(file.nextLine());
    }
  }



}//TestBank
