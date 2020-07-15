/*
*Assignment #9
*
*Jared Gross
*November 4, 2018
*
*CIS1068
*Professor Fiore
*
*Description: Uses multiple classes to create different question types:
*             -Objective Question
*             -Fill in the Blank Question
*             -Multiple Choice Question
*             TestBank class allows random tests to be generated, made into files,
*             and also read those files to the console.
*/
import java.io.*;
import java.util.*;


public class Driver{

  public static void main(String args[]) throws FileNotFoundException{
    Scanner in = new Scanner(System.in);

    //gets test questions from TestBank class
    TestBank questions = new TestBank();

    //creates a random test based on the number of questions the user inputs
    questions.writeTest(in);

    //reads a file that user chooses
    //user does NOT input ".txt" to the end of files
    questions.readFile(in);



  }


//***************FOR TEST CREATION WITHOUT TESTBANK**************//
  // //Create one question of each type
  //
  // ObjectiveQuestion q1 = new ObjectiveQuestion(3, 3, 3, "What color is the sky?", "Blue");
  //
  // FillInTheBlankQuestion q2 = new FillInTheBlankQuestion(3, 3, 3, "The color of the sky is _______.", "blue");
  //
  // String[] possibleAns = {"Red", "Blue", "Green"};
  // MultipleChoiceQuestion q3 = new MultipleChoiceQuestion(3, 3, 1, "What color is the sky?", "Blue", possibleAns);
  //
  // //create Question array
  // Question[] questions = {q1,q2,q3};
  //
  // //create test made up of the questions
  // Test assessment = new Test(questions);
  //
  // String test = assessment.toString();
  // String answers = assessment.createAnswerKey();
  //
  // // //print the test
  // // System.out.println(test);
  // //
  // // //print the test w/ the answer key
  // // System.out.println(answers);
  //
  // //Prompts user for name and writes a test file
  // System.out.println("It is time to make your test file...");
  // String testFile = askForFileName(in);
  // writeFile(testFile, test);
  //
  // System.out.println("It is time to make your answer key file...");
  // String answerFile = askForFileName(in);
  // writeFile(answerFile, answers);

  // //Prompts user for a file name and returns it
  // public static String askForFileName(Scanner in){
  //   System.out.print("Provide a file name (no .txt, etc...): ");
  //   String fileName = in.nextLine();
  //   return fileName;
  // }
  //
  // //Takes in a name and input, and creates a file
  // public static void writeFile(String fileName, String input) throws FileNotFoundException{
  //   PrintStream out = new PrintStream(new File(fileName + ".txt"));
  //   out.println(input);
  // }




}
