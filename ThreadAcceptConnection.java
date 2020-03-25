package quizboard.server.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import static javax.swing.JOptionPane.showMessageDialog;

public class ThreadAcceptConnection extends Thread{
	private QuizController quizController;
	private ServerSocket serverSocket;
	
	public ThreadAcceptConnection(ServerSocket serverSocket, QuizController quizController) {
		this.serverSocket = serverSocket;
		this.quizController = quizController;
	}
	
	public void run()
	{
		try {
			while(quizController.isAcceptConnection()) {
				Socket s = this.serverSocket.accept();
				ThreadConnection thread = new ThreadConnection(s, this.quizController);
				thread.start();
			}
			System.out.println("Stop accepting new connection");
		} catch(IOException e) {
			showMessageDialog(null,e.getMessage());
		}
	}
}
