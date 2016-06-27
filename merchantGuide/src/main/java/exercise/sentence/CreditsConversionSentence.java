package exercise.sentence;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditsConversionSentence extends Sentence {

	private static final String CREDITS_CONVERSIONS_REGEX = "(.*) (\\D+)( is )(\\d+)(.*)";
	private String mineralName;
	private List<String> galacticValues;
	private int creditsValue;

	public CreditsConversionSentence(String text) {
		super(text);

		Pattern patern = Pattern.compile(CREDITS_CONVERSIONS_REGEX);
		Matcher matcher = patern.matcher(text);
		matcher.find();
		this.galacticValues = Arrays.asList(matcher.group(1).split(" "));
		this.mineralName = matcher.group(2);
		this.creditsValue = Integer.parseInt(matcher.group(4));

	}

	public String getMineralName() {
		return mineralName;
	}

	public List<String> getGalacticValues() {
		return galacticValues;
	}

	public int getCreditsValue() {
		return creditsValue;
	}

	@Override
	public SentenceType getType() {
		return SentenceType.CREDITS_CONVERSION;
	}

}
