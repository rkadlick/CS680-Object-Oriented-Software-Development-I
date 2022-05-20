package edu.umb.cs680.hw12.apfs;

import java.util.LinkedList;

/*This class holds the ApfsFileSearchVistor that is meant to search through the files under 
 * a directory looking for a specifically named file.
 */
public class ApfsFileSearchVisitor implements ApfsVisitor{

	//Holds the name of the file we are searching for. The list is for the files that equal that name.
	private String fileName;
	private LinkedList<ApfsFile> foundFiles = new LinkedList<ApfsFile>();
	
	//Assign the file name we are looking for
	public ApfsFileSearchVisitor(String s) {
		this.fileName = s;
	}

	//No need for links
	@Override
	public void visit(ApfsLink link) {
		return;
	}

	//No need for directoires
	@Override
	public void visit(ApfsDirectory dir) {
		return;
	}

	//If the file we crawl to is equal to the name we are searching for, add it to the list.
	@Override
	public void visit(ApfsFile file) {
		if(file.getName().equals(fileName)) {
			foundFiles.add(file);
		}
	}
	
	//Retrieve list of the files with the name we searched for
	public LinkedList<ApfsFile> getFoundFiles(){
		return this.foundFiles;
	}
	
	

}
