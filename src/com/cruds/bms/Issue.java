package com.cruds.bms;

import java.time.LocalDate;

public class Issue {
	
	private int Issue_ID;
	private String USN;
	private LocalDate Issued_Date;
	private LocalDate ReturnDate;
	private String Isbn;
	
	public Issue(int issue_ID, String uSN, LocalDate issued_Date, LocalDate returnDate, String isbn) {
		super();
		Issue_ID = issue_ID;
		USN = uSN;
		Issued_Date = issued_Date;
		ReturnDate = returnDate;
		Isbn = isbn;
		
	}
	public Issue(String uSN, LocalDate issued_Date, LocalDate returnDate, String searchisbn) {
		super();
		USN = uSN;
		Issued_Date = issued_Date;
		ReturnDate = returnDate;
		Isbn = searchisbn;
		
	}
	public int getIssue_ID() {
		return Issue_ID;
	}
	public void setIssue_ID(int issue_ID) {
		Issue_ID = issue_ID;
	}
	public String getUSN() {
		return USN;
	}
	public void setUSN(String uSN) {
		USN = uSN;
	}
	public LocalDate getIssued_Date() {
		return Issued_Date;
	}
	public void setIssued_Date(LocalDate issued_Date) {
		Issued_Date = issued_Date;
	}
	public LocalDate getReturnDate() {
		return ReturnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		ReturnDate = returnDate;
	}
	public String getIsbn() {
		return Isbn;
	}
	public void setIsbn(String isbn) {
		Isbn = isbn;
	}
	
	@Override
	public String toString() {
		return "Issue [Issue_ID=" + Issue_ID + ", USN=" + USN + ", Issued_Date=" + Issued_Date + ", ReturnDate="
				+ ReturnDate + ", Isbn=" + Isbn + "]";
	}
	
	
	
}