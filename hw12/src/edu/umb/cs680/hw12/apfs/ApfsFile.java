package edu.umb.cs680.hw12.apfs;

import java.time.LocalDateTime;

/*This class is used for ApfsFiles*/
public class ApfsFile extends ApfsElement {
	
	public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String owner, 
		LocalDateTime lastModified) {
		
		super(parent, name, size, creationTime, owner, lastModified);
		
	}
	
	//This method accepts visitors to ApfsFiles
	public void accept(ApfsVisitor v) {
		v.visit(this);
	}
	
	public boolean isDirectory() {
		return false;
	}

}
