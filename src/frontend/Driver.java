/**
 * 
 */
package frontend;

import java.util.List;
import java.util.Scanner;

import backend.database.DatabaseController;
import backend.entities.User;
import backend.entities.WordAnalyzer;

/**
 * The Driver class is used to demonstrate a bit of database functionality.
 * You shouldn't need to change anything in this class.
 */
public class Driver {

	// PART 1 ONLY!
	private static void part1() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);

		// ask the user for a username to add to the DB (for testing)
		System.out.print("What username should I add to the database (must be unique!)?: ");
		String username = s.nextLine();
		System.out.print("What password should I assign to that user?: ");
		String password = s.nextLine();

		// add the user to the database
		DatabaseController.addUser(username, password);

		// get the list of all users in the database,
		// and print out the  to prove that it added
		// successfully!
		List<User> allUsers = DatabaseController.getAllUsers();
		for (User u : allUsers) {
			System.out.println(u.getUsername() + " | " + u.getPassword());
		}

		// remove the user we added from the database, so we don't leave
		// junk test data in the database for future users
		DatabaseController.removeUser(username);
	}

	// PART 2 ONLY!
	private static void testWAFirst(String s) {
		WordAnalyzer wa = new WordAnalyzer(s);
		char result = wa.firstRepeatedCharacter();
		if (result == 0)
			System.out.println("No repeated character.");
		else
			System.out.println("First repeated character = " + result);
	}

	// PART 2 ONLY!
	private static void testWACount(String s)
	{
		WordAnalyzer wa = new WordAnalyzer(s);
		int result = wa.countRepeatedCharacters();
		System.out.println(result + " repeated characters.");
	}

	// PART 2 ONLY!
	// a test for the WordAnalyzer...not currently set to run
	// because of bugs...
	// We should write some regression tests and fix the bugs!
	private static void part2() {
		testWAFirst("aardvark"); // expect: a
		testWAFirst("roommate"); // expect: o (not m)
		testWAFirst("mate"); // expect: 0 (no duplicate letters)
		testWAFirst("test"); // expect: 0 (the t isn't repeating)

		testWACount("mississippiii"); // expect: 4 (ss, ss, pp, iii)
		testWACount("test"); // expect: 0 (no repeated letters)
		testWACount("aabbcdaaaabb"); // expect: 4 (aa, bb, aaaa, bb)
	}

	// This is main.  It calls the other methods to run the "program"!
	public static void main(String[] args) {
		part1();
		//part2();
	}

}
