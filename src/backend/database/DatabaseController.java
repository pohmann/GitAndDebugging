package backend.database;

import java.util.ArrayList;
import java.util.List;

import backend.entities.User;
import dblibrary.project.csci230.UniversityDBLibrary;

public class DatabaseController {
	// NOTE: You can log in to the database from your browser to check the expected
	// data in your database at the following link:
	//    http://devsrv.cs.csbsju.edu/phpmyadmin

	// TODO: add a login username and password to connect to the database
	// I created/saved a few databases (all with the same structure) that you can
	// use for testing.  That way, not everyone is adding/removing rows within the
	// same database, causing lots of conflicts.
	//       Username     / Password
	//       -----------------------
	// DB 1: busyteam    / Csci230$
	// DB 2: funteam     / Csci230$
	// DB 3: otherteam   / Csci230$
	// DB 4: myteam      / Csci230$
	// DB 5: lastteam    / Csci230$
	private static UniversityDBLibrary database = new UniversityDBLibrary("busyteam", "Csci230$");

	// 
	/**
	 * Add a user to the db with the specified username and password.
	 * For the purposes of this example, we just set the other fields to
	 * some default values.
	 * 
	 * NOTE: This method will fail (and crash horribly) if the user already
	 * exists in the database or if the database connection (above) has the
	 * wrong username/password.
	 * 
	 * @param username the username to store
	 * @param password the password to store with the user
	 */
	public static void addUser(String username, String password) {
		int result = database.user_addUser("GitAnd", "DebuggingUser", username, password, 'u');

		if (result == -1) {
			System.err.println("Error adding user to the DB");
			System.exit(1);
		}
	}

	/**
	 * Remove a user with the provided username from the db.
	 * 
	 * Note: The method reports no errors, even if the user cannot
	 * be removed from the database.  You should do better than this
	 * in your CMC implementation!
	 * 
	 * @param username the username for the user to delete
	 */
	public static void removeUser(String username) {
		@SuppressWarnings("unused")
		int result = database.user_deleteUser(username);
	}

	/**
	 * Get the list of all the users in the DB.
	 * 
	 * @return the list of users, as User objects
	 */
	public static List<User> getAllUsers() {
		String[][] dbUserList = database.user_getUsers();
		
		// Important: You'll need to look at the documentation for the
		// database library to understand the return value of the method
		// above.  It contains the information for all users in the DB,
		// but YOU need to translate that data into useful objects (of type
		// User) for the rest of the application.
		// The code below fills in just the username for two User objects
		// based on just the first 2 users in the database.  How can you
		// modify it to handle the rest?
		// (Use a loop over all the rows in dbUserList!)

		ArrayList<User> result = new ArrayList<User>();
		
		String[] firstUserData = dbUserList[0];
		User firstUser = new User(firstUserData[2], "??", 'u', "??", "??");
		result.add(firstUser);
		String[] secondUserData = dbUserList[1];
		User secondUser = new User(secondUserData[2], "??", 'u', "??", "??");
		result.add(secondUser);

		return result;
	}
}
