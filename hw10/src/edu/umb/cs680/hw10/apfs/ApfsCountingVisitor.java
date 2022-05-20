package edu.umb.cs680.hw10.apfs;

/*This class holds the ApfsCountingVisitor which crawls through an apfs file system and counts all 
 * directories, files, and links*/
public class ApfsCountingVisitor implements ApfsVisitor{

	//Initialize the counts
	private int dirNum = 0;
	private int fileNum = 0;
	private int linkNum = 0;
	
	
	//Increase link counter for links
	@Override
	public void visit(ApfsLink link) {
		linkNum++;
	}

	//Increase directory counter for directories
	@Override
	public void visit(ApfsDirectory dir) {
		dirNum++;
		
	}

	//Increase file counter for files
	@Override
	public void visit(ApfsFile file) {
		fileNum++;
	}
	
	//getters
	public int getDirNum() {
		return this.dirNum;
	}
	
	public int getFileNum() {
		return this.fileNum;
	}
	
	public int getLinkNum() {
		return this.linkNum;
	}

}
