package org.mfh114.chashi.fsm;

import java.util.List;
import java.util.Map;

import org.mfh114.chashi.ChashiException;
import org.mfh114.chashi.graph.Vertex;

public class RowMapEntryRemover implements State {

	private FSMContext context;
	
	public RowMapEntryRemover(FSMContext context, Map<String, List<Vertex>> rowMap) {
		this.context = context;
	}

	@Override
	public void execute() throws ChashiException {
		
		
	}

}
