import java.util.*;
import java.io.*;

public class Recommend{
  public static final int BOOKCOUNT = 20;
  public static final int USERCOUNT = 30;
  public static final int NUM_RECOMMENDATIONS = 3;

  public static void main(String args[]) throws FileNotFoundException{
    Scanner books = new Scanner(new File("bookNames.txt"));
    Scanner ratings = new Scanner(new File("ratings.txt"));
    Scanner kbd = new Scanner(System.in);


    //creates an array of book names as Strings
    String[] bookArray = new String[BOOKCOUNT];
    fillBookArray(bookArray, books);

    //creates an array of array of scores. Each array correlates to a user.
    int[][] ratingsArray = new int[USERCOUNT][BOOKCOUNT];
    fillRatingsArray(ratingsArray, ratings);

    //creates an Array and fills it with User input (-1 through 5)
    int[] userRatings = new int[BOOKCOUNT];
    askForRatings(userRatings, bookArray, kbd);

    double[] similarityRatings = new double[USERCOUNT];
    compareSimilarity(userRatings, ratingsArray, similarityRatings);

    double[] weightedAverages = new double[BOOKCOUNT];
    calcWeightAvg(ratingsArray, similarityRatings, weightedAverages);

    //Used if user has read nothing/rates nothing
    double[] regularAverages = new double[BOOKCOUNT];
    calcAvg(ratingsArray, regularAverages);

    String[] recommendedBooks = new String[NUM_RECOMMENDATIONS];
    recommendBooks(weightedAverages, recommendedBooks, bookArray, regularAverages);


    System.out.println(Arrays.toString(regularAverages));
    printRecommendations(recommendedBooks);
  }//main

//********FILL INITIAL ARRAYS********//

  public static void fillBookArray(String[] arr, Scanner file) {
    for(int i = 0; i < arr.length; i++){
      arr[i] = file.nextLine();
    }
  }//fillBookArray

  public static void fillRatingsArray(int[][] arr, Scanner file){
    for(int i = 0; i <USERCOUNT; i++){
      for(int j = 0; j < BOOKCOUNT; j++){
        if(file.hasNextInt()){
          arr[i][j] = file.nextInt();
        }
      }
    }
  }//fillRatingsArray

  //Fills user ratings array
  public static void askForRatings(int[] arr, String[] bookArray, Scanner kbd){
    for(int i = 0; i < BOOKCOUNT; i++){
      System.out.println("Rate the following (0-5 or -1 if you haven't read it):");
      System.out.println(bookArray[i]);
      int input = kbd.nextInt();
      while(input < -1 || input > 5){
        System.out.println("Incorrect input, must be between 0-5 or -1 if you haven't read it");
        input = kbd.nextInt();
      }
        arr[i] = input;
        System.out.println();
    }
  }//askForRatings

//********SIMILARITY********//
  public static void compareSimilarity(int[] userArr, int[][] ratingsArr, double[] simRatings){
    for(int i =0; i < USERCOUNT; i++){
      double similarity = computeSimilarity(userArr, ratingsArr[i]);
      simRatings[i] = similarity;
    }
  }

  //computes similarity with cosine similarity
  public static double computeSimilarity(int arr1[], int arr2[]){
    double p1 = computeIndividual(arr1);
    double p2 = computeIndividual(arr2);
    double both = 0;

    for(int i = 0; i < arr1.length; i++){
      if(arr1[i]!= -1 && arr2[i] != -1){
        both += arr1[i] * arr2[i];
      }
    }

    double similarity = both/(p1*p2);
    return similarity;
  }//computeSimilarity

  public static double computeIndividual(int arr[]){
    double sum = 0.0;
    for(int i = 0; i < arr.length; i ++){
      if(arr[i] != -1){
        sum += arr[i] * arr[i];
      }
    }
    return Math.sqrt(sum);
  }

  //********WEIGHTED AVERAGE********//

  public static void calcWeightAvg(int[][] ratings, double[] simRatings, double[] weightAvg){
    double weightSum = 0;
    double simScoresSum = sumOfCollection(simRatings);
    for(int i = 0; i < BOOKCOUNT; i++){
      for(int j = 0; j < USERCOUNT; j++){
        //Go down each row and weight avg using sim ratings for each
        if(ratings[j][i] != -1){
          weightSum += ratings[j][i] * simRatings[j];
        }
      }
      //Divide that sum by sum of all similarity scores and add that value to that book index
      weightAvg[i] = weightSum/simScoresSum;
      weightSum = 0;
    }
  }

  public static double sumOfCollection(double[] arr){
    double sum = 0;
    for(int i = 0; i < arr.length; i++){
      sum += arr[i];
    }
    return sum;
  }

  //********NON-WEIGHTED AVERAGE********//

  public static void calcAvg(int[][] ratings, double[] regAvg){
    for(int i = 0; i < BOOKCOUNT; i++){
      double sum = 0;
      int booksCounted = 0;
      for(int j = 0; j < USERCOUNT; j++){
        if (ratings[j][i] != -1){
          sum+= ratings[j][i];
          booksCounted ++;
        }
      }
      regAvg[i] = sum/booksCounted;
    }
  }

  //********CHOOSE RECOMMENDATION********//
  public static void recommendBooks(double[] weightAvg, String[] recommendedBooks, String[] bookArr, double[] regAvg){
    int maxIndex = -1;
    for(int i = 0; i < NUM_RECOMMENDATIONS; i++){
      if(indexOfMax(weightAvg, maxIndex) != -1){
        maxIndex = indexOfMax(weightAvg, maxIndex);
        recommendedBooks[i] = bookArr[maxIndex];
      //Accounts for case where user read nothing (gives result from non-weighted average)
      }else{
        maxIndex = indexOfMax(regAvg, maxIndex);
        recommendedBooks[i] = bookArr[maxIndex];
      }
    }
  }

  public static int indexOfMax(double[] arr, int notAllowed){
    int maxIndex = -1;
    double maxValue = -1;
    for(int i = 0; i < arr.length; i++){
      //Chooses the actual max
      if(arr[i] > maxValue && notAllowed == -1){
          maxValue = arr[i];
          maxIndex = i;
      //Chooses the next max. Not allowed is the index of the previous max
      }else{
        if(arr[i] > maxValue && arr[i] < arr[notAllowed]){
          maxValue = arr[i];
          maxIndex = i;
        }
      }
    }
    return maxIndex;
  }

  public static void printRecommendations(String[] recommendedBooks){
    System.out.println();
    System.out.println("Here are your recommendations in preferential order:");
    for(int i = 0; i < NUM_RECOMMENDATIONS; i++){
      System.out.println(i+1 +". " + recommendedBooks[i]);
    }
  }
}//Reccomend
