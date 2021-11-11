package com.cruds.bms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.cruds.db.DBConnectionManager;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class BookDAO {

	public boolean create(Book book)throws MySQLIntegrityConstraintViolationException {
	{
		String sql = "insert into book(Isbn,Title,Category,No_of_books) values(?,?,?,?) " ;
		String sql2 = "insert into author(Authorname,Authormailid,Isbn) values (?,?,?)";
		int rows = 0;

		try(Connection conn = DBConnectionManager.getconnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, book.getIsbn());
			ps.setString(2, book.getTitle());
			ps.setString(3,book.getCategory());
			ps.setInt(4, book.getNo_of_books());

			rows = ps.executeUpdate();


			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setString(1, book.getAuthor().getAuthorname());
			ps2.setString(2, book.getAuthor().getAuthormailid());
			ps2.setInt(3, book.getIsbn());

			rows = ps2.executeUpdate();

		}
		catch (MySQLIntegrityConstraintViolationException mse) {
			System.out.println(book.getIsbn() + "Book isbn already entered" );
			System.out.println("**Please enter another Book isbn**");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}return rows > 0;}

	}

	public void getBookbyTitle(String searchTitle)
	{
		String sql = "select b.Isbn,b.Title,b.Category,b.No_of_books,a.Authorname,a.Authormailid from book b,"
				+ "author a where Title like? and b.Isbn=a.Isbn";
		try(Connection conn = DBConnectionManager.getconnection()) 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" +searchTitle+"%");
			ResultSet rs = ps.executeQuery();

			while(rs!=null && rs.next())
			{
				int isbn = rs.getInt("Isbn");
				String title = rs.getString("Title");
				String category = rs.getString("Category");
				int no_of_books = rs.getInt("No_of_books");
				String author_name = rs.getString("Authorname");
				String author_mailid= rs.getString("Authormailid");

				System.out.println("Book ID: " +isbn +"Book_Name: " +title +"Book_category: " +category +"No_of_books: " +no_of_books 
						+"Author_Name: " +author_name +"Author_Mail_Id: " +author_mailid);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}}

	public void getBookbyCategory(String searchCategory)
	{
		String sql = "select b.Isbn,b.Title,b.Category,b.No_of_books,a.Authorname,a.Authormailid from book b,author a where Category like? and b.Isbn=a.Isbn";
		try(Connection conn = DBConnectionManager.getconnection()) 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" +searchCategory+"%");
			ResultSet rs = ps.executeQuery();

			while(rs!=null && rs.next())
			{
				int isbn = rs.getInt("Isbn");
				String title = rs.getString("Title");
				String category = rs.getString("Category");
				int no_of_books = rs.getInt("No_of_books");
				String author_name = rs.getString("Authorname");
				String author_mailid= rs.getString("Authormailid");

				System.out.println("Book ID: " +isbn +"Book_Name: " +title +"Book_category: " +category +"No_of_books: " +no_of_books 
						+"Author_Name: " +author_name +"Author_Mail_Id: " +author_mailid);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}}

	public void getBookbyAuthor(String searchAuthorname)
	{
		String sql = "select b.Isbn,b.Title,b.Category,b.No_of_books,a.Authorname,a.Authormailid from book b,author a where"
				+ " Authorname like? and b.Isbn=a.Isbn";
		try(Connection conn = DBConnectionManager.getconnection()) 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" +searchAuthorname+"%");
			ResultSet rs = ps.executeQuery();

			while(rs!=null && rs.next())
			{
				int isbn = rs.getInt("Isbn");
				String title = rs.getString("Title");
				String category = rs.getString("Category");
				int no_of_books = rs.getInt("No_of_books");
				String author_name = rs.getString("Authorname");
				String author_mailid= rs.getString("Authormailid");

				System.out.println("Book ID: " +isbn +"\n" +"Book_Name: " +title +"\n"+"Book_category: " +category +"\n" +"No_of_books: " +no_of_books +"\n" 
						+"Author_Name: " +author_name +"\n" +"Author_Mail_Id: " +author_mailid +"\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}}


	public static void getAllBooks()
	{
		String sql = "select b.Isbn,b.Title,b.Category,b.No_of_books,a.Authorname,"
				+ "a.Authormailid from book b,author a  where b.Isbn=a.Isbn";
		try(Connection conn = DBConnectionManager.getconnection();)
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs!=null && rs.next())
			{
				int isbn = rs.getInt("Isbn");
				String title = rs.getString("Title");
				String category = rs.getString("Category");
				int no_of_books = rs.getInt("No_of_books");
				String author_name = rs.getString("Authorname");
				String author_mailid= rs.getString("Authormailid");

				System.out.println("Book ID: " +isbn +"\n" +"Book_Name: " +title +"\n"+"Book_category: " +category +"\n"+"No_of_books: " +no_of_books +"\n" 
						+"Author_Name: " +author_name +"\n"+"Author_Mail_Id: " +author_mailid);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public boolean createstudent(Student student)
	{
		String sql1 = "insert into student(USN,Name) values(?,?)";
		int rows = 0;

		try(Connection conn = DBConnectionManager.getconnection();) 
		{
			PreparedStatement ps = conn.prepareStatement(sql1);
			ps.setString(1,student.getUSN());
			ps.setString(2, student.getName());

			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows>0;
	}

	public List<String>getStudentbyUSN(String searchUSN)
	{
		String sql = "select USN,Name from Student where USN = ?";
		List<String> list = new ArrayList<>();
		try(Connection conn = DBConnectionManager.getconnection();)
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, searchUSN);
			ResultSet rs = ps.executeQuery();

			while(rs!=null && rs.next())
			{
				list.add(rs.getString(1));
				list.add(rs.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean createBookIssue(Issue book_issue)
	{
		LocalDateTime localDateTime = LocalDateTime.now();
		java.sql.Date date = java.sql.Date.valueOf(localDateTime.toLocalDate());

		LocalDateTime localDateTime1 = LocalDateTime.now();
		LocalDateTime returnDate = localDateTime1.plusDays(7);
		java.sql.Date date1 = java.sql.Date.valueOf(returnDate.toLocalDate());

		String sql3 = "insert into bookissue(USN, Issued_Date,Return_Date,Isbn) values(?,?,?,?)";
		int rows =0;

		try(Connection conn = DBConnectionManager.getconnection();)
		{
			PreparedStatement ps3 = conn.prepareStatement(sql3) ;
			ps3.setString(1,book_issue.getUSN());
			ps3.setDate(2, date);
			ps3.setDate(3, date1);
			ps3.setString(4,book_issue.getIsbn());

			rows = ps3.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows>0;
	}

	public void getbookissuebyUSN(String USNsearch)
	{
		String sql = "select b.Title,s.Name,bi.Return_Date from book b,student s,bookissue bi where b.Isbn = bi.Isbn and s.USN=bi.USN and s.USN =? ";
		try(Connection conn = DBConnectionManager.getconnection();)
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, USNsearch);
			ResultSet rs = ps.executeQuery();

			while(rs!=null && rs.next())
			{
				String title = rs.getString("Title");
				String StudentName = rs.getString("Name");
				String returndate = rs.getString("Return_Date");

				System.out.println("Book_Title: " +title +"\n" +"Student_Name: " +StudentName +"\n" +"Return_Date: " +returndate);

			}
		}catch (SQLException e) {
			e.printStackTrace();
		}}

	public List<String> getBookbyIsbn(String searchIsbn)
	{
		String sql = "select b.Isbn,b.Title,b.Category,b.No_of_books from book b where b.No_of_books>0 and b.Isbn=?";
		List<String> list = new ArrayList<>();
		try(Connection conn = DBConnectionManager.getconnection();)
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, searchIsbn);
			ResultSet rs = ps.executeQuery();

			while(rs!=null && rs.next())
			{
				list.add(rs.getString(1));
				list.add(rs.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void getReturnBook()
	{
		String sql3 = "select s.Name,s.USN,b.Isbn,b.Title,bi.Return_Date from student s,book b, bookissue bi where s.USN = bi.USN and b.Isbn and bi.Return_Date=CURDATE()";

		try(Connection conn = DBConnectionManager.getconnection();) 
		{
			PreparedStatement ps3 = conn.prepareStatement(sql3);
			ResultSet rs = ps3.executeQuery();

			while(rs!=null && rs.next())
			{
				String name = rs.getString("Name");
				String usn = rs.getString("USN");
				int isbn = rs.getInt("Isbn");
				String title = rs.getString("Title");
				String returndate = rs.getString("Return_Date");

				System.out.println("Student Name: " +name +"\n" +" USN: " +usn +"\n"+"BookNo: " +isbn +"\n"
						+"BookTitle:" +title+"\n" +"ReturnDate:" +returndate);
			}
			System.out.println("No books to return for current date");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void NoOfBooksDecrement(String Bisbn)
	{
		String sql = "update book set No_of_books=No_of_books -1 where No_of_books>0 and Isbn=?";
		int rows=0;
		try(Connection conn = DBConnectionManager.getconnection();)
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Bisbn);
			rows =ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}




