package exercise.sentence;

public class QuestionFactory {

	private static final String INTERGALACTIC_TO_DECIMAL_QUESTION_STRING = "how much is";
	private static final String MINERALS_TO_CREDITS_QUESTION_STRING = "how many Credits is";
	private static final String MINERAL_TO_MINERAL_QUESTION_REGEX = "^how much (\\w+) is in.*?$";

	public static Sentence create(String line) {
		Sentence question = null;

		if (line.startsWith(INTERGALACTIC_TO_DECIMAL_QUESTION_STRING)) {
			question = new IntergalacticToDecimalQuestion(line);
		} else if (line.startsWith(MINERALS_TO_CREDITS_QUESTION_STRING)) {
			question = new MineralsToCreditsQuestion(line);
		} else if (line.matches(MINERAL_TO_MINERAL_QUESTION_REGEX)) {
			question = new MineralToMineralQuestion(line);
		} else {
			question = new UnknownQuestion(line);
		}

		return question;
	}

}
