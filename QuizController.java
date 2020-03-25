package quizboard.server.controller;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.Timer;

import quizboard.model.Answer;
import quizboard.model.Player;
import quizboard.model.Question;
import quizboard.model.Quiz;
import quizboard.server.frmQuiz;

public class QuizController {
	private frmQuiz view;
	private ScoreBoardController scoreBoardController;
	private Quiz quiz;
	private ArrayList<Question> question;
	private int current_question_id;
	private Timer timer;
	private ServerSocket serverSocket;
	private ThreadAcceptConnection threadAcceptConnection;
	private boolean acceptConnection;
	private HashMap<Integer,Integer> answerReport;

	private ArrayList<Player> threadConnections;
	
	public ArrayList<Player> getThreadConnections() {
		return threadConnections;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public void setThreadConnections(ArrayList<Player> threadConnections) {
		this.threadConnections = threadConnections;
	}
	
	public boolean insertNewPlayer(String username,ThreadConnection thread)
	{
		Player p = new Player(username, thread, 0);
		if(!threadConnections.contains(p)) {
			threadConnections.add(p);
			System.out.println("Add user: "+username);
			this.scoreBoardController.insertNewPlayer(username+" - 0");
			return true;
		}
		return false;
	}

	public QuizController(Quiz quiz)
	{
		try {
			acceptConnection = true;
			threadConnections = new ArrayList<Player>();
			serverSocket = new ServerSocket(3333);
			threadAcceptConnection = new ThreadAcceptConnection(serverSocket,this);
			threadAcceptConnection.start();
			view = new frmQuiz();
			this.scoreBoardController = new ScoreBoardController(this);
			this.scoreBoardController.init();
			this.quiz = quiz;
			this.current_question_id = 0;
			if(this.quiz!= null) {
				question = this.quiz.getQuestions();
			}
			initView();

		} catch(IOException e) {
			showMessageDialog(null, e.getMessage());
		}
	}
	
	public void initView()
	{
//		loadQuestion();
		view.getFrame().setVisible(true);
		view.getLblQuestionHere().setText("Waiting For All Connections Ready...");
	}
	
	public void clearAnswerPanel()
	{
		for(Component component : view.getPanel_1().getComponents())
		{
			view.getPanel_1().remove(component);
		}
		
		view.getPanel_1().revalidate();
		view.getPanel_1().repaint();
	}
	
	public void showRightAnswer()
	{
		stopTimer();
		sendMsgToAllConnections("skipQuestion@@@");
		
		ArrayList<Answer> lst_answer = question.get(current_question_id).getAnswers();
		for(int i=0; i<lst_answer.size(); i++) {
			JButton btnAnswer = (JButton)(view.getPanel_1().getComponent(i));
			float selectedRate = ((float)answerReport.getOrDefault(lst_answer.get(i).getID(),0)/(float)threadConnections.size()) * 100;
			btnAnswer.setText(btnAnswer.getText()+" - "+String.format("%.2f", selectedRate)+"%");
			if(lst_answer.get(i).isAnswer()) {
				btnAnswer.setText(btnAnswer.getText()+" \u2713");
			}
		}
		
		scoreBoardController.updatePlayerScoreBoard(threadConnections);
		
		view.getBtnNextQuestion().setText("Next Question");
		view.getBtnNextQuestion().removeActionListener(view.getBtnNextQuestion().getActionListeners()[0]);
		view.getBtnNextQuestion().addActionListener(e -> nextQuestion());
	}
	
	public void loadAnswer()
	{
		view.getBtnNextQuestion().setVisible(true);
		view.getBtnNextQuestion().setText("Skip To Result");
		if(view.getBtnNextQuestion().getActionListeners().length>0) view.getBtnNextQuestion().removeActionListener(view.getBtnNextQuestion().getActionListeners()[0]);
		view.getBtnNextQuestion().addActionListener(e -> showRightAnswer());
		
		sendMsgToAllConnections("answerStart@@@"+question.get(current_question_id).getID()+"###"+question.get(current_question_id).getAnswerTime());

		timer = new Timer(1000, new ActionListener() {
			int count = question.get(current_question_id).getAnswerTime();
			@Override
			public void actionPerformed(ActionEvent e) {
				if(count >= 0) {
					view.getLblTime().setText("Time: "+count+"s");;
				} else {
					((Timer) (e.getSource())).stop();
					showRightAnswer();
				}
				count--;
			}
			
		});
		
		for(Answer answer : question.get(current_question_id).getAnswers()) {
			sendMsgToAllConnections("addAnswer@@@"+answer.getQuestion_ID()+"###"+answer.getID()+"###"+answer.getAnswer()+"###"+answer.isAnswer());
			JButton btnAnswer = view.addAnswer(answer);
//			btnAnswer.addActionListener(e -> answerClicked(answer));
		}
		
		timer.setInitialDelay(0);
		timer.start();

	}
	
	public void nextQuestion()
	{
		if(current_question_id < question.size()-1)
		{
			current_question_id++;
			loadQuestion();
		} else{
			showMessageDialog(null, "End!");
		}
	}
	
	public void answerClicked(Answer answer) {
		if(answer.isAnswer()) {
			showMessageDialog(null, "Yes!!!");
		} else {
			showMessageDialog(null, "No...");
		}
	}
	
	public void stopTimer() {
		if(timer!=null && timer.isRunning()) {
			timer.stop();
		}
	}
	
	public void loadQuestion()
	{
		answerReport = new HashMap<Integer,Integer>();
		if(current_question_id == 0) {
			scoreBoardController.hideStartButton();
			acceptConnection = false;
		}
		clearAnswerPanel();
		Question current_question = question.get(current_question_id);
		view.getBtnNextQuestion().setVisible(false);
		view.getLblQuestionHere().setText(current_question.getQuestion());
		sendMsgToAllConnections("questionStart@@@"+current_question.getID()+"###"+current_question.getQuestionTime());
		timer = new Timer(1000, new ActionListener() {
			int count = current_question.getQuestionTime();
			@Override
			public void actionPerformed(ActionEvent e) {
				if(count >= 0) {
					view.getLblTime().setText("Time: "+count+"s");;
				} else {
					((Timer) (e.getSource())).stop();
					loadAnswer();
				}
				count--;
			}
			
		});
		timer.setInitialDelay(0);
		timer.start();
	}
	
	public boolean isAcceptConnection() {
		return acceptConnection;
	}

	public void setAcceptConnection(boolean acceptConnection) {
		this.acceptConnection = acceptConnection;
	}

	public void init()
	{
	}
	
	public void sendMsgToConnection(ThreadConnection thread, String msg) {
		thread.sendMsgToClient(msg);
	}
	
	public void sendMsgToAllConnections(String msg) {
		for(Player player : threadConnections) {
			sendMsgToConnection(player.getThreadConnection(),msg);
		}
	}
		
	public void checkClientAnswer(String username, int answerID) {
		for(int i=0; i<threadConnections.size();i++)
		{
			if(threadConnections.get(i).getUserName().equals(username) && question.get(current_question_id).getAnswer(answerID).isAnswer()) {
				threadConnections.get(i).setScore(threadConnections.get(i).getScore()+question.get(current_question_id).getScore());
			}
		}
		answerReport.put(answerID, answerReport.getOrDefault(answerID, 0)+1);
	}
}