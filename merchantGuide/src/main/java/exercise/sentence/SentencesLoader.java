package exercise.sentence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exercise.exception.LoaderException;
import exercise.exception.RuleException;
import exercise.exception.UnknownSentenceFormatException;
import exercise.util.InputFileReader;
import exercise.util.Messages;
import exercise.util.Rule;

public class SentencesLoader {

	private List<AttributionSentence> attributions = new ArrayList<>();
	private List<CreditsConversionSentence> creditsConversions = new ArrayList<>();
	private List<Question> questions = new ArrayList<>();

	public void loadFile(String fileName) throws LoaderException, RuleException {
		try {
			InputFileReader reader = new InputFileReader();
			load(reader.readFromFile(fileName));
		} catch (IOException e) {
			throw new LoaderException(Messages.IOEXCEPTION_MESSAGE, e);
		}
	}

	public void loadResource(String resourceName) throws LoaderException, RuleException {
		try {
			InputFileReader reader = new InputFileReader();
			load(reader.readFromResource(resourceName));
		} catch (IOException e) {
			throw new LoaderException(Messages.IOEXCEPTION_MESSAGE, e);
		}
	}

	private void load(List<String> fileLines) throws RuleException, LoaderException {

		loadSentences(fileLines);
		Rule<SentencesLoader> semanticsRule = new FileSemanticsRule();
		semanticsRule.test(this);
	}

	private void loadSentences(List<String> lines) throws LoaderException {
		SentenceIdentifier identifier = new SentenceIdentifier();
		QuestionCreator questionCreator = new QuestionCreator();

		try {
			for (String line : lines) {
				switch (identifier.identify(line)) {
					case ATTRIBUTION:
						attributions.add(new AttributionSentence(line));
						break;

					case CREDITS_CONVERSION:
						creditsConversions.add(new CreditsConversionSentence(line));
						break;

					case QUESTION:
						questions.add(questionCreator.create(line));
						break;

					default:
						throw new LoaderException(Messages.INVALID_PARAMETER_FOR_CONVERSION);
				}
			}

		} catch (UnknownSentenceFormatException e) {
			throw new LoaderException(e.getMessage(), e);

		}

	}

	public List<AttributionSentence> getAttributions() {
		return attributions;
	}

	public List<CreditsConversionSentence> getCreditsConversions() {
		return creditsConversions;
	}

	public List<Question> getQuestions() {
		return questions;
	}

}
