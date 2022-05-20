package edu.umb.cs680.hw09.apfs;

import java.time.LocalDateTime;
import java.util.LinkedList;

import edu.umb.cs680.hw09.fs.FSElement;
import edu.umb.cs680.hw09.fs.FileSystem;

/*This class holds the APFS which is a type of File System*/
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

	//Creates a default root for the APFS file system
	@Override
	protected FSElement createDefaultRoot() {
		return new ApfsDirectory(null, "Root", 0, LocalDateTime.of(2000, 1, 1, 1, 0), "admin", LocalDateTime.of(2000, 1, 1, 1, 0));
	}
	
	//Retrieves the root directory of the APFS file system
	public ApfsDirectory getRootDir() {
		LinkedList<FSElement> rootDirs = this.rootDirs;
		ApfsDirectory root = (ApfsDirectory) rootDirs.getFirst();
		return root;

	}
	

}
