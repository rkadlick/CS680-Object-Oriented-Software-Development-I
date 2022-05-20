package edu.umb.cs680.hw12.apfs;

import java.time.LocalDateTime;
import java.util.LinkedList;


import edu.umb.cs680.hw12.fs.FSElement;
import edu.umb.cs680.hw12.fs.FileSystem;

/*This class holds the APFS type FileSystem */
public class APFS extends FileSystem {
	
	protected static APFS apfsystem = null;
	private APFS() {};
	
	//Singleton class
	public static APFS getAPFS() {
		if(apfsystem == null) {
			apfsystem = new APFS();
			apfsystem.initFileSystem("APFS", 1000);
		}
		return apfsystem;
	}

	//Creates the default root directory
	@Override
	protected FSElement createDefaultRoot() {
		
		return new ApfsDirectory(null, "Root", 0, LocalDateTime.of(2000, 1, 1, 1, 0), "admin", LocalDateTime.of(2000, 1, 1, 1, 0));

		}
	
	//Retrieves the root directory
	public ApfsDirectory getRootDir() {
		LinkedList<FSElement> rootDirs = this.rootDirs;
		ApfsDirectory root = (ApfsDirectory) rootDirs.getFirst();
		return root;

	}
	

}
