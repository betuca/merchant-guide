package exercise;

import java.util.List;

import exercise.exception.InputException;
import exercise.exception.NotesException;
import exercise.sentence.Question;
import exercise.util.Messages;

public class MerchantsUnitConverter {

	public static void main(String[] args) {

		try {

			String filePath = validateInput(args);

			IntergalacticNotesAnalyzer ina = new IntergalacticNotesAnalyzer(filePath);

			List<Question> questions = ina.getQuestions();
			questions.forEach(question -> System.out.println(question.getAnswer(ina.getConverter(), ina.getMinerals())));

		} catch (NotesException e) {
			System.out.println(e.getMessage());
		} catch (InputException e) {
			System.out.println(Messages.INPUT_FILE_TEXT);
		}

	}

	private static String validateInput(String[] args) throws InputException {

		if (args.length == 0) {
			throw new InputException();
		}

		return args[0];

	}

}
