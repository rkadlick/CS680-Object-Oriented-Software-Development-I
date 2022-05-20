package edu.umb.cs680.hw04;

import edu.umb.cs680.hw04.Student.StudentStatus;

public class Student {

	private float tuition;
	private String name;
	private int i20num;
	private String usAddr;
	private int yrsInState;
	private String foreignAddr;
	private StudentStatus status;
	
	enum StudentStatus{
		INSTATE,
		OUTSTATE,
		INTL
	}
	
	private Student(String name, String usAddr, int yrsInState, int i20num, String foreignAddr, StudentStatus status) {
		
		this.name = name;
		this.usAddr = usAddr;
		this.yrsInState = yrsInState;
		this.i20num = i20num;
		this.foreignAddr = foreignAddr;
		this.status = status;
		
	}
	
	public static Student createInStateStudent(String name, String usAddr) {
		StudentStatus status = StudentStatus.INSTATE;
		int yrsInState = 0;
		int i20num = 0;
		String foreignAddr= null;
		
		return new Student(name, usAddr, yrsInState, i20num, foreignAddr, status);
	}
	
	public static Student createOutStateStudent(String name, String usAddr, int yrsInState) {
		StudentStatus status = StudentStatus.OUTSTATE;
		int i20num = 0;
		String foreignAddr = null;
		
		return new Student(name, usAddr, yrsInState, i20num, foreignAddr, status);
	}
	
	public static Student createIntlStudent(String name, int i20num, String foreignAddr) {
		StudentStatus status = StudentStatus.INTL;
		String usAddr = null;
		int yrsInState = 0;
		
		return new Student(name, usAddr, yrsInState, i20num, foreignAddr, status);
	}
	
	public float getTuition() {
		return this.tuition;
	}
	
	public String getName() {
		return this.name;
	}
	
	public StudentStatus getStatus() {
		return this.status;
	}
	
	public static void main(String[] args) {
		
		String name = "Test";
		String usAddr = "testAddr";
		int yrsInState = 1;
		int i20number = 12345;
		String foreignAddr = "TestAddr";
		StudentStatus status = StudentStatus.INTL;
		
		Student actual = new Student(name, usAddr, yrsInState, i20number, foreignAddr, status);
		
		String realName = actual.getName();
		System.out.println(realName);
		
	}
	
	
}
