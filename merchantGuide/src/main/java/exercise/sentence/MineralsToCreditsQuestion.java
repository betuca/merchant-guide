package exercise.sentence;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exercise.GalacticValueToNumberConverter;
import exercise.Mineral;
import exercise.exception.ConversionException;
import exercise.util.Messages;
import exercise.util.Util;

public class MineralsToCreditsQuestion extends Sentence implements Question {

	private static final String MINERAL_QUESTION_REGEX = "how many Credits is (.*) (\\w+)\\.?";
	private List<String> galacticValues;
	private String galactitcValueText;
	private String metalName;

	public MineralsToCreditsQuestion(String text) {
		super(text);

		Pattern patern = Pattern.compile(MINERAL_QUESTION_REGEX);
		Matcher matcher = patern.matcher(text);
		matcher.find();
		this.galactitcValueText = matcher.group(1);
		this.galacticValues = Arrays.asList(this.galactitcValueText.split(" "));
		this.metalName = matcher.group(2).toLowerCase(Locale.getDefault());
	}

	@Override
	public String getAnswer(GalacticValueToNumberConverter converter, Map<String, Mineral> mineralsMap) {

		String answer = "";
		try {

			float convertedGalacticValue = converter.convert(galacticValues);

			Mineral mineral = mineralsMap.get(metalName);
			if (mineral == null) {
				throw new ConversionException(MessageFormat.format(Messages.UNRECOGNIZABLE_SYMBOL_MESSAGE, metalName));
			}

			float priceInCredits = mineral.getPriceInCredits();

			answer = MessageFormat.format(Messages.MINERAL_TO_CREDITS_ANSWER_MESSAGE, galactitcValueText,
					Util.capitalizeFirstLetter(metalName), Util.formatDoulbe(convertedGalacticValue * priceInCredits));

		} catch (ConversionException e) {
			System.out.println(e.getMessage());
		}
		return answer;

	}

	public static void main(String[] args) {
		new MineralsToCreditsQuestion("how many Credits is glob prok Gold ?");
	}

	@Override
	public SentenceType getType() {
		return SentenceType.QUESTION;
	}

}
