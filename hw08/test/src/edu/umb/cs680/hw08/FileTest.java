package edu.umb.cs680.hw08;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;


/*This class is used to test the File class*/
public class FileTest {
	
	//Holds the file system test fixture
	private static FileSystem fs;
	
	//This method converts the fields of a File object into a array of strings, used for testing
	private String[] fileToStringArray(File f) {
		String[] fileInfo = {
				String.valueOf(f.isDirectory()), f.getName(), String.valueOf(f.getSize()), 
				f.getCreationTime().toString(), f.getParent().getName()
		};
		
		return fileInfo;
	}
	
	//Setting up our test fixture for each method
	@BeforeAll
	public static void setUp() {
		
		fs = TestFixtureInitializer.createFS(fs);
		
	}
	
	//This method tests File A from our test fixture
	@Test
	public void verifyFileEqualityA() {
		
		String[] expected = {"false", "a", "1", "2000-01-01T03:00", "Applications"};
		
		LinkedList<Directory> rootDirs = fs.getRootDirs();
		Directory root = rootDirs.getFirst();
		LinkedList<Directory> rootSubDirs = root.getSubDirectories();
		Directory applications = rootSubDirs.getFirst();
		LinkedList<File> appFiles = applications.getFiles();
		File actual = appFiles.getFirst();
		
		//System.out.println("Expected: " + Arrays.toString(expected));
		//System.out.println("Actual: " + Arrays.toString(fileToStringArray(actual)));
		assertArrayEquals(expected, fileToStringArray(actual));
		
	}
	
	//This method tests File B from our test fixture
	@Test
	public void verifyFileEqualityB() {
		
		String[] expected = {"false", "b", "2", "2000-01-01T05:00", "Home"};
		
		LinkedList<Directory> rootDirs = fs.getRootDirs();
		Directory root = rootDirs.getFirst();
		LinkedList<Directory> rootSubDirs = root.getSubDirectories();
		Directory home = rootSubDirs.getLast();
		LinkedList<File> appFiles = home.getFiles();
		File actual = appFiles.getFirst();
		
		assertArrayEquals(expected, fileToStringArray(actual));
		
	}
	
	//This method tests file C from our test fixture
	@Test
	public void verifyFileEqualityC() {
		
		String[] expected = {"false", "c", "3", "2000-01-01T07:00", "Code"};
		
		LinkedList<Directory> rootDirs = fs.getRootDirs();
		Directory root = rootDirs.getFirst();
		LinkedList<Directory> rootSubDirs = root.getSubDirectories();
		Directory home = rootSubDirs.getLast();
		LinkedList<Directory> homeSubDirs = home.getSubDirectories();
		Directory code = homeSubDirs.getFirst();
		LinkedList<File> codeFiles = code.getFiles();
		File actual = codeFiles.getFirst();
		
		assertArrayEquals(expected, fileToStringArray(actual));
		
	}
	
	//This method tests file D from our test fixture
	@Test
	public void verifyFileEqualityD() {
		
		String[] expected = {"false", "d", "4", "2000-01-01T08:00", "Code"};
		
		LinkedList<Directory> rootDirs = fs.getRootDirs();
		Directory root = rootDirs.getFirst();
		LinkedList<Directory> rootSubDirs = root.getSubDirectories();
		Directory home = rootSubDirs.getLast();
		LinkedList<Directory> homeSubDirs = home.getSubDirectories();
		Directory code = homeSubDirs.getFirst();
		LinkedList<File> codeFiles = code.getFiles();
		File actual = codeFiles.getLast();
		
		assertArrayEquals(expected, fileToStringArray(actual));
		
	}
	
	//This method tests file E from our test fixture
	@Test
	public void verifyFileEqualityE() {
		
		String[] expected = {"false", "e", "5", "2000-01-01T10:00", "Pics"};
		
		LinkedList<Directory> rootDirs = fs.getRootDirs();
		Directory root = rootDirs.getFirst();
		LinkedList<Directory> rootSubDirs = root.getSubDirectories();
		Directory home = rootSubDirs.getLast();
		LinkedList<Directory> homeSubDirs = home.getSubDirectories();
		Directory pics = homeSubDirs.getLast();
		LinkedList<File> picsFiles = pics.getFiles();
		File actual = picsFiles.getFirst();
		
		assertArrayEquals(expected, fileToStringArray(actual));
		
	}
	
	//This method tests file F from our test fixture
	@Test
	public void verifyFileEqualityF() {
		
		String[] expected = {"false", "f", "6", "2000-01-01T11:00", "Pics"};
		
		LinkedList<Directory> rootDirs = fs.getRootDirs();
		Directory root = rootDirs.getFirst();
		LinkedList<Directory> rootSubDirs = root.getSubDirectories();
		Directory home = rootSubDirs.getLast();
		LinkedList<Directory> homeSubDirs = home.getSubDirectories();
		Directory pics = homeSubDirs.getLast();
		LinkedList<File> picsFiles = pics.getFiles();
		File actual = picsFiles.getLast();
		
		assertArrayEquals(expected, fileToStringArray(actual));
		
	}

}
