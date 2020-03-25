package quizboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import quizboard.model.User;

public class UserDAO {
	public static User checkLogin(User user) throws SQLException
	{
		Connection conn = DatabaseConnection.getConnection();
		
		String query = "SELECT id,name FROM users WHERE email=? AND password=? LIMIT 1";
		
		PreparedStatement pstm = conn.prepareStatement(query);
				
		pstm.setString(1, user.getEmail());
		pstm.setString(2, user.getPassword());
		
		ResultSet rs = pstm.executeQuery();
		
		if(rs.next()) {
			user.setID(rs.getInt("id"));
			user.setName(rs.getString("name"));
			return user;
		}
		return null;
	}
	
	public static User get(int id) throws SQLException
	{
		Connection conn = DatabaseConnection.getConnection();
		
		String query = "SELECT * FROM users WHERE id=? LIMIT 1";
		
		PreparedStatement pstm = conn.prepareStatement(query);
		
		pstm.setInt(1, id);
		
		ResultSet rs = pstm.executeQuery();
		
		if(rs.next()) {
			return new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("name"));
		}
		
		return null;

	}
	
	public static User create(User user) throws SQLException
	{
		Connection conn = DatabaseConnection.getConnection();
		
		String query = "INSERT INTO users (email,password,name) VALUES (?,?,?)";
		
		PreparedStatement pstm = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		pstm.setString(1, user.getEmail());
		pstm.setString(2, user.getPassword());
		pstm.setString(3, user.getName());
		
		int affectedRows = pstm.executeUpdate();
		if(affectedRows == 0) return null;
		
		ResultSet rs = pstm.getGeneratedKeys();
		if(rs.next()) {
			user.setID(rs.getInt(1));
			return user;
		}		
		return null;
	}
}
