package org.mfh114.chashi.fsm;

import java.util.List;
import java.util.Map;

import org.mfh114.chashi.ChashiException;
import org.mfh114.chashi.graph.Vertex;

public class ColumnMapEntryRemover implements State {

	private FSMContext context;

	public ColumnMapEntryRemover(FSMContext context, Map<String, List<Vertex>> columnMap) {
		this.context = context;
	}

	@Override
	public void execute() throws ChashiException {
		this.context.setNextState(StateDefination.RM_ROW_ENTRY);
	}

}
