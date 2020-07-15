public class Car{
  private String make;
  private String model;
  private int year;
  private double mpg;
  private double milesDriven;
  private double fuelCapacity;
  private double fuelRemaining;

  public Car(String thisMake, String thisModel, int thisYear, double thisMpg, double thisMilesDriven, double thisFuelCapacity, double thisFuelRemaining){
    make = thisMake;
    model = thisModel;
    year = thisYear;
    mpg = thisMpg;
    milesDriven = thisMilesDriven;
    fuelCapacity = thisFuelCapacity;
    fuelRemaining = thisFuelRemaining;
  }//Car

  public String toString(){
    return year + " " + make + " " + model + "\n" +
           "MPG: " + mpg + "\n" +
           "Miles Driven: " + milesDriven + "\n" +
           fuelRemaining + "/" + fuelCapacity + " gallons in the tank\n";
  }//toString

  public void fillTank(double g){
    if(g+fuelRemaining >= fuelCapacity){
      fuelRemaining = fuelCapacity;
    }else{
      fuelRemaining += g;
    }
  }//fillTank

  public void drive(double m){
    milesDriven += m;
    fuelRemaining -= (m/mpg);
  }//drive

  public double getFuelRemaining(){
    return fuelRemaining;
  }//getFuelRemaining

}//Car
