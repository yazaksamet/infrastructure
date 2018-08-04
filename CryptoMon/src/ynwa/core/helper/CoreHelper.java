package ynwa.core.helper;

import java.io.PrintWriter;
import java.io.StringWriter;

public class CoreHelper {
	public static String GetStackTrace(Exception e) {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}
}
