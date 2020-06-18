package deepak.practice.sorting.bubblesort;

public class BubbleSort {

	public static void main(String[] args) {
		int[] numbers = new int[]{75, 93, 1, 7, 3, 2, 8, 9, 4, 5, 6, 10, 12, 11,
				15, 53, 14, 68, 61, 59, 39, 49, 13, 18, 17, 16, 33, 19, 20, 99,
				29, 25, 22, 36, 45, 55, 76};

		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = 0; j < numbers.length - i - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println("\nNumbers Length: " + numbers.length + "\n");

		int numbersLength = numbers.length;
		int expected = 75;
		int result = 0;
		int minIndex = 0;
		int maxIndex = numbersLength;
		int mid = 0;
		int lastMid = 0;
		do {
			lastMid = mid;
			mid = numbersLength / 2;
			mid = minIndex + mid;
			if (expected > numbers[mid]) {
				// modify min index
				minIndex = minIndex + numbersLength / 2;
			} else if (expected < numbers[mid]) {
				// modify max index
				maxIndex = maxIndex - numbersLength / 2;
			} else {
				result = numbers[mid];
			}
			numbersLength = maxIndex - minIndex;

		} while (expected != result && lastMid != mid);
		if (result != 0)
			System.out.println(result);
	}

}
