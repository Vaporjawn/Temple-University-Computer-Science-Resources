public class AsciiArt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 3;
		topLayer(size);
		middleLayer(size);
		bottomLayer(size);
	}
		public static void bottomLayer(int size) {
		for (int layer = 1; layer <= 4 * size; layer++); {
			System.out.print("|");
			for (int top = 1; top <= 20 * size; top++) {
				System.out.print(" ");
			}
			System.out.println("|");
			for (int line = 1; line <= 2 * size; line ++) {
				System.out.print("|");
				for (int space = 1; space <= 20 * size; space ++) {
					System.out.print("*");
				}
				System.out.println("|");
			}
			System.out.print("|");
			for (int under = 1; under <= 20 * size; under ++) {
				System.out.print("_");
			}
			System.out.println("|");
		}
	}

	public static void middleLayer(int size) {
		for (int layer = 1; layer <= 4 * size; layer++); {
			for (int leftSpace = 1; leftSpace <= 4 * size; leftSpace++) {
				System.out.print(" ");
			}
		}
			System.out.print("|");
			for (int top = 1; top <= 12 * size; top++) {
				System.out.print(" ");
			}
			System.out.println("|");
			for (int line = 1; line <= 2 * size; line ++) {
				for (int leftSpace = 1; leftSpace <= 4 * size; leftSpace++) {
					System.out.print(" ");
				}
					System.out.print("|");
				for (int space = 1; space <= 12 * size; space ++) {
					System.out.print("*");
				}
				System.out.println("|");
			}
			for (int rightSpace = 1; rightSpace <= 1 * size; rightSpace++) {
				System.out.print(" ");
			}
			for (int leftLine = 1; leftLine <= 3 * size; leftLine++) {
				System.out.print("_");
			}
			System.out.print("|");
			for (int under = 1; under <= 12 * size; under ++) {
				System.out.print("_");
			}
			System.out.print("|");
			for (int rightLine = 1; rightLine <= 3 * size; rightLine++) {
				System.out.print("_");
			}
			for (int rightSpace = 1; rightSpace <= 1 * size; rightSpace++) {
				System.out.print(" ");
			}
			System.out.println("");
		}
	
	public static void topLayer(int size) {
		System.out.print(" ");
		for (int left = 1; left <= 9 * size; left++) {
			System.out.print(" ");
		}
		for (int tip = 1; tip <= 1 * size; tip ++) {
			System.out.print("|_|");
		}
		System.out.println("");
		for (int layer = 1; layer <= 3 * size; layer++); {
			for (int left = 1; left <= 7 * size; left++) {
				System.out.print(" ");
			}
			System.out.print("|");
			for (int top = 1; top <= 7 * size; top++) {
				System.out.print(" ");
			}
			System.out.println("|");
			for (int line = 1; line <= 1 * size; line ++) {
				for (int left = 1; left <= 7 * size; left++) {
					System.out.print(" ");
				}
				System.out.print("|");
				for (int space = 1; space <= 7 * size; space ++) {
					System.out.print("*");
				}
				System.out.println("|");
			}
			for (int left = 1; left <= 6 * size; left++) {
				System.out.print(" ");
			}
			for (int left = 1; left <= 1 * size; left++) {
				System.out.print("_");
			}
			System.out.print("|");
			for (int under = 1; under <= 7 * size; under ++) {
				System.out.print("_");
			}
			System.out.print("|");
			for (int right = 1; right <= 1 * size; right++) {
				System.out.print("_");
			}
			for (int right = 1; right <= 6 * size; right++) {
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
}

