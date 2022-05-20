package edu.umb.cs680.hw08;

import java.util.LinkedList;

/*This class holds the FileSystem*/
public class FileSystem {
	
	//Holds the file system object and keeps track of the root directories of the file system
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
	
	//Returns the root directories of a file system
	public LinkedList<Directory> getRootDirs() {
		return this.rootDirs;
	}
	
	//Adds a directory to the list of root directories of a file system
	public void appendRootDir(Directory root) {
		this.rootDirs.add(root);
	}

}
