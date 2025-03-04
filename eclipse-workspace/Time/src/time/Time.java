package time;

import java.util.Scanner;

/**
 * @modfied by Liz Dancy
 * Used to show how to catch multiple Exceptions and then as a base class
 * for the testing exercise with JUnit
 *
 */

import javax.swing.JOptionPane;

/**
 * Taken from Wendi Jollymore :http://www-acad.sheridanc.on.ca/~jollymor/prog24178/oop2.html
 * @modfied by Liz Dancy
 * Used  as a base class
 * for the testing exercise with JUnit
 *  Winter 2021
 */

public class Time {
	public static void main(String[] args) {
		int totalSeconds = getTotalSeconds("10:10:10");
		System.out.println("Github Seconds! = "+ totalSeconds);
		;
	}

	public static int getTotalSeconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
		// First validate the time format
		if (time.length() < 8 || time.charAt(2) != ':' || time.charAt(5) != ':') {
			throw new StringIndexOutOfBoundsException("Time format is invalid. Expected format: hh:mm:ss");
		}

		int hours = getTotalHours(time);
		int minutes = getTotalMinutes(time);
		int seconds = getSeconds(time);

		return hours * 3600 + minutes * 60 + seconds;
	}

	public static int getSeconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException {

		return Integer.parseInt(time.substring(6, 8));
	}

	public static int getTotalMinutes(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
		String[] parts = time.split(":");
		if (parts.length != 3) {
			throw new NumberFormatException("Time format is invalid. Expected format: hh:mm:ss");
		}
		return Integer.parseInt(parts[1]);
	}

	public static int getTotalHours(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
		return Integer.parseInt(time.substring(0, 2));
	}

	public static int getMilliseconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
		String[] parts = time.split(":");
		if (parts.length != 4) {
			throw new StringIndexOutOfBoundsException("The time format is invalid. Expected format: hh:mm:ss:ms");
		}
		return Integer.parseInt(parts[3]);
	}
}
