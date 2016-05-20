package exercise.sentence;

import exercise.exception.FileSemanticsException;
import exercise.util.Messages;
import exercise.util.Rule;

public class FileSemanticsRule implements Rule<SentencesLoader> {

	public void test(SentencesLoader loader) throws FileSemanticsException {

		// file must have attributions
		if (loader.getAttributions().size() == 0) {
			throw new FileSemanticsException(Messages.FILE_SEMANTICS_NO_ATTRIBUTIONS);
		}
		// file must have conversions
		if (loader.getCreditsConversions().size() == 0) {
			throw new FileSemanticsException(Messages.FILE_SEMANTICS_NO_CONVERSIONS);
		}
		// file must have questions
		if (loader.getQuestions().size() == 0) {
			throw new FileSemanticsException(Messages.FILE_SEMANTICS_NO_QUESTIONS);
		}

	}

}
