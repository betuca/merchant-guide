package exercise;

import java.util.List;
import java.util.Map;

import exercise.exception.ConvertionException;
import exercise.exception.InputException;
import exercise.exception.NotesException;
import exercise.romanNumbers.RomanSymbol;
import exercise.sentence.Question;
import exercise.util.Messages;

public class MerchantsUnitConverter {

	public static void main(String[] args) {

		try {

			String fileName = validateInput(args);

			IntergalacticNotesAnalyzer intergalacticNotesAnalyzer = new IntergalacticNotesAnalyzer();
			intergalacticNotesAnalyzer.loadNotesFromFile(fileName);

			Map<String, RomanSymbol> conversionMap = intergalacticNotesAnalyzer.getConversionMap();
			List<Question> questions = intergalacticNotesAnalyzer.getQuestions();
			Map<String, Mineral> minerals = intergalacticNotesAnalyzer.getMinerals();

			AnswerModule answerModule = new AnswerModule(questions, conversionMap, minerals);
			List<String> answers = answerModule.getAnswers();

			for (String answer : answers) {
				System.out.println(answer);
			}

		} catch (NotesException e) {
			System.out.println(e.getMessage());
		} catch (ConvertionException e) {
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
