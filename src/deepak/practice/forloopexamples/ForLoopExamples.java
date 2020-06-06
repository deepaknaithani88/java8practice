package deepak.practice.forloopexamples;

public class ForLoopExamples {

	public static void main(String[] args) {
		int height = 8;
		for (int i = 0; i < height; i++) {
			for (int j = 1; j < height - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i + 1; j++) {
				System.out.print("#");
			}
			System.out.print(" ");
			System.out.print(" ");
			for (int j = 0; j < i + 1; j++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}
}
