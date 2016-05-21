package exercise;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import exercise.exception.ConversionException;
import exercise.exception.RuleException;
import exercise.romanNumbers.RomanSymbol;
import exercise.romanNumbers.RomanToDecimalConverter;
import exercise.util.Messages;

/*
 * Classe responsavel por realizar a conversao de numeros galaticos,
 * servindo de interface para o pacote de numeros romanos.
 */
public class GalacticValueToNumberConverter {

	private Map<String, RomanSymbol> conversionMap;

	public GalacticValueToNumberConverter(Map<String, RomanSymbol> conversionMap) {
		this.conversionMap = conversionMap;
	}

	public float convert(List<String> list) throws ConversionException {

		float result = 0;
		if (list != null && !list.isEmpty()) {

			String romanNumber = "";
			StringBuilder sb = new StringBuilder();
			for (String value : list) {
				RomanSymbol symbol = conversionMap.get(value);
				if (symbol == null) {
					throw new ConversionException(MessageFormat.format(Messages.UNRECOGNIZABLE_SYMBOL_MESSAGE, value));
				}
				sb.append(symbol);
			}
			romanNumber = sb.toString();
			RomanToDecimalConverter converter = new RomanToDecimalConverter();
			try {

				result = converter.convert(romanNumber);

			} catch (RuleException e) {

				throw new ConversionException(MessageFormat.format(Messages.INVALID_ROMAN_NUMBER, romanNumber), e);
			}

		} else {
			throw new ConversionException(Messages.TRYING_TO_CONVERT_EMPTY_LIST_MESSAGE);
		}
		return result;

	}

}
