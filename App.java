package quizboard.server;

import quizboard.server.controller.LoginController;

public class App {

	public static void main(String[] args) {
		LoginController controller = new LoginController();
		controller.init();
	}

}
