package exercise;

import java.text.MessageFormat;
import java.util.Map;

import exercise.exception.ConvertionException;
import exercise.romanNumbers.RomanSymbol;
import exercise.sentence.IntergalacticToDecimalQuestion;
import exercise.sentence.MineralsToCreditsQuestion;
import exercise.sentence.Question;
import exercise.util.Messages;
import exercise.util.Util;

public class AnswerQuestion {

	private Map<String, RomanSymbol> conversionMap;
	private Map<String, Mineral> minerals;

	public AnswerQuestion(Map<String, RomanSymbol> conversionMap, Map<String, Mineral> minerals) {
		this.conversionMap = conversionMap;
		this.minerals = minerals;
	}

	public String answer(Question question) throws ConvertionException {

		String answer = "";
		StringListToDecimanlConverter converter = new StringListToDecimanlConverter(conversionMap);

		float convertedGalacticValue;

		if (question instanceof IntergalacticToDecimalQuestion) {
			convertedGalacticValue = converter.convert(question.getGalacticValues());
			answer = MessageFormat.format(Messages.INTERGALACTIC_TO_DECIMAL_ANSWER_MESSAGE, question.getGalactitcValueText(),
					Util.formatDoulbe(convertedGalacticValue));
		} else if (question instanceof MineralsToCreditsQuestion) {
			convertedGalacticValue = converter.convert(question.getGalacticValues());

			Mineral mineral = minerals.get(question.getMetalName());
			if (mineral == null)
				throw new ConvertionException(MessageFormat.format(Messages.UNRECOGNIZABLE_SYMBOL_MESSAGE, question.getMetalName()));

			float priceInCredits = mineral.getPriceInCredits();

			answer = MessageFormat.format(Messages.MINERAL_TO_CREDITS_ANSWER_MESSAGE, question.getGalactitcValueText(),
					Util.capitalizeFirstLetter(question.getMetalName()), Util.formatDoulbe(convertedGalacticValue * priceInCredits));
		} else {
			answer = Messages.UNKNOWN_ANSWER_MESSAGE;
		}
		return answer;

	}

}
