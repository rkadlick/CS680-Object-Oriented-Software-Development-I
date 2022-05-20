package edu.umb.cs680.hw07;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

/*This class is used to test the FileSystem class*/
public class FileSystemTest {
	
	//Holds our file system
	private static FileSystem fs;
	
	//Sets up our test fixture file system
	@BeforeAll
	public static void setUp() {
		
		fs = TestFixtureInitializer.createFS(fs);
		
	}
	
	//Tests the root directory from our test fixture
	@Test
	public void testRootDir() {
		
		String expected = "Root";
		
		LinkedList<Directory> rootDir = fs.getRootDirs();
		String actual = rootDir.getFirst().getName();
		
		assertEquals(expected, actual);
		
	}

}
