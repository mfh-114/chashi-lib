package org.mfh114.chashi.graph.validator;

import org.mfh114.chashi.graph.exception.ValidatorException;

public interface Validator<T> {

	public void validate(T validateTypeObject) throws ValidatorException;

}
