
import java.util.Scanner;

import java.util.*;

public class AGame {
 

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		 Scanner kbd = new Scanner(System.in);
		 System.out.print("Would you like to play? (y/n):");
		 String start = kbd.next(); 
		 if(start.equals("y")) 
		 {
			 rules();
		 }
		 else 
		 {
			 System.out.println("Okay. Bye-bye");
		 }
		 computerMove();
		 String a = computerMove();
		 userMove();
		 String b = userMove();
//		 winner(a, b);
		 kbd.close();
	}
	
	public static void rules() 
	{
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
		String name = "";
		Random rand = new Random();
		int move = rand.nextInt(4) + 0;
		if(move == 0) {
			name = "Applaro";
		}
		else if(move == 1) 
		{
			name = "Scartra";
		}
		else if(move == 2) 
		{
			name = "Tunholmen";
		}
		else if(move == 3)
		{
			name = "Godafton";
		}
		System.out.println("I have made my move. Your turn!");
		System.out.println(name);
		return name;
	}
	
	public static String userMove()
	{
		Scanner kbd = new Scanner(System.in);
		System.out.print("Please make your move. (Applaro/Svartra/Tunholmen/Godafton):");
		String move = kbd.nextLine();
		while(!move.equals("Applaro") && !move.equals("Scartra") && !move.equals("Tunholmen") && !move.equals("Godafton")) 
		{
			System.out.print("Please enter a valid move. (Applaro/Svartra/Tunholmen/Godafton):");
			move = kbd.nextLine();
		}
		System.out.println(move);
		kbd.close();
		return move;
	}
	
//	public static boolean winner(String name, String move)
//	{
//		
//	}
}
