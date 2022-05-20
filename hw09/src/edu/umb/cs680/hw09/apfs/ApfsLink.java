package edu.umb.cs680.hw09.apfs;

import java.time.LocalDateTime;

/*This class holds ApfsLink objects, which extend from ApfsElement*/
public class ApfsLink extends ApfsElement {
	
	//Represents the target element of the link
	private ApfsElement target;
	
	//ApfsLinks represent a link to a target element in an apfs file system
	public ApfsLink (ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String owner, 
			LocalDateTime lastModified, ApfsElement target) {

		super(parent, name, size, creationTime, owner, lastModified);
		this.setTarget(target);
		
	}

	//getter and setter
	public ApfsElement getTarget() {
		return target;
	}


	public void setTarget(ApfsElement target) {
		this.target = target;
	}


	//If the target element of the link is a directory, return true
	@Override
	public boolean isDirectory() {
		
		if(this.target instanceof ApfsDirectory) {
			return true;
		}
		return false;
	}

}
