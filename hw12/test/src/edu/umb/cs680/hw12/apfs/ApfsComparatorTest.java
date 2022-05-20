package edu.umb.cs680.hw12.apfs;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/*This class tests the 4 different comparator classes*/
public class ApfsComparatorTest {
	
private static APFS apfs;
	
	//This method is used to retrieve the name's of the elements in the sorted list.
	private ArrayList<String> listToStringArray(LinkedList<ApfsElement> l) {
			
		ArrayList<String> elementNames = new ArrayList<String>();
			
			for(ApfsElement ae : l) {
				elementNames.add(ae.getName());
			}
			
			return elementNames;
			}
		
	
	
	//Set up the apfs file system
	@BeforeAll
	public static void setUp() {
		
		apfs = APFSTestFixtureInitializer.createAPFS(apfs);
		
	}
	
	
	/* An explanation on why I used the @AfterAll tag: 
	 * When testing the classes individually in Eclipse, I had no issues. However when using ANT, I would run into
	 * issues where the setUp function above would run for each test class and cause multiple instances of root folders,
	 * the directory folders, files and links. By canceling out the Singleton instance on each test class, it creates a new one
	 * for each class and runs smoothly.
	 * */
	@AfterAll
	public static void tearDown() {
		APFS.apfsystem = null;
	}
	
	/*This method tests the alphabetical comparator that is supposed to sort the list alphabetically.
	 * We create a fake file system in which the expected order of files is the correct order that
	 * they should be sorted in.
	 */
	@Test
	public void AlphabeticalComparatorTest() {
		ArrayList<String> expected = new ArrayList<String>();

		expected.add("Apps");
		expected.add("Home");
		expected.add("Pics");
		expected.add("alpha");
		expected.add("beta");
		
		
		ApfsDirectory rootDir = new ApfsDirectory(null, "Root", 0, LocalDateTime.of(2000, 1, 1, 1, 0), "admin", 
				LocalDateTime.of(2000, 1, 1, 1, 0));
		ApfsDirectory home = new ApfsDirectory(rootDir, "Home", 0, LocalDateTime.of(2000, 1, 1, 1, 0), "admin", 
				LocalDateTime.of(2000, 1, 1, 1, 0));
		rootDir.appendChild(home);
		ApfsDirectory apps = new ApfsDirectory(rootDir, "Apps", 0, LocalDateTime.of(2000, 1, 1, 1, 0), "admin", 
				LocalDateTime.of(2000, 1, 1, 1, 0));
		rootDir.appendChild(apps);
		ApfsDirectory pics = new ApfsDirectory(rootDir, "Pics", 0, LocalDateTime.of(2000, 1, 1, 1, 0), "admin", 
				LocalDateTime.of(2000, 1, 1, 1, 0));
		rootDir.appendChild(pics);
		ApfsFile beta = new ApfsFile(rootDir, "beta", 0, LocalDateTime.of(2000, 2, 1, 1, 0), "admin", 
				LocalDateTime.of(2000, 2, 2, 1, 0));
		rootDir.appendChild(beta);
		ApfsFile alpha = new ApfsFile(rootDir, "alpha", 0, LocalDateTime.of(2000, 2, 1, 1, 1), "admin", 
				LocalDateTime.of(2000, 2, 2, 1, 1));
		rootDir.appendChild(alpha);
		
		LinkedList <ApfsElement> actual = rootDir.getChildren();

		assertEquals(expected, listToStringArray(actual));
		
	}
	
	/*This method tests the reverse alphabetical comparator that is supposed to sort the list alphabetically in reverse.
	 * We create a fake file system in which the expected order of files is the correct order that
	 * they should be sorted in.
	 */
	@Test
	public void ReverseAlphabeticalComparatorTest() {
		ArrayList<String> expected = new ArrayList<String>();

		expected.add("beta");		
		expected.add("alpha");
		expected.add("Pics");
		expected.add("Home");
		expected.add("Apps");
		
		
		
		
		ApfsDirectory rootDir = new ApfsDirectory(null, "Root", 0, LocalDateTime.of(2000, 1, 1, 1, 0), "admin", 
				LocalDateTime.of(2000, 1, 1, 1, 0));
		ApfsDirectory home = new ApfsDirectory(rootDir, "Home", 0, LocalDateTime.of(2000, 1, 1, 1, 0), "admin", 
				LocalDateTime.of(2000, 1, 1, 1, 0));
		rootDir.appendChild(home);
		ApfsDirectory apps = new ApfsDirectory(rootDir, "Apps", 0, LocalDateTime.of(2000, 1, 1, 1, 0), "admin", 
				LocalDateTime.of(2000, 1, 1, 1, 0));
		rootDir.appendChild(apps);
		ApfsDirectory pics = new ApfsDirectory(rootDir, "Pics", 0, LocalDateTime.of(2000, 1, 1, 1, 0), "admin", 
				LocalDateTime.of(2000, 1, 1, 1, 0));
		rootDir.appendChild(pics);
		ApfsFile beta = new ApfsFile(rootDir, "beta", 0, LocalDateTime.of(2000, 2, 1, 1, 0), "admin", 
				LocalDateTime.of(2000, 2, 2, 1, 0));
		rootDir.appendChild(beta);
		ApfsFile alpha = new ApfsFile(rootDir, "alpha", 0, LocalDateTime.of(2000, 2, 1, 1, 1), "admin", 
				LocalDateTime.of(2000, 2, 2, 1, 1));
		rootDir.appendChild(alpha);
		
		LinkedList <ApfsElement> actual = rootDir.getChildren(new ReverseAlphabeticalComparator());

		assertEquals(expected, listToStringArray(actual));
		
	}
	
