package edu.umb.cs680.hw09.apfs;

import java.time.LocalDateTime;
import java.util.LinkedList;


import edu.umb.cs680.hw09.fs.FSElement;

/*This class holds the ApfsDirectory object which is an ApfsElement*/
public class ApfsDirectory extends ApfsElement {
	
	//Holds the elements that are contained in the apfsDirectory
	private LinkedList<ApfsElement> children = new LinkedList<ApfsElement>();
	
	//ApfsDirectory object references a directory in the apfs file system
	public ApfsDirectory (ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String owner, 
			LocalDateTime lastModified) {
		
		super(parent, name, size, creationTime, owner, lastModified);
	}
	
	//Retrieves all elements contained in the directory
	public LinkedList<ApfsElement> getChildren() {
		return this.children;
		
	}
	
	//Adds an element into the directory, sets the directory as element's parent
	public void appendChild(ApfsElement child) {
		
		this.children.add(child);
		child.setParent(this);
		
	}
	
	//Returns the number of elements contained in the directory
	public int countChildren() {
		return this.children.size();
		
	}
	
	//Returns only directory elements that are contained in the directory
	public LinkedList<ApfsDirectory> getSubDirectories(){
		
		LinkedList<ApfsDirectory> subDirectories = new LinkedList<ApfsDirectory>();
		
		for(ApfsElement d : this.children) {
		
			if(d instanceof ApfsDirectory) {
				
				ApfsDirectory directory = (ApfsDirectory)d;
				subDirectories.add(directory);
				
			}
		}
		
		return subDirectories;
		
	}
	
	//Returns only file elements that are contained in the directory
	public LinkedList<ApfsFile> getFiles(){
		
		LinkedList<ApfsFile> files = new LinkedList<ApfsFile>();
		
		for(ApfsElement f : this.children) {
		
			if(f instanceof ApfsFile) {
				
				ApfsFile file = (ApfsFile)f;
				files.add(file);
				
			}
		}
		
		return files;
		
	}
	
	//Returns only links that are contained in the directory
	public LinkedList<ApfsLink> getLinks(){
		
		LinkedList<ApfsLink> links = new LinkedList<ApfsLink>();
		
		for(ApfsElement l : this.children) {
		
			if(l instanceof ApfsLink) {
				
				ApfsLink link = (ApfsLink)l;
				links.add(link);
				
			}
		}
		
		return links;
		
	}
	
	//Returns total size of all files contained in directory, including sub-directories
	public int getTotalSize() {
		
		int totalSize = 0;
		
		for(ApfsElement e : this.children) {
			
			totalSize = totalSize + e.getSize(); 
		
		}
		
		for(ApfsDirectory d : this.getSubDirectories()) {
			totalSize = totalSize + d.getTotalSize();
		}
		
		return totalSize;
		
	}
	
	//true
	public boolean isDirectory() {
		return true;
	}


}
