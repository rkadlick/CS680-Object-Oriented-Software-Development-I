package edu.umb.cs680.hw15.apfs;

import java.time.LocalDateTime;

import edu.umb.cs680.hw15.fs.FSElement;

/*This class holds the ApfsElement, used for ApfsFile, Directory, and Link*/
public abstract class ApfsElement extends FSElement {

	//Apfs specific fields
	protected ApfsDirectory parent;
	protected String name;
	protected String owner;
	protected LocalDateTime lastModified;
	
	
	public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String owner, 
			LocalDateTime lastModified) {
		
		super(size, creationTime);
		
		this.parent = parent;
		this.name = checkLength(name);
		this.owner = owner;
		this.lastModified = lastModified;
	}
	
	//No ApfsElement can have name longer than 255 characters
	public String checkLength(String name) {
		if(name.length()>255) {
			String cutName = name.substring(0, 255);
			name = cutName;
		}
		return name;
	}
	
	//Method to accept ApfsVisitor
	public abstract void accept(ApfsVisitor v);
	
	//Getters and setters
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
