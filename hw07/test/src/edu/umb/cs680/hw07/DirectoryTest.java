package edu.umb.cs680.hw07;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;


/*This class is meant to test the Directory class*/
public class DirectoryTest {
	
	//Holds our test fixture file system
	private static FileSystem fs;
	
	//Used to turn a Directory's fields into a string array for testing
	private String[] dirToStringArray(Directory d) {
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
	
	
	//Setting up our Test fixture used for the methods below
	@BeforeAll
	public static void setUp() {
		
		fs = TestFixtureInitializer.createFS(fs);
		
	}
	
	//Testing the getChildren method from Directory
	@Test
	public void testChildren() {
		Directory test = new Directory(null, "test", 0, null);
		Directory c1 = new Directory(test, "child1", 0, null);
		test.appendChild(c1);
		File c2 = new File(test, "child2", 0, null);
		test.appendChild(c2);
		
		LinkedList<FSElement> expected = new LinkedList<FSElement>();
		expected.add(c1);
		expected.add(c2);
		
		LinkedList<FSElement> actual = test.getChildren();
		
		assertArrayEquals(expected.toArray(), actual.toArray());
	}
	
	//Testing the count children method from Directory
	@Test
	public void testCountChildren() {
		Directory test = new Directory(null, "test", 0, null);
		Directory c1 = new Directory(test, "child1", 0, null);
		test.appendChild(c1);
		File c2 = new File(test, "child2", 0, null);
		test.appendChild(c2);
		
		int expected = 2;
		
		int actual = test.countChildren();
		
		assertEquals(expected, actual);
	}
	
	//This method is used to test the root directory in our test fixture file system
	@Test
	public void verifyDirectoryEqualityRoot() {
		
		String[] expected = {"true", "Root", "0", "2000-01-01T01:00", "null", "2", "21"};
		
		LinkedList<Directory> rootDirs = fs.getRootDirs();
		Directory actual = rootDirs.getFirst();
		
		
		assertArrayEquals(expected, dirToStringArray(actual));
		
	}
	
	//This method is used to test the Applications directory in our test fixture file system
	@Test
	public void verifyDirectoryEqualityApplications() {
		
		String[] expected = {"true", "Applications", "0", "2000-01-01T02:00", "Root", "1", "1"};
		
		LinkedList<Directory> rootDirs = fs.getRootDirs();
		Directory root = rootDirs.getFirst();
		LinkedList<Directory> rootSubDirs = root.getSubDirectories();
		Directory actual = rootSubDirs.getFirst();
		
		assertArrayEquals(expected, dirToStringArray(actual));
		
	}
	
	//This method is used to test the Home directory in our test fixture file system
	@Test
	public void verifyDirectoryEqualityHome() {
		
		String[] expected = {"true", "Home", "0", "2000-01-01T04:00", "Root", "3", "20"};
		
		LinkedList<Directory> rootDirs = fs.getRootDirs();
		Directory root = rootDirs.getFirst();
		LinkedList<Directory> rootSubDirs = root.getSubDirectories();
		Directory actual = rootSubDirs.getLast();
		
		
		assertArrayEquals(expected, dirToStringArray(actual));
		
	}
	
	//This method is used to test the Code directory in our test fixture file system
	@Test
	public void verifyDirectoryEqualityCode() {
		
		String[] expected = {"true", "Code", "0", "2000-01-01T06:00", "Home", "2", "7"};
		
		LinkedList<Directory> rootDirs = fs.getRootDirs();
		Directory root = rootDirs.getFirst();
		LinkedList<Directory> rootSubDirs = root.getSubDirectories();
		Directory home = rootSubDirs.getLast();
		LinkedList<Directory> homeSubDirs = home.getSubDirectories();
		Directory actual = homeSubDirs.getFirst();
		
		assertArrayEquals(expected, dirToStringArray(actual));
		
	}
	
	//This method is used to test the Pics directory in our test fixture file system
	@Test
	public void verifyDirectoryEqualityPics() {
		
		String[] expected = {"true", "Pics", "0", "2000-01-01T09:00", "Home", "2", "11"};
		
		LinkedList<Directory> rootDirs = fs.getRootDirs();
		Directory root = rootDirs.getFirst();
		LinkedList<Directory> rootSubDirs = root.getSubDirectories();
		Directory home = rootSubDirs.getLast();
		LinkedList<Directory> homeSubDirs = home.getSubDirectories();
		Directory actual = homeSubDirs.getLast();
		
		assertArrayEquals(expected, dirToStringArray(actual));
		
	}
	

}