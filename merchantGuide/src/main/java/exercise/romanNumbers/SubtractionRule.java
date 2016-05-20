package exercise.romanNumbers;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exercise.exception.SubtractionException;
import exercise.util.Messages;
import exercise.util.Rule;

public class SubtractionRule implements Rule<RomanSymbol> {

	private RomanSymbol lastSymbol = null;

	private Map<RomanSymbol, List<RomanSymbol>> symbolCanSubtractFrom = new HashMap<>();

	public SubtractionRule() {

		symbolCanSubtractFrom.put(RomanSymbol.I, Arrays.asList(RomanSymbol.X, RomanSymbol.V));
		symbolCanSubtractFrom.put(RomanSymbol.X, Arrays.asList(RomanSymbol.L, RomanSymbol.C));
		symbolCanSubtractFrom.put(RomanSymbol.C, Arrays.asList(RomanSymbol.D, RomanSymbol.M));
	}

	public void test(RomanSymbol currentSymbol) throws SubtractionException {

		if (lastSymbol != null && isSubtracion(currentSymbol)) {
			testCurrentSymbol(currentSymbol);
		}

		lastSymbol = currentSymbol;
	}

	private void testCurrentSymbol(RomanSymbol currentSymbol) throws SubtractionException {
		if (symbolCanSubtractFrom.containsKey(lastSymbol)) {

			List<RomanSymbol> canSubtract = symbolCanSubtractFrom.get(lastSymbol);

			if (!canSubtract.contains(currentSymbol)) {
				throw new SubtractionException(MessageFormat.format(Messages.SYMBOL_SUBTRACTION_EXCEPTION_MESSAGE, lastSymbol));
			}

		} else {

			throw new SubtractionException(MessageFormat.format(Messages.SYMBOL_SUBTRACTION_EXCEPTION_MESSAGE, lastSymbol));
		}
	}

	private boolean isSubtracion(RomanSymbol s) {
		return s.compareTo(lastSymbol) > 0;
	}

}
