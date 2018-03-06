package org.mfh114.chashi.fsm;

public interface FSMContext {

	public void setFreeVertex(FreeVertex freeVertex);

	public FreeVertex getFreeVertex();

	public void setError(Error error);

	public Error getError();

	public void setNextState(StateDefination stateDefination);

	public StateDefination getNextState();

}
