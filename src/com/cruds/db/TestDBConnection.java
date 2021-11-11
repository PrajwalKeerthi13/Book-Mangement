package com.cruds.db;

import java.sql.Connection;

public class TestDBConnection {

	public static void main(String[] args) {
Connection conn = DBConnectionManager.getconnection();
		
		if(conn != null)
		{
			System.out.println("Connection Successful");
		}

	}

}
