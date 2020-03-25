package quizboard.model;

import java.sql.SQLException;
import java.util.ArrayList;

import quizboard.dao.AnswerDAO;
import quizboard.dao.QuestionDAO;

public class Answer {
	private int ID;
	private int question_ID;
	private String answer;
	private boolean isAnswer;
	
	public Answer(int question_ID, String answer, boolean isAnswer) {
		this.question_ID = question_ID;
		this.answer = answer;
		this.isAnswer = isAnswer;
	}
	
	public Answer(int iD, int question_ID, String answer, boolean isAnswer) {
		ID = iD;
		this.question_ID = question_ID;
		this.answer = answer;
		this.isAnswer = isAnswer;
	}
	
	public int getID() {
		return ID;
	}
	public Answer setID(int iD) {
		ID = iD;
		return this;
	}
	public int getQuestion_ID() {
		return question_ID;
	}
	public Answer setQuestion_ID(int question_ID) {
		this.question_ID = question_ID;
		return this;
	}
	public String getAnswer() {
		return answer;
	}
	public Answer setAnswer(String answer) {
		this.answer = answer;
		return this;
	}
	public boolean isAnswer() {
		return isAnswer;
	}
	public Answer setAnswer(boolean isAnswer) {
		this.isAnswer = isAnswer;
		return this;
	}
	
	public Question getQuestion() throws SQLException{
		return QuestionDAO.get(this.question_ID);
	}
	
	public static ArrayList<Answer> getByQuestion(int questionID) throws SQLException{
		return AnswerDAO.getByQuestion(questionID);
	}
}
