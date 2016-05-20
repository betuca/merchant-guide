package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exercise.exception.ConvertionException;
import exercise.exception.LoaderException;
import exercise.exception.NotesException;
import exercise.exception.RuleException;
import exercise.romanNumbers.RomanSymbol;
import exercise.sentence.AttributionSentence;
import exercise.sentence.CreditsConversionSentence;
import exercise.sentence.Question;
import exercise.sentence.SentencesLoader;
import exercise.util.Messages;

public class IntergalacticNotesAnalyzer {

	private Map<String, RomanSymbol> convertionMap = new HashMap<>();
	private Map<String, Mineral> mineralsMap = new HashMap<>();

	private List<Question> questions;

	public void loadNotesFromFile(String filePath) throws NotesException {
		SentencesLoader loader = new SentencesLoader();
		try {
			loader.loadFile(filePath);
			load(loader);

		} catch (LoaderException e) {
			throw new NotesException(Messages.PROBLEM_READING_NOTES, e);
		} catch (RuleException e) {
			throw new NotesException(e.getMessage(), e);
		}
	}

	private void load(SentencesLoader loader) throws NotesException {

		loadConversionMap(loader.getAttributions());
		loadMinerals(loader.getCreditsConversions());
		questions = loader.getQuestions();
	}

	private void loadMinerals(List<CreditsConversionSentence> creditsConversions) throws NotesException {

		StringListToDecimanlConverter converter = new StringListToDecimanlConverter(convertionMap);

		try {
			for (CreditsConversionSentence creditsConversion : creditsConversions) {
				Mineral mineral = new Mineral(creditsConversion.getMineralName());
				float convertedGalacticValue = converter.convert(creditsConversion.getGalacticValues());
				mineral.setPriceInCredits(creditsConversion.getCreditsValue() / convertedGalacticValue);
				mineralsMap.put(mineral.getName(), mineral);
			}
		} catch (ConvertionException e) {
			throw new NotesException(Messages.PROBLEM_READING_NOTES, e);

		}

	}

	private void loadConversionMap(List<AttributionSentence> attributions) {
		for (AttributionSentence attribution : attributions) {
			convertionMap.put(attribution.getName(), attribution.getSymbol());
		}

	}

	public Map<String, RomanSymbol> getConversionMap() {
		return convertionMap;
	}

	public Map<String, Mineral> getMinerals() {
		return mineralsMap;
	}

	public List<Question> getQuestions() {
		return questions;
	}

}
