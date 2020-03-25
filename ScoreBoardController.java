package quizboard.server.controller;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;

import quizboard.model.Player;
import quizboard.server.frmScoreBoard;

public class ScoreBoardController {
	private QuizController quizController;
	private frmScoreBoard view;

	public ScoreBoardController(QuizController quizController)
	{
		this.quizController = quizController;
		this.view = new frmScoreBoard();
		clearScoreBoard();
		initView();
	}
	
	public void initView()
	{
		view.getFrame().setVisible(true);
	}
	
	public void insertNewPlayer(String str) {
		view.addPlayer(str);
		view.getPanel().revalidate();
	}
	
	public void clearScoreBoard() {
		for(Component component : view.getPanel().getComponents())
		{
			view.getPanel().remove(component);
		}
		
		view.getPanel().revalidate();
		view.getPanel().repaint();
	}
	
	public void updatePlayerScoreBoard(ArrayList<Player> players) {
		clearScoreBoard();
		Collections.sort(players);
		for(Player player : players) {
			insertNewPlayer(player.getUserName()+" - "+player.getScore());
		}
	}
	
	public void init()
	{
		view.getBtnStart().addActionListener(e -> quizController.loadQuestion());
	}
	
	public void hideStartButton()
	{
		view.getBtnStart().setVisible(false);
	}

}