	/*This method tests the creation time comparator that is supposed to sort the list by date of creation.
	 * We create a fake file system in which the expected order of files is the correct order that
	 * they should be sorted in.
	 */
	@Test
	public void CreationTimeComparatorTest() {
		ArrayList<String> expected = new ArrayList<String>();


		expected.add("Pics");
		expected.add("Apps");
		expected.add("Home");
		expected.add("beta");		
		expected.add("alpha");
		
		
		
		ApfsDirectory rootDir = new ApfsDirectory(null, "Root", 0, LocalDateTime.of(2000, 1, 1, 1, 0), "admin", 
				LocalDateTime.of(2000, 1, 1, 1, 0));
		ApfsDirectory home = new ApfsDirectory(rootDir, "Home", 0, LocalDateTime.of(2000, 1, 6, 1, 0), "admin", 
				LocalDateTime.of(2000, 1, 1, 1, 0));
		rootDir.appendChild(home);
		ApfsDirectory apps = new ApfsDirectory(rootDir, "Apps", 0, LocalDateTime.of(2000, 1, 4, 1, 0), "admin", 
				LocalDateTime.of(2000, 1, 1, 1, 0));
		rootDir.appendChild(apps);
		ApfsDirectory pics = new ApfsDirectory(rootDir, "Pics", 0, LocalDateTime.of(2000, 1, 2, 1, 0), "admin", 
				LocalDateTime.of(2000, 1, 1, 1, 0));
		rootDir.appendChild(pics);
		ApfsFile beta = new ApfsFile(rootDir, "beta", 0, LocalDateTime.of(2000, 2, 1, 1, 0), "admin", 
				LocalDateTime.of(2000, 2, 2, 1, 0));
		rootDir.appendChild(beta);
		ApfsFile alpha = new ApfsFile(rootDir, "alpha", 0, LocalDateTime.of(2000, 2, 1, 1, 1), "admin", 
				LocalDateTime.of(2000, 2, 2, 1, 1));
		rootDir.appendChild(alpha);
		
		LinkedList <ApfsElement> actual = rootDir.getChildren(new CreationTimeComparator());

		assertEquals(expected, listToStringArray(actual));
		
	}
	
	/*This method tests the last modified comparator that is supposed to sort the list by date it was last modified.
	 * We create a fake file system in which the expected order of files is the correct order that
	 * they should be sorted in.
	 */
	@Test
	public void LastModifiedComparatorTest() {
		ArrayList<String> expected = new ArrayList<String>();


		
		expected.add("Apps");
		expected.add("Home");
		expected.add("Pics");
		expected.add("beta");		
		expected.add("alpha");
		
		
		
		ApfsDirectory rootDir = new ApfsDirectory(null, "Root", 0, LocalDateTime.of(2000, 1, 1, 1, 0), "admin", 
				LocalDateTime.of(2000, 1, 1, 1, 15));
		ApfsDirectory home = new ApfsDirectory(rootDir, "Home", 0, LocalDateTime.of(2000, 1, 6, 1, 0), "admin", 
				LocalDateTime.of(2000, 1, 1, 1, 14));
		rootDir.appendChild(home);
		ApfsDirectory apps = new ApfsDirectory(rootDir, "Apps", 0, LocalDateTime.of(2000, 1, 4, 1, 0), "admin", 
				LocalDateTime.of(2000, 1, 1, 1, 1));
		rootDir.appendChild(apps);
		ApfsDirectory pics = new ApfsDirectory(rootDir, "Pics", 0, LocalDateTime.of(2000, 1, 2, 1, 0), "admin", 
				LocalDateTime.of(2000, 1, 1, 1, 23));
		rootDir.appendChild(pics);
		ApfsFile beta = new ApfsFile(rootDir, "beta", 0, LocalDateTime.of(2000, 2, 1, 1, 0), "admin", 
				LocalDateTime.of(2000, 2, 2, 1, 0));
		rootDir.appendChild(beta);
		ApfsFile alpha = new ApfsFile(rootDir, "alpha", 0, LocalDateTime.of(2000, 2, 1, 1, 1), "admin", 
				LocalDateTime.of(2000, 2, 2, 1, 1));
		rootDir.appendChild(alpha);
		
		LinkedList <ApfsElement> actual = rootDir.getChildren(new LastModifiedComparator());

		assertEquals(expected, listToStringArray(actual));
		
	}

}
