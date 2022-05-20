package edu.umb.cs680.hw09.fat;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.fs.FSElement;

/*This class is used to test the FatFile class*/
public class FatFileTest {
	
	//holds the FAT file system test fixture
	private static FAT fat;
	
	//Converts the fields of a FatFile into a string array, used for testing
	private String[] fileToStringArray(FatFile f) {
		String[] fileInfo = {
				String.valueOf(f.isDirectory()), f.getName(), String.valueOf(f.getSize()), 
				f.getCreationTime().toString(), f.getParent().getName()
		};
		
		return fileInfo;
	}
	
	//Setting up the Fat file system test fixture
	@BeforeAll
	public static void setUp() {
		
		fat = FATTestFixtureInitializer.createFAT(fat);
		
	}
	
	/* An explanation on why I used the @AfterAll tag: 
	 * When testing the classes individually in Eclipse, I had no issues. However when using ANT, I would run into
	 * issues where the setUp function above would run for each test class and cause multiple instances of root folders,
	 * the directory folders, files and links. By cancelling out the Singleton instance on each test class, it creates a new one
	 * for each class and runs smoothly.
	 * */
	@AfterAll
	public static void tearDown() {
		FAT.Fat = null;
	}
	
	//Testing the character limit on names of FatFSElements
	@Test
	public void testCharacterLimit() {
		String tooLong = "WeOnlyNeedEight";
		String expected = "WeOnlyNe";
		FatFile test = new FatFile(null, tooLong, 0, null);
		
		String actual = test.getName();
		
		assertEquals(expected, actual);
	}
	
	//This method tests File A from the Fat file system test fixture
	@Test
	public void verifyFileEqualityA() {
		
		String[] expected = {"false", "a", "1", "2000-01-01T03:00", "Apps"};
		
		LinkedList<FSElement> rootDirs = fat.getRootDirs();
		FatDirectory root = (FatDirectory) rootDirs.getFirst();
		LinkedList<FatDirectory> rootSubDirs = root.getSubDirectories();
		FatDirectory applications = rootSubDirs.getFirst();
		LinkedList<FatFile> appFiles = applications.getFiles();
		FatFile actual = appFiles.getFirst();
	
		assertArrayEquals(expected, fileToStringArray(actual));
		
	}
	
	//This method tests File B from the Fat file system test fixture
	@Test
	public void verifyFileEqualityB() {
		
		String[] expected = {"false", "b", "2", "2000-01-01T05:00", "Home"};
		
		LinkedList<FSElement> rootDirs = fat.getRootDirs();
		FatDirectory root = (FatDirectory) rootDirs.getFirst();
		LinkedList<FatDirectory> rootSubDirs = root.getSubDirectories();
		FatDirectory home = rootSubDirs.getLast();
		LinkedList<FatFile> appFiles = home.getFiles();
		FatFile actual = appFiles.getFirst();
		
		assertArrayEquals(expected, fileToStringArray(actual));
		
	}
	
	//This method tests File C from the Fat file system test fixture
	@Test
	public void verifyFileEqualityC() {
		
		String[] expected = {"false", "c", "3", "2000-01-01T07:00", "Code"};
		
		LinkedList<FSElement> rootDirs = fat.getRootDirs();
		FatDirectory root = (FatDirectory) rootDirs.getFirst();
		LinkedList<FatDirectory> rootSubDirs = root.getSubDirectories();
		FatDirectory home = rootSubDirs.getLast();
		LinkedList<FatDirectory> homeSubDirs = home.getSubDirectories();
		FatDirectory code = homeSubDirs.getFirst();
		LinkedList<FatFile> codeFiles = code.getFiles();
		FatFile actual = codeFiles.getFirst();
		
		assertArrayEquals(expected, fileToStringArray(actual));
		
	}
	
	//This method tests File D from the Fat file system test fixture
	@Test
	public void verifyFileEqualityD() {
		
		String[] expected = {"false", "d", "4", "2000-01-01T08:00", "Code"};
		
		LinkedList<FSElement> rootDirs = fat.getRootDirs();
		FatDirectory root = (FatDirectory) rootDirs.getFirst();
		LinkedList<FatDirectory> rootSubDirs = root.getSubDirectories();
		FatDirectory home = rootSubDirs.getLast();
		LinkedList<FatDirectory> homeSubDirs = home.getSubDirectories();
		FatDirectory code = homeSubDirs.getFirst();
		LinkedList<FatFile> codeFiles = code.getFiles();
		FatFile actual = codeFiles.getLast();
		
		assertArrayEquals(expected, fileToStringArray(actual));
		
	}
	
	//This method tests File E from the Fat file system test fixture
	@Test
	public void verifyFileEqualityE() {
		
		String[] expected = {"false", "e", "5", "2000-01-01T10:00", "Pics"};
		
		LinkedList<FSElement> rootDirs = fat.getRootDirs();
		FatDirectory root = (FatDirectory) rootDirs.getFirst();
		LinkedList<FatDirectory> rootSubDirs = root.getSubDirectories();
		FatDirectory home = rootSubDirs.getLast();
		LinkedList<FatDirectory> homeSubDirs = home.getSubDirectories();
		FatDirectory pics = homeSubDirs.getLast();
		LinkedList<FatFile> picsFiles = pics.getFiles();
		FatFile actual = picsFiles.getFirst();
		
		assertArrayEquals(expected, fileToStringArray(actual));
		
	}
	
	//This method tests File F from the Fat file system test fixture
	@Test
	public void verifyFileEqualityF() {
		
		String[] expected = {"false", "f", "6", "2000-01-01T11:00", "Pics"};
		
		LinkedList<FSElement> rootDirs = fat.getRootDirs();
		FatDirectory root = (FatDirectory) rootDirs.getFirst();
		LinkedList<FatDirectory> rootSubDirs = root.getSubDirectories();
		FatDirectory home = rootSubDirs.getLast();
		LinkedList<FatDirectory> homeSubDirs = home.getSubDirectories();
		FatDirectory pics = homeSubDirs.getLast();
		LinkedList<FatFile> picsFiles = pics.getFiles();
		FatFile actual = picsFiles.getLast();
		
		assertArrayEquals(expected, fileToStringArray(actual));
		
	}

}
