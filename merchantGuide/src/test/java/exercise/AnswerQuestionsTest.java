package exercise;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import exercise.exception.ConvertionException;
import exercise.romanNumbers.RomanSymbol;
import exercise.sentence.IntergalacticToDecimalQuestion;
import exercise.sentence.MineralsToCreditsQuestion;
import exercise.sentence.Question;
import exercise.util.MineralBuilder;

public class AnswerQuestionsTest {

	@Test
	public void testAnswerIntergalacticToDecimalQuestionsSugested() throws ConvertionException {

		AnswerQuestion answerQuestions = new AnswerQuestion(buildConversionMapForSugestTest(), buildMineralsMapForSugestTest());

		Question question = new IntergalacticToDecimalQuestion("how much is pish tegj glob glob ?");

		assertEquals("pish tegj glob glob is 42", answerQuestions.answer(question));

	}

	@Test
	public void testAnswerIntergalacticToDecimalQuestionsExtra() throws ConvertionException {

		AnswerQuestion answerQuestions = new AnswerQuestion(buildConversionMapForExtraTest(), buildMineralsMapForExtraTest());

		Question question = new IntergalacticToDecimalQuestion("how much is george george dumbledore ron ?");

		assertEquals("george george dumbledore ron is 2060", answerQuestions.answer(question));

	}

	@Test
	public void testAnswerMineralToCreditsQuestionsSugested() throws ConvertionException {

		AnswerQuestion answerQuestions = new AnswerQuestion(buildConversionMapForSugestTest(), buildMineralsMapForSugestTest());

		Question question = new MineralsToCreditsQuestion("how many Credits is glob prok Silver ?");

		assertEquals("glob prok Silver is 68 Credits", answerQuestions.answer(question));

	}

	@Test
	public void testAnswerMineralToCreditsQuestionsExtra() throws ConvertionException {

		AnswerQuestion answerQuestions = new AnswerQuestion(buildConversionMapForExtraTest(), buildMineralsMapForExtraTest());

		Question question = new MineralsToCreditsQuestion("how many Credits is neville neville ron ron harry harry Iron ?");

		assertEquals("neville neville ron ron harry harry Iron is 222 Credits", answerQuestions.answer(question));

	}

	@Test(expected = ConvertionException.class)
	public void testThorwExceptionWhenMetalNotInMap() throws ConvertionException {

		AnswerQuestion answerQuestions = new AnswerQuestion(buildConversionMapForSugestTest(), buildMineralsMapForSugestTest());
		Question question = new MineralsToCreditsQuestion("how many Credits is glob glob MMMMM ?");
		answerQuestions.answer(question);
	}

	private Map<String, RomanSymbol> buildConversionMapForExtraTest() {
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

	private Map<String, RomanSymbol> buildConversionMapForSugestTest() {
		Map<String, RomanSymbol> conversionMap = new HashMap<>();
		conversionMap.put("glob", RomanSymbol.I);
		conversionMap.put("prok", RomanSymbol.V);
		conversionMap.put("pish", RomanSymbol.X);
		conversionMap.put("tegj", RomanSymbol.L);
		return conversionMap;
	}

	private Map<String, Mineral> buildMineralsMapForSugestTest() {
		Map<String, Mineral> convertionMap = new HashMap<>();
		convertionMap.put("silver", new MineralBuilder().setName("silver").setPriceInCredits(17).build());
		convertionMap.put("gold", new MineralBuilder().setName("gold").setPriceInCredits(14450).build());
		convertionMap.put("iron", new MineralBuilder().setName("iron").setPriceInCredits(195.5F).build());
		return convertionMap;
	}

	private Map<String, Mineral> buildMineralsMapForExtraTest() {
		Map<String, Mineral> convertionMap = new HashMap<>();
		convertionMap.put("silver", new MineralBuilder().setName("silver").setPriceInCredits(1000 / 110).build());
		convertionMap.put("gold", new MineralBuilder().setName("gold").setPriceInCredits(12000 / 6).build());
		convertionMap.put("iron", new MineralBuilder().setName("iron").setPriceInCredits(1).build());
		convertionMap.put("steel", new MineralBuilder().setName("steel").setPriceInCredits(50).build());
		return convertionMap;
	}

}
