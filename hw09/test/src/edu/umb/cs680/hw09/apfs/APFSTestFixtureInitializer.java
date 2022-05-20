package edu.umb.cs680.hw09.apfs;

import java.time.LocalDateTime;

/*This class holds the APFS file system that we implement as a test fixture in various APFS test classes*/
public class APFSTestFixtureInitializer {
	
	
	public static APFS createAPFS(APFS apfs) {
		
		apfs = APFS.getAPFS();
		
		ApfsDirectory root = apfs.getRootDir();
		
		ApfsDirectory applications = new ApfsDirectory(root, "Applications", 0, LocalDateTime.of(2000, 1, 1, 2, 0), 
				"admin", LocalDateTime.of(2001,  1, 1, 2, 0));
		root.appendChild(applications);
		ApfsFile a = new ApfsFile(applications, "a", 1, LocalDateTime.of(2000, 1, 1, 3, 0), 
				"admin", LocalDateTime.of(2001,  1, 1, 3, 0));
		applications.appendChild(a);
		
		ApfsDirectory home = new ApfsDirectory (root, "Home", 0, LocalDateTime.of(2000, 1, 1, 4, 0), 
				"admin", LocalDateTime.of(2001,  1, 1, 4, 0));
		root.appendChild(home);
		ApfsFile b = new ApfsFile(home, "b", 2, LocalDateTime.of(2000, 1, 1, 5, 0),
				"admin", LocalDateTime.of(2001, 1, 1, 5, 0));
		home.appendChild(b);
		ApfsLink x = new ApfsLink(home, "x", 0, LocalDateTime.of(2000, 1, 1, 5, 1),
				"admin", LocalDateTime.of(2001, 1, 1, 5, 1), applications);
		home.appendChild(x);
		
		ApfsDirectory code = new ApfsDirectory(home, "Code", 0, LocalDateTime.of(2000, 1, 1, 6, 0), 
				"admin", LocalDateTime.of(2001, 1, 1, 6, 0));
		home.appendChild(code);
		ApfsLink y = new ApfsLink(home, "y", 0, LocalDateTime.of(2000, 1, 1, 6, 1),
				"admin", LocalDateTime.of(2001, 1, 1, 6, 1), a );
		code.appendChild(y);
		ApfsFile c = new ApfsFile(code, "c", 3, LocalDateTime.of(2000, 1, 1, 7, 0),
				"admin", LocalDateTime.of(2001, 1, 1, 7, 0));
		code.appendChild(c);
		ApfsFile d = new ApfsFile(code, "d", 4, LocalDateTime.of(2000, 1, 1, 8, 0),
				"admin", LocalDateTime.of(2001, 1, 1, 8, 0));
		code.appendChild(d);
		
		ApfsDirectory pics = new ApfsDirectory(home, "Pics", 0, LocalDateTime.of(2000, 1, 1, 9, 0),
				"admin", LocalDateTime.of(2001,  1, 1, 9, 0));
		home.appendChild(pics);
		ApfsFile e = new ApfsFile(pics, "e", 5, LocalDateTime.of(2000, 1, 1, 10, 0),
				"admin", LocalDateTime.of(2001, 1, 1, 10, 0));
		pics.appendChild(e);
		ApfsFile f = new ApfsFile(pics, "f", 6, LocalDateTime.of(2000, 1, 1, 11, 0),
				"admin", LocalDateTime.of(2001, 1, 1, 11, 0));
		pics.appendChild(f);
		
		
		return apfs;
	}

}
