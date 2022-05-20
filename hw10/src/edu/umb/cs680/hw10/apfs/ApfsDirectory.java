package edu.umb.cs680.hw10.apfs;

import java.time.LocalDateTime;
import java.util.LinkedList;

import edu.umb.cs680.hw10.fs.FSElement;

/*This class holds ApfsDirectory which extends ApfsElement class*/
public class ApfsDirectory extends ApfsElement {
	
	//Holds the elements contained inside the directory
	private LinkedList<ApfsElement> children = new LinkedList<ApfsElement>();
	
	//ApfsDirectory represents a directory inside an apfs file system
	public ApfsDirectory (ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String owner, 
			LocalDateTime lastModified) {
		
		super(parent, name, size, creationTime, owner, lastModified);
	}
	
	//Accepts an ApfsVisitor into the directory and it's children
	public void accept(ApfsVisitor v) {
		v.visit(this);
		for(ApfsElement e: children) {
			e.accept(v);
		}
	}
	
	//Retrieves elements inside the directory
	public LinkedList<ApfsElement> getChildren() {
		return this.children;
		
	}
	
	//Adds element to the directory, sets directory as elements parent
	public void appendChild(ApfsElement child) {
		
		this.children.add(child);
		child.setParent(this);
		
	}
	
	//Returns amount of elements inside directory
	public int countChildren() {
		return this.children.size();
		
	}
	
	//Returns only directory elements inside directory
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
	
	//Returns only file elements inside directory
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
	
	//Returns only link elements inside directory
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
	
	//Retrieves total size of all files contained in directory, including in sub-directories
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
