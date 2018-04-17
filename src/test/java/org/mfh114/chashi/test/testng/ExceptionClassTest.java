package org.mfh114.chashi.test.testng;

import org.mfh114.chashi.graph.exception.ChashiException;
import org.mfh114.chashi.graph.exception.DuplicateVertexNameException;
import org.mfh114.chashi.graph.exception.GraphInLoopException;
import org.mfh114.chashi.graph.exception.InvalidVertexNameException;
import org.mfh114.chashi.graph.exception.ParameterRequiredException;
import org.mfh114.chashi.graph.exception.ValidatorException;
import org.testng.annotations.Test;

public class ExceptionClassTest {

	@Test(expectedExceptions = ChashiException.class)
	public void verifyChashiException() throws ChashiException {
		throw new ChashiException(ChashiException.class.getName());
	}

	@Test(expectedExceptions = ChashiException.class)
	public void verifyChashiExceptionWithThrowable() throws ChashiException {
		throw new ChashiException(ChashiException.class.getName(), new Throwable());
	}

	@Test(expectedExceptions = DuplicateVertexNameException.class)
	public void duplicateVertexNameException() throws DuplicateVertexNameException {
		throw new DuplicateVertexNameException(DuplicateVertexNameException.class.getName());
	}

	@Test(expectedExceptions = DuplicateVertexNameException.class)
	public void verifyDuplicateVertexNameExceptionWithThrowable() throws DuplicateVertexNameException {
		throw new DuplicateVertexNameException(DuplicateVertexNameException.class.getName(), new Throwable());
	}

	@Test(expectedExceptions = GraphInLoopException.class)
	public void verifyGraphInLoopException() throws GraphInLoopException {
		throw new GraphInLoopException(GraphInLoopException.class.getName());
	}

	@Test(expectedExceptions = GraphInLoopException.class)
	public void verifyGraphInLoopExceptionWithThrowable() throws GraphInLoopException {
		throw new GraphInLoopException(GraphInLoopException.class.getName(), new Throwable());
	}

	@Test(expectedExceptions = InvalidVertexNameException.class)
	public void verifyInvalidVertexNameException() throws InvalidVertexNameException {
		throw new InvalidVertexNameException(InvalidVertexNameException.class.getName());
	}

	@Test(expectedExceptions = InvalidVertexNameException.class)
	public void verifyInvalidVertexNameExceptionWithThrowable() throws InvalidVertexNameException {
		throw new InvalidVertexNameException(InvalidVertexNameException.class.getName(), new Throwable());
	}

	@Test(expectedExceptions = ParameterRequiredException.class)
	public void verifyParameterRequiredException() throws ParameterRequiredException {
		throw new ParameterRequiredException(ParameterRequiredException.class.getName());
	}

	@Test(expectedExceptions = ParameterRequiredException.class)
	public void verifyParameterRequiredExceptionWithThrowable() throws ParameterRequiredException {
		throw new ParameterRequiredException(ParameterRequiredException.class.getName(), new Throwable());
	}

	@Test(expectedExceptions = ValidatorException.class)
	public void verifyValidatorException() throws ValidatorException {
		throw new ValidatorException(ValidatorException.class.getName());
	}

	@Test(expectedExceptions = ValidatorException.class)
	public void verifyValidatorExceptionWithThrowable() throws ValidatorException {
		throw new ValidatorException(ValidatorException.class.getName(), new Throwable());
	}
}
