package edu.umb.cs680.hw09.apfs;

import java.time.LocalDateTime;

/*This class holds the ApfsFile object, extends from ApfsElement*/
public class ApfsFile extends ApfsElement {
	
	//ApfsFile represents a file in an apfs file system
	public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String owner, 
		LocalDateTime lastModified) {
		
		super(parent, name, size, creationTime, owner, lastModified);
		
	}
	
	//false
	public boolean isDirectory() {
		return false;
	}

}
