package edu.umb.cs680.hw09.fat;

import java.time.LocalDateTime;

/*This class holds the FatFile object which extends the FatFSElement class*/
public class FatFile extends FatFSElement {

	//A FatFile object represents a file in an FAT file system
	public FatFile(FatDirectory parent, String name, int size, LocalDateTime creationTime) {
			
			super(parent, name, size, creationTime);
			
		}
		
	//false
	public boolean isDirectory() {
		return false;
	}

}
