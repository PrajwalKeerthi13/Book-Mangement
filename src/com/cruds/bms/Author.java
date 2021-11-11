package com.cruds.bms;

public class Author {
	
	private String Authorname;
	private String Authormailid;
	public Author(String authorname, String authormailid) {
		super();
		Authorname = authorname;
		Authormailid = authormailid;
	}
	public String getAuthorname() {
		return Authorname;
	}
	public void setAuthorname(String authorname) {
		Authorname = authorname;
	}
	public String getAuthormailid() {
		return Authormailid;
	}
	public void setAuthormailid(String authormailid) {
		Authormailid = authormailid;
	}
	@Override
	public String toString() {
		return "Author [Authorname=" + Authorname + ", Authormailid=" + Authormailid + "]";
	}
	
	
	
}
