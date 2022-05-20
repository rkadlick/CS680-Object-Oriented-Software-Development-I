package edu.umb.cs680.hw12.apfs;

import java.util.Comparator;

/*This class holds the last modified comparator and is used to sort elements by date of last modification.*/
public class LastModifiedComparator implements Comparator<ApfsElement> {

	@Override
	public int compare(ApfsElement ae1, ApfsElement ae2) {
		return ae1.getLastModified().compareTo(ae2.getLastModified());
	}

}