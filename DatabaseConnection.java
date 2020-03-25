package quizboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	private static String DB_URL = "jdbc:mysql://localhost:3306/quizboard?useSSL=false";
	private static String USER_NAME = "root";
	private static String PASSWORD = "";

	public static void main(String[] args) {
		getConnection(DB_URL, USER_NAME, PASSWORD);
	}
	
	public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
//            System.out.println("Connect to Database successfully!");
        } catch (Exception ex) {
//            System.out.println("Database connection failure!");
            ex.printStackTrace();
        }
        return conn;
	}
	
	public static Connection getConnection(String dbURL, String userName, 
            String password) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("Connect to Database successfully!");
        } catch (Exception ex) {
            System.out.println("Database connection failure!");
            ex.printStackTrace();
        }
        return conn;
	}
}
