package exercise;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import exercise.exception.ConversionException;
import exercise.exception.NotesException;
import exercise.romanNumbers.RomanSymbol;
import exercise.sentence.Question;
import exercise.util.Util;

public class IntergalacticNotesAnalyzerTest {

	@Test
	public void testLoadGalacticConverterFromSugestedFile() throws NotesException, ConversionException {
		IntergalacticNotesAnalyzer ina = new IntergalacticNotesAnalyzer(TestConstants.SUGESTED_TEST_FILE);
		GalacticValueToNumberConverter converterFromAnalizer = ina.getConverter();

		GalacticValueToNumberConverter testConverter = new GalacticValueToNumberConverter(buildMapForSugestTest());
		List<String> testValues = Arrays.asList("glob", "glob", "glob");
		List<String> testValues2 = Arrays.asList("glob", "prok");
		List<String> testValues3 = Arrays.asList("pish", "pish", "pish");
		List<String> testValues4 = Arrays.asList("pish", "pish", "prok");

		assertEquals(testConverter.convert(testValues), converterFromAnalizer.convert(testValues), Util.EPSILON);
		assertEquals(testConverter.convert(testValues2), converterFromAnalizer.convert(testValues2), Util.EPSILON);
		assertEquals(testConverter.convert(testValues3), converterFromAnalizer.convert(testValues3), Util.EPSILON);
		assertEquals(testConverter.convert(testValues4), converterFromAnalizer.convert(testValues4), Util.EPSILON);
	}

	@Test
	public void testLoadGalacticConverterFromExtraFile() throws NotesException, ConversionException {
		IntergalacticNotesAnalyzer ina = new IntergalacticNotesAnalyzer(TestConstants.EXTRA_TEST);
		GalacticValueToNumberConverter converterFromAnalizer = ina.getConverter();

		GalacticValueToNumberConverter testConverter = new GalacticValueToNumberConverter(buildMapForExtraTest());
		List<String> testValues = Arrays.asList("george", "george", "george", "neville", "george", "dumbledore", "ron", "ron", "harry",
				"hermione");
		List<String> testValues2 = Arrays.asList("neville", "neville", "neville", "ron", "harry");
		List<String> testValues3 = Arrays.asList("george", "hermione", "harry", "harry");

		assertEquals(testConverter.convert(testValues), converterFromAnalizer.convert(testValues), Util.EPSILON);
		assertEquals(testConverter.convert(testValues2), converterFromAnalizer.convert(testValues2), Util.EPSILON);
		assertEquals(testConverter.convert(testValues3), converterFromAnalizer.convert(testValues3), Util.EPSILON);
	}

	@Test
	public void testLoadMineralsFromSugestedFile() throws NotesException {
		IntergalacticNotesAnalyzer ina = new IntergalacticNotesAnalyzer(TestConstants.SUGESTED_TEST_FILE);

		Set<String> expectedValues = new HashSet<String>(Arrays.asList("silver", "gold", "iron"));
		Map<String, Mineral> minerals = ina.getMinerals();
		assertEquals(true, minerals.keySet().equals(expectedValues));

	}

	@Test
	public void testLoadMineralsPricesFromSugestedFile() throws NotesException {
		IntergalacticNotesAnalyzer ina = new IntergalacticNotesAnalyzer(TestConstants.SUGESTED_TEST_FILE);

		Map<String, Mineral> minerals = ina.getMinerals();
		assertEquals(17, minerals.get("silver").getPriceInCredits(), Util.EPSILON);
		assertEquals(14450, minerals.get("gold").getPriceInCredits(), Util.EPSILON);
		assertEquals(195.5, minerals.get("iron").getPriceInCredits(), Util.EPSILON);

	}

	@Test
	public void testLoadMineralsFromExtraFile() throws NotesException {
		IntergalacticNotesAnalyzer ina = new IntergalacticNotesAnalyzer(TestConstants.EXTRA_TEST);

		Set<String> expectedValues = new HashSet<String>(Arrays.asList("silver", "gold", "iron", "steel"));
		Map<String, Mineral> minerals = ina.getMinerals();
		assertEquals(true, minerals.keySet().equals(expectedValues));

	}

	@Test
	public void testLoadQuestionsFromSugestedFile() throws NotesException {
		IntergalacticNotesAnalyzer ina = new IntergalacticNotesAnalyzer(TestConstants.SUGESTED_TEST_FILE);

		List<String> allExpectedQuestions = new LinkedList<String>(Arrays.asList("how much is pish tegj glob glob ?",
				"how many Credits is glob prok Silver ?", "how many Credits is glob prok Gold ?", "how many Credits is glob prok Iron ?",
				"how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
		List<Question> questionsFromAnalyzer = ina.getQuestions();
		questionsFromAnalyzer.removeIf(question -> allExpectedQuestions.contains(question.getSentenceText()));

		assertEquals(0, questionsFromAnalyzer.size());
	}

	@Test
	public void testLoadQuestionsFromExtraFile() throws NotesException {
		IntergalacticNotesAnalyzer ina = new IntergalacticNotesAnalyzer(TestConstants.EXTRA_TEST);

		List<String> allExpectedQuestions = new LinkedList<String>(Arrays.asList("how much is george george dumbledore ron ?",
				"how many Credits is hermione harry Silver ?", "how many Credits is ron ron ron Gold ?",
				"how many Credits is neville neville ron ron harry harry Iron ?", "how many Credits is ginny neville Steel ?",
				"how much nerd content are there in this test ?", "is there anything else you need to know ?"));
		List<Question> questionsFromAnalyzer = ina.getQuestions();
		questionsFromAnalyzer.removeIf(question -> allExpectedQuestions.contains(question.getSentenceText()));

		assertEquals(0, questionsFromAnalyzer.size());
	}

	private Map<String, RomanSymbol> buildMapForExtraTest() {
		Map<String, RomanSymbol> conversionMap = new HashMap<>();
		conversionMap.put("harry", RomanSymbol.I);
		conversionMap.put("hermione", RomanSymbol.V);
		conversionMap.put("ron", RomanSymbol.X);
		conversionMap.put("dumbledore", RomanSymbol.L);
		conversionMap.put("neville", RomanSymbol.C);
		conversionMap.put("ginny", RomanSymbol.D);
		conversionMap.put("george", RomanSymbol.M);
		return conversionMap;
	}

	private Map<String, RomanSymbol> buildMapForSugestTest() {
		Map<String, RomanSymbol> conversionMap = new HashMap<>();
		conversionMap.put("glob", RomanSymbol.I);
		conversionMap.put("prok", RomanSymbol.V);
		conversionMap.put("pish", RomanSymbol.X);
		conversionMap.put("tegj", RomanSymbol.L);
		return conversionMap;
	}

}
