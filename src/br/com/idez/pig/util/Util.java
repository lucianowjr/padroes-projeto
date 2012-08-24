package br.com.idez.pig.util;

public class Util {

	public static boolean isInteger(String str) {

		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException nfe) {
		}
		return false;
	}

}