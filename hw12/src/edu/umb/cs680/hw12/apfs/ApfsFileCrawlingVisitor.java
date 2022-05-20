package edu.umb.cs680.hw12.apfs;

import java.util.LinkedList;

/*This class is for the ApfsFileCrawlingVisitor that is used to save all files underneath a directory*/
public class ApfsFileCrawlingVisitor implements ApfsVisitor {

	//Holds the list of files
	private LinkedList<ApfsFile> files = new LinkedList<ApfsFile>();
	
	//No need for links
	@Override
	public void visit(ApfsLink link) {
		return;
	}

	//No need for directories
	@Override
	public void visit(ApfsDirectory dir) {
		return;
	}

	//Adds file to list when it reaches one
	@Override
	public void visit(ApfsFile file) {
		files.add(file);
	}
	
	//Retrieves list of files crawled
	public LinkedList<ApfsFile> getFiles(){
		return this.files;
	}
	
	
	
	

}
