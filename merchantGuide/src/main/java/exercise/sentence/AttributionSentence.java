package exercise.sentence;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exercise.romanNumbers.RomanSymbol;

public class AttributionSentence extends Sentence {

	private static final String ATTRIBUTION_REGEX = "(.*)( is )(.*)";
	private String name;
	private RomanSymbol symbol;

	public AttributionSentence(String text) {
		super(text);

		Pattern patern = Pattern.compile(ATTRIBUTION_REGEX);
		Matcher matcher = patern.matcher(text);
		matcher.find();
		name = matcher.group(1).toLowerCase(Locale.getDefault());
		symbol = RomanSymbol.getFromString(matcher.group(3));

	}

	public String getName() {
		return name;
	}

	public RomanSymbol getSymbol() {
		return symbol;
	}

	@Override
	public SentenceType getType() {
		return SentenceType.ATTRIBUTION;
	}

}
