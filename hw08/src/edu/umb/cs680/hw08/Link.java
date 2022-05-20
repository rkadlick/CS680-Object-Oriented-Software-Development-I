package edu.umb.cs680.hw08;

import java.time.LocalDateTime;


/*This class holds Link objects which are an extension of the FSElement class*/
public class Link extends FSElement{
	
	//A reference to what element the link targets
	private FSElement target;
	
	//Link object represents a link in the file system that targets another element
	public Link (Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {

		super(parent, name, size, creationTime);
		this.setTarget(target);
		
	}

	//Getters and setters
	public FSElement getTarget() {
		return target;
	}


	public void setTarget(FSElement target) {
		this.target = target;
	}


	//If the target of the link is a directory, return true
	@Override
	public boolean isDirectory() {
		if(this.target instanceof Directory) {
			return true;
		}
		return false;
	}

}
