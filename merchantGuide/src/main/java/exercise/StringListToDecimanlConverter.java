package exercise;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import exercise.exception.ConvertionException;
import exercise.exception.RuleException;
import exercise.romanNumbers.RomanSymbol;
import exercise.romanNumbers.RomanToDecimalConverter;
import exercise.util.Messages;

public class StringListToDecimanlConverter {

	private Map<String, RomanSymbol> convertionMap;

	public StringListToDecimanlConverter(Map<String, RomanSymbol> convertionMap) {
		this.convertionMap = convertionMap;
	}

	public float convert(List<String> list) throws ConvertionException {

		float result = 0;
		if (list != null && !list.isEmpty()) {

			String romanNumber = "";
			StringBuilder sb = new StringBuilder();
			RomanSymbol symbol = null;
			for (String value : list) {
				symbol = convertionMap.get(value);
				if (symbol == null)
					throw new ConvertionException(MessageFormat.format(Messages.UNRECOGNIZABLE_SYMBOL_MESSAGE, value));
				sb.append(symbol);
			}
			romanNumber = sb.toString();
			RomanToDecimalConverter converter = new RomanToDecimalConverter();
			try {

				result = converter.convert(romanNumber);

			} catch (RuleException e) {

				throw new ConvertionException(MessageFormat.format(Messages.INVALID_ROMAN_NUMBER, romanNumber), e);
			}

		} else {
			throw new ConvertionException(Messages.TRYING_TO_CONVERT_EMPTY_LIST_MESSAGE);
		}
		return result;

	}

}
