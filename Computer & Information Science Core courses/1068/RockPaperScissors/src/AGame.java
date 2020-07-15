
import java.util.Scanner;

import java.util.*;

public class AGame {
 

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		 int counter = 0;
		 int numWins = 0;
		 int numLoss = 0; 
		 rules();
		 Scanner kbd = new Scanner(System.in);
		 System.out.print("Would you like to play? (y/n):");
		 String start = kbd.next();
		 while(!start.equals("y") && !start.equals("Y") && !start.equals("n") && !start.equals("N"))
		 {
			 System.out.print("Please enter a valid reponse. Would you like to play? (y/n):");
			 kbd = new Scanner(System.in);
			 start = kbd.next();
		 }
		 while(start.equals("y") || start.equals("Y")) 
		 {
			 String b = userMove();
			 String a = computerMove();
			 
			 boolean win = winner(a, b);
			 if(win == true)
			 {
				 System.out.println("Aw man! You beat me!");
				 numWins ++;
			 }
			 else
			 {
				 System.out.println("Yay! I won!");
				 numLoss ++;
			 }
			 
			 counter ++;
			 kbd = new Scanner(System.in);
			 System.out.print("Would you like to play again? (y/n):");
			 start = kbd.next();
			 while(!start.equals("y") && !start.equals("Y") && !start.equals("n") && !start.equals("N"))
			 {
				 System.out.print("Please enter a valid reponse. Would you like to play? (y/n):");
				 kbd = new Scanner(System.in);
				 start = kbd.next();
			 }
		 }
		
		System.out.println("Okay! We have played " + counter +" round(s). You have won " + numWins + " time(s). I have won " + numLoss + " time(s). I hope you play with me some other time!");
		kbd.close();
	}
	
	public static void rules() 
	{
		System.out.println("This game is called Havsta.");
		System.out.println("Here are the rules:");
		System.out.println("Applaro beats Svartrå and Tunholmen");
		System.out.println("Svartrå beats Tunholmen");
		System.out.println("Tunholmen beats Godafton");
		System.out.println("Godafton beats Applaro and Svartrå");
		System.out.println("If there is a tie, I win!");
	}
	
	public static String computerMove() 
	{
//		int Applaro = 0;
//		int Scartra = 1;
//		int Tunholmen = 2;
//		int Godafton = 3;
		String comp = "";
		Random rand = new Random();
		int move = rand.nextInt(4) + 0;
		if(move == 0) {
			comp = "Applaro";
		}
		else if(move == 1) 
		{
			comp = "Svartra";
		}
		else if(move == 2) 
		{
			comp = "Tunholmen";
		}
		else if(move == 3)
		{
			comp = "Godafton";
		}
		System.out.println("I have made my move.");
//		System.out.println(comp);
		return comp;
	}
	
	public static String userMove()
	{
		Scanner kbd = new Scanner(System.in);
		System.out.print("Please make your move. (Applaro/Svartra/Tunholmen/Godafton):");
		String user = kbd.nextLine();
		while(!user.equals("Applaro") && !user.equals("Svartra") && !user.equals("Tunholmen") && !user.equals("Godafton")) 
		{
			System.out.print("Please enter a valid move. (Applaro/Svartra/Tunholmen/Godafton):");
			user = kbd.nextLine();
			kbd.close();
		}
//		System.out.println(user);
		return user;
	}
	
	//if method returns false, computer wins
	public static boolean winner(String comp, String user)
	{
		System.out.println("My move was " + comp + " and your move was " + user);
		if(comp.contentEquals("Applaro") && (user.contentEquals("Svartra") || user.contentEquals("Tunholmen")))
		{
			return false;
		}
		else if(comp.contentEquals("Svartra") && user.contentEquals("Tunholmen"))
		{
			return false;
		}
		else if(comp.contentEquals("Tunholmen") && user.contentEquals("Godafton"))
		{
			return false;
		}
		else if(comp.contentEquals("Godafton") && (user.contentEquals("Applaro") || user.contentEquals("Svartra")))
		{
			return false;
		}
		else if (comp.contentEquals(user)) 
		{
			return false;
		}
		else
		{
			return true;
		}
	}
		
}
