package quizboard.server.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadConnection extends Thread{
	private Socket socket;
	private boolean isActive;
	private QuizController quizController;
	
	public ThreadConnection(Socket socket, QuizController quizController) {
		this.quizController = quizController;
		this.socket = socket;
		this.isActive = true;
	}
	
	public void sendMsgToClient(String msg)
	{
		try {
			DataOutputStream dOP = new DataOutputStream(this.socket.getOutputStream());
			dOP.writeUTF(msg);
			dOP.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void analyseInput(String input) {
		
		
		String input_type = input.split("@@@")[0];
		
		if(input_type.equals("checkOpen")) {
			if(quizController.isAcceptConnection()) {
				//checkOpen@@@KhanhLy###1005
				String userName = input.split("@@@")[1].split("###")[0];
				String value = input.split("@@@")[1].split("###")[1];
	
				if(value.equals(quizController.getQuiz().getID()) && this.quizController.insertNewPlayer(userName, this)) {
					System.out.println("isOpened@@@");
					sendMsgToClient("isOpened@@@");
				} else {
					isActive = false;
				}
			} else {
				isActive = false;
			}
		}
		if(input_type.equals("answerQuestion")) {
			String userName = input.split("@@@")[1].split("###")[0];
			int answerID = Integer.parseInt(input.split("@@@")[1].split("###")[1]);
			quizController.checkClientAnswer(userName, answerID);
		}
	}
	
	public void run() {
		try {
			DataInputStream dIP = new DataInputStream(this.socket.getInputStream());			
			while(isActive)
			{
				while(dIP.available()==0)
				{
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				String ComingText=dIP.readUTF();
				analyseInput(ComingText);
				System.out.println(ComingText);
			}
			dIP.close();
			if(!this.socket.isClosed()) this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
