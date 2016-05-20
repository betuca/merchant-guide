package exercise.util;

public class Messages {

	public static final String INVALID_PARAMETER_FOR_CONVERSION = "The parameter value {0} is not a valid roman symbol.";
	public static final String SYMBOL_REPETITION_EXCEPTION_MESSAGE = "The symbol {0} cannot repeat more than {1} times.";
	public static final String SYMBOL_SUBTRACTION_EXCEPTION_MESSAGE = "The symbol {0} cannot be subtracted.";
	public static final String UNKNOWN_SENTENCE_EXCEPTION_MESSAGE = "Sentence format was not recognized. Sentence text: \"{0}\"";
	public static final String IOEXCEPTION_MESSAGE = "Problems reading file.";
	public static final String PROBLEM_LOADING_SENTENCES_MESSAGE = "There was a problem loading sentences from file.";
	public static final String TRYING_TO_CONVERT_EMPTY_LIST_MESSAGE = "It is not possible to convert an empy or null list.";
	public static final String INVALID_ROMAN_NUMBER = "The number \"{0}\" is not a valid roman number.";
	public static final String UNRECOGNIZABLE_SYMBOL_MESSAGE = "Problem translating symbol from question. Symbol \"{0}\" not recognized.";
	public static final String UNRECOGNIZABLE_MINERAL_MESSAGE = "Problem translating mineral from question. Mineral \"{0}\" not recognized.";
	public static final String FILE_SEMANTICS_NO_ATTRIBUTIONS = "Invalid intergalactic notes file. No attributions section found.";
	public static final String FILE_SEMANTICS_NO_CONVERSIONS = "Invalid intergalactic notes file. No conversions section found.";
	public static final String FILE_SEMANTICS_NO_QUESTIONS = "Invalid intergalactic notes file. No questions section found.";
	public static final String PROBLEM_READING_NOTES = "Problem reading intergalactic notes. Please check the file path and try again.";

	public static final String INTERGALACTIC_TO_DECIMAL_ANSWER_MESSAGE = "{0} is {1}";
	public static final String MINERAL_TO_CREDITS_ANSWER_MESSAGE = "{0} {1} is {2} Credits";
	public static final String UNKNOWN_ANSWER_MESSAGE = "I have no idea what you are talking about";

	public static final String INPUT_FILE_TEXT = "\nMissing file parameter. "
			+ "\n\nUsage:\njava -cp target/classes exercise.MerchantsUnitConverter full_path_to_input_file"
			+ "\n\nExample: \njava -cp target/classes exercise.MerchantsUnitConverter C:\\desenv\\input.txt";
}
