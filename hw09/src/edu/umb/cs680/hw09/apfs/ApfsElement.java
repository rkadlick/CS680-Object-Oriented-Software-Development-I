package edu.umb.cs680.hw09.apfs;

import java.time.LocalDateTime;

import edu.umb.cs680.hw09.fs.FSElement;

/*This class holds the ApfsElement object, which extends FSElement. ApfsElement's include Directories, Files, and Links*/
public abstract class ApfsElement extends FSElement {

	//Shared fields of ApfsElements
	protected ApfsDirectory parent;
	protected String name;
	protected String owner;
	protected LocalDateTime lastModified;
	
	//Can be ApfsDirectory, ApfsFile, or ApfsLink
	public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String owner, 
			LocalDateTime lastModified) {
		
		super(size, creationTime);
		
		this.parent = parent;
		this.name = checkLength(name);
		this.owner = owner;
		this.lastModified = lastModified;
	}
	
	//ApfsEleemnts can have a max 255 character limit on names
	public String checkLength(String name) {
		if(name.length()>255) {
			String cutName = name.substring(0, 255);
			name = cutName;
		}
		return name;
	}
	
	//getters and setters
	public ApfsDirectory getParent() {
		return this.parent;
	}
	
	public void setParent(ApfsDirectory newParent) {
		this.parent = newParent;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	public void setOwner(String newOwner) {
		this.owner = newOwner;
	}
	
	public LocalDateTime getLastModified() {
		return this.lastModified;
	}
	
	public void setLastModified(LocalDateTime newLastModified) {
		this.lastModified = newLastModified;
	}
	

	@Override
	public abstract boolean isDirectory();

}
