public class FractionsMain{
  public static void main(String args[]){
    Fraction one = new Fraction(1, 4);
    Fraction two = new Fraction(2, 8);
    Fraction three = one.add(two);
    Fraction four = new Fraction(100, 200);

    //Fraction is stored in reduced form
    System.out.println(four);

    //Addition works and is stored in reduced form
    System.out.println(three);

    //Equals outputs correctly
    System.out.println(two.equals(one));

    // //Recheck Equals with non reduced fraction
    // two.setNum(4);
    // System.out.println(two);
    // System.out.println(two.equals(one));

  }
}
