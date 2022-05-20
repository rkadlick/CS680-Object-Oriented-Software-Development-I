package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

/*This class holds the File object that extends the FSElement class*/
public class File extends FSElement {
	
	//File object represents a file in the file system
	public File(Directory parent, String name, int size, LocalDateTime creationTime) {
		
		super(parent, name, size, creationTime);
		
	}
	
	//false
	public boolean isDirectory() {
		return false;
	}

}
