package edu.umb.cs680.hw09.fat;

import java.time.LocalDateTime;
import java.util.LinkedList;

import edu.umb.cs680.hw09.apfs.APFS;
import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.fs.FSElement;
import edu.umb.cs680.hw09.fs.FileSystem;

/*This class holds the FAT file system object that extends from FileSystem*/
public class FAT extends FileSystem {

	protected static FAT Fat = null;
	private FAT() {};
	
	//Singleton
	protected static FAT getFAT() {
		if(Fat == null) {
			Fat = new FAT();
			Fat.initFileSystem("FAT", 1000);
		}
		return Fat;
	}

	//Creates the default root directory of the FAT file system
	@Override
	protected FSElement createDefaultRoot() {
		return new FatDirectory(null, "Root", 0, LocalDateTime.of(2000, 1, 1, 1, 0));
	}
	
	//Adds another root directory to the FAT file system
	protected void addRoot(FatDirectory fatRoot) {
		setRoot(fatRoot);
	}

}
