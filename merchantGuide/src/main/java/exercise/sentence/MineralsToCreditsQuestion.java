package exercise.sentence;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	public List<String> getGalacticValues() {
		return galacticValues;
	}

	public String getGalactitcValueText() {
		return galactitcValueText;
	}

	@Override
	public String getMetalName() {
		return metalName;
	}

	@Override
	public SentenceType getType() {
		return SentenceType.QUESTION;
	}

}
