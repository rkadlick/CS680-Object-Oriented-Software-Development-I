package edu.umb.cs680.hw07;

import java.util.LinkedList;

/*This class holds the FileSystem object*/
public class FileSystem {
	
	//Holds the file system as well as the root directories of that file system
	private static FileSystem fileSystem = null;
	public LinkedList<Directory> rootDirs = new LinkedList<Directory>();
	
	private FileSystem() {}
	
	//Singleton
	public static FileSystem getFileSystem() {
		if(fileSystem == null) {
			fileSystem = new FileSystem();
		}
		return fileSystem;
	}
	
	//Return root directories of file system
	public LinkedList<Directory> getRootDirs() {
		return this.rootDirs;
	}
	
	//Add a root directory
	public void appendRootDir(Directory root) {
		this.rootDirs.add(root);
	}

}
