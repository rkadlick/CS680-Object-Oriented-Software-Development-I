package edu.umb.cs680.hw12.apfs;

/*This class holds the ApfsCountingVisitor that is used to count the elements under a directory*/
public class ApfsCountingVisitor implements ApfsVisitor{

	//Initialize counters
	private int dirNum = 0;
	private int fileNum = 0;
	private int linkNum = 0;
	
	//Raise the link counter for a link
	@Override
	public void visit(ApfsLink link) {
		linkNum++;
	}

	//Raise the directory counter for a directory
	@Override
	public void visit(ApfsDirectory dir) {
		dirNum++;
		
	}

	//Raise file counter for a file
	@Override
	public void visit(ApfsFile file) {
		fileNum++;
	}
	
	//Getters
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
