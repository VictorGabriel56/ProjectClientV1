package br.com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crudclient","root","");
			return con;
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("Error!");
			
		}
		 return null;		
	}
	
	
	public static void closeConnection(Connection con)	throws SQLException{
		if(con != null) {
			con.close();
		}
	}
	
	
	public static void closeConnection(Connection con, Statement stmt)	throws SQLException{
		if(stmt != null) {
			stmt.close();
		}
	}
	
	
	public static void closeConnection(Connection con, Statement stmt, ResultSet rs)	throws SQLException{
		if(rs != null) {
			rs.close();
		}
	}	
}
