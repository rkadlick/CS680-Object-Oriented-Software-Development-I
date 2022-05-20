package edu.umb.cs680.hw12.apfs;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

/*This class tests all of the ApfsVisitor classes*/
public class ApfsVisitorTest {
	
	private static APFS apfs;
	
	//This is used to turn the fields of a ApfsFile to a string array, used for testing
	private String[] fileToStringArray(ApfsFile f) {
		String[] fileInfo = {
				String.valueOf(f.isDirectory()), f.getName(), String.valueOf(f.getSize()), 
				f.getCreationTime().toString(), f.getParent().getName(), f.getOwner(),
				f.getLastModified().toString()
		};
		
		return fileInfo;
	}
	
	//Set up our test fixture
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
	
	//This method test the counting visitor using our test fixture
	@Test
	public void testCountingVisitor() {
		
		
		ApfsCountingVisitor visitor = new ApfsCountingVisitor();
		ApfsDirectory rootDir = apfs.getRootDir();
		rootDir.accept(visitor);
		
		int actualDirNum = visitor.getDirNum();
		int actualFileNum = visitor.getFileNum();
		int actualLinkNum = visitor.getLinkNum();
		
		String[] expected = {"5", "6", "2"};
		String[] actual =  { String.valueOf(actualDirNum), String.valueOf(actualFileNum),
							String.valueOf(actualLinkNum)};
		
		assertArrayEquals(expected, actual);
	}
	
	//This method tests the crawling visitor comparing to file A
	@Test
	public void testCrawlingVisitorFileA() {
		
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		ApfsDirectory rootDir = apfs.getRootDir();
		rootDir.accept(visitor);
		
		LinkedList<ApfsFile> files = visitor.getFiles();
		ApfsFile a = files.get(0);
		
		String[] expected = {"false", "a", "1", "2000-01-01T03:00", "Applications", "admin", "2001-01-01T03:00"};
		String[] actual = fileToStringArray(a);
		
		assertArrayEquals(expected, actual);

	}
	
	//This method tests the crawling visitor comparing to file B
	@Test
	public void testCrawlingVisitorFileB() {
		
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		ApfsDirectory rootDir = apfs.getRootDir();
		rootDir.accept(visitor);
		
		LinkedList<ApfsFile> files = visitor.getFiles();
		ApfsFile a = files.get(5);
		
		String[] expected = {"false", "b", "2", "2000-01-01T05:00", "Home", "admin", "2001-01-01T05:00"};
		String[] actual = fileToStringArray(a);
		
		assertArrayEquals(expected, actual);

	}
	
	//This method tests the crawling visitor comparing to file C
	@Test
	public void testCrawlingVisitorFileC() {
		
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		ApfsDirectory rootDir = apfs.getRootDir();
		rootDir.accept(visitor);
		
		LinkedList<ApfsFile> files = visitor.getFiles();
		ApfsFile a = files.get(1);
		
		String[] expected = {"false", "c", "3", "2000-01-01T07:00", "Code", "admin", "2001-01-01T07:00"};
		String[] actual = fileToStringArray(a);
		
		assertArrayEquals(expected, actual);

	}
	
	//This method tests the crawling visitor comparing to file D
	@Test
	public void testCrawlingVisitorFileD() {
		
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		ApfsDirectory rootDir = apfs.getRootDir();
		rootDir.accept(visitor);
		
		LinkedList<ApfsFile> files = visitor.getFiles();
		ApfsFile a = files.get(2);
		
		String[] expected = {"false", "d", "4", "2000-01-01T08:00", "Code", "admin", "2001-01-01T08:00"};
		String[] actual = fileToStringArray(a);
		
		assertArrayEquals(expected, actual);

	}
	
	//This method tests the crawling visitor comparing to file E
	@Test
	public void testCrawlingVisitorFileE() {
		
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		ApfsDirectory rootDir = apfs.getRootDir();
		rootDir.accept(visitor);
		
		LinkedList<ApfsFile> files = visitor.getFiles();
		ApfsFile a = files.get(3);
		
		String[] expected = {"false", "e", "5", "2000-01-01T10:00", "Pics", "admin", "2001-01-01T10:00"};
		String[] actual = fileToStringArray(a);
		
		assertArrayEquals(expected, actual);

	}
	
