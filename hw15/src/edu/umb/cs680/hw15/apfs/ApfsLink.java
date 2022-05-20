package edu.umb.cs680.hw15.apfs;

import java.time.LocalDateTime;

/*This class holds ApfsLinks*/
public class ApfsLink extends ApfsElement {
	
	//This holds the target element of the link
	private ApfsElement target;
	
	//We create an ApfsElement and set its target
	public ApfsLink (ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String owner, 
			LocalDateTime lastModified, ApfsElement target) {

		super(parent, name, size, creationTime, owner, lastModified);
		this.setTarget(target);
		
	}
	
	//Accepts visitors
	public void accept(ApfsVisitor v) {
		v.visit(this);
	}


	public ApfsElement getTarget() {
		return target;
	}


	public void setTarget(ApfsElement target) {
		this.target = target;
	}


	//Returns true if the link is to a directory
	@Override
	public boolean isDirectory() {
		
		if(this.target instanceof ApfsDirectory) {
			return true;
		}
		return false;
	}

}
