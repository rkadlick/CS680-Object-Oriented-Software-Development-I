package edu.umb.cs680.hw09.fat;

import java.time.LocalDateTime;

import edu.umb.cs680.hw09.fs.FSElement;

/*This class holds FatFSelement objects which extend from FSElement class*/
public abstract class FatFSElement extends FSElement {

	//shared fields of all FatFSElements
	protected FatDirectory parent;
	protected String name;
	
	//Refers to FatFiles or FatDirectories
	public FatFSElement(FatDirectory parent, String name, int size, LocalDateTime creationTime) {
		
		super(size, creationTime);
		
		this.parent = parent;
		this.name = checkLength(name);
	}
	
	//Names of FatFSElements can not exceed 8 characters
	public String checkLength(String name) {
		if(name.length()>8) {
			String cutName = name.substring(0, 8);
			name = cutName;
		}
		return name;
	}
	
	//getters and setters
	public FatDirectory getParent() {
		return this.parent;
	}
	
	public void setParent(FatDirectory newParent) {
		this.parent = newParent;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String newName) {
		this.name = checkLength(newName);
	}
	
	@Override
	public abstract boolean isDirectory();

}
