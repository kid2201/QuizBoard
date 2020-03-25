package quizboard.model;

import java.sql.SQLException;
import java.util.ArrayList;

import quizboard.dao.QuestionDAO;

public class Question {
	private int ID;
	private String quiz_ID;
	
	private String question;
	private int questionTime;
	private int answerTime;
	private float score;
	private ArrayList<Answer> answers;
	
	public Question(String quiz_ID, String question, int questionTime, int answerTime, float score, ArrayList<Answer> answers)
	{
		this.quiz_ID = quiz_ID;
		this.question = question;
		this.questionTime = questionTime;
		this.answerTime = answerTime;
		this.score = score;
		this.answers = answers;
	}

	public Question(String quiz_ID, String question, int questionTime, int answerTime, float score)
	{
		this.quiz_ID = quiz_ID;
		this.question = question;
		this.questionTime = questionTime;
		this.answerTime = answerTime;
		this.score = score;
		this.answers = new ArrayList<Answer>();
	}
	
	public Question(String question, int questionTime, int answerTime, float score)
	{
		this.question = question;
		this.questionTime = questionTime;
		this.answerTime = answerTime;
		this.score = score;
		this.answers = new ArrayList<Answer>();
	}

	
	public Question(int ID, String quiz_ID, String question, int questionTime, int answerTime, float score)
	{
		this.ID = ID;
		this.quiz_ID = quiz_ID;
		this.question = question;
		this.questionTime = questionTime;
		this.answerTime = answerTime;
		this.score = score;
		this.answers = new ArrayList<Answer>();
	}
	
	public Question(int ID, String quiz_ID, String question, int questionTime, int answerTime, float score, ArrayList<Answer> answers)
	{
		this.ID = ID;
		this.quiz_ID = quiz_ID;
		this.question = question;
		this.questionTime = questionTime;
		this.answerTime = answerTime;
		this.score = score;
		this.answers = answers;
	}
	
	public String getQuiz_ID() {
		return quiz_ID;
	}

	public void setQuiz_ID(String quiz_ID) {
		this.quiz_ID = quiz_ID;
	}

	public int getID() {
		return ID;
	}

	public Question setID(int iD) {
		ID = iD;
		return this;
	}

	public String getQuestion() {
		return question;
	}

	public Question setQuestion(String question) {
		this.question = question;
		return this;
	}

	public int getQuestionTime() {
		return questionTime;
	}

	public Question setQuestionTime(int questionTime) {
		this.questionTime = questionTime;
		return this;
	}

	public int getAnswerTime() {
		return answerTime;
	}

	public Question setAnswerTime(int answerTime) {
		this.answerTime = answerTime;
		return this;
	}

	public float getScore() {
		return score;
	}

	public Question setScore(float score) {
		this.score = score;
		return this;
	}

	public ArrayList<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<Answer> answers) {
		this.answers = answers;
	}
	
	public static Question get(int ID) throws SQLException
	{
		return QuestionDAO.get(ID);
	}	
	
	public Answer getAnswer(int answerID)
	{
		for(Answer answer : answers) {
			if (answer.getID()==answerID) return answer;
		}
		return null;
	}
	
	public static Question create(Question q) {
		try {
			return QuestionDAO.create(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
