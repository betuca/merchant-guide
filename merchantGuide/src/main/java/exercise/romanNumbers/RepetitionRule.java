package exercise.romanNumbers;

import java.text.MessageFormat;

import exercise.exception.RepetitionException;
import exercise.util.Messages;
import exercise.util.Rule;

public class RepetitionRule implements Rule<RomanSymbol> {

	private RomanSymbol lastSymbol = null;
	private int count = 0;

	public void test(RomanSymbol currentSymbol) throws RepetitionException {

		if (lastSymbol == null) {
			lastSymbol = currentSymbol;
			count++;
		} else {
			if (currentSymbol.equals(lastSymbol)) {
				count++;
			} else {
				lastSymbol = currentSymbol;
				count = 1;
			}
		}
		testRepetitionLimit(currentSymbol);
	}

	private void testRepetitionLimit(RomanSymbol s) throws RepetitionException {

		if (count > s.getPossibleRepetitions()) {
			throw new RepetitionException(
					MessageFormat.format(Messages.SYMBOL_REPETITION_EXCEPTION_MESSAGE, s, s.getPossibleRepetitions()));
		}
	}

}
