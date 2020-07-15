public class CarMain{

  public static void main(String args[]){
    Car[] carArray = new Car[5];

    Car car1 = new Car("Honda", "Civic", 2006, 31.0, 75002.2, 11.5, 10.0);
    Car car2 = new Car("Tesla", "Model S", 2017, 300.0, 95.5, 1.0, 1.0);
    Car car3 = new Car("BMW", "X", 2012, 35.5, 3600.2, 13.5, 13.5);
    Car car4 = new Car("Audi", "A8", 2016, 32.3, 9800.4, 15.5, 1.9);
    Car car5 = new Car("Ford", "F-150", 2018, 20.2, 32.0, 18.5, 17.2);

    carArray[0] = car1;
    carArray[1] = car2;
    carArray[2] = car3;
    carArray[3] = car4;
    carArray[4] = car5;

    //toString() works
    printCars(carArray);

    //fillTank works and does not go over fuel capacity
    fillAllTanks(carArray);

    //drive works
    driveAllCars(carArray);

    //Correctly returns fuel remaining after driving
    getAllFuelRemaining(carArray);

  }//main

  public static void printCars(Car[] arr){
    for(int i = 0; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }//printCars

  public static void fillAllTanks(Car arr[]){
    for(int i = 0; i < arr.length; i++){
      arr[i].fillTank(100);
    }
  }//fillAllTanks

  public static void driveAllCars(Car arr[]){
    for(int i = 0; i < arr.length; i ++){
      double rand = Math.random() * 100;
      arr[i].drive(rand);
    }
  }//driveAllCars

  public static void getAllFuelRemaining(Car[] arr){
    for(int i = 0; i < arr.length; i++){
      System.out.println(arr[i].getFuelRemaining() + " fuel remaining.");
    }
  }


}//CarMain
