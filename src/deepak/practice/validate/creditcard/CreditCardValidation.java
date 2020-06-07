package deepak.practice.validate.creditcard;

import java.util.ArrayList;
import java.util.List;

public class CreditCardValidation {

	public static void main(String[] args) {

		for (long cardNumber : getCardList()) {
			long numberMultiplier = 100;
			long evenNumberMultiplier = 100;
			long oddNumberMultiplier = 10;
			long evenSummedNumber = 0;
			long oddSummedNumber = 0;
			long evenLastNumber = 0;
			long oddLastNumber = 0;
			long multiplier = 10;
			long cardLength = 0;
			long lastNumber = 0;
			long cardNumber1 = cardNumber;

			for (int i = 0; i < 18; i++) {
				long remainder = cardNumber1 % multiplier;
				if (remainder > 0) {
					cardLength = i + 1;
					lastNumber = remainder;
				}
				cardNumber1 /= 10;
				multiplier *= 10;
			}

			for (int i = 0; i < cardLength / 2; i++) {
				evenLastNumber = ((((cardNumber % evenNumberMultiplier)
						- (cardNumber % oddNumberMultiplier))
						/ oddNumberMultiplier));
				long temp2 = evenLastNumber * 2;
				evenSummedNumber += temp2 % 10;
				if (temp2 > 9) {
					evenSummedNumber += 1;
				}
				evenNumberMultiplier *= numberMultiplier;
				oddNumberMultiplier *= numberMultiplier;
			}
			evenNumberMultiplier = 10;
			oddNumberMultiplier = 1;
			for (int i = 0; i < (cardLength + 1) / 2; i++) {
				oddLastNumber = ((((cardNumber % evenNumberMultiplier)
						- (cardNumber % oddNumberMultiplier))
						/ oddNumberMultiplier));
				oddSummedNumber += oddLastNumber;
				evenNumberMultiplier *= numberMultiplier;
				oddNumberMultiplier *= numberMultiplier;
			}
			if ((oddSummedNumber + evenSummedNumber) % 10 != 0) {
				continue;
			}
			System.out.println("Card Number: " + cardNumber
			// + "; Card Length: " + cardLength
					+ "; Card Validity: " + (oddSummedNumber + evenSummedNumber)
					// + "; Last Number: " + lastNumber
					// + "; Even Last Number: " + evenLastNumber
					// + "; Odd Last Number: " + oddLastNumber
					+ "; Final Last Number: "
					+ getCardFirst2Digits(lastNumber, evenLastNumber,
							oddLastNumber)
					+ "; Card Name: " + getCardName(lastNumber, evenLastNumber,
							oddLastNumber, cardLength));

		}
	}

	public static long getCardFirst2Digits(long lastNumber, long evenLastNumber,
			long oddLastNumber) {
		if (lastNumber == evenLastNumber && lastNumber == oddLastNumber) {
			lastNumber = (evenLastNumber * 10) + oddLastNumber;
		} else if (lastNumber == evenLastNumber) {
			lastNumber = (evenLastNumber * 10) + oddLastNumber;
		} else if (lastNumber == oddLastNumber) {
			lastNumber = (oddLastNumber * 10) + evenLastNumber;
		}
		return lastNumber;
	}

	public static String getCardName(long lastNumber, long evenLastNumber,
			long oddLastNumber, long cardLength) {
		if (lastNumber == evenLastNumber && lastNumber == oddLastNumber) {
			lastNumber = (evenLastNumber * 10) + oddLastNumber;
		} else if (lastNumber == evenLastNumber) {
			lastNumber = (evenLastNumber * 10) + oddLastNumber;
		} else if (lastNumber == oddLastNumber) {
			lastNumber = (oddLastNumber * 10) + evenLastNumber;
		}
		if (lastNumber == 34 || lastNumber == 37) {
			return "AMEX";
		} else if (lastNumber == 51 || lastNumber == 52 || lastNumber == 53
				|| lastNumber == 54 || lastNumber == 55) {
			return "MASTERCARD";
		} else if (((lastNumber % 100) - (lastNumber % 10)) / 10 == 4
				&& cardLength >= 13) {
			return "VISA";
		}
		return "INVALID";
	}

	public static List<Long> getCardList() {
		List<Long> cards = new ArrayList<>();
		cards.add(4003600000000014l);
		cards.add(378282246310005l);
		cards.add(371449635398431l);
		cards.add(378734493671000l);
		cards.add(30569309025904l);
		cards.add(6011111111111117l);
		cards.add(6011000990139424l);
		cards.add(3530111333300000l);
		cards.add(3566002020360505l);
		cards.add(2221000000000009l);
		cards.add(2223000048400011l);
		cards.add(2223016768739313l);
		cards.add(5555555555554444l);
		cards.add(5105105105105100l);
		cards.add(4111111111111111l);
		cards.add(4012888888881881l);
		cards.add(4222222222222l);
		cards.add(371449635398431l);
		cards.add(4062901840l);
		return cards;
	}

}
