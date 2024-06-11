package com.example.Web_Book.DAO;

import java.sql.DriverManager;

public class SQLConnection {
	public static void main(String[] args) {
		SQLConnection con = new SQLConnection();
		System.out.println(con.getConnection());
	}

	public java.sql.Connection getConnection() {
		java.sql.Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName=PTHTTTQL; user=sa; password=1; encrypt=false;");
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}
}
