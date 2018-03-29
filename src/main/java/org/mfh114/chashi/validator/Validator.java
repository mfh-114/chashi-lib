package org.mfh114.chashi.validator;

import org.mfh114.chashi.validator.exception.ValidatorException;

public interface Validator<T> {

	public void validate(T validateTypeObject) throws ValidatorException;

}
