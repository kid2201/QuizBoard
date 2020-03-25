package quizboard.server.controller;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import quizboard.model.Question;
import quizboard.model.Quiz;
import quizboard.model.User;
import quizboard.server.frmIndex;
import static javax.swing.JOptionPane.showMessageDialog;

public class IndexController {
	private frmIndex view;
	private User user;
	private String selectedQuizID;
	
	public IndexController(User user)
	{
		this.view = new frmIndex();
		this.user = user;
		this.selectedQuizID = "";
		initView();
	}
	
	public void initView() {
		loadQuizTable();
		view.getFrame().setVisible(true);
	}
	
	public void clearTable(JTable table) {
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
	}
	
	public void loadQuizTable() {
		DefaultTableModel dtm = (DefaultTableModel)view.getTableQuiz().getModel();
		clearTable(view.getTableQuiz());

		for(Quiz quiz : user.getQuiz()) {
			String[] data = {quiz.getID()};
			dtm.addRow(data);
		}
	}
	
	public void loadQuestionTable() {
		DefaultTableModel dtm = (DefaultTableModel)view.getTableQuestion().getModel();
		clearTable(view.getTableQuestion());

		Quiz quiz = Quiz.get(selectedQuizID);
		for(Question question : quiz.getQuestions()) {
			String[] data = {Integer.toString(question.getID()), question.getQuestion()};
			dtm.addRow(data);
		}
	}
	
	public void tableQuizSelected() {
		selectedQuizID = (String)view.getTableQuiz().getValueAt(view.getTableQuiz().getSelectedRow(), 0);
		loadQuestionTable();
	}
	
	public void createQuestion(Question q) {
		q.setQuiz_ID(selectedQuizID);
		q = Question.create(q);
		if(q != null) {
			showMessageDialog(null, "Success!");
		} else {
			showMessageDialog(null, "Please try again later!");
		}
	}
	
	public void updateQuestion(Question q) {
		
	}
	
	public void newQuestion() {
		if(!selectedQuizID.isEmpty()) {
			EditQuestionController x = new EditQuestionController(this);
			x.init();
		} else {
			showMessageDialog(null, "Please select Quiz first!");
		}
	}
	
	public void init() {
		view.getTableQuiz().getSelectionModel().addListSelectionListener(e -> tableQuizSelected());
		view.getBtnAddQuestion().addActionListener(e -> newQuestion());
	}

}
