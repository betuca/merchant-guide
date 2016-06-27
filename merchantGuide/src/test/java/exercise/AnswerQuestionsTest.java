package exercise;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exercise.exception.NotesException;
import exercise.sentence.IntergalacticToDecimalQuestion;
import exercise.sentence.MineralsToCreditsQuestion;
import exercise.sentence.Question;
import exercise.sentence.UnknownQuestion;
import exercise.util.Messages;

public class AnswerQuestionsTest {

	@Test
	public void testAnswerIntergalacticToDecimalQuestionsSugested() throws NotesException {
		IntergalacticNotesAnalyzer ina = new IntergalacticNotesAnalyzer(TestConstants.SUGESTED_TEST_FILE);

		Question question = new IntergalacticToDecimalQuestion("how much is pish tegj glob glob ?");

		assertEquals("pish tegj glob glob is 42", question.getAnswer(ina.getConverter(), ina.getMinerals()));
	}

	@Test
	public void testAnswerIntergalacticToDecimalQuestionsExtra() throws NotesException {
		IntergalacticNotesAnalyzer ina = new IntergalacticNotesAnalyzer(TestConstants.EXTRA_TEST);

		Question question = new IntergalacticToDecimalQuestion("how much is george george dumbledore ron ?");

		assertEquals("george george dumbledore ron is 2060", question.getAnswer(ina.getConverter(), ina.getMinerals()));
	}

	@Test
	public void testAnswerMineralToCreditsQuestionsSugested() throws NotesException {
		IntergalacticNotesAnalyzer ina = new IntergalacticNotesAnalyzer(TestConstants.SUGESTED_TEST_FILE);

		Question question = new MineralsToCreditsQuestion("how many Credits is glob prok Silver ?");

		assertEquals("glob prok Silver is 68 Credits", question.getAnswer(ina.getConverter(), ina.getMinerals()));
	}

	@Test
	public void testAnswerMineralToCreditsQuestionsExtra() throws NotesException {
		IntergalacticNotesAnalyzer ina = new IntergalacticNotesAnalyzer(TestConstants.EXTRA_TEST);

		Question question = new MineralsToCreditsQuestion("how many Credits is neville neville ron ron harry harry Iron ?");

		assertEquals("neville neville ron ron harry harry Iron is 222 Credits", question.getAnswer(ina.getConverter(), ina.getMinerals()));
	}

	@Test
	public void testAnswerUnknownQuestion() throws NotesException {
		Question question = new UnknownQuestion("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");

		assertEquals(Messages.UNKNOWN_ANSWER_MESSAGE, question.getAnswer(null, null));
	}
}
