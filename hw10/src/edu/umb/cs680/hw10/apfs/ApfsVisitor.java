package edu.umb.cs680.hw10.apfs;

/*This is an interface for ApfsVisitors, currently 3 visitors classes use this: ApfsFileCrawlingVisitor, 
 * ApfsCountingVisitor, and ApfsFileSearchVisitor
 */
public interface ApfsVisitor {
	
	//Methods for ApfsVisitors
	
	public void visit(ApfsLink link);
	
	public void visit(ApfsDirectory dir);
	
	public void visit(ApfsFile file);

}
