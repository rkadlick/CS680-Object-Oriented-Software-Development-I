package edu.umb.cs680.hw12.apfs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import edu.umb.cs680.hw12.fs.FSElement;

/*This class holds the ApfsDirectory*/
public class ApfsDirectory extends ApfsElement {
	
	//Holds the children(elements) of a directory
	private LinkedList<ApfsElement> children = new LinkedList<ApfsElement>();
	
	//Constructor
	public ApfsDirectory (ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String owner, 
			LocalDateTime lastModified) {
		
		super(parent, name, size, creationTime, owner, lastModified);
	}
	
	//Accepts vistor recursively for it's children
	public void accept(ApfsVisitor v) {
		v.visit(this);
		for(ApfsElement e: children) {
			e.accept(v);
		}
	}
	
	//Get children, sorted Alphabetically
	public LinkedList<ApfsElement> getChildren(){
		Collections.sort(this.children, new AlphabeticalComparator());
		return this.children;
	}
	
	//Get children, sorted by chosen comparator
	public LinkedList<ApfsElement> getChildren(Comparator<ApfsElement> comparator) {
		Collections.sort(this.children, comparator);
		return this.children;
		
	}
	
	//Adds element to children list, sets directory as parent of element, sorts alphabetically
	public void appendChild(ApfsElement child) {
		
		this.children.add(child);
		child.setParent(this);
		Collections.sort(this.children, new AlphabeticalComparator());
		
	}
	
	//Returns number of children
	public int countChildren() {
		return this.children.size();
		
	}
	
	//Returns children that are ApfsDirectorys, sorts alphabetically
	public LinkedList<ApfsDirectory> getSubDirectories(){
		LinkedList<ApfsDirectory> subDirectories = new LinkedList<ApfsDirectory>();
		
		for(ApfsElement d : this.children) {
		
			if(d instanceof ApfsDirectory) {
				
				ApfsDirectory directory = (ApfsDirectory)d;
				subDirectories.add(directory);
				
			}
		}
		
		Collections.sort(subDirectories, new AlphabeticalComparator());
		return subDirectories;
	}
	
	//Return children that are APfsDirectorys, sorts by given comparator
	public LinkedList<ApfsDirectory> getSubDirectories(Comparator<ApfsElement> comparator){
		
		LinkedList<ApfsDirectory> subDirectories = new LinkedList<ApfsDirectory>();
		
		for(ApfsElement d : this.children) {
		
			if(d instanceof ApfsDirectory) {
				
				ApfsDirectory directory = (ApfsDirectory)d;
				subDirectories.add(directory);
				
			}
		}
		
		Collections.sort(subDirectories, comparator);
		return subDirectories;
		
	}
	
	//Returns children that are ApfsFiles, sorts alphabetically
	public LinkedList<ApfsFile> getFiles(){
		
		LinkedList<ApfsFile> files = new LinkedList<ApfsFile>();
		
		for(ApfsElement f : this.children) {
		
			if(f instanceof ApfsFile) {
				
				ApfsFile file = (ApfsFile)f;
				files.add(file);
				
			}
		}
		
		Collections.sort(files, new AlphabeticalComparator());
		return files;
		
	}
	
	//Returns children that are ApfsFiles, sorts by given comparator
	public LinkedList<ApfsFile> getFiles(Comparator<ApfsElement> comparator){
		
		LinkedList<ApfsFile> files = new LinkedList<ApfsFile>();
		
		for(ApfsElement f : this.children) {
		
			if(f instanceof ApfsFile) {
				
				ApfsFile file = (ApfsFile)f;
				files.add(file);
				
			}
		}
		
		Collections.sort(files, comparator);
		return files;
		
	}
	
	//Returns children that are ApfsLinks, sorts alphabetically
	public LinkedList<ApfsLink> getLinks(){
		
		LinkedList<ApfsLink> links = new LinkedList<ApfsLink>();
		
		for(ApfsElement l : this.children) {
		
			if(l instanceof ApfsLink) {
				
				ApfsLink link = (ApfsLink)l;
				links.add(link);
				
			}
		}
		
		Collections.sort(links, new AlphabeticalComparator());
		return links;
		
	}
	
	//Returns children that are Apfslinks, sorts by given comparator
	public LinkedList<ApfsLink> getLinks(Comparator<ApfsElement> comparator){
		
		LinkedList<ApfsLink> links = new LinkedList<ApfsLink>();
		
		for(ApfsElement l : this.children) {
		
			if(l instanceof ApfsLink) {
				
				ApfsLink link = (ApfsLink)l;
				links.add(link);
				
			}
		}
		
		Collections.sort(links, comparator);
		return links;
		
	}
	
	//Adds up total file size inside directory, calls recursively on sub-directories
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
	
	public boolean isDirectory() {
		return true;
	}


}
