
public class AsciiArt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		middleLayer();
		bottomLayer();
	}
	
	public static void bottomLayer() {
		for (int layer = 1; layer <= 4; layer++); {
			System.out.print("|");
			for (int top = 1; top <= 20; top++) {
				System.out.print(" ");
			}
			System.out.println("|");
			for (int line = 1; line <= 2; line ++) {
				System.out.print("|");
				for (int space = 1; space <= 20; space ++) {
					System.out.print("*");
					//System.out.print(" ");
				}
				System.out.println("|");
			}
			System.out.print("|");
			for (int under = 1; under <= 20; under ++) {
				System.out.print("_");
			}
			System.out.println("|");
		}
	}
	public static void middleLayer() {	}
}
