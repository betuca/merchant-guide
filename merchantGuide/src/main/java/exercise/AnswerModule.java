package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import exercise.exception.ConvertionException;
import exercise.romanNumbers.RomanSymbol;
import exercise.sentence.Question;

public class AnswerModule {

	private Map<String, Mineral> minerals;
	private Map<String, RomanSymbol> conversionMap;
	private List<Question> questions;

	public AnswerModule(List<Question> questions, Map<String, RomanSymbol> conversionMap, Map<String, Mineral> minerals) {
		this.questions = questions;
		this.conversionMap = conversionMap;
		this.minerals = minerals;
	}

	public List<String> getAnswers() throws ConvertionException {

		List<String> answers = new ArrayList<>();

		AnswerQuestion answerQuestion = new AnswerQuestion(this.conversionMap, this.minerals);

		for (Question question : questions) {
			answers.add(answerQuestion.answer(question));

		}

		return answers;
	}

}
