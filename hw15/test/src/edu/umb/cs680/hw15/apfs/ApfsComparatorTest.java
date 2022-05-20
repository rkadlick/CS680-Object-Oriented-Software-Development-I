package edu.umb.cs680.hw15.apfs;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/*This class tests sorting mechanisms using the Comparator class and lambda functions*/
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
	
	/*This method creates a fake file system and then organizes the children of the root alphabetically using
	 *a lambda function and tests against the expected list.
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
	
	/*This method creates a fake file system and then organizes the children of the root reverse alphabetically using
	 *a lambda function and tests against the expected list.
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
		
		LinkedList <ApfsElement> actual = rootDir.getChildren(Comparator.comparing(ApfsElement::getName).reversed());

		assertEquals(expected, listToStringArray(actual));
		
	}
	
	/*This method creates a fake file system and then organizes the children of the root by creation time using
	 *a lambda function and tests against the expected list.
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
		
		LinkedList <ApfsElement> actual = rootDir.getChildren(Comparator.comparing(ApfsElement::getCreationTime));

		assertEquals(expected, listToStringArray(actual));
		
	}
	
	/*This method creates a fake file system and then organizes the children of the root by creation time in reverse using
	 *a lambda function and tests against the expected list.
	 */
	@Test
	public void reverseCreationTimeComparatorTest() {
		ArrayList<String> expected = new ArrayList<String>();

		expected.add("alpha");
		expected.add("beta");
		expected.add("Home");
		expected.add("Apps");
		expected.add("Pics");
				
		
		
		
		
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
		
		LinkedList <ApfsElement> actual = rootDir.getChildren(Comparator.comparing(ApfsElement::getCreationTime).reversed());

		assertEquals(expected, listToStringArray(actual));
		
	}
	
	/*This method creates a fake file system and then organizes the children of the root by date last modified using
	 *a lambda function and tests against the expected list.
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
		
		LinkedList <ApfsElement> actual = rootDir.getChildren(Comparator.comparing(ApfsElement::getLastModified));

		assertEquals(expected, listToStringArray(actual));
		
	}
	
	/*This method creates a fake file system and then organizes the children of the root by the date last modified reversed using
	 *a lambda function and tests against the expected list.
	 */
	@Test
	public void reverseLastModifiedComparatorTest() {
		ArrayList<String> expected = new ArrayList<String>();

		expected.add("alpha");
		expected.add("beta");
		expected.add("Pics");
		expected.add("Home");
		expected.add("Apps");
				
		
		
		
		
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
		
		LinkedList <ApfsElement> actual = rootDir.getChildren(Comparator.comparing(ApfsElement::getLastModified).reversed());

		assertEquals(expected, listToStringArray(actual));
		
	}

}
