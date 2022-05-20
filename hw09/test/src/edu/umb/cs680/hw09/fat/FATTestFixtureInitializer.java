package edu.umb.cs680.hw09.fat;

import java.time.LocalDateTime;
import java.util.LinkedList;

import edu.umb.cs680.hw09.fs.FSElement;


/*This class holds the Fat File system test fixture that is used for the FAT test classes*/
public class FATTestFixtureInitializer {
	
public static FAT createFAT(FAT fat) {
		
		fat = FAT.getFAT();
		
		LinkedList<FSElement> rootDirs = fat.getRootDirs();
		FatDirectory root = (FatDirectory) rootDirs.getFirst();
		
		FatDirectory applications = new FatDirectory(root, "Apps", 0, LocalDateTime.of(2000, 1, 1, 2, 0));
		root.appendChild(applications);
		FatFile a = new FatFile(applications, "a", 1, LocalDateTime.of(2000, 1, 1, 3, 0));
		applications.appendChild(a);
		
		FatDirectory home = new FatDirectory (root, "Home", 0, LocalDateTime.of(2000, 1, 1, 4, 0));
		root.appendChild(home);
		FatFile b = new FatFile(home, "b", 2, LocalDateTime.of(2000, 1, 1, 5, 0));
		home.appendChild(b);
		
		FatDirectory code = new FatDirectory(home, "Code", 0, LocalDateTime.of(2000, 1, 1, 6, 0));
		home.appendChild(code);
		FatFile c = new FatFile(code, "c", 3, LocalDateTime.of(2000, 1, 1, 7, 0));
		code.appendChild(c);
		FatFile d = new FatFile(code, "d", 4, LocalDateTime.of(2000, 1, 1, 8, 0));
		code.appendChild(d);
		
		FatDirectory pics = new FatDirectory(home, "Pics", 0, LocalDateTime.of(2000, 1, 1, 9, 0));
		home.appendChild(pics);
		FatFile e = new FatFile(pics, "e", 5, LocalDateTime.of(2000, 1, 1, 10, 0));
		pics.appendChild(e);
		FatFile f = new FatFile(pics, "f", 6, LocalDateTime.of(2000, 1, 1, 11, 0));
		pics.appendChild(f);
				
		return fat;
	}

}
