package edu.umb.cs680.hw12.apfs;

import java.util.Comparator;

/*This class is holds the creation time comparator used to sort elements by creation time*/
public class CreationTimeComparator  implements Comparator<ApfsElement> {

	@Override
	public int compare(ApfsElement ae1, ApfsElement ae2) {
		return ae1.getCreationTime().compareTo(ae2.getCreationTime());
	}

}