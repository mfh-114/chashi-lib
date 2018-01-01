package org.mfh114.chashi.fsm;

import org.mfh114.chashi.ChashiException;

public interface State {

	public void execute() throws ChashiException;

}
