package exercise.romanNumbers;

import exercise.exception.RuleException;
import exercise.util.Rule;

public class RomanToDecimalConverter {

	public int convert(String value) throws RuleException {

		int sum = 0;
		RomanSymbol currentSymbol = null;
		RomanSymbol nextSymbol = null;
		int valueLength = value.length();

		Rule<RomanSymbol> repetitionRule = new RepetitionRule();
		Rule<RomanSymbol> subtractionRule = new SubtractionRule();

		for (int i = 0; i < valueLength; i++) {
			currentSymbol = RomanSymbol.getFromChar(value.charAt(i));
			repetitionRule.test(currentSymbol);
			subtractionRule.test(currentSymbol);

			if (i == valueLength - 1) {

				sum += currentSymbol.getValue();

			} else {

				nextSymbol = RomanSymbol.getFromChar(value.charAt(i + 1));
				if (currentSymbol.compareTo(nextSymbol) < 0) {
					sum -= currentSymbol.getValue();
				} else {
					sum += currentSymbol.getValue();
				}

			}

		}

		return sum;
	}

}
