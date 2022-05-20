package edu.umb.cs680.hw10.fs;

import java.util.LinkedList;

/*This class is the super class for all types of File Systems*/
public abstract class FileSystem {
	
	//Shared fields of all types of file systems
	protected LinkedList<FSElement> rootDirs = new LinkedList<FSElement>();
	protected String name;
	protected int capacity;
	protected int id;
	
	//Creating a new file system with a default root.
	public FSElement initFileSystem(String name, int capacity) {
		
		this.name = name;
		this.capacity = capacity;
		
		
		FSElement root = createDefaultRoot();
		if(root.isDirectory() && capacity >= root.getSize()) {
			setRoot(root);
			this.id = root.hashCode();
			return root;
		} else {
			return null;
		}
	}
	
	protected abstract FSElement createDefaultRoot();
	
	//getters and setters
	protected void setRoot(FSElement root) {
		this.rootDirs.add(root);
	}
	
	public LinkedList<FSElement> getRootDirs() {
		return this.rootDirs;
	}
	
	protected void setCapacity(int newCapacity) {
		this.capacity = newCapacity;
	}
	
	protected int getCapacity() {
		return this.capacity;
	}
	
	protected void setName(String newName) {
		this.name = newName;
	}
	
	protected String getName() {
		return this.name;
	}
	
	protected int getId() {
		return this.id;
	}
	
	protected void setId(int newId) {
		this.id = newId;
	}

}
