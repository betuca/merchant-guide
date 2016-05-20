package exercise;

import static org.junit.Assert.assertEquals;

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
	public void testConvertSymbolI() throws RuleException {
		assertEquals(1, r2d.convert("I"));
	}

	@Test
	public void testConvertSymbolV() throws RuleException {
		assertEquals(5, r2d.convert("V"));
	}

	@Test
	public void testConvertSymbolX() throws RuleException {
		assertEquals(10, r2d.convert("X"));
	}

	@Test
	public void testConvertSymbolL() throws RuleException {
		assertEquals(50, r2d.convert("L"));
	}

	@Test
	public void testConvertSymbolC() throws RuleException {
		assertEquals(100, r2d.convert("C"));
	}

	@Test
	public void testConvertSymbolD() throws RuleException {
		assertEquals(500, r2d.convert("D"));
	}

	@Test
	public void testConvertSymbolM() throws RuleException {
		assertEquals(1000, r2d.convert("M"));
	}

	@Test(expected = InvalidParameterException.class)
	public void testThrowExceptionForLowerCaseSymbols() throws RuleException {
		r2d.convert("i");
	}

	@Test
	public void testConvertSequencesWithoutSubtractionMMCCXII() throws RuleException {
		assertEquals(2212, r2d.convert("MMCCXII"));
	}

	@Test
	public void testConvertSequencesWithoutSubtractionDLXI() throws RuleException {
		assertEquals(561, r2d.convert("DLXI"));
	}

	@Test
	public void testConvertSequencesWithSubtractionXXIX() throws RuleException {
		assertEquals(29, r2d.convert("XXIX"));
	}

	@Test
	public void testConvertSequencesWithSubtractionCCCXC() throws RuleException {
		assertEquals(390, r2d.convert("CCCXC"));
	}

	@Test
	public void testConvertSequencesWithSubtractionXLIV() throws RuleException {
		assertEquals(44, r2d.convert("XLIV"));
	}

	@Test
	public void testConvertSequencesWithSubtractionCMXCIX() throws RuleException {
		assertEquals(999, r2d.convert("CMXCIX"));
	}

	@Test
	public void testConvertSequencesWithFourXsOneApart() throws RuleException {
		assertEquals(39, r2d.convert("XXXIX"));
	}

	@Test(expected = RuleException.class)
	public void testThrowExceptionWithMoreThanTreeXs() throws RuleException {
		r2d.convert("XXXXV");

	}

	@Test(expected = RuleException.class)
	public void testThrowExceptionWithMoreThanTreeIs() throws RuleException {
		r2d.convert("MMCXIIII");
	}

	@Test(expected = RuleException.class)
	public void shouldThrowExceptionWithDoubleDs() throws RuleException {
		r2d.convert("MMDDII");
	}

	@Test(expected = RuleException.class)
	public void testThrowExceptionWithDoubleLs() throws RuleException {
		r2d.convert("CLLI");
	}

	@Test(expected = RuleException.class)
	public void testThrowExceptionSubtractionWithD() throws RuleException {
		r2d.convert("MMDM");
	}

	@Test
	public void testErrorMessarForSubtraction() {

		boolean expectedMessageFound = false;
		try {
			r2d.convert("MMDM");
		} catch (RuleException e) {

			if (e.getMessage().equals("The symbol D cannot be subtracted.")) {
				expectedMessageFound = true;
			}
		}
		assertEquals(true, expectedMessageFound);
	}

	@Test
	public void testErrorMessarForRepetitionCLLI() {

		boolean expectedMessageFound = false;
		try {
			r2d.convert("CLLI");
		} catch (RuleException e) {

			if (e.getMessage().equals("The symbol L cannot repeat more than 1 times.")) {
				expectedMessageFound = true;
			}
		}
		assertEquals(true, expectedMessageFound);
	}

	@Test
	public void testErrorMessarForRepetitionXXXXV() {

		boolean expectedMessageFound = false;
		try {
			r2d.convert("XXXXV");
		} catch (RuleException e) {

			if (e.getMessage().equals("The symbol X cannot repeat more than 3 times.")) {
				expectedMessageFound = true;
			}
		}
		assertEquals(true, expectedMessageFound);
	}

}
