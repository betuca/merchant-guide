package exercise.sentence;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	public List<String> getGalacticValues() {
		return galacticValues;
	}

	public String getGalactitcValueText() {
		return galactitcValueText;
	}

	@Override
	public String getMetalName() {
		return null;
	}

	@Override
	public SentenceType getType() {
		return SentenceType.QUESTION;
	}

}
