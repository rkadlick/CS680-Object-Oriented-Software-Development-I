package edu.umb.cs680.hw12.apfs;

import java.util.Comparator;

/*This class holds the reverse alphabet comparator and is used to sort elements reverse alphabetically.*/
public class ReverseAlphabeticalComparator implements Comparator<ApfsElement> {

	@Override
	public int compare(ApfsElement ae1, ApfsElement ae2) {
		return -ae1.getName().compareTo(ae2.getName());
	}

}