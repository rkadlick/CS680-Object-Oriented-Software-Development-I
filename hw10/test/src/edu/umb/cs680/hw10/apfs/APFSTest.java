package edu.umb.cs680.hw10.apfs;



import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/*This class is used to test the APFS class*/
public class APFSTest {
	
	//Holds our apfs file system test fixture
	private static APFS apfs;
	
	//Converts the fields of an ApfsDirectory into a string array, used for testing
	private String[] rootToStringArray(ApfsDirectory d) {
			
			String[] dirInfo = {
					String.valueOf(d.isDirectory()), d.getName(), String.valueOf(d.getSize()), 
					d.getCreationTime().toString(), "null", String.valueOf(d.countChildren()), 
					String.valueOf(d.getTotalSize()), d.getOwner(), d.getLastModified().toString()
					};

			
			return dirInfo;
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
	
	
	//This method tests root directory methods inside APFS
	@Test
	public void testRootDir() {
		
		String[] expected = {"true", "Root", "0", "2000-01-01T01:00", "null", "2", "21", "admin", "2000-01-01T01:00"};
		
		ApfsDirectory actual = apfs.getRootDir();
		
		assertArrayEquals(expected, rootToStringArray(actual));
		
	}

}
