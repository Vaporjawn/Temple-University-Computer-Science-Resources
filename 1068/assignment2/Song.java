//Jared Gross
//1068 Section 005
//September 3, 2018
//Professor Fiore
//
//Description: This program uses static methods and println statements
//             to print the lyrics to a song efficiently.

public class Song{
  public static void main(String[] args){
    verse1();
    verse2();
    verse3();
    verse4();
    verse5();
    verse6();

  }//main

  //VERSES

  public static void verse1(){
    System.out.println("Bought me a cat and the cat pleased me," +
    "\nI fed my cat under yonder tree.");
    cat();
    System.out.println();
  }//verse1
  public static void verse2(){
    System.out.println("Bought me a hen and the hen pleased me," +
    "\nI fed my hen under yonder tree.");
    hen();
    System.out.println();
  }//verse2
  public static void verse3(){
    System.out.println("Bought me a duck and the duck pleased me," +
    "\nI fed my duck under yonder tree.");
    duck();
    System.out.println();
  }//verse3
  public static void verse4(){
    System.out.println("Bought me a goose and the goose pleased me," +
    "\nI fed my goose under yonder tree.");
    goose();
    System.out.println();
  }//verse4
  public static void verse5(){
    System.out.println("Bought me a sheep and the sheep pleased me," +
    "\nI fed my sheep under yonder tree.");
    sheep();
    System.out.println();
  }//verse5
  public static void verse6(){
    System.out.println("Bought me a rabbit and the rabbit pleased me," +
    "\nI fed my rabbit under yonder tree.");
    rabbit();
    System.out.println();
  }//verse6

  //INDIVIDUAL ANIMAL LINES (Each compounds as the lines go down)

  public static void cat(){
    System.out.println("Cat goes fiddle-i-fee.");
  }//cat
  public static void hen(){
    System.out.println("Hen goes chimmy-chuck, chimmy-chuck,");
    cat();
  }//hen
  public static void duck(){
    System.out.println("Duck goes quack, quack,");
    hen();
  }//duck
  public static void goose(){
    System.out.println("Goose goes hissy, hissy,");
    duck();
  }//goose
  public static void sheep(){
    System.out.println("Sheep goes baa, baa,");
    goose();
  }//sheep
  public static void rabbit(){
    System.out.println("Rabbit goes ..., ...,");
    sheep();
  }//rabbit

}//Song
