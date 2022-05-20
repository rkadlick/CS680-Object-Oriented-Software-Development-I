package edu.umb.cs680.hw15.apfs;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/*This class is used to test the ApfsFile class*/
public class ApfsFileTest {
	
private static APFS apfs;
	
	//This method converts the fields of an ApfsFile into a string array for testing
	private String[] fileToStringArray(ApfsFile f) {
		String[] fileInfo = {
				String.valueOf(f.isDirectory()), f.getName(), String.valueOf(f.getSize()), 
				f.getCreationTime().toString(), f.getParent().getName(), f.getOwner(),
				f.getLastModified().toString()
		};
		
		return fileInfo;
	}
	
	//Set up file system and our test fixture
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
	
	//Testing the character limit on file names
	@Test
	public void testCharacterLimit() {
		String tooLong = "INeedToGetALongEnoughNameToMakeItTotalMoreThanTwoHundredAndFiftyFiveCharactersInOrderToTest"
				+ "IfTheMethodForCheckingTheAmountOfCharactersInANameIsCorrectIfItIsNotCorrectThenIWouldNeedToFigureOut"
				+ "WhyAndChangeItWeAreGettingCloseToTheLimitNowInFactThisIsGoingToQTheQShouldBeTheLastCharacter";
		String expected = "INeedToGetALongEnoughNameToMakeItTotalMoreThanTwoHundredAndFiftyFiveCharactersInOrderToTestIf"
				+ "TheMethodForCheckingTheAmountOfCharactersInANameIsCorrectIfItIsNotCorrectThenIWouldNeedToFigureOutWhy"
				+ "AndChangeItWeAreGettingCloseToTheLimitNowInFactThisIsGoingToQ";
		ApfsFile test = new ApfsFile(null, tooLong, 0, null, "admin", null);
		
		String actual = test.getName();
		
		assertEquals(expected, actual);
	}
	
	//Testing file A from our test fixture
	@Test
	public void verifyFileEqualityA() {
		
		String[] expected = {"false", "a", "1", "2000-01-01T03:00", "Applications", "admin", "2001-01-01T03:00"};
		
		ApfsDirectory root = apfs.getRootDir();
		LinkedList<ApfsDirectory> rootSubDirs = root.getSubDirectories();
		ApfsDirectory applications = rootSubDirs.getFirst();
		LinkedList<ApfsFile> appFiles = applications.getFiles();
		ApfsFile actual = appFiles.getFirst();
		
		//System.out.println("Expected: " + Arrays.toString(expected));
		//System.out.println("Actual: " + Arrays.toString(fileToStringArray(actual)));
		assertArrayEquals(expected, fileToStringArray(actual));
		
	}
	
	//Testing file B from our test fixture
	@Test
	public void verifyFileEqualityB() {
		
		String[] expected = {"false", "b", "2", "2000-01-01T05:00", "Home", "admin", "2001-01-01T05:00"};
		
		ApfsDirectory root = apfs.getRootDir();
		LinkedList<ApfsDirectory> rootSubDirs = root.getSubDirectories();
		ApfsDirectory home = rootSubDirs.getLast();
		LinkedList<ApfsFile> appFiles = home.getFiles();
		ApfsFile actual = appFiles.getFirst();
		
		assertArrayEquals(expected, fileToStringArray(actual));
		
	}
	
	//Testing file C from our test fixture
	@Test
	public void verifyFileEqualityC() {
		
		String[] expected = {"false", "c", "3", "2000-01-01T07:00", "Code", "admin", "2001-01-01T07:00"};
		
		ApfsDirectory root = apfs.getRootDir();
		LinkedList<ApfsDirectory> rootSubDirs = root.getSubDirectories();
		ApfsDirectory home = rootSubDirs.getLast();
		LinkedList<ApfsDirectory> homeSubDirs = home.getSubDirectories();
		ApfsDirectory code = homeSubDirs.getFirst();
		LinkedList<ApfsFile> codeFiles = code.getFiles();
		ApfsFile actual = codeFiles.getFirst();
		
		assertArrayEquals(expected, fileToStringArray(actual));
		
	}
	
	//Testing file D from our test fixture
	@Test
	public void verifyFileEqualityD() {
		
		String[] expected = {"false", "d", "4", "2000-01-01T08:00", "Code", "admin", "2001-01-01T08:00"};
		
		ApfsDirectory root = apfs.getRootDir();
		LinkedList<ApfsDirectory> rootSubDirs = root.getSubDirectories();
		ApfsDirectory home = rootSubDirs.getLast();
		LinkedList<ApfsDirectory> homeSubDirs = home.getSubDirectories();
		ApfsDirectory code = homeSubDirs.getFirst();
		LinkedList<ApfsFile> codeFiles = code.getFiles();
		ApfsFile actual = codeFiles.getLast();
		
		assertArrayEquals(expected, fileToStringArray(actual));
		
	}
	
	//Testing file E from our test fixture
	@Test
	public void verifyFileEqualityE() {
		
		String[] expected = {"false", "e", "5", "2000-01-01T10:00", "Pics", "admin", "2001-01-01T10:00"};
		
		ApfsDirectory root = apfs.getRootDir();
		LinkedList<ApfsDirectory> rootSubDirs = root.getSubDirectories();
		ApfsDirectory home = rootSubDirs.getLast();
		LinkedList<ApfsDirectory> homeSubDirs = home.getSubDirectories();
		ApfsDirectory pics = homeSubDirs.getLast();
		LinkedList<ApfsFile> picsFiles = pics.getFiles();
		ApfsFile actual = picsFiles.getFirst();
		
		assertArrayEquals(expected, fileToStringArray(actual));
		
	}
	
	//Testing file F from our test fixture
	@Test
	public void verifyFileEqualityF() {
		
		String[] expected = {"false", "f", "6", "2000-01-01T11:00", "Pics", "admin", "2001-01-01T11:00"};
		
		ApfsDirectory root = apfs.getRootDir();
		LinkedList<ApfsDirectory> rootSubDirs = root.getSubDirectories();
		ApfsDirectory home = rootSubDirs.getLast();
		LinkedList<ApfsDirectory> homeSubDirs = home.getSubDirectories();
		ApfsDirectory pics = homeSubDirs.getLast();
		LinkedList<ApfsFile> picsFiles = pics.getFiles();
		ApfsFile actual = picsFiles.getLast();
		
		assertArrayEquals(expected, fileToStringArray(actual));
		
	}

}
