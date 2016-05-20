package exercise.romanNumbers;

import java.security.InvalidParameterException;
import java.text.MessageFormat;

import exercise.util.Messages;

public enum RomanSymbol {

	I(1, 3), V(5, 1), X(10, 3), L(50, 1), C(100, 3), D(500, 1), M(1000, 3);

	private int value;
	private int possibleRepetitions;

	private RomanSymbol(int value, int possibleRepetitions) {
		this.value = value;
		this.possibleRepetitions = possibleRepetitions;
	}

	public int getValue() {
		return value;
	}

	public static RomanSymbol getFromChar(char c) {
		RomanSymbol symbol;
		switch (c) {
			case 'I':
				symbol = I;
				break;
			case 'V':
				symbol = V;
				break;
			case 'X':
				symbol = X;
				break;
			case 'L':
				symbol = L;
				break;
			case 'C':
				symbol = C;
				break;
			case 'D':
				symbol = D;
				break;
			case 'M':
				symbol = M;
				break;
			default:
				throw new InvalidParameterException(MessageFormat.format(Messages.INVALID_PARAMETER_FOR_CONVERSION, c));
		}

		return symbol;
	}

	public static RomanSymbol getFromString(String s) {
		RomanSymbol symbol;
		if (s.length() == 1) {
			symbol = getFromChar(s.charAt(0));
		} else {
			throw new InvalidParameterException(MessageFormat.format(Messages.INVALID_PARAMETER_FOR_CONVERSION, s));
		}
		return symbol;
	}

	public int getPossibleRepetitions() {
		return possibleRepetitions;
	}

}
