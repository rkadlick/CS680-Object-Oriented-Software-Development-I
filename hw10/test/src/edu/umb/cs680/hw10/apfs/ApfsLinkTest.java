package edu.umb.cs680.hw10.apfs;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/*This class is used to test the ApfsLink class*/
public class ApfsLinkTest {
	
	//This holds the apfs file system test fixture
	private static APFS apfs;
	
	//Converts the fields of an ApfsLink object into a string array, used for testing
	private String[] linkToStringArray(ApfsLink l) {
		String[] linkInfo = {
				String.valueOf(l.isDirectory()), l.getName(), String.valueOf(l.getSize()), 
				l.getCreationTime().toString(), l.getParent().getName(), l.getOwner(),
				l.getLastModified().toString(), l.getTarget().getName()
		};
		
		return linkInfo;
	}
	//Setting up the apfs file system test fixture
	@BeforeAll
	public static void setUp() {
		
		apfs = APFSTestFixtureInitializer.createAPFS(apfs);
		
	}
	
	/* An explanation on why I used the @AfterAll tag: 
	 * When testing the classes individually in Eclipse, I had no issues. However when using ANT, I would run into
	 * issues where the setUp function above would run for each test class and cause multiple instances of root folders,
	 * the directory folders, files and links. By cancelling out the Singleton instance on each test class, it creates a new one
	 * for each class and runs smoothly.
	 * */
	@AfterAll
	public static void tearDown() {
		APFS.apfsystem = null;
	}
	
	//Testing the character limit on names of Apfs Elements
	@Test
	public void testCharacterLimit() {
		String tooLong = "INeedToGetALongEnoughNameToMakeItTotalMoreThanTwoHundredAndFiftyFiveCharactersInOrderToTest"
				+ "IfTheMethodForCheckingTheAmountOfCharactersInANameIsCorrectIfItIsNotCorrectThenIWouldNeedToFigureOut"
				+ "WhyAndChangeItWeAreGettingCloseToTheLimitNowInFactThisIsGoingToQTheQShouldBeTheLastCharacter";
		String expected = "INeedToGetALongEnoughNameToMakeItTotalMoreThanTwoHundredAndFiftyFiveCharactersInOrderToTestIf"
				+ "TheMethodForCheckingTheAmountOfCharactersInANameIsCorrectIfItIsNotCorrectThenIWouldNeedToFigureOutWhy"
				+ "AndChangeItWeAreGettingCloseToTheLimitNowInFactThisIsGoingToQ";
		ApfsLink test = new ApfsLink(null, tooLong, 0, null, "admin", null, null);
		
		String actual = test.getName();
		
		assertEquals(expected, actual);
	}
	
	//This method tests Link X from our apfs file system test fixture
	@Test
	public void verifyLinkEqualityX() {
		
		String[] expected = {"true", "x", "0", "2000-01-01T05:01", "Home", "admin", "2001-01-01T05:01", "Applications"};
		
		ApfsDirectory root = apfs.getRootDir();
		LinkedList<ApfsDirectory> rootSubDirs = root.getSubDirectories();
		ApfsDirectory home = rootSubDirs.getLast();
		LinkedList<ApfsLink> homeLinks = home.getLinks();
		ApfsLink actual = homeLinks.getFirst();
		
		assertArrayEquals(expected, linkToStringArray(actual));
		
	}
	
	//This method tests Link Y from the apfs file system test fixture
	@Test
	public void verifyLinkEqualityY() {
		
		String[] expected = {"false", "y", "0", "2000-01-01T06:01", "Code", "admin", "2001-01-01T06:01", "a"};
		
		ApfsDirectory root = apfs.getRootDir();
		LinkedList<ApfsDirectory> rootSubDirs = root.getSubDirectories();
		ApfsDirectory home = rootSubDirs.getLast();
		LinkedList<ApfsDirectory> homeSubDirs = home.getSubDirectories();
		ApfsDirectory code = homeSubDirs.getFirst();
		LinkedList<ApfsLink> codeLinks = code.getLinks();
		ApfsLink actual = codeLinks.getFirst();

		assertArrayEquals(expected, linkToStringArray(actual));
		
	}

}
