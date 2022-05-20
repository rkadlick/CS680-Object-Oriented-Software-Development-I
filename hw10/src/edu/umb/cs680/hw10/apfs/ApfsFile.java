package edu.umb.cs680.hw10.apfs;

import java.time.LocalDateTime;

/*This class holds ApfsFile objects which are extended from ApfsElement*/
public class ApfsFile extends ApfsElement {
	
	//ApfsFile represent a file in an apfs file system
	public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String owner, 
		LocalDateTime lastModified) {
		
		super(parent, name, size, creationTime, owner, lastModified);
		
	}
	
	//Accepts apfsVisitors
	public void accept(ApfsVisitor v) {
		v.visit(this);
	}
	
	//false
	public boolean isDirectory() {
		return false;
	}

}
