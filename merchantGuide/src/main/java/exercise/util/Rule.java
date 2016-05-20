package exercise.util;

import exercise.exception.RuleException;

public interface Rule<T> {

	void test(T var) throws RuleException;

}
