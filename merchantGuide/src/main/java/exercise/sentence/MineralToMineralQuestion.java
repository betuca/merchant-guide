package exercise.sentence;

import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exercise.GalacticValueToNumberConverter;
import exercise.Mineral;

public class MineralToMineralQuestion extends Sentence implements Question {

	private static final String MINERAL_TO_MINERAL_QUESTION_REGEX = "how much (\\w+) is in (\\w+)\\.?";
	private String firstMetalName, secondMetalName;

	public MineralToMineralQuestion(String text) {
		super(text);

		Pattern patern = Pattern.compile(MINERAL_TO_MINERAL_QUESTION_REGEX);
		Matcher matcher = patern.matcher(text);
		matcher.find();
		this.firstMetalName = matcher.group(1).toLowerCase(Locale.getDefault());
		this.secondMetalName = matcher.group(2).toLowerCase(Locale.getDefault());
	}

	@Override
	public SentenceType getType() {
		return SentenceType.QUESTION;
	}

	@Override
	public String getAnswer(GalacticValueToNumberConverter converter, Map<String, Mineral> mineralsMap) {

		//		String answer = "";
		//		try {
		//
		//			float convertedGalacticValue = converter.convert(galacticValues);
		//
		//			Mineral mineral = mineralsMap.get(firstMetalName);
		//			if (mineral == null) {
		//				throw new ConversionException(MessageFormat.format(Messages.UNRECOGNIZABLE_SYMBOL_MESSAGE, firstMetalName));
		//			}
		//
		//			float priceInCredits = mineral.getPriceInCredits();
		//
		//			answer = MessageFormat.format(Messages.MINERAL_TO_CREDITS_ANSWER_MESSAGE, galactitcValueText,
		//					Util.capitalizeFirstLetter(firstMetalName), Util.formatDoulbe(convertedGalacticValue * priceInCredits));
		//
		//		} catch (ConversionException e) {
		//			System.out.println(e.getMessage());
		//		}
		//		return answer;
		return null;

	}

	public static void main(String[] args) {
		new MineralToMineralQuestion("how much Iron is in Gold ?");
		String a = "how much Iron is in Gold ?";
		System.out.println("true".matches("^true$"));
		System.out.println(a.matches("^how much (\\w+) is in.*?$"));
		System.out.println(a.matches("^how much (\\w+) is in.*$"));

	}

}
