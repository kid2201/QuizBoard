package quizboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import quizboard.model.Answer;
import quizboard.model.Question;

public class QuestionDAO {
	public static Question get(int questionID) throws SQLException
	{
		Connection conn = DatabaseConnection.getConnection();
		
		String query = "SELECT * FROM questions WHERE id=?";
		
		PreparedStatement pstm = conn.prepareStatement(query);
		
		pstm.setInt(1, questionID);
		
		ResultSet rs = pstm.executeQuery();
		
		if(rs.next()) {
			return new Question(rs.getInt("id"), 
								rs.getString("quiz_ID"), 
								rs.getString("question"), 
								rs.getInt("questionTime"), 
								rs.getInt("answerTime"), 
								rs.getFloat("score"),
								Answer.getByQuestion(rs.getInt("id")));
		}
		
		return null;
	}
	
	public static ArrayList<Question> getByQuiz(String quizID) throws SQLException{
		Connection conn = DatabaseConnection.getConnection();
		
		ArrayList<Question> result = new ArrayList<Question>();
		
		String query = "SELECT id FROM questions WHERE quiz_ID=?";
		
		PreparedStatement pstm = conn.prepareStatement(query);
		
		pstm.setString(1, quizID);
		
		ResultSet rs = pstm.executeQuery();
		
		while(rs.next()) {
			result.add(get(rs.getInt("id")));
		}
		
		return result;
	}
	
	public static Question create(Question question) throws SQLException
	{
		Connection conn = DatabaseConnection.getConnection();
		
		String query = "INSERT INTO questions (quiz_ID,question,questionTime,answerTime, score) VALUES (?,?,?,?,?)";
		
		PreparedStatement pstm = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		pstm.setString(1, question.getQuiz_ID());
		pstm.setString(2, question.getQuestion());
		pstm.setInt(3, question.getQuestionTime());
		pstm.setInt(4, question.getAnswerTime());
		pstm.setFloat(5, question.getScore());
		
		int affectedRows = pstm.executeUpdate();
		if(affectedRows == 0) return null;
		
		ResultSet rs = pstm.getGeneratedKeys();
		if(rs.next()) {
			question.setID(rs.getInt(1));
			return question;
		}		
		return null;
	}

}
