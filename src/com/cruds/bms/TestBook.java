package com.cruds.bms;


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class TestBook {

	public static void main(String[] args) 
	{	
	    Issue[] array= new Issue[25];
	    int position =0;
		BookDAO dao = new BookDAO();
		Scanner sc = new Scanner(System.in);
		
		String choice = "";
		
		do{
			System.out.println("Please select a choice ");
			System.out.println("1.Add Book");
			System.out.println("2.Search book by Title");
			System.out.println("3.Search book by Category");
			System.out.println("4.Search book by Author");
			System.out.println("5.List all books by Author information");
			System.out.println("6.Issue book to a student");
			System.out.println("7.List books issued to student based on USN");
			System.out.println("8.List books which are to be returned for current date");
			System.out.println("9.Exit");
			System.out.println("Please enter your choice");
			
			choice =sc.nextLine();
			
			switch(choice)
			{
			case "1":
				System.out.println("**Adding of books**");
				System.out.println("Enter the Book_isbn: ");
				int isbn = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the Title of book: ");
				String title = sc.nextLine();
				System.out.println("Enter the Category of book: ");
				String category = sc.nextLine();
				System.out.println("Enter the no of books: ");
				int no_of_books = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the name of Author: ");
				String authorname = sc.nextLine();
				System.out.println("Enter the mail id of Author: ");
				String authormailid = sc.nextLine();
				
				Author author= new Author(authorname, authormailid);
				Book book = new Book(isbn, title, category, no_of_books);
				
				BookDAO dao1 = new BookDAO();
				book.setAuthor(author);
				try {
					dao1.create(book);
				} catch (MySQLIntegrityConstraintViolationException e) {
					System.out.println("Book added successfully....");
					e.printStackTrace();
				}
			
			break;
			
			case "2":
				System.out.println("**Searching book by title**");
				System.out.println("Enter the title of book to search: ");
				String searchtitle = sc.nextLine();
				BookDAO dao2 = new BookDAO();
				dao2.getBookbyTitle(searchtitle);
				break;
				
			case "3":
				System.out.println("**Searching book by Category**");
				System.out.println("Enter the category of book to search: ");
				String searchcategory = sc.nextLine();
				BookDAO dao3 = new BookDAO();
				dao3.getBookbyCategory(searchcategory);
				break;
				
			case "4":
				System.out.println("**Searching book by Authorname**");
				System.out.println("Enter the Authorname of book to search: ");
				String searchauthorname = sc.nextLine();
				BookDAO dao4 = new BookDAO();
				dao4.getBookbyAuthor(searchauthorname);
				break;	
				
			case "5":
				BookDAO.getAllBooks();;
				break;
				
			case "6":
				System.out.println("Enter a USN to issue book");
				String USNsearch = sc.nextLine();
				List<String> getbyStudentlist = dao.getStudentbyUSN(USNsearch);
				if(getbyStudentlist.isEmpty())
				{
					System.out.println("No files found please enter a choice");
					String choice1 = "";
					do
					{
						System.out.println("1.Add a student");
						System.out.println("2.Exit");
						choice1 = sc.nextLine();
						
						switch(choice1)
						{
						case "1":
							
							System.out.println("enter a USN number");
							String usn=sc.nextLine();
							System.out.println("enter a student name");
							String studentname = sc.nextLine();
							System.out.println("Student added successfully");
							
							Student s = new Student(usn, studentname);
							BookDAO dao5 = new BookDAO();
							dao5.createstudent(s);
							break;
							
						case "2":
							break;
							
						default:
							System.out.println("invalid choice!!!");
							break;
							
						}
						
					}while(!choice1.equals("2"));
				}
				else {
					System.out.println("enter a book no");
					String searchisbn = sc.nextLine();
					List<String>getbybookisbn = dao.getBookbyIsbn(searchisbn);
					if(getbybookisbn.isEmpty())
					{
						System.out.println("Book is out of stock");
						
					}
					else
					{
						if((!USNsearch.isEmpty())  )
						{
							LocalDate Today = LocalDate.now();
							LocalDate Today7 = LocalDate.now();
							LocalDate returnDate = Today7.plusDays(7);
							
						Issue bi = new Issue(USNsearch, Today, returnDate, searchisbn);
						array[position] = bi;
						position++;
						BookDAO dao5 = new BookDAO();
						dao5.createBookIssue(bi);
						System.out.println("Book issued successfully");
						dao.NoOfBooksDecrement(searchisbn);;
						System.out.println(bi);
						
						
						}
					}
				}
				break;
			case "7":
				System.out.println("enter a USN no");
				String usnsearch = sc.nextLine();
				BookDAO dao5 = new BookDAO();
				dao5.getbookissuebyUSN(usnsearch);
				
				break;
				
			case "8":
				BookDAO.getReturnBook();
				break;
				
			case "9":
				System.out.println("**You are exited from the file**");
				break;
				
			}
			
		}while(!choice.equals("9"));
		
		sc.close();
	}
	
	
}
