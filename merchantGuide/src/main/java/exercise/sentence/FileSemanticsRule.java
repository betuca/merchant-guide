package exercise.sentence;

import exercise.exception.FileSemanticsException;
import exercise.util.Messages;
import exercise.util.Rule;

/*
 * Classe que representa uma regra para garantir que o arquivo que 
 * esta sendo lido apresenta o minimo de caracteristicas para ser 
 * considerado valido. Para ser considerado um arquivo valido
 * este precisa ter, no minimo, uma frase de cada tipo (attributions,
 * conversions e questions).
 */
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
