/**
 * 
 */
package frontend;

import java.util.List;
import java.util.Scanner;

import backend.database.DatabaseController;
import backend.entities.User;

/**
 * The Driver class is used to demonstrate a bit of database functionality.
 * You shouldn't need to change anything in this class.
 */
public class Driver {

	public static void main(String[] args) {
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

}
