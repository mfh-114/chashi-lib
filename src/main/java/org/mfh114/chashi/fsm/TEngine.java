package org.mfh114.chashi.fsm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mfh114.chashi.graph.Vertex;

/***
 * This is finite state machine to do the finite sequence of logic to perform
 * topological sort and execute callback method asynchronously if available in
 * the Vertex implementation.
 */
public class TEngine implements FSMContext {

	private Error error;
	private FreeVertex freeVertex;
	private StateDefination stateDefination;
	private Map<String, List<Vertex>> rowMap;
	private Map<String, List<Vertex>> columnMap;
	private List<FreeVertex> sortedVertexes;
	private TEngineErrorHandler tEngineErrorHandler;

	public TEngine(Map<String, List<Vertex>> rowMap, Map<String, List<Vertex>> columnMap,
			TEngineErrorHandler tEngineErrorHandler) {
		this.error = null;
		this.freeVertex = null;
		this.rowMap = rowMap;
		this.columnMap = columnMap;
		this.sortedVertexes = new ArrayList<FreeVertex>();
		this.stateDefination = StateDefination.SCAN_ENTRY;
		this.tEngineErrorHandler = tEngineErrorHandler;
	}

	@Override
	public void setNextState(StateDefination stateDefination) {
		this.stateDefination = stateDefination;
	}

	@Override
	public StateDefination getNextState() {
		return stateDefination;
	}

	@Override
	public void setError(Error error) {
		this.error = error;
	}

	@Override
	public Error getError() {
		return error;
	}

	@Override
	public void setFreeVertex(FreeVertex freeVertex) {
		this.freeVertex = freeVertex;
	}

	@Override
	public FreeVertex getFreeVertex() {
		return freeVertex;
	}

	public void run() {
		while (stateDefination != StateDefination.EXIT) {
			switch (stateDefination) {

			case SCAN_ENTRY:
				State scanState = new ScanState(this);
				scanState.execute();
				if (freeVertex != null)
					sortedVertexes.add(freeVertex);
				break;
			case RM_COLUMN_ENTRY:
				State rmColumnEntryState = new ColumnMapEntryRemover(this, columnMap);
				rmColumnEntryState.execute();
				break;
			case RM_ROW_ENTRY:
				State rmRowEntryState = new RowMapEntryRemover(this, rowMap);
				rmRowEntryState.execute();
				break;
			case ERROR:
				State errorState = new ErrorHandler(this, tEngineErrorHandler);
				errorState.execute();
				break;
			default:
				stateDefination = StateDefination.EXIT;
			}
		}

		handleSortedVertexCallBack();
	}

	public void printSortedVertexes() {

	}

	private void handleSortedVertexCallBack() {
		// aync callback if registered.
	}
}
