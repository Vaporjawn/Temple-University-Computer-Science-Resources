/*
*Jared Gross
*October 1, 2018
*Assignment 5
*
*CIS1068
*Professor Fiore
*
*Description: Game of Havsta made with Scanner, Random, and an Array. Users play against
*             the computer in a game similar to rock, paper, scissors. Users choose one of
*             the given options, and the computer randomly chooses an option. After each round
*             either the player or the computer gains a point, and the scores are shown once the
*             player types 'n' to stop playing. 
*/


import java.util.*;

public class Havsta {
	public static int roundsPlayed = 0;
	public static int userWinCount = 0;
	public static int computerWinCount = 0;

	public static void main(String args[]) {
		Scanner kbd = new Scanner(System.in);
		displayRules();
		willPlay(kbd);

	}//main

	//Display rules to the user on game start
	public static void displayRules() {
		System.out.println("Welcome to Havsta!");
		System.out.println("You shall play this mighty game against the computer.");
		System.out.println("Enter either 'applaro', 'svartra', 'tunholmen', or 'godafton'");
		System.out.println();
		System.out.println("***********************************************");
    System.out.println("| RULES:                                      |");
		System.out.println("| -applaro beats svartra and tunholmen        |");
		System.out.println("| -svartra beats tunholmen                    |");
		System.out.println("| -tunholmen beats godafton                   |");
		System.out.println("| -godafton beats applaro and svartra         |");
		System.out.println("| -The computer wins in the event of a tie.   |");
    System.out.println("***********************************************");
    System.out.println();

	}//displayRules

	//Asks player if they would like to play a round
	public static void willPlay(Scanner kbd) {
		System.out.print("Would you like to play a round?(Enter 'y' or 'n') ");
		char answer = kbd.next().toLowerCase().charAt(0);
		if(answer == 'y') {
			System.out.println();
			playRound(kbd);
		}else {
			endGame();
		}
	}//willPlay

	//Initiates round of havsta
	public static void playRound(Scanner kbd) {
		System.out.println("Name your move ('applaro', 'svartra', 'tunholmen', or 'godafton') ");
		String userMove = kbd.next().toLowerCase();
		String computerMove = computerMove();
		if(isValidMove(userMove)) {
			roundsPlayed ++;
			printMoves(userMove, computerMove);
			if(userWins(userMove, computerMove)) {
				System.out.println("Player wins!");
        drawLine();
				userWinCount ++;
				willPlay(kbd);
			}else {
				System.out.println("Sorry computer wins...");
        drawLine();
				computerWinCount ++;
				willPlay(kbd);
			}
		}else {
			System.out.println("Invalid input...try again");
			playRound(kbd);
		}
	}//playRound


	public static void printMoves(String user, String comp) {
		System.out.println();
    drawLine();
		System.out.println("User Move: " + user);
		System.out.println("Computer Move: " + comp);

	}//printMoves

  public static void drawLine(){
		System.out.print("+");
		for(int i = 0; i < 70; i ++){
		System.out.print("-");
		}
		System.out.println("+");

  }

	public static void endGame() {
		System.out.println();
		System.out.println("*******************************************");
		System.out.println("Game Stats:");
		System.out.println("Rounds played: " + roundsPlayed);
		System.out.println("User Wins: " + userWinCount);
		System.out.println("Computer Wins: " + computerWinCount);
    System.out.println("*******************************************");
		System.out.println();
		System.out.println("Game Over");
	}//endGame

	//checks if user wins. returns true if so.
	public static boolean userWins(String player, String comp) {
		if(player.equals("applaro") && (comp.equals("svartra") || comp.equals("tunholmen"))) {
			return true;
		}else if(player.equals("svartra") && comp.equals("tunholmen")) {
			return true;
		}else if(player.equals("tunholmen") && comp.equals("godafton")) {
			return true;
		}else if(player.equals("godafton") && (comp.equals("applaro") || comp.equals("svartra"))) {
			return true;
		}
		return false;
	}//userWins

	public static boolean isValidMove(String input) {
		if(input.equals("applaro") || input.equals("svartra") || input.equals("tunholmen") || input.equals("godafton")){
			return true;
		}
		return false;
	}//isValidMove

	public static String computerMove() {
		String[] moves = new String[4];
		moves[0] = "applaro";
		moves[1] = "svartra";
		moves[2] = "tunholmen";
		moves[3] = "godafton";

		return moves[random(4)];
	}//computerMove

	public static int random(int max) {
		Random rnd = new Random();
		return rnd.nextInt(max);
	}//random

}
