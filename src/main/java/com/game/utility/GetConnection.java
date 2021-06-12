package com.game.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetConnection {

	public static Connection getConnection() {
		Connection con = null;
		Credentials cred=new Credentials();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/game?user="+cred.getUser()+"&password="+cred.getPassword()+"");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		catch (SQLException e) {
			System.out.println("Connection cant Established");
		}
		return con;
	}

	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Cant close connection");
			}
		}
	}

	public static void closeConnection(PreparedStatement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				System.out.println("Cant close connection");
			}
		}
	}

	public static void closeConnection(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("Cant close connection");
			}
		}
	}

	public static void closeConnection(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Cant close connection");
			}
		}
	}
}
