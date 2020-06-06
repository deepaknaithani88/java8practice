package deepak.practice.validate.creditcard;

public class CreditCardValidation {

	public static void main(String[] args) {
		long cardNumber = 4003600000000014l;
		// cardNumber = 4222222222222l;
		long numberMultiplier = 100;
		long evenNumberMultiplier = 100;
		long oddNumberMultiplier = 10;
		long evenSummedNumber = 0;
		long oddSummedNumber = 0;
		for (int i = 0; i < 10; i++) {
			long temp = ((((cardNumber % evenNumberMultiplier)
					- (cardNumber % oddNumberMultiplier))
					/ oddNumberMultiplier)) * 2;
			oddSummedNumber += temp % 10;
			if (temp > 9) {
				oddSummedNumber += 1;
				System.out.println((temp % 10) - (temp % 1) / 1);
			}
			evenNumberMultiplier *= numberMultiplier;
			oddNumberMultiplier *= numberMultiplier;
		}
		evenNumberMultiplier = 10;
		oddNumberMultiplier = 1;
		for (int i = 0; i < 20; i++) {
			oddSummedNumber += ((((cardNumber % evenNumberMultiplier)
					- (cardNumber % oddNumberMultiplier))
					/ oddNumberMultiplier));
			evenNumberMultiplier *= numberMultiplier;
			oddNumberMultiplier *= numberMultiplier;
		}
		System.out.println(oddSummedNumber + evenSummedNumber);
	}

}
