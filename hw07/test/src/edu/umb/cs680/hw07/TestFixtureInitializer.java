package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

/*This class holds our test fixture, a fake file system used in our test classes*/
public class TestFixtureInitializer {
	
	
	public static FileSystem createFS(FileSystem fs) {
		
		fs = FileSystem.getFileSystem();
		
		Directory root = new Directory(null, "Root", 0, LocalDateTime.of(2000, 1, 1, 1, 0));
		fs.appendRootDir(root);
		
		Directory applications = new Directory(root, "Applications", 0, LocalDateTime.of(2000, 1, 1, 2, 0));
		root.appendChild(applications);
		File a = new File(applications, "a", 1, LocalDateTime.of(2000, 1, 1, 3, 0));
		applications.appendChild(a);
		
		Directory home = new Directory (root, "Home", 0, LocalDateTime.of(2000, 1, 1, 4, 0));
		root.appendChild(home);
		File b = new File(home, "b", 2, LocalDateTime.of(2000, 1, 1, 5, 0));
		home.appendChild(b);
		
		Directory code = new Directory(home, "Code", 0, LocalDateTime.of(2000, 1, 1, 6, 0));
		home.appendChild(code);
		File c = new File(code, "c", 3, LocalDateTime.of(2000, 1, 1, 7, 0));
		code.appendChild(c);
		File d = new File(code, "d", 4, LocalDateTime.of(2000, 1, 1, 8, 0));
		code.appendChild(d);
		
		Directory pics = new Directory(home, "Pics", 0, LocalDateTime.of(2000, 1, 1, 9, 0));
		home.appendChild(pics);
		File e = new File(pics, "e", 5, LocalDateTime.of(2000, 1, 1, 10, 0));
		pics.appendChild(e);
		File f = new File(pics, "f", 6, LocalDateTime.of(2000, 1, 1, 11, 0));
		pics.appendChild(f);
		
		fs.appendRootDir(root);
		
		return fs;
	}

}
