import java.util.*;
/**
 * 
 * @author Nathan Adiam
 * Date: April 24, 2020
 * Section: 007
 * Project: Coding Theory
 * Description :Computer project exercise 2
 * 
 *
 */

public class Exercise_2 {
	public static final String INTRO_MESSG = "Hello!\nGiven a binary code and a minimum distance, this program \ndetermines the number of errors it can detect and correct.\n\nEnter 1 to start: ";
	public static final String PROMPT_BINARY_1 = "Enter the first binary code (and -1 when done): ";
	public static final String PROMPT_DISTANCE = "Enter the minimum distance of the binary number: ";
	public static final String INVALID_INPUT = "Invalid input. Only enter 1 or 0";
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		ArrayList <Integer> binary = new ArrayList<Integer>();
		System.out.println(INTRO_MESSG);
		int input = in.nextInt();
		System.out.println(PROMPT_BINARY_1);
		while (input != -1) { // input first binary number
			input = in.nextInt();
			if (input == -1) {
				break;
			}
			if (input < -1 || input > 1) {
				System.out.println(INVALID_INPUT);
				break;
			}
			binary.add(input);
			System.out.println(binary);		
		}
		System.out.println(PROMPT_DISTANCE);
		int distance = in.nextInt();
		System.out.println("\nFrom the codeword x = " + printBinary(binary) + " with minimum distance: " + distance);
		System.out.println(findErrors(binary, distance));
		in.close();
	}
	public static String findErrors(ArrayList<Integer> binary, int distance) {
		int canDetect = 0;
		int canCorrect = 0;
		while (canDetect < distance - 1) {
			canDetect++;
		}
		while (canCorrect < (distance -1)/2 ){
			canCorrect++;
		}
		return "\nWe can detect in as many as " + canDetect + " error(s) and \ncan correct errors in as many as " + canCorrect + " error(s)";
	}
	public static String printBinary(ArrayList<Integer> binary) {
		String s = "";
			for (int i = 0; i < binary.size(); i++) {
				s += binary.get(i);
			}
		return s;
	}
}