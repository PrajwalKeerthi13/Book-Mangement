package com.cruds.bms;

public class Student {

	private String USN;
	private String Name;
	public Student(String uSN, String name) {
		super();
		USN = uSN;
		Name = name;
	}
	public String getUSN() {
		return USN;
	}
	public void setUSN(String uSN) {
		USN = uSN;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@Override
	public String toString() {
		return "Student [USN=" + USN + ", Name=" + Name + "]";
	}
	
	
	
}
