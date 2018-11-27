package motif.shared.gamelog;

import java.text.MessageFormat;
import java.util.ArrayList;

import com.google.gson.annotations.Expose;

import motif.shared.util.MotifConsole;
import motif.shared.util.MotifConsole.MotifConsoleBorder;

public class MotifGameLog<T> {

	public class MotifGameLogRow {
		@Expose private String message;
		@Expose private T type;
		public MotifGameLogRow (String message, T type) {
			this.message = message;
			this.type = type;
		} // GameLogRow
	} // BritGameLogRow
	
	private ArrayList<MotifGameLogRow> logRows;
	
	public MotifGameLog (ArrayList<MotifGameLogRow> logRows) {
		this.logRows = logRows;
	} // GameLog

	protected MotifGameLogRow add (T type, MotifConsoleBorder borderType, String text, Object...args) {
		String message = new MessageFormat (text).format (args);
		MotifGameLogRow logRow = new MotifGameLogRow (message, type);
		logRows.add (logRow);
		MotifConsole.println (borderType, message);
		return logRow;
	} // add

} // MotifGameLog
