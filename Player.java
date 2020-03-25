package quizboard.model;

import quizboard.server.controller.ThreadConnection;

public class Player implements Comparable<Player>{
	private String userName;
	private ThreadConnection threadConnection;
	private float score;
	public Player(String userName, ThreadConnection threadConnection, int score) {
		this.userName = userName;
		this.threadConnection = threadConnection;
		this.score = score;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public ThreadConnection getThreadConnection() {
		return threadConnection;
	}
	public void setThreadConnection(ThreadConnection threadConnection) {
		this.threadConnection = threadConnection;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	@Override
	public int compareTo(Player p) {
		return (this.getScore()>p.getScore()?-1:(this.getScore()==p.getScore()?0:1));
	}
	@Override
	public boolean equals(Object obj) {
		Player p = (Player) obj;
		return this.getUserName().equals(p.getUserName());
	}
	
}
