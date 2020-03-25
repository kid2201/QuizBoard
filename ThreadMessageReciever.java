package quizboard.client.controller;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadMessageReciever extends Thread{
	private boolean isActive;
	private DataInputStream dIP;
	private Socket socket;
	private IndexController indexController;
	private QuizController quizController;
	private String userName;
	
	public ThreadMessageReciever(String userName, Socket socket, IndexController indexController)
	{
		isActive = true;
		this.userName = userName;
		this.socket = socket;
		this.indexController = indexController;
	}
	
	public void analyseInput(String input) {
		if(!input.isEmpty()) {
			String input_type = input.split("@@@")[0];

			if(input_type.equals("isOpened")) {
				indexController.stopTimer();
				quizController = new QuizController(userName, socket);
				quizController.initView();
				quizController.init();
			}
			
			if(input_type.equals("questionStart")) {
				int question_ID = Integer.parseInt(input.split("@@@")[1].split("###")[0]);
				int value = Integer.parseInt(input.split("@@@")[1].split("###")[1]);
				quizController.setCurrentQuestionID(question_ID);
				quizController.setQuestionTime(value);
			}
			
			if(input_type.equals("answerStart")) {
				int question_ID = Integer.parseInt(input.split("@@@")[1].split("###")[0]);
				int value = Integer.parseInt(input.split("@@@")[1].split("###")[1]);
				quizController.setCurrentQuestionID(question_ID);
				quizController.setAnswerTime(value);
			}
			
			if(input_type.equals("addAnswer")) {
				int question_ID = Integer.parseInt(input.split("@@@")[1].split("###")[0]);
				int answer_ID = Integer.parseInt(input.split("@@@")[1].split("###")[1]);
				String answer = input.split("@@@")[1].split("###")[2];
				boolean isAnswer = Boolean.parseBoolean(input.split("@@@")[1].split("###")[3]);
				quizController.addAnswer(answer_ID, question_ID, answer, isAnswer);
			}
			if(input_type.equals("skipQuestion")) {
				quizController.stopTimer();
			}
		}

	}
	
	public void run() {
		try {
			dIP=new DataInputStream(socket.getInputStream());
			while(isActive)
			{
				try {
					while(dIP.available()==0)
					{
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					String msg = dIP.readUTF();
					System.out.println(msg);
					analyseInput(msg);
				} catch (IOException e) {
					e.printStackTrace();
					try {
						dIP.close();
						socket.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}	
			}
		} catch (IOException e) {
			e.printStackTrace();
			try {
				dIP.close();
				socket.close();
			} catch (IOException x) {
				// TODO Auto-generated catch block
				x.printStackTrace();
			}
		}
	}
}
