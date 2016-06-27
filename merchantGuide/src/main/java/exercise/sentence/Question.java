package exercise.sentence;

import java.util.Map;

import exercise.GalacticValueToNumberConverter;
import exercise.Mineral;

public interface Question {

	String getSentenceText();

	String getAnswer(GalacticValueToNumberConverter converter, Map<String, Mineral> mineralsMap);

}
