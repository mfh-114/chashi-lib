package org.mfh114.chashi.fsm;

import org.mfh114.chashi.ChashiException;

public class ScanState implements State {

	private FSMContext context;

	public ScanState(FSMContext context) {
		this.context = context;
	}

	@Override
	public void execute() throws ChashiException {
		// TODO Auto-generated method stub

		
		this.context.setNextState(StateDefination.RM_COLUMN_ENTRY);
	}

}
