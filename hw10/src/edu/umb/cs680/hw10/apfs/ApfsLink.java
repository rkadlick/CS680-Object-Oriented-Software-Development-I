package edu.umb.cs680.hw10.apfs;

import java.time.LocalDateTime;

/*This class holds the ApfsLink which is extended from ApfsElement*/
public class ApfsLink extends ApfsElement {
	
	//References what element the link points to
	private ApfsElement target;
	
	
	//ApfsLink object refers to a link to an element in an apfs file system
	public ApfsLink (ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String owner, 
			LocalDateTime lastModified, ApfsElement target) {

		super(parent, name, size, creationTime, owner, lastModified);
		this.setTarget(target);
		
	}
	
	//accepts apfsvisitors
	public void accept(ApfsVisitor v) {
		v.visit(this);
	}

	//getters and setters
	public ApfsElement getTarget() {
		return target;
	}


	public void setTarget(ApfsElement target) {
		this.target = target;
	}

	//If link is pointing to a directory, return true
	@Override
	public boolean isDirectory() {
		
		if(this.target instanceof ApfsDirectory) {
			return true;
		}
		return false;
	}

}
