package edu.umb.cs680.hw08;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

/*This class is used to test the FileSystem class*/
public class FileSystemTest {
	
	//This holds the file system test fixture
	private static FileSystem fs;
	
	//This sets up the test fixture, fake file system
	@BeforeAll
	public static void setUp() {
		
		fs = TestFixtureInitializer.createFS(fs);
		
	}
	
	//Testing the rootDirectory functions of a file system
	@Test
	public void testRootDir() {
		
		String expected = "Root";
		
		LinkedList<Directory> rootDir = fs.getRootDirs();
		String actual = rootDir.getFirst().getName();
		
		assertEquals(expected, actual);
		
	}

}
