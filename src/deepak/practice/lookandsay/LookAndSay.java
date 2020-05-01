package deepak.practice.lookandsay;

public class LookAndSay {

	public LookAndSay() {
	}

	public static void main(String[] args) {
		String start = "11";
		// Input 111212233222
		// iteration
		// 1 ==> 311211222332
		// 2 ==> 13211221322312
		// 3 ==> 1113122122111322131112
		// 4 ==> 31131122112231132211133112
		// 5 ==> 132113212221221321132231232112
		int iteration = 40;
		// calculatingGroupedNumbers1(start, iteration);
		System.out.println(System.currentTimeMillis());
		System.out.println(calculatingGroupedNumbers2(start, iteration));
		System.out.println(System.currentTimeMillis());
	}

	private static String calculatingGroupedNumbers2(String start, int iteration) {
		if (iteration == 0) {
			return start;
		}
		if (start == null || start.length() == 0) {
			return "";
		}
		int stringLength = start.length();

		int digitStartPosition = 0;
		int digitEndPosition = 1;

		String previoustDigit = null;
		StringBuffer resultingDigit = new StringBuffer();

		previoustDigit = start.substring(0, 1);

		for (int i = 1; i < stringLength; i++) {
			String currentDigit = start.substring(i, i + 1);
			if (previoustDigit.equals(currentDigit)) {
				digitEndPosition = i + 1;
			} else {
				int characterCount = digitEndPosition - digitStartPosition;
				resultingDigit.append(characterCount).append(previoustDigit);
				digitStartPosition = i;
				digitEndPosition = i + 1;
				previoustDigit = currentDigit;
			}
			if (digitEndPosition == stringLength) {
				int characterCount = digitEndPosition - digitStartPosition;
				resultingDigit.append(characterCount).append(previoustDigit);
			}
		}
		return calculatingGroupedNumbers2(resultingDigit.toString(), iteration - 1);
	}

	private static String calculatingGroupedNumbers1(String start, int iteration) {
		if (iteration == 0) {
			return "";
		}
		if (start == null || start.length() == 0) {
			return "Invalid Digits";
		}
		String subDigits = calculatingGroupedNumbers1(start.substring(0, iteration), iteration - 1);

		return "";
	}
}
