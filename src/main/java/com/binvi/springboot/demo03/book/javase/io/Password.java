package com.binvi.springboot.demo03.book.javase.io;

import java.io.Console;
import java.util.Arrays;

/**
 * @author binvi
 * @version 1.0
 * @Description: Console usage
 * @date 2020/6/27 0:05
 */
public class Password {

	public static void main(String[] args) throws Exception {

		Console console = System.console();
		if (console == null) {
			System.err.println("No Console.");
			System.exit(1);
		}

		String login = console.readLine("Enter your login: ");
		char[] oldPassword = console.readPassword("Enter your old password: ");
		if (verifyPassword(login, oldPassword)) {
			boolean notMatch;
			do {
				char[] newPassword1 = console.readPassword("Enter your new password: ");
				char[] newPassword2 = console.readPassword("Enter new password again: ");
				notMatch = !Arrays.equals(newPassword1, newPassword2);
				if (notMatch) {
					console.format("Password don't match. Try again.%n");
				} else {
					changePassword(login, newPassword1);
					console.format("Password for %s changed.%n", login);
				}
				Arrays.fill(newPassword1, ' ');
				Arrays.fill(newPassword2, ' ');
			} while (notMatch);
		}
		Arrays.fill(oldPassword, ' ');
	}

	private static boolean verifyPassword(String login, char[] oldPassword) {
		return true;
	}

	private static void changePassword(String login, char[] newPassword1) {

	}

}
