package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw04.Student.StudentStatus;


public class StudentTest {
	@Test
	public void inState(){
		// This test method is used to test createInStateStudent(), also getStatus() and getName() methods when status is InState
		
		String name = "Test";
		String usAddr = "TestAddr";
		
		Student actual = Student.createInStateStudent(name, usAddr);
		
		StudentStatus status = StudentStatus.INSTATE;
		
		assertEquals("Test", actual.getName());
		assertEquals(status, actual.getStatus());
	}
	
	@Test
	public void outState(){
		// This test method is used to test createOutStateStudent(), also getStatus() and getName() methods when status is OutState
		
		String name = "Test";
		String usAddr = "TestAddr";
		int yrsInState = 5;
		
		Student actual = Student.createOutStateStudent(name, usAddr, yrsInState);
		
		StudentStatus status = StudentStatus.OUTSTATE;
		
		assertEquals("Test", actual.getName());
		assertEquals(status, actual.getStatus());
	}
	
	@Test
	public void intl(){
		// This test method is used to test createIntlStudent(), also getStatus() and getName() methods when status is Intl
		
		String name = "Test";
		int i20number = 12345;
		String foreignAddr = "TestAddr";

		
		Student actual = Student.createIntlStudent(name, i20number, foreignAddr);
		
		StudentStatus status = StudentStatus.INTL;		
		
		assertEquals("Test", actual.getName());
		assertEquals(status, actual.getStatus());
	}
	

}
