package edu.umb.cs680.hw09.fat;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.apfs.APFS;
import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.fs.FSElement;

/*This class is used to test the FatDirectory class*/
public class FatDirectoryTest {
	
	//This holds the FAT file system test fixture
	private static FAT fat;
	
	//This converts the fields of a FatDirectory object into a string array, used for testing
	private String[] dirToStringArray(FatDirectory d) {
		//Separates root directory with null parent
		if(d.getParent() == null) {
			
			String[] dirInfo = {
					String.valueOf(d.isDirectory()), d.getName(), String.valueOf(d.getSize()), 
					d.getCreationTime().toString(), "null", String.valueOf(d.countChildren()), 
					String.valueOf(d.getTotalSize())
			};
			
			return dirInfo;
		
		}else {
		
			String[] dirInfo = {
					String.valueOf(d.isDirectory()), d.getName(), String.valueOf(d.getSize()), 
					d.getCreationTime().toString(), d.getParent().getName(), String.valueOf(d.countChildren()), 
					String.valueOf(d.getTotalSize())
			};
		
		return dirInfo;
	}}
	
	
	//This sets up the FAT file system test fixture
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
	
	//Testing the character limit on FATElements
	@Test
	public void testCharacterLimit() {
		String tooLong = "WeOnlyNeedEight";
		String expected = "WeOnlyNe";
		FatDirectory test = new FatDirectory(null, tooLong, 0, null);
		
		String actual = test.getName();
		
		assertEquals(expected, actual);
	}
	
	//Testing children methods of FATDirectory
	@Test
	public void testChildren() {
		FatDirectory test = new FatDirectory(null, "test", 0, null);
		FatDirectory c1 = new FatDirectory(test, "child1", 0, null);
		test.appendChild(c1);
		FatFile c2 = new FatFile(test, "child2", 0, null);
		test.appendChild(c2);
		
		LinkedList<FatFSElement> expected = new LinkedList<FatFSElement>();
		expected.add(c1);
		expected.add(c2);
		
		LinkedList<FatFSElement> actual = test.getChildren();
		
		assertArrayEquals(expected.toArray(), actual.toArray());
	}
	
	//Testing countChildren method of FATDirectory
	@Test
	public void testCountChildren() {
		FatDirectory test = new FatDirectory(null, "test", 0, null);
		FatDirectory c1 = new FatDirectory(test, "child1", 0, null);
		test.appendChild(c1);
		FatFile c2 = new FatFile(test, "child2", 0, null);
		test.appendChild(c2);
		
		int expected = 2;
		
		int actual = test.countChildren();
		
		assertEquals(expected, actual);
	}
	
	//Testing the root directory of our FAT file system test fixture
	@Test
	public void verifyDirectoryEqualityRoot() {
		
		String[] expected = {"true", "Root", "0", "2000-01-01T01:00", "null", "2", "21"};
		
		LinkedList<FSElement> rootDirs = fat.getRootDirs();
		FatDirectory actual = (FatDirectory) rootDirs.getFirst();
		
		assertArrayEquals(expected, dirToStringArray(actual));
		
	}
	
	//Testing the Apps directory of our FAT file system test fixture
	@Test
	public void verifyDirectoryEqualityApps() {
		
		String[] expected = {"true", "Apps", "0", "2000-01-01T02:00", "Root", "1", "1"};
		
		LinkedList<FSElement> rootDirs = fat.getRootDirs();
		FatDirectory root = (FatDirectory) rootDirs.getFirst();
		LinkedList<FatDirectory> rootSubDirs = root.getSubDirectories();
		FatDirectory actual = rootSubDirs.getFirst();
		
		assertArrayEquals(expected, dirToStringArray(actual));
		
	}
	
	//Testing the Home directory of our FAT file system test fixture
	@Test
	public void verifyDirectoryEqualityHome() {
		
		String[] expected = {"true", "Home", "0", "2000-01-01T04:00", "Root", "3", "20"};
		
		LinkedList<FSElement> rootDirs = fat.getRootDirs();
		FatDirectory root = (FatDirectory) rootDirs.getFirst();
		LinkedList<FatDirectory> rootSubDirs = root.getSubDirectories();
		FatDirectory actual = rootSubDirs.getLast();
		
		
		assertArrayEquals(expected, dirToStringArray(actual));
		
	}
	
	//Testing the Code directory of our FAT file system test fixture
	@Test
	public void verifyDirectoryEqualityCode() {
		
		String[] expected = {"true", "Code", "0", "2000-01-01T06:00", "Home", "2", "7"};
		
		LinkedList<FSElement> rootDirs = fat.getRootDirs();
		FatDirectory root = (FatDirectory) rootDirs.getFirst();
		LinkedList<FatDirectory> rootSubDirs = root.getSubDirectories();
		FatDirectory home = rootSubDirs.getLast();
		LinkedList<FatDirectory> homeSubDirs = home.getSubDirectories();
		FatDirectory actual = homeSubDirs.getFirst();
		
		assertArrayEquals(expected, dirToStringArray(actual));
		
	}
	
	//Testing the Pics directory of our FAT file system test fixture
	@Test
	public void verifyDirectoryEqualityPics() {
		
		String[] expected = {"true", "Pics", "0", "2000-01-01T09:00", "Home", "2", "11"};
		
		LinkedList<FSElement> rootDirs = fat.getRootDirs();
		FatDirectory root = (FatDirectory) rootDirs.getFirst();
		LinkedList<FatDirectory> rootSubDirs = root.getSubDirectories();
		FatDirectory home = rootSubDirs.getLast();
		LinkedList<FatDirectory> homeSubDirs = home.getSubDirectories();
		FatDirectory actual = homeSubDirs.getLast();
		
		assertArrayEquals(expected, dirToStringArray(actual));
		
	}

}
