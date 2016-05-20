package exercise.sentence;

public class QuestionCreator {

	private static final String INTERGALACTIC_TO_DECIMAL_QUESTION_STRING = "how much is";
	private static final String MINERALS_TO_CREDITS_QUESTION_STRING = "how many Credits is";

	public Question create(String line) {
		Question question = null;

		if (line.startsWith(INTERGALACTIC_TO_DECIMAL_QUESTION_STRING)) {
			question = new IntergalacticToDecimalQuestion(line);
		} else if (line.startsWith(MINERALS_TO_CREDITS_QUESTION_STRING)) {
			question = new MineralsToCreditsQuestion(line);
		} else {
			question = new UnknownQuestion(line);
		}

		return question;
	}

}
