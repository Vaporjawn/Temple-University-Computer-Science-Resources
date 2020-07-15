import java.util.*;

/**
 * 
 * @author Nathan Adiam
 * Section: 007
 * Date: April 24, 2020
 * Project: Coding Theory
 * Description: Computer project exercise 1
 *  
 */

public class Exercise_1 {
	public static final String INTRO_MESSG = "Hello!\nGiven two binary codes, this program determines the\nnumber of errors it can detect and correct.\n\nEnter 1 to start: ";
	public static final String PROMPT_BINARY_1 = "Enter the first binary code (and -1 when done): ";
	public static final String PROMPT_BINARY_2 = "Enter the second binary code (and -1 when done): ";
	public static final String INVALID_INPUT = "Invalid input. Only enter 1 or 0";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList <Integer> binary1 = new ArrayList<Integer>();
		ArrayList <Integer> binary2 = new ArrayList<Integer>();
		System.out.println(INTRO_MESSG);
		int input = in.nextInt();
		System.out.println(PROMPT_BINARY_1);
		while (input != -1) { // input first codeword number
			input = in.nextInt();
			if (input == -1) {
				break;
			}
			if (input < -1 || input > 1) {
				System.out.println(INVALID_INPUT);
				break;
			}
			binary1.add(input);
			System.out.println(binary1);		
		}
		System.out.println(PROMPT_BINARY_2);
		input = 1;
		while (input != -1 && binary2.size() < binary1.size()) { // input second codeword
			input = in.nextInt();
			if (input != 1 && input != 0) {
				System.out.println(INVALID_INPUT);
				break;
			}
			binary2.add(input);
			System.out.println(binary2);		
		}
		System.out.println("\nFrom the codewords x = " + printBinary(binary1) + "\nand y = "+ printBinary(binary2));
		System.out.println(findErrors(binary1, findMinDistance(binary1, binary2)));
		in.close();
	}

	public static int findMinDistance(ArrayList<Integer> binary, ArrayList<Integer> binary2) {
		int numDifference = 0;
		for (int i  = 0; i < binary.size(); i++) {
			if(binary.get(i) != binary2.get(i)){
				numDifference++;
			}
		}
		return numDifference;
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
		return "\nWe can detect in as many as " + canDetect + " error(s) and \ncan correct errors as many as " + canCorrect + " error(s)";
	}
	public static String printBinary(ArrayList<Integer> binary) {
		String s = "";
		for (int i = 0; i < binary.size(); i++) {
			s += binary.get(i);
		}
		return s;
	}
}
