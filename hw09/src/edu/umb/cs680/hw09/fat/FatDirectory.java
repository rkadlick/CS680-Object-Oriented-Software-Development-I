package edu.umb.cs680.hw09.fat;

import java.time.LocalDateTime;
import java.util.LinkedList;


/*This class holds the FatDirectory which extends the FatFSElement class*/
public class FatDirectory extends FatFSElement {
	
	//Holds the elements that are contained inside the directory
	private LinkedList<FatFSElement> children = new LinkedList<FatFSElement>();

	
	//Represents a directory in an FAT file system
	public FatDirectory (FatDirectory parent, String name, int size, LocalDateTime creationTime) {
		
		super(parent, name, size, creationTime);
	}
	
	//Retrieves elements contained inside the directory
	public LinkedList<FatFSElement> getChildren() {
		return this.children;
		
	}
	
	//Adds an element to the directory, sets the parent of the element to the directory
	public void appendChild(FatFSElement child) {
		
		this.children.add(child);
		child.setParent(this);
		
	}
	
	//Returns the number of elements inside the directory
	public int countChildren() {
		return this.children.size();
		
	}
	
	//Returns only the directory elements that are contained inside the directory
	public LinkedList<FatDirectory> getSubDirectories(){
		
		LinkedList<FatDirectory> subDirectories = new LinkedList<FatDirectory>();
		
		for(FatFSElement d : this.children) {
		
			if(d instanceof FatDirectory) {
				
				FatDirectory directory = (FatDirectory)d;
				subDirectories.add(directory);
				
			}
		}
		
		return subDirectories;
		
	}
	
	//Returns only the File elements that are contained inside the directory
	public LinkedList<FatFile> getFiles(){
		
		LinkedList<FatFile> files = new LinkedList<FatFile>();
		
		for(FatFSElement f : this.children) {
		
			if(f instanceof FatFile) {
				
				FatFile file = (FatFile)f;
				files.add(file);
				
			}
		}
		
		return files;
		
	}
	
	//Gets the total size of the files in the directory, including subdirectories
	public int getTotalSize() {
		
		int totalSize = 0;
		
		for(FatFSElement e : this.children) {
			
			totalSize = totalSize + e.getSize(); 
		
		}
		
		for(FatDirectory d : this.getSubDirectories()) {
			totalSize = totalSize + d.getTotalSize();
		}
		
		return totalSize;
		
	}
	
	//truth
	public boolean isDirectory() {
		return true;
	}

}
