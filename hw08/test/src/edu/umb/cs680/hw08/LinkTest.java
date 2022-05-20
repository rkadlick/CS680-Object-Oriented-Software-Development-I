package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/*This class is used to test the Link class*/
public class LinkTest {
	
	//Holds our file system
	private static FileSystem fs;
	
	//This method converts the fields of a Link object to an array of strings, used for testing
	private String[] linkToStringArray(Link l) {
		String[] linkInfo = {
				String.valueOf(l.isDirectory()), l.getName(), String.valueOf(l.getSize()), 
				l.getCreationTime().toString(), l.getParent().getName(), l.getTarget().getName()
		};
		
		return linkInfo;
	}
	
	//This sets up our test fixture, fake file system
	@BeforeAll
	public static void setUp() {
		
		fs = TestFixtureInitializer.createFS(fs);
		
	}
	
	//This method tests Link x from our file test fixture
	@Test
	public void verifyLinkEqualityX() {
		
		String[] expected = {"true", "x", "0", "2000-01-01T05:01", "Home", "Applications"};
		
		LinkedList<Directory> rootDirs = fs.getRootDirs();
		Directory root = rootDirs.getFirst();
		LinkedList<Directory> rootSubDirs = root.getSubDirectories();
		Directory home = rootSubDirs.getLast();
		LinkedList<Link> homeLinks = home.getLinks();
		Link actual = homeLinks.getFirst();
		
		assertArrayEquals(expected, linkToStringArray(actual));
		
	}
	
	//This method tests Link y from our file test fixture
	@Test
	public void verifyLinkEqualityY() {
		
		String[] expected = {"false", "y", "0", "2000-01-01T06:01", "Code", "a"};
		
		LinkedList<Directory> rootDirs = fs.getRootDirs();
		Directory root = rootDirs.getFirst();
		LinkedList<Directory> rootSubDirs = root.getSubDirectories();
		Directory home = rootSubDirs.getLast();
		LinkedList<Directory> homeSubDirs = home.getSubDirectories();
		Directory code = homeSubDirs.getFirst();
		LinkedList<Link> codeLinks = code.getLinks();
		Link actual = codeLinks.getFirst();
		
		assertArrayEquals(expected, linkToStringArray(actual));
		
	}
	
	

}
