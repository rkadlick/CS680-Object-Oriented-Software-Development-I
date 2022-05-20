package edu.umb.cs680.hw09.apfs;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/*This class is used to test the ApfsDirectory class*/
public class ApfsDirectoryTest {
	
private static APFS apfs;
	
	//This method converts ApfsDirectory objects into a string array of it's fields, used for testing
	private String[] dirToStringArray(ApfsDirectory d) {
		//Separates root directory with null parent
		if(d.getParent() == null) {
			
			String[] dirInfo = {
					String.valueOf(d.isDirectory()), d.getName(), String.valueOf(d.getSize()), 
					d.getCreationTime().toString(), "null", String.valueOf(d.countChildren()), 
					String.valueOf(d.getTotalSize()), d.getOwner(), d.getLastModified().toString()
			};
			
			return dirInfo;
		
		}else {
		
			String[] dirInfo = {
					String.valueOf(d.isDirectory()), d.getName(), String.valueOf(d.getSize()), 
					d.getCreationTime().toString(), d.getParent().getName(), String.valueOf(d.countChildren()), 
					String.valueOf(d.getTotalSize()), d.getOwner(), d.getLastModified().toString()
			};
		
		return dirInfo;
	}}
	
	
	//Sets up our test fixture
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
	
	//This tests the character limit of apfsElements
	@Test
	public void testCharacterLimit() {
		String tooLong = "INeedToGetALongEnoughNameToMakeItTotalMoreThanTwoHundredAndFiftyFiveCharactersInOrderToTest"
				+ "IfTheMethodForCheckingTheAmountOfCharactersInANameIsCorrectIfItIsNotCorrectThenIWouldNeedToFigureOut"
				+ "WhyAndChangeItWeAreGettingCloseToTheLimitNowInFactThisIsGoingToQTheQShouldBeTheLastCharacter";
		String expected = "INeedToGetALongEnoughNameToMakeItTotalMoreThanTwoHundredAndFiftyFiveCharactersInOrderToTestIf"
				+ "TheMethodForCheckingTheAmountOfCharactersInANameIsCorrectIfItIsNotCorrectThenIWouldNeedToFigureOutWhy"
				+ "AndChangeItWeAreGettingCloseToTheLimitNowInFactThisIsGoingToQ";
		ApfsDirectory test = new ApfsDirectory(null, tooLong, 0, null, "admin", null);
		
		String actual = test.getName();
		
		assertEquals(expected, actual);
	}
	
	//This tests the children methods of an ApfsDirectory
	@Test
	public void testChildren() {
		ApfsDirectory test = new ApfsDirectory(null, "test", 0, null, "admin", null);
		ApfsDirectory c1 = new ApfsDirectory(test, "child1", 0, null, "admin", null);
		test.appendChild(c1);
		ApfsFile c2 = new ApfsFile(test, "child2", 0, null, "admin", null);
		test.appendChild(c2);
		
		LinkedList<ApfsElement> expected = new LinkedList<ApfsElement>();
		expected.add(c1);
		expected.add(c2);
		
		LinkedList<ApfsElement> actual = test.getChildren();
		
		assertArrayEquals(expected.toArray(), actual.toArray());
	}
	
	//This tests the countChildren method of an apfsdirectory
	@Test
	public void testCountChildren() {
		ApfsDirectory test = new ApfsDirectory(null, "test", 0, null, "admin", null);
		ApfsDirectory c1 = new ApfsDirectory(test, "child1", 0, null, "admin", null);
		test.appendChild(c1);
		ApfsFile c2 = new ApfsFile(test, "child2", 0, null, "admin", null);
		test.appendChild(c2);
		
		int expected = 2;
		
		int actual = test.countChildren();
		
		assertEquals(expected, actual);
	}
	
	//This tests the root directory in our test fixture file system
	@Test
	public void verifyDirectoryEqualityRoot() {
		
		String[] expected = {"true", "Root", "0", "2000-01-01T01:00", "null", "2", "21", "admin", "2000-01-01T01:00"};
		
		ApfsDirectory actual = apfs.getRootDir();
		
		LinkedList<ApfsElement> children = actual.getChildren();
		
		for(ApfsElement e : children) {
			System.out.println(e.getName());
		}
		
		assertArrayEquals(expected, dirToStringArray(actual));
		
	}
	
	//This tests the Applications directory in our test fixture file system
	@Test
	public void verifyDirectoryEqualityApplications() {
		
		String[] expected = {"true", "Applications", "0", "2000-01-01T02:00", "Root", "1", "1", "admin", "2001-01-01T02:00"};
		
		ApfsDirectory root = apfs.getRootDir();
		LinkedList<ApfsDirectory> rootSubDirs = root.getSubDirectories();
		ApfsDirectory actual = rootSubDirs.getFirst();
		
		assertArrayEquals(expected, dirToStringArray(actual));
		
	}
	
	//This tests the Home Directory in our test fixture file system
	@Test
	public void verifyDirectoryEqualityHome() {
		
		String[] expected = {"true", "Home", "0", "2000-01-01T04:00", "Root", "4", "20", "admin", "2001-01-01T04:00"};
		
		ApfsDirectory root = apfs.getRootDir();
		LinkedList<ApfsDirectory> rootSubDirs = root.getSubDirectories();
		ApfsDirectory actual = rootSubDirs.getLast();
		
		
		assertArrayEquals(expected, dirToStringArray(actual));
		
	}
	
	//This tests the Code directory of our test fixture file system
	@Test
	public void verifyDirectoryEqualityCode() {
		
		String[] expected = {"true", "Code", "0", "2000-01-01T06:00", "Home", "3", "7", "admin", "2001-01-01T06:00"};
		
		ApfsDirectory root = apfs.getRootDir();
		LinkedList<ApfsDirectory> rootSubDirs = root.getSubDirectories();
		ApfsDirectory home = rootSubDirs.getLast();
		LinkedList<ApfsDirectory> homeSubDirs = home.getSubDirectories();
		ApfsDirectory actual = homeSubDirs.getFirst();
		
		assertArrayEquals(expected, dirToStringArray(actual));
		
	}
	
	//This tests the Pics directory of our test fixture file system
	@Test
	public void verifyDirectoryEqualityPics() {
		
		String[] expected = {"true", "Pics", "0", "2000-01-01T09:00", "Home", "2", "11", "admin", "2001-01-01T09:00"};
		
		ApfsDirectory root = apfs.getRootDir();
		LinkedList<ApfsDirectory> rootSubDirs = root.getSubDirectories();
		ApfsDirectory home = rootSubDirs.getLast();
		LinkedList<ApfsDirectory> homeSubDirs = home.getSubDirectories();
		ApfsDirectory actual = homeSubDirs.getLast();
		
		assertArrayEquals(expected, dirToStringArray(actual));
		
	}

}
