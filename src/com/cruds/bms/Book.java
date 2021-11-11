package com.cruds.bms;

public class Book {

	private int Isbn;
	private String Title;
	private String Category;
	private int No_of_books;
	
	private Author author;
	
	public Book(int isbn, String title, String category, int no_of_books) {
		super();
		Isbn = isbn;
		Title = title;
		Category = category;
		No_of_books = no_of_books;
	}
	
	

	public Book(int isbn, String title, String category, int no_of_books, Author author) {
		super();
		Isbn = isbn;
		Title = title;
		Category = category;
		No_of_books = no_of_books;
		this.author = author;
	}



	public int getIsbn() {
		return Isbn;
	}

	public void setIsbn(int isbn) {
		Isbn = isbn;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public int getNo_of_books() {
		return No_of_books;
	}

	public void setNo_of_books(int no_of_books) {
		No_of_books = no_of_books;
	}

	
	public Author getAuthor() {
		return author;
	}



	public void setAuthor(Author author) {
		this.author = author;
	}



	@Override
	public String toString() {
		return "Book [Isbn=" + Isbn + ", Title=" + Title + ", Category=" + Category + ", No_of_books=" + No_of_books
				+ ", author=" + author + "]";
	}
	
	
	
}
