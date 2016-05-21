package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exercise.exception.ConversionException;
import exercise.exception.LoaderException;
import exercise.exception.NotesException;
import exercise.exception.RuleException;
import exercise.romanNumbers.RomanSymbol;
import exercise.sentence.AttributionSentence;
import exercise.sentence.CreditsConversionSentence;
import exercise.sentence.Question;
import exercise.sentence.SentencesLoader;
import exercise.util.Messages;

/**
 * Classe responsavel por fazer a interface com o SentecesLoader utilizando as
 * "sentences" (frases) para criar as ferramentas que serao necessarias para
 * responder as perguntas originais (o GalacticValueToNumberConverter e o mapa
 * de minerais (mineralsMap)).
 */
public class IntergalacticNotesAnalyzer {

	private GalacticValueToNumberConverter converter;
	private Map<String, Mineral> mineralsMap = new HashMap<>();
	private List<Question> questions;

	public IntergalacticNotesAnalyzer(String filePath) throws NotesException {
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

		loadGalacticToNumberConverter(loader.getAttributions());
		loadMinerals(loader.getCreditsConversions());
		questions = loader.getQuestions();
	}

	private void loadMinerals(List<CreditsConversionSentence> creditsConversions) throws NotesException {

		try {
			for (CreditsConversionSentence creditsConversion : creditsConversions) {
				Mineral mineral = new Mineral(creditsConversion.getMineralName());
				float convertedGalacticValue = converter.convert(creditsConversion.getGalacticValues());
				mineral.setPriceInCredits(creditsConversion.getCreditsValue() / convertedGalacticValue);
				mineralsMap.put(mineral.getName(), mineral);
			}
		} catch (ConversionException e) {
			throw new NotesException(Messages.PROBLEM_READING_NOTES, e);

		}

	}

	private void loadGalacticToNumberConverter(List<AttributionSentence> attributions) {
		Map<String, RomanSymbol> conversionMap = new HashMap<>();
		for (AttributionSentence attribution : attributions) {
			conversionMap.put(attribution.getName(), attribution.getSymbol());
		}
		converter = new GalacticValueToNumberConverter(conversionMap);
	}

	public GalacticValueToNumberConverter getConverter() {
		return converter;
	}

	public Map<String, Mineral> getMinerals() {
		return mineralsMap;
	}

	public List<Question> getQuestions() {
		return questions;
	}

}
