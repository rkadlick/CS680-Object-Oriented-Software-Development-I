package edu.umb.cs680.hw09.fat;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.fs.FSElement;

/*This class is used to test the FAT class*/
public class FATTest {

	//Holds the Fat file system test fixture
	private static FAT fat;
	
	//Converts fields of a FatDirectory object into a string array, used for testing
	private String[] rootToStringArray(FatDirectory d) {
			
			String[] dirInfo = {
					String.valueOf(d.isDirectory()), d.getName(), String.valueOf(d.getSize()), 
					d.getCreationTime().toString(), "null", String.valueOf(d.countChildren()), 
					String.valueOf(d.getTotalSize())
					};

			
			return dirInfo;
			}
		
	
	//Setting up our Fat file system test fixture
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
	
	//This method tests the root directory from the Fat file system test fixture
	@Test
	public void testRootDir() {
		
		String[] expected = {"true", "Root", "0", "2000-01-01T01:00", "null", "2", "21"};
		
		LinkedList<FSElement> rootDirs = fat.getRootDirs();
		FatDirectory actual = (FatDirectory) rootDirs.getFirst();
		
		assertArrayEquals(expected, rootToStringArray(actual));
		
	}
	
	//This method tests the fact a Fat file system can have multiple roots
	@Test
	public void testMultipleRootDirs() {
		
		String[] expected = {"Root", "Root1", "Root2"};
		String[] actual = new String[3];
		int count = 0;
		
		FatDirectory root1 = new FatDirectory(null, "Root1", 0, LocalDateTime.of(2000, 1, 1, 1, 0));
		FatDirectory root2 = new FatDirectory(null, "Root2", 0, LocalDateTime.of(2000, 1, 1, 1, 0));
		
		fat.addRoot(root1);
		fat.addRoot(root2);
		
		LinkedList<FSElement> rootDirs = fat.getRootDirs();
		
		for(FSElement f : rootDirs) {
			
			FatDirectory d = (FatDirectory) f;
			
			actual[count] = d.getName();
			count++;
		}
		
		assertArrayEquals(expected, actual);
		
		
	}
}
