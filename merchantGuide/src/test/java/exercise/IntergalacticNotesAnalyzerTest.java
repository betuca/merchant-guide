package exercise;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import exercise.exception.NotesException;
import exercise.romanNumbers.RomanSymbol;
import exercise.sentence.Question;
import exercise.util.Util;

public class IntergalacticNotesAnalyzerTest {

	@Test
	public void testLoadAttributionsNamesToMapFromSugestedFile() throws NotesException {
		IntergalacticNotesAnalyzer iuc = new IntergalacticNotesAnalyzer();
		iuc.loadNotesFromFile(TestConstants.SUGESTED_TEST_FILE);
		Map<String, RomanSymbol> conversionMap = iuc.getConversionMap();

		Set<String> correctValues = new HashSet<String>(Arrays.asList("glob", "prok", "pish", "tegj"));

		assertEquals(true, conversionMap.keySet().equals(correctValues));
	}

	@Test
	public void testLoadAttributionsValuesToMapFromSugestedFile() throws NotesException {
		IntergalacticNotesAnalyzer iuc = new IntergalacticNotesAnalyzer();
		iuc.loadNotesFromFile(TestConstants.SUGESTED_TEST_FILE);
		Map<String, RomanSymbol> conversionMap = iuc.getConversionMap();

		assertEquals(true, conversionMap.get("glob").equals(RomanSymbol.I));
		assertEquals(true, conversionMap.get("prok").equals(RomanSymbol.V));
		assertEquals(true, conversionMap.get("pish").equals(RomanSymbol.X));
		assertEquals(true, conversionMap.get("tegj").equals(RomanSymbol.L));
	}

	@Test
	public void testLoadAttributionsNamesToMapFromExtraFile() throws NotesException {
		IntergalacticNotesAnalyzer iuc = new IntergalacticNotesAnalyzer();
		iuc.loadNotesFromFile(TestConstants.EXTRA_TEST);
		Map<String, RomanSymbol> conversionMap = iuc.getConversionMap();

		Set<String> correctValues = new HashSet<String>(
				Arrays.asList("harry", "hermione", "ron", "dumbledore", "neville", "ginny", "george"));

		assertEquals(true, conversionMap.keySet().equals(correctValues));
	}

	@Test
	public void testLoadAttributionsValuesToMapFromExtraFile() throws NotesException {
		IntergalacticNotesAnalyzer iuc = new IntergalacticNotesAnalyzer();
		iuc.loadNotesFromFile(TestConstants.EXTRA_TEST);
		Map<String, RomanSymbol> conversionMap = iuc.getConversionMap();

		assertEquals(true, conversionMap.get("harry").equals(RomanSymbol.I));
		assertEquals(true, conversionMap.get("hermione").equals(RomanSymbol.V));
		assertEquals(true, conversionMap.get("ron").equals(RomanSymbol.X));
		assertEquals(true, conversionMap.get("dumbledore").equals(RomanSymbol.L));
		assertEquals(true, conversionMap.get("neville").equals(RomanSymbol.C));
		assertEquals(true, conversionMap.get("ginny").equals(RomanSymbol.D));
		assertEquals(true, conversionMap.get("george").equals(RomanSymbol.M));
	}

	@Test
	public void testLoadMineralsFromSugestedFile() throws NotesException {
		IntergalacticNotesAnalyzer iuc = new IntergalacticNotesAnalyzer();
		iuc.loadNotesFromFile(TestConstants.SUGESTED_TEST_FILE);

		Set<String> correctValues = new HashSet<String>(Arrays.asList("silver", "gold", "iron"));
		Map<String, Mineral> minerals = iuc.getMinerals();
		assertEquals(true, minerals.keySet().equals(correctValues));

	}

	@Test
	public void testLoadMineralsPricesFromSugestedFile() throws NotesException {
		IntergalacticNotesAnalyzer iuc = new IntergalacticNotesAnalyzer();
		iuc.loadNotesFromFile(TestConstants.SUGESTED_TEST_FILE);

		Map<String, Mineral> minerals = iuc.getMinerals();
		assertEquals(17, minerals.get("silver").getPriceInCredits(), Util.EPSILON);
		assertEquals(14450, minerals.get("gold").getPriceInCredits(), Util.EPSILON);
		assertEquals(195.5, minerals.get("iron").getPriceInCredits(), Util.EPSILON);

	}

	@Test
	public void testLoadMineralsFromExtraFile() throws NotesException {
		IntergalacticNotesAnalyzer iuc = new IntergalacticNotesAnalyzer();
		iuc.loadNotesFromFile(TestConstants.EXTRA_TEST);

		Set<String> correctValues = new HashSet<String>(Arrays.asList("silver", "gold", "iron", "steel"));
		Map<String, Mineral> minerals = iuc.getMinerals();
		assertEquals(true, minerals.keySet().equals(correctValues));

	}

	@Test
	public void testLoadQuestionsFromSugestedFile() throws NotesException {
		IntergalacticNotesAnalyzer iuc = new IntergalacticNotesAnalyzer();
		iuc.loadNotesFromFile(TestConstants.SUGESTED_TEST_FILE);

		List<String> allQuestions = new LinkedList<String>(Arrays.asList("how much is pish tegj glob glob ?",
				"how many Credits is glob prok Silver ?", "how many Credits is glob prok Gold ?", "how many Credits is glob prok Iron ?",
				"how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
		List<Question> questions = iuc.getQuestions();

		removeSimilarItemsFromLists(allQuestions, questions);

		assertEquals(0, allQuestions.size());
	}

	@Test
	public void testLoadQuestionsFromExtraFile() throws NotesException {
		IntergalacticNotesAnalyzer iuc = new IntergalacticNotesAnalyzer();
		iuc.loadNotesFromFile(TestConstants.EXTRA_TEST);

		List<String> allQuestions = new LinkedList<String>(Arrays.asList("how much is george george dumbledore ron ?",
				"how many Credits is hermione harry Silver ?", "how many Credits is ron ron ron Gold ?",
				"how many Credits is neville neville ron ron harry harry Iron ?", "how many Credits is ginny neville Steel ?",
				"how much nerd content are there in this test ?", "is there anything else you need to know ?"));
		List<Question> questions = iuc.getQuestions();

		removeSimilarItemsFromLists(allQuestions, questions);

		assertEquals(0, allQuestions.size());
	}

	private void removeSimilarItemsFromLists(List<String> firstList, List<Question> secondList) {
		for (Question question : secondList) {
			if (firstList.contains(question.getSentenceText())) {
				firstList.remove(question.getSentenceText());
			}
		}
	}

}
