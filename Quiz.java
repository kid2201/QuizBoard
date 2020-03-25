package quizboard.model;

import java.sql.SQLException;
import java.util.ArrayList;

import quizboard.dao.QuestionDAO;
import quizboard.dao.QuizDAO;

public class Quiz {
	private String ID;
	private int user_ID;
	private ArrayList<Question> questions;
	
	public Quiz(String iD, int user_ID, ArrayList<Question> questions) {
		ID = iD;
		this.user_ID = user_ID;
		this.questions = questions;
	}
	
	public Quiz(int user_ID, ArrayList<Question> questions) {
		this.user_ID = user_ID;
		this.questions = questions;
	}
	
	public static Quiz get(String ID)
	{
		try {
			return QuizDAO.get(ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public int getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}

	public ArrayList<Question> getQuestions() {
		if(this.questions.size() == 0)
		{
			try {
				this.questions = QuestionDAO.getByQuiz(this.ID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}

}
