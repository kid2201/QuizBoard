package quizboard.model;

import java.sql.SQLException;
import java.util.ArrayList;

import quizboard.dao.QuizDAO;
import quizboard.dao.UserDAO;

public class User {
	private int ID;
	private String email;
	private String password;
	private String name;
	private ArrayList<Quiz> quiz;
	
	public User(String email, String password)
	{
		this.email = email;
		this.password = password;
		this.quiz = new ArrayList<Quiz>();
	}
	
	public User(String email, String password, String name)
	{
		this.email = email;
		this.password = password;
		this.name = name;
		this.quiz = new ArrayList<Quiz>();
	}
	
	public User(int ID, String email, String password, String name)
	{
		this.ID = ID;
		this.email = email;
		this.password = password;
		this.name = name;
		this.quiz = new ArrayList<Quiz>();
	}
	
	public User(int ID, String email, String password, String name, ArrayList<Quiz> quiz)
	{
		this.ID = ID;
		this.email = email;
		this.password = password;
		this.name = name;
		this.quiz = quiz;
	}
	
	public int getID()
	{
		return this.ID;
	}
	
	public User setID(int ID)
	{
		this.ID = ID;
		return this;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public User setEmail(String email)
	{
		this.email = email;
		return this;
	}
	
	public User setPassword(String password)
	{
		this.password = password;
		return this;
	}
	
	public User setName(String name)
	{
		this.name = name;
		return this;
	}

	public User setQuiz(ArrayList<Quiz> quiz) {
		this.quiz = quiz;
		return this;
	}
	
	public static User checkLogin(User user)
	{
		try {
			return UserDAO.checkLogin(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static User create(User user)
	{
		try {
			return UserDAO.create(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Quiz> getQuiz(){
		if(this.quiz.size()==0)
			try {
				this.quiz = QuizDAO.getByUser(this.ID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return quiz;
	}

}
