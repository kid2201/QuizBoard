package quizboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import quizboard.model.Question;
import quizboard.model.Quiz;

public class QuizDAO {
	public static Quiz get(String quizID) throws SQLException{
		Connection conn = DatabaseConnection.getConnection();
		
		String query = "SELECT * FROM quizzes WHERE id=?";
		
		PreparedStatement pstm = conn.prepareStatement(query);
		
		pstm.setString(1, quizID);
				
		ResultSet rs = pstm.executeQuery();
		
		if(rs.next()) {
			return new Quiz(	rs.getString("id"), 
								rs.getInt("user_ID"),
								QuestionDAO.getByQuiz(rs.getString("id")));
		}
		
		return null;
	}
	
	public static void main(String[] args) {
//		try {
//			Quiz quiz = get("NTN1005");
//			for(Question question : quiz.getQuestions()) {
//				System.out.println(question.getQuestion());
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}
	
	public static ArrayList<Quiz> getByUser(int user_ID) throws SQLException{
		Connection conn = DatabaseConnection.getConnection();
		
		ArrayList<Quiz> result = new ArrayList<Quiz>();
		
		String query = "SELECT id FROM quizzes WHERE user_ID=?";
		
		PreparedStatement pstm = conn.prepareStatement(query);
		
		pstm.setInt(1, user_ID);
		
		ResultSet rs = pstm.executeQuery();
		
		while(rs.next()) {
			result.add(get(rs.getString("id")));
		}
		
		return result;

	}
}
