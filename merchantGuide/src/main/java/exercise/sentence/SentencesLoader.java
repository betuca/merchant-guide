package exercise.sentence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	public void loadFile(String filePath) throws LoaderException, RuleException {
		try {
			InputFileReader reader = new InputFileReader();
			load(reader.readFromFilePath(filePath));
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

		List<Sentence> allSentences = new ArrayList<>();
		try {

			for (String line : lines) {
				allSentences.add(SentencesFactory.createSentence(line));
			}
			attributions = allSentences.stream().filter(sentence -> SentenceType.ATTRIBUTION.equals(sentence.getType()))
					.map(attribution -> (AttributionSentence) attribution).collect(Collectors.toList());
			creditsConversions = allSentences.stream().filter(sentence -> SentenceType.CREDITS_CONVERSION.equals(sentence.getType()))
					.map(creditsConvertion -> (CreditsConversionSentence) creditsConvertion).collect(Collectors.toList());
			questions = allSentences.stream().filter(sentence -> SentenceType.QUESTION.equals(sentence.getType()))
					.map(question -> (Question) question).collect(Collectors.toList());

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
