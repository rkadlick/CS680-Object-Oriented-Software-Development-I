package edu.umb.cs680.hw10.apfs;

import java.util.LinkedList;

/*This class holds an ApfsFileCrawlingVisitor which has a purpose to crawl through an apfs file system
 * saving only apfsFiles to a list.
 */
public class ApfsFileCrawlingVisitor implements ApfsVisitor {

	//List to save crawled files
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

	//Add file to list of files
	@Override
	public void visit(ApfsFile file) {
		files.add(file);
	}
	
	//Return list of files
	public LinkedList<ApfsFile> getFiles(){
		return this.files;
	}
	
	
	
	

}
