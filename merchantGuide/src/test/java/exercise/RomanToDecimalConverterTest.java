package exercise;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.Test;

import exercise.exception.RuleException;
import exercise.romanNumbers.RomanToDecimalConverter;

public class RomanToDecimalConverterTest {

	private RomanToDecimalConverter r2d;

	public RomanToDecimalConverterTest() {
		this.r2d = new RomanToDecimalConverter();
	}

	@Test
	public void shouldConvertSymbolI() throws RuleException {
		assertEquals(1, r2d.convert("I"));
	}

	@Test
	public void shouldConvertSymbolV() throws RuleException {
		assertEquals(5, r2d.convert("V"));
	}

	@Test
	public void shouldConvertSymbolX() throws RuleException {
		assertEquals(10, r2d.convert("X"));
	}

	@Test
	public void shouldConvertSymbolL() throws RuleException {
		assertEquals(50, r2d.convert("L"));
	}

	@Test
	public void shouldConvertSymbolC() throws RuleException {
		assertEquals(100, r2d.convert("C"));
	}

	@Test
	public void shouldConvertSymbolD() throws RuleException {
		assertEquals(500, r2d.convert("D"));
	}

	@Test
	public void shouldConvertSymbolM() throws RuleException {
		assertEquals(1000, r2d.convert("M"));
	}

	@Test
	public void shouldThrowExceptionForLowerCaseSymbols() throws RuleException {

		boolean threwException = false;
		try {
			r2d.convert("i");
		} catch (InvalidParameterException e) {

			threwException = true;
		}

		assertEquals(true, threwException);
	}

	@Test
	public void shouldConvertSequencesWithoutSubtractionMMCCXII() throws RuleException {
		assertEquals(2212, r2d.convert("MMCCXII"));
	}

	@Test
	public void shouldConvertSequencesWithoutSubtractionDLXI() throws RuleException {
		assertEquals(561, r2d.convert("DLXI"));
	}

	@Test
	public void shouldConvertSequencesWithSubtractionXXIX() throws RuleException {
		assertEquals(29, r2d.convert("XXIX"));
	}

	@Test
	public void shouldConvertSequencesWithSubtractionCCCXC() throws RuleException {
		assertEquals(390, r2d.convert("CCCXC"));
	}

	@Test
	public void shouldConvertSequencesWithSubtractionXLIV() throws RuleException {
		assertEquals(44, r2d.convert("XLIV"));
	}

	@Test
	public void shouldConvertSequencesWithSubtractionCMXCIX() throws RuleException {
		assertEquals(999, r2d.convert("CMXCIX"));
	}

	@Test
	public void shouldConvertSequencesWithFourXsOneApart() throws RuleException {
		assertEquals(39, r2d.convert("XXXIX"));
	}

	@Test(expected=RuleException.class)
	public void shouldThrowExceptionWithMoreThanTreeXs() throws RuleException {
//		assertThrown(new RomanToDecimalConverter()::convert("XXXXV")).isInstanceOf(RuleException.class);
		r2d.convert("XXXXV");

	}

	@Test(expected=RuleException.class)
	public void shouldThrowExceptionWithMoreThanTreeIs() throws RuleException {
		r2d.convert("MMCXIIII");
	}

	@Test(expected=RuleException.class)
	public void shouldThrowExceptionWithDoubleDs() throws RuleException {
		r2d.convert("MMDDII");
	}

	@Test(expected=RuleException.class)
	public void shouldThrowExceptionWithDoubleLs() throws RuleException {
		r2d.convert("CLLI");
	}

	@Test(expected=RuleException.class)
	public void shouldThrowExceptionSubtractionWithD() throws RuleException {
		r2d.convert("MMDM");
	}

	@Test
	public void shouldGiveAppropriateErrorMessarForSubtraction() {

		boolean threwException = false;
		try {
			r2d.convert("MMDM");
		} catch (RuleException e) {

			if (e.getMessage().equals("The symbol D cannot be subtracted.")) {
				threwException = true;
			}
		}

		assertEquals(true, threwException);
	}

	@Test
	public void shouldGiveAppropriateErrorMessarForRepetitionCLLI() {

		boolean threwException = false;
		try {
			r2d.convert("CLLI");
		} catch (RuleException e) {

			if (e.getMessage().equals("The symbol L cannot repeat more than 1 times.")) {
				threwException = true;
			}
		}

		assertEquals(true, threwException);
	}

	@Test
	public void shouldGiveAppropriateErrorMessarForRepetitionXXXXV() {

		boolean threwException = false;
		try {
			r2d.convert("XXXXV");
		} catch (RuleException e) {

			if (e.getMessage().equals("The symbol X cannot repeat more than 3 times.")) {
				threwException = true;
			}
		}

		assertEquals(true, threwException);
	}

}
