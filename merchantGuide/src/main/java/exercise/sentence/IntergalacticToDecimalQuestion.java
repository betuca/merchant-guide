package exercise.sentence;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exercise.GalacticValueToNumberConverter;
import exercise.Mineral;
import exercise.exception.ConversionException;
import exercise.util.Messages;
import exercise.util.Util;

public class IntergalacticToDecimalQuestion extends Sentence implements Question {

	private static final String INTERGALACTIC_QUESTION_REGEX = "how much is (.*) ./?";
	private List<String> galacticValues;
	private String galactitcValueText;

	public IntergalacticToDecimalQuestion(String text) {
		super(text);

		Pattern patern = Pattern.compile(INTERGALACTIC_QUESTION_REGEX);
		Matcher matcher = patern.matcher(text);
		matcher.find();
		galactitcValueText = matcher.group(1);
		this.galacticValues = Arrays.asList(galactitcValueText.split(" "));

	}

	@Override
	public String getAnswer(GalacticValueToNumberConverter converter, Map<String, Mineral> mineralsMap) {

		String answer = "";
		try {
			float convertedGalacticValue = converter.convert(galacticValues);
			answer = MessageFormat.format(Messages.INTERGALACTIC_TO_DECIMAL_ANSWER_MESSAGE, galactitcValueText,
					Util.formatDoulbe(convertedGalacticValue));
		} catch (ConversionException e) {
			System.out.println(e.getMessage());
		}
		return answer;
	}

	@Override
	public SentenceType getType() {
		return SentenceType.QUESTION;
	}

}
