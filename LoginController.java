package quizboard.server.controller;

import static javax.swing.JOptionPane.showMessageDialog;

import java.sql.SQLException;

import quizboard.model.Quiz;
import quizboard.model.User;
import quizboard.server.frmLogin;
import quizboard.service.Password;

public class LoginController {
	private frmLogin view;
	
	public LoginController()
	{
		this.view = new frmLogin();
		initView();
	}
	
	public void initView()
	{
		view.getTxtEmail().setText("khanhsly22@gmail.com");
		view.getTxtSignUpEmail().setText("Email");
		view.getTxtSignUpName().setText("Name");
		view.getTxtPassword().setText("1412");
		view.getTxtSignUpPassword().setText("Password");
		view.getTxtQuizID().setText("QUIZ ID");
		
		view.getFrame().setVisible(true);
	}
	
	public void init(){
		view.getBtnSignIn().addActionListener(e -> login());
		view.getBtnSignUp().addActionListener(e -> signup());
		view.getBtnStart().addActionListener(e -> {
			try {
				start();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	public void signup() {
		User user = User.create(new User(view.getTxtSignUpEmail().getText(), Password.toMD5( new String(view.getTxtSignUpPassword().getPassword() ) ), view.getTxtSignUpName().getText() ) );
		if(user!=null) {
			showMessageDialog(null, "Create Successfully");
//			new frmQuiz().setVisible(true);
//			view.getFrame().dispose();
		}
		else {
			showMessageDialog(null, "Error occured! Please try again later!");
		}
	}
	
	public void start() throws SQLException{
		if(!view.getTxtQuizID().getText().isBlank()) {
			Quiz quiz = Quiz.get(view.getTxtQuizID().getText());
			if(quiz != null) {
				QuizController quizController = new QuizController(quiz);
				quizController.init();
				view.getFrame().dispose();
			} else {
				showMessageDialog(null, "Can not find Quiz with your Quiz ID!");
			}
		} else {
			showMessageDialog(null, "Please input the Quiz ID!");
		}
	}
	
	public void login()
	{
		User user = User.checkLogin(new User(view.getTxtEmail().getText(), Password.toMD5( new String(view.getTxtPassword().getPassword()))));
		if(user!=null) {
			IndexController indexController = new IndexController(user);
			indexController.init();
			this.view.getFrame().dispose();
		}
		else {
			showMessageDialog(null, "Your email or password is not correct!");
		}
	}
}
