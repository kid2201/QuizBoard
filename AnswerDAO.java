package quizboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import quizboard.model.Answer;

public class AnswerDAO {
	public static Answer get(int answerID) throws SQLException{
		Connection conn = DatabaseConnection.getConnection();
		
		String query = "SELECT * FROM answers WHERE id=?";
		
		PreparedStatement pstm = conn.prepareStatement(query);
		
		pstm.setInt(1, answerID);
		
		ResultSet rs = pstm.executeQuery();
		
		if(rs.next()) {
			return new Answer(rs.getInt("id"), rs.getInt("question_ID"), rs.getString("answer"), rs.getBoolean("isAnswer"));
		}
		
		return null;
	}
	
	public static ArrayList<Answer> getByQuestion(int questionID) throws SQLException{
		Connection conn = DatabaseConnection.getConnection();
		ArrayList<Answer> result = new ArrayList<Answer>();
		
		String query = "SELECT id FROM answers WHERE question_id=?";
		
		PreparedStatement pstm = conn.prepareStatement(query);
		
		pstm.setInt(1, questionID);
		
		ResultSet rs = pstm.executeQuery();
		
		while(rs.next()) {
			result.add(get(rs.getInt("id")));
		}
		
		return result;
	}
}
