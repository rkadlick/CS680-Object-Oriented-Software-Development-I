package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;

/*This class holds the Directory class which extends from the FSElement super class*/
public class Directory extends FSElement {
	
	//Field holding all elements that are children of the directory
	private LinkedList<FSElement> children = new LinkedList<FSElement>();
	
	//Directy object references a Directory in the file system
	public Directory (Directory parent, String name, int size, LocalDateTime creationTime) {
		
		super(parent, name, size, creationTime);
	}
	
	//Gets list of all children
	public LinkedList<FSElement> getChildren() {
		return this.children;
		
	}
	
	//Adds an element to children of a directory, sets that directory as the parent to the element
	public void appendChild(FSElement child) {
		
		this.children.add(child);
		child.setParent(this);
		
	}
	
	//Returns number of children
	public int countChildren() {
		return this.children.size();
		
	}
	
	//Returns a list of only directories that are children of the focused directory
	public LinkedList<Directory> getSubDirectories(){
		
		LinkedList<Directory> subDirectories = new LinkedList<Directory>();
		
		for(FSElement f : this.children) {
		
			if(f instanceof Directory) {
				
				Directory directory = (Directory)f;
				subDirectories.add(directory);
				
			}
		}
		
		return subDirectories;
		
	}
	
	//Returns a list of only files that are children of the focused directory
	public LinkedList<File> getFiles(){
		
		LinkedList<File> files = new LinkedList<File>();
		
		for(FSElement f : this.children) {
		
			if(f instanceof File) {
				
				File file = (File)f;
				files.add(file);
				
			}
		}
		
		return files;
		
	}
	
	//Returns the total size of all files that are children of the directory, including children of subdirectories
	public int getTotalSize() {
		
		int totalSize = 0;
		
		for(FSElement f : this.children) {
			
			totalSize = totalSize + f.getSize(); 
		
		}
		
		for(Directory d : this.getSubDirectories()) {
			totalSize = totalSize + d.getTotalSize();
		}
		
		return totalSize;
		
	}
	
	//true
	public boolean isDirectory() {
		return true;
	}

}
