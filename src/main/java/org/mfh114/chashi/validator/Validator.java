package org.mfh114.chashi.validator;

public interface Validator<T> {

	public void validate(T validateTypeObject) throws ValidatorException;

}
