package com.game.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetConnection {

//	private static String url="jdbc:mysql://127.0.0.1:3306/game";
//	private static String userName="root";
//	private static String password="Kiccha@123";

	public static Connection getConnection() {
		Connection con = null;
		Credentials cred=new Credentials();
		//String user=cred.getUser();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/game?user="+cred.getUser()+"&password="+cred.getPassword()+"");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}

		// con=DriverManager.getConnection(url,userName,password);

		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection cant Established");
		}

		return con;

	}

	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Cant close connection");
			}
		}
	}

	public static void closeConnection(PreparedStatement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Cant close connection");
			}
		}
	}

	public static void closeConnection(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Cant close connection");
			}
		}
	}

	public static void closeConnection(Statement stmt) {
		// TODO Auto-generated method stub
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Cant close connection");
			}
		}
	}
}
