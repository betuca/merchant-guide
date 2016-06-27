package exercise;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import exercise.exception.ConversionException;
import exercise.romanNumbers.RomanSymbol;
import exercise.util.Util;

public class GalacticValueToNumberConverterTest {

	@Test(expected = ConversionException.class)
	public void testThorwExceptionWithEmptyList() throws ConversionException {

		GalacticValueToNumberConverter converter = new GalacticValueToNumberConverter(buildMapForSugestTest());
		List<String> list = new ArrayList<>();
		converter.convert(list);
	}

	@Test
	public void testConvertGlobGlobGlob() throws ConversionException {

		GalacticValueToNumberConverter converter = new GalacticValueToNumberConverter(buildMapForSugestTest());
		List<String> list = Arrays.asList("glob", "glob", "glob");
		assertEquals(3, converter.convert(list), Util.EPSILON);
	}

	@Test
	public void testConvertGlobGlobProk() throws ConversionException {

		GalacticValueToNumberConverter converter = new GalacticValueToNumberConverter(buildMapForSugestTest());
		List<String> list = Arrays.asList("glob", "prok");
		assertEquals(4, converter.convert(list), Util.EPSILON);
	}

	@Test
	public void testConvertLongListsOfNumbers() throws ConversionException {

		GalacticValueToNumberConverter converter = new GalacticValueToNumberConverter(buildMapForExtraTest());
		List<String> list = Arrays.asList("george", "george", "george", "neville", "george", "dumbledore", "ron", "ron", "harry",
				"hermione");
		assertEquals(3974, converter.convert(list), Util.EPSILON);
	}

	@Test(expected = ConversionException.class)
	public void testThorwExceptionWithUnrecognizedSymbols() throws ConversionException {

		GalacticValueToNumberConverter converter = new GalacticValueToNumberConverter(buildMapForExtraTest());
		List<String> list = Arrays.asList("XXXX", "YYYY");
		converter.convert(list);
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
