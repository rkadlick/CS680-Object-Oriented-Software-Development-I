package edu.umb.cs680.hw10.apfs;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.platform.commons.annotation.Testable;

import edu.umb.cs680.hw10.fs.FSElement;
import edu.umb.cs680.hw10.fs.FileSystem;

/*This class holds the APFS file system which extends the FileSystem class*/
public class APFS extends FileSystem {
	
	protected static APFS apfsystem = null;
	private APFS() {};
	
	//Singleton
	public static APFS getAPFS() {
		if(apfsystem == null) {
			apfsystem = new APFS();
			apfsystem.initFileSystem("APFS", 1000);
		}
		return apfsystem;
	}

	//Creates default root for Apfs file system
	@Override
	protected FSElement createDefaultRoot() {
		
		return new ApfsDirectory(null, "Root", 0, LocalDateTime.of(2000, 1, 1, 1, 0), "admin", LocalDateTime.of(2000, 1, 1, 1, 0));

		}
	
	//Retrieves root of apfs file system
	public ApfsDirectory getRootDir() {
		LinkedList<FSElement> rootDirs = this.rootDirs;
		ApfsDirectory root = (ApfsDirectory) rootDirs.getFirst();
		return root;

	}
	

}
