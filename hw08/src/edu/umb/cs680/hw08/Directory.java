package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;

/*This class holds Directory objects that come from the super class FSelement*/
public class Directory extends FSElement {
	
	//Holds the elements that are children to the Directory
	private LinkedList<FSElement> children = new LinkedList<FSElement>();
	
	public Directory (Directory parent, String name, int size, LocalDateTime creationTime) {
		
		super(parent, name, size, creationTime);
	}
	
	//Returns the children of that directory
	public LinkedList<FSElement> getChildren() {
		return this.children;
		
	}
	
	//Adds an element to the children of that directory, sets the parent of the element to the directory
	public void appendChild(FSElement child) {
		
		this.children.add(child);
		child.setParent(this);
		
	}
	
	//Returns number of children a directory has
	public int countChildren() {
		return this.children.size();
		
	}
	
	//Returns only directories that are children of the directory
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
	
	//Returns only files that are children of the directory
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
	
	//Returns only links that are children of the directory
	public LinkedList<Link> getLinks(){
		
		LinkedList<Link> links = new LinkedList<Link>();
		
		for(FSElement l : this.children) {
		
			if(l instanceof Link) {
				
				Link link = (Link)l;
				links.add(link);
				
			}
		}
		
		return links;
		
	}
	
	//Returns the total size of all files in the directory, including subdirectories
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
	
	//truth
	public boolean isDirectory() {
		return true;
	}

}
