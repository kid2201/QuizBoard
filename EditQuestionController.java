package quizboard.server.controller;

import quizboard.model.Question;
import quizboard.server.frmEditQuestion;

public class EditQuestionController {
	private frmEditQuestion view;
	private IndexController indexController;
	private Question question;
	
	public EditQuestionController(IndexController indexController) {
		view = new frmEditQuestion();
		this.indexController = indexController;
		question = null;
		initView();
	}
	
	public EditQuestionController(IndexController indexController, Question question) {
		view = new frmEditQuestion();
		this.indexController = indexController;
		this.question = question;
		initView();
	}
	
	public void initView() {
		view.getFrame().setVisible(true);
	} 
	
	public void create() {
//		indexController.createQuestion(new Question(
//				 view.getTxtQuestion().getText(), 
//				 Integer.parseInt(view.getTxtQTime().getText()), 
//				 Integer.parseInt(view.getTxtAnsTime().getText()), 
//				 Float.parseFloat(view.getTxtScore().getText())
//		));
	}
	
	public void update() {
		indexController.updateQuestion(question);
	}
		
	public void init() {
//		if(question == null) {
			view.getBtnOK().addActionListener(e -> create());
//		} else {
//			view.getBtnOK().addActionListener(e -> update());
//		}
	}
}
