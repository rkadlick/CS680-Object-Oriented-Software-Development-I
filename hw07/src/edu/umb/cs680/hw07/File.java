package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

/*This class holds File objects that extend the FSElement class*/
public class File extends FSElement {
	
	//A file object represents a file in the file system
	public File(Directory parent, String name, int size, LocalDateTime creationTime) {
		
		super(parent, name, size, creationTime);
		
	}
	
	//false
	public boolean isDirectory() {
		return false;
	}

}
