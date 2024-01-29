package regression;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import backend.entities.User;
import junit.framework.Assert;

/**
 * This regression test covers a bug from the initial implementation
 * of the User class where changing the user's password a second time
 * (before storing back into the database) resulted in an error. 
 */
@SuppressWarnings("deprecation")
public class FirstNameBug {
	private static User theUser;
	
	private static String origPass = "thepass";

	@Before
	public void setUp() throws Exception {
		theUser = new User("puser", origPass, 'a', "Peter", "TheUser");
	}

	@After
	public void tearDown() throws Exception {
		// no need to clean anything up, since we didn't store any temporary
		// data in the DB for this test
	}

	@Test
	public void testFirstNameBug() {
		// verify that the original password is correct
		Assert.assertEquals(origPass, theUser.getPassword());
		
		// change the password twice
		theUser.setPassword("firstChange");
		theUser.setPassword("secondChange"); // crash?  Not if we fixed the bug!
		
		// verify that the password is updated to the newest
		Assert.assertEquals("secondChange", theUser.getPassword());
	}
	
	// Note: It would have been great to add more tests that trigger the bug
	//       if possible...it's always great to have more test coverage!

}
