package deepak.practice.forloopexamples;

public class ForLoopExamples2 {

	public static void main(String[] args) {
		int height = 20;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < height; j++) {
				if (j >= height - (i + 1)) {
					System.out.print("#");
				} else {
					System.out.print(" ");
				}
			}
			System.out.print(" ");
			System.out.print(" ");
			for (int j = 0; j < i + 1; j++) {
				System.out.print("#");
			}
			if (i != height - 1)
				System.out.println();
		}
	}

}
