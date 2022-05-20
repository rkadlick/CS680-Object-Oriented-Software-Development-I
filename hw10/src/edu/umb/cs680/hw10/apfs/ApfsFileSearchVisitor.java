package edu.umb.cs680.hw10.apfs;

import java.util.LinkedList;

/*This class holds an ApfsFileSearchVisitor that's purpose is to crawl through an Apfs file system
 * and save any files that have a name equal to the given string.
 */
public class ApfsFileSearchVisitor implements ApfsVisitor{

	//String holding file name being search for. List of found files with that name;
	private String fileName;
	private LinkedList<ApfsFile> foundFiles = new LinkedList<ApfsFile>();
	
	//Assign file name that we are searching for
	public ApfsFileSearchVisitor(String s) {
		this.fileName = s;
	}

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

	//When we reach a file, check it's name to our given String, if equal then add to the list.
	@Override
	public void visit(ApfsFile file) {
		if(file.getName().equals(fileName)) {
			foundFiles.add(file);
		}
	}
	
	//Return list of files with name equal to given string
	public LinkedList<ApfsFile> getFoundFiles(){
		return this.foundFiles;
	}
	
	

}