	//This method tests the crawling visitor comparing to file f
	@Test
	public void testCrawlingVisitorFileF() {
		
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		ApfsDirectory rootDir = apfs.getRootDir();
		rootDir.accept(visitor);
		
		LinkedList<ApfsFile> files = visitor.getFiles();
		ApfsFile a = files.get(4);
		
		String[] expected = {"false", "f", "6", "2000-01-01T11:00", "Pics", "admin", "2001-01-01T11:00"};
		String[] actual = fileToStringArray(a);
		
		assertArrayEquals(expected, actual);

	}
	
	//This method tests the file search visitor searching for file A
	@Test
	public void testFileSearchVisitorFileA() {
		
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("a");
		ApfsDirectory rootDir = apfs.getRootDir();
		rootDir.accept(visitor);
		
		LinkedList<ApfsFile> files = visitor.getFoundFiles();
		ApfsFile a = files.getFirst();
		
		String[] expected = {"false", "a", "1", "2000-01-01T03:00", "Applications", "admin", "2001-01-01T03:00"};
		String[] actual = fileToStringArray(a);
		
		assertArrayEquals(expected, actual);
		
	}
	
	//This method tests the file search visitor searching for file B
	@Test
	public void testFileSearchVisitorFileB() {
		
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("b");
		ApfsDirectory rootDir = apfs.getRootDir();
		rootDir.accept(visitor);
		
		LinkedList<ApfsFile> files = visitor.getFoundFiles();
		ApfsFile a = files.getFirst();
		
		String[] expected = {"false", "b", "2", "2000-01-01T05:00", "Home", "admin", "2001-01-01T05:00"};
		String[] actual = fileToStringArray(a);
		
		assertArrayEquals(expected, actual);
		
	}
	
	//This method tests the file search visitor searching for file C
	@Test
	public void testFileSearchVisitorFileC() {
		
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("c");
		ApfsDirectory rootDir = apfs.getRootDir();
		rootDir.accept(visitor);
		
		LinkedList<ApfsFile> files = visitor.getFoundFiles();
		ApfsFile a = files.getFirst();
		
		String[] expected = {"false", "c", "3", "2000-01-01T07:00", "Code", "admin", "2001-01-01T07:00"};
		String[] actual = fileToStringArray(a);
		
		assertArrayEquals(expected, actual);
		
	}
	
	//This method tests the file search visitor searching for file D
	@Test
	public void testFileSearchVisitorFileD() {
		
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("d");
		ApfsDirectory rootDir = apfs.getRootDir();
		rootDir.accept(visitor);
		
		LinkedList<ApfsFile> files = visitor.getFoundFiles();
		ApfsFile a = files.getFirst();
		
		String[] expected = {"false", "d", "4", "2000-01-01T08:00", "Code", "admin", "2001-01-01T08:00"};
		String[] actual = fileToStringArray(a);
		
		assertArrayEquals(expected, actual);
		
	}
	
	//This method tests the file search visitor searching for file E
	@Test
	public void testFileSearchVisitorFileE() {
		
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("e");
		ApfsDirectory rootDir = apfs.getRootDir();
		rootDir.accept(visitor);
		
		LinkedList<ApfsFile> files = visitor.getFoundFiles();
		ApfsFile a = files.getFirst();
		
		String[] expected = {"false", "e", "5", "2000-01-01T10:00", "Pics", "admin", "2001-01-01T10:00"};
		String[] actual = fileToStringArray(a);
		
		assertArrayEquals(expected, actual);
		
	}
	
	//This method tests the file search visitor searching for file F
	@Test
	public void testFileSearchVisitorFileF() {
		
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("f");
		ApfsDirectory rootDir = apfs.getRootDir();
		rootDir.accept(visitor);
		
		LinkedList<ApfsFile> files = visitor.getFoundFiles();
		ApfsFile a = files.getFirst();
		
		String[] expected = {"false", "f", "6", "2000-01-01T11:00", "Pics", "admin", "2001-01-01T11:00"};
		String[] actual = fileToStringArray(a);
		
		assertArrayEquals(expected, actual);
		
	}
}
