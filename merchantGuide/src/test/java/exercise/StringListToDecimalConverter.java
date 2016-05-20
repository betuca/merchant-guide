package exercise;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import exercise.exception.ConvertionException;
import exercise.romanNumbers.RomanSymbol;
import exercise.util.Util;

public class StringListToDecimalConverter {

	@Test(expected = ConvertionException.class)
	public void testThorwExceptionWithEmptyList() throws ConvertionException {

		StringListToDecimanlConverter converter = new StringListToDecimanlConverter(buildMapForSugestTest());
		List<String> list = new ArrayList<>();
		converter.convert(list);
	}

	@Test
	public void testConvertGlobGlobGlob() throws ConvertionException {

		StringListToDecimanlConverter converter = new StringListToDecimanlConverter(buildMapForSugestTest());
		List<String> list = Arrays.asList("glob", "glob", "glob");
		assertEquals(3, converter.convert(list), Util.EPSILON);
	}

	@Test
	public void testConvertGlobGlobProk() throws ConvertionException {

		StringListToDecimanlConverter converter = new StringListToDecimanlConverter(buildMapForSugestTest());
		List<String> list = Arrays.asList("glob", "prok");
		assertEquals(4, converter.convert(list), Util.EPSILON);
	}

	@Test
	public void testConvertLongListsOfNumbers() throws ConvertionException {

		StringListToDecimanlConverter converter = new StringListToDecimanlConverter(buildMapForExtraTest());
		List<String> list = Arrays.asList("george", "george", "george", "neville", "george", "dumbledore", "ron", "ron", "harry",
				"hermione");
		assertEquals(3974, converter.convert(list), Util.EPSILON);
	}

	@Test(expected = ConvertionException.class)
	public void testThorwExceptionWithUnrecognizedSymbols() throws ConvertionException {

		StringListToDecimanlConverter converter = new StringListToDecimanlConverter(buildMapForExtraTest());
		List<String> list = Arrays.asList("XXXX", "YYYY");
		converter.convert(list);
	}

	private Map<String, RomanSymbol> buildMapForExtraTest() {
		Map<String, RomanSymbol> convertionMap = new HashMap<>();
		convertionMap.put("harry", RomanSymbol.I);
		convertionMap.put("hermione", RomanSymbol.V);
		convertionMap.put("ron", RomanSymbol.X);
		convertionMap.put("dumbledore", RomanSymbol.L);
		convertionMap.put("neville", RomanSymbol.C);
		convertionMap.put("ginny", RomanSymbol.D);
		convertionMap.put("george", RomanSymbol.M);
		return convertionMap;
	}

	private Map<String, RomanSymbol> buildMapForSugestTest() {
		Map<String, RomanSymbol> convertionMap = new HashMap<>();
		convertionMap.put("glob", RomanSymbol.I);
		convertionMap.put("prok", RomanSymbol.V);
		convertionMap.put("pish", RomanSymbol.X);
		convertionMap.put("tegj", RomanSymbol.L);
		return convertionMap;
	}

}
