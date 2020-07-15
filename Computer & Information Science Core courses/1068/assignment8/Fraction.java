public class Fraction{
  private int numerator;
  private int denominator;

  public Fraction(int n, int d){
    numerator = n;
    denominator = d;
    reduce();
  }//Fraction

  public String toString(){
    return numerator + "/" + denominator;
  }//toString

  public int getNum(){
    return numerator;
  }//getNum

  public int getDenom(){
    return denominator;
  }//getDenom

  public void setNum(int n){
    numerator = n;
    reduce();
  }//setNum

  public void setDenom(int d){
    denominator = d;
    reduce();
  }//setDenom


  //Checks for fraction equality. Outputs true/false.
  public boolean equals(Fraction other){
    int a = numerator;
    int b = denominator;
    int c = other.numerator;
    int d = other.denominator;

    return a*d == b*c;
  }//equals

  //Adds (a/b) + (c/d)
  public Fraction add(Fraction other){
    int a = numerator;
    int b = denominator;
    int c = other.numerator;
    int d = other.denominator;

    //Calculates addition (a*d + b*c)/b*d
    int newNum = (a*d + b*c);
    int newDenom = b*d;

    //Finds Greatest Common Denominator
    int gcd = gcd(newNum, newDenom);

    newNum /= gcd;
    newDenom /= gcd;

    return new Fraction(newNum, newDenom);
  }//add

  private void reduce(){
    int gcd = gcd(numerator, denominator);
    numerator /= gcd;
    denominator /= gcd;
  }

  //Finds greatest common denominator with Euclidean Algorithm
  private int gcd(int num1, int num2){
    int a = num1;
    int b = num2;
    int temp;
    while( b != 0){
      temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }//gcd

}
