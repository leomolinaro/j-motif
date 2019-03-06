package com.motif.shared.util;

import java.text.MessageFormat;

public class MotifConsole {
	
	public enum MotifConsoleBorder {
		WIDE, NORMAL, THIN, NONE
	} // MotifConsoleBorder
	
	public static String getIndent (int indent) {
		StringBuilder s = new StringBuilder ("");
		for (int i = 0; i < indent; i++) { s.append ("\t"); }
		return s.toString ();
	} // getIndent
	
	public static String format (String text, Object...args) { return new MessageFormat (text).format (args); }
	
	public static void println (String text, Object...args) { println (MotifConsoleBorder.NONE, text, args); }

	public static void println (MotifConsoleBorder borderType, String text, Object...args) {
		String toConsole = format (text, args);
		String border;
		switch (borderType) {
			case NORMAL: border = "=================================================================================="; break;
			case THIN:   border = "----------------------------------------------------------------------------------"; break;
			case WIDE:   border = "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"; break;
			default: border = null;
		} // switch
		if (border != null) { System.out.println (border); }
		System.out.println (toConsole);
		if (border != null) { System.out.println (border); }
	} // println
	
} // MotifConsole
