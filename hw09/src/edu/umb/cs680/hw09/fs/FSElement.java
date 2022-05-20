package edu.umb.cs680.hw09.fs;

import java.time.LocalDateTime;

/*This class is the super class to all file system elements. Directories, files, links*/
public abstract class FSElement {
	
	//Shared fields of all file system elements
	protected int size;
	protected LocalDateTime creationTime;
	
	
	public FSElement(int size, LocalDateTime creationTime) {
		
		this.size = size;
		this.creationTime = creationTime;
			
	}
	
	//getters and setters
	public int getSize() {
		return this.size;
	}
	
	public LocalDateTime getCreationTime() {
		return this.creationTime;
	}
	
	public void setSize(int newSize) {
		this.size = newSize;
	}
	
	
	public void setCreationTime(LocalDateTime newCreationTime) {
		this.creationTime = newCreationTime;
	}
	
	public abstract boolean isDirectory();


}
