/*
*Jared Gross
*1068 Section 005
*September 12, 2018
*Professor Fiore
*
*Description: This program uses class constants, for loops, and conditionals to
*             draw AsciiArt of the linc and its parking lot. It also prints a flag
*             using a triple nested for loop.
*
*             -This program works best when the constant SIZE >= 4.
*             -The AsciiArt grows or shrinks in proportion to the value of SIZE
*             -No constant other than SIZE should be changed.
*/

public class AsciiArt{

//****************CONSTANT VALUES****************//

  public static final int SIZE = 4;
  public static final int PARKING_WIDTH = SIZE * 4 + 2;
  public static final int PARKING_LENGTH = SIZE * 4;
  public static final int STADIUM_WIDTH = SIZE * 8 + 2;
  public static final int STADIUM_LENGTH = SIZE * 4 + 2;
  public static final int FIELD_WIDTH = SIZE * 2;

//****************MAIN****************//

  public static void main(String[] args){
    parkingLot();
    lincStadium();
    flag();
  }//main


//****************PARKING LOT****************//

  public static void parkingLot(){
    parkingTopLine();
    parkingSpaces();
  }//parkingLot

//**PARKING LOT PIECES

  public static void parkingTopLine(){
    System.out.print(" ");
    centerParking();
    for(int i = 0; i < PARKING_WIDTH - 1; i++){
      System.out.print("_");
    }
    System.out.println();
  }//parkingTopLine

  public static void parkingSpaces(){
    for(int i = 0; i < PARKING_LENGTH; i++){
      centerParking();
      oneParkingSpace();
      oneParkingSpace();
      System.out.print("|");
      System.out.println();
    }
  }//parkingSpaces

  public static void oneParkingSpace(){
    int spaceWidth = (PARKING_WIDTH -2)/2;
    System.out.print('|');
    for(int i = 0; i < spaceWidth; i++){   //Subtract outer lines +
      System.out.print("_");                         //divide because it is a singular spot
    }
  }//oneParkingSpace

  public static void centerParking(){
    int spacesToCenter = SIZE * 2;
    for(int i = 0; i < spacesToCenter; i++){
      System.out.print(" ");
    }
  }//centerParking

//****************STADIUM****************//

  public static void lincStadium(){
    stadiumTopBorder();
    stadiumTopHalf();
    stadiumBottomHalf();
  }//lincStadium

//**STADIUM PIECES

//STADIUM TOP HALF

  public static void stadiumTopBorder(){
    System.out.print(" ");
    for(int i = 0; i < STADIUM_WIDTH; i++){
      System.out.print("_");
    }
    System.out.println();
  }//stadiumEndLine

  public static void stadiumTopHalf(){
    for(int line = 0; line < STADIUM_LENGTH/2; line++){
      System.out.print("|");
      if(line == 0){
        stadiumTopLine0(line);
      }else if(line <= SIZE){
        stadiumTopSeats(line);
      }else{
        stadiumTopWithField(line);
      }
    }
  }//stadiumTopHalf

    public static void stadiumTopLine0(int line){
      stadiumTopSpaces(line);
        System.out.print("__");
      stadiumTopSpaces(line);
      System.out.println("|");
    }//stadiumTopLine0

    public static void stadiumTopSeats(int line){    //Stadium before field is drawn
      int numberOfSeats = (line * 4) -2;
      stadiumTopSpaces(line);
      System.out.print("_/");
      for(int i =0; i < numberOfSeats; i++){
        System.out.print(".");
      }
      System.out.print("\\_");
      stadiumTopSpaces(line);
      System.out.println("|");
    }//stadiumTopSeats

    public static void stadiumTopWithField(int line){
      int numberOfSeats = ((line * 4) - 2 - FIELD_WIDTH)/2;
      stadiumTopSpaces(line);
      System.out.print("_/");
      for(int i = 0; i < numberOfSeats; i++){
        System.out.print(".");
      }
      field();
      for(int i = 0; i < numberOfSeats; i++){
        System.out.print(".");
      }
      System.out.print("\\_");
      stadiumTopSpaces(line);
      System.out.println("|");
    }//staidumTopWithField


    public static void stadiumTopSpaces(int line){
      int numberOfSpaces = (SIZE*4) - (line * 2);
      for(int i = 0; i < numberOfSpaces; i++){
        System.out.print(" ");
      }
    }//stadiumTopSpaces

//STADIUM BOTTOM HALF
    public static void stadiumBottomHalf(){
      for(int line = (STADIUM_LENGTH/2) -1; line >= 0; line--){
        System.out.print("|");
        if(line == 0){
          stadiumBottomLine0();
        }else if(line <= SIZE){
          stadiumBottomSeats(line);
        }else{
          stadiumBottomWithField(line);
        }
      }
    }//stadiumBottomHalf

    public static void stadiumBottomLine0(){
      for(int i = 0; i < STADIUM_WIDTH; i++){
        System.out.print("_");
      }
      System.out.println("|");
    }//stadiumTopLine0

    public static void stadiumBottomSeats(int line){        //Stadium after field is drawn
      int numberOfSeats = (line * 4) -4;
      stadiumBottomSpaces(line);
      System.out.print("\\_");
      for(int i =0; i < numberOfSeats; i++){
        System.out.print(".");
      }
      System.out.print("_/");
      stadiumBottomSpaces(line);
      System.out.println("|");
    }//stadiumTopSeats

    public static void stadiumBottomWithField(int line){
      int numberOfSeats = ((line * 4) -(4 + FIELD_WIDTH))/2;
      stadiumBottomSpaces(line);
      System.out.print("\\_");
      for(int i = 0; i < numberOfSeats; i++){
        System.out.print(".");
      }
      field();
      for(int i = 0; i < numberOfSeats; i++){
        System.out.print(".");
      }
      System.out.print("_/");
      stadiumBottomSpaces(line);
      System.out.println("|");
    }//stadiumBottomWithField

    public static void stadiumBottomSpaces(int line){
      int numberOfSpaces = (STADIUM_WIDTH/2) - (line * 2);
      for(int i = 0; i < numberOfSpaces; i++){
        System.out.print(" ");
      }
    }//stadiumTopSpaces

    public static void field(){
      for(int i = 0; i < FIELD_WIDTH; i++){
        System.out.print("*");
      }
    }//field

//************FLAG************//

public static void flag(){
  flagTop();
  flagBottom();
  flagPole();
}//flag

public static void flagTop(){
  for(int line = 0; line <= SIZE; line++){
    for(int i = 0; i < line; i++){
        System.out.print("*");
      for(int j = 0; j <i; j++){
        System.out.print("_");
      }
    }
    System.out.println();
  }
}//flagTop

public static void flagBottom(){
  for(int line = SIZE; line > 0; line--){
    for(int i = 0; i < line; i++){
        System.out.print("*");
      for(int j = 0; j <i; j++){
        System.out.print("_");
      }
    }
    System.out.println();
  }
}//flagBottom

public static void flagPole(){
  int poleLength = SIZE * 4;
  for(int i = 0; i < poleLength; i++){
    System.out.println("**");
  }
}//flagPole

}//AsciiArt
