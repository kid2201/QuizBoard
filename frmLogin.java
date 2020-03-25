package quizboard.server;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.border.EtchedBorder;

public class frmLogin{

	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtSignUpEmail;
	private JTextField txtSignUpName;
	private JTextField txtQuizID;
	private JPasswordField txtPassword;
	private JPasswordField txtSignUpPassword;
	private JButton btnSignIn;
	private JButton btnSignUp;
	private JButton btnStart;

	/**
	 * Create the frame.
	 */
	public frmLogin() {
		//--------- MAIN PANEL ----------
		contentPane = new JPanel();
		contentPane.setBackground(new Color(75, 56, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		//--------- MAIN PANEL ----------
		
		//--------- INIT FRAME ----------
		frame = new JFrame("Quiz Board");		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 642, 326);
		frame.setLocationRelativeTo(null);
		frame.setContentPane(contentPane);
		//--------- INIT FRAME ----------
		
		//--------- LABEL TITLE ---------
		JLabel lblQuizBoard = new JLabel("QUIZ BOARD");
		lblQuizBoard.setForeground(new Color(255, 255, 255));
		lblQuizBoard.setFont(new Font("Helvetica", Font.PLAIN, 20));
		lblQuizBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuizBoard.setBounds(251, 10, 130, 33);
		contentPane.add(lblQuizBoard);
		//--------- LABEL TITLE ---------
		
		//------- Panel LOGIN -----------
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(54, 55, 255, 155);
		panel.setBackground(new Color(75, 56, 210));
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblLogin);

		txtEmail = new JTextField();
		panel.add(txtEmail);
		txtEmail.setColumns(20);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(20);
		panel.add(txtPassword);

		btnSignIn = new JButton("Sign In");
		btnSignIn.setForeground(new Color(255, 255, 255));
		btnSignIn.setBackground(new Color(253, 174, 92));
		btnSignIn.setOpaque(true);
		btnSignIn.setBorderPainted(false);
		panel.add(btnSignIn);

		
		//------- Panel LOGIN -----------
		
		//------- Panel SIGNUP -----------
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(75, 56, 210));
		panel_1.setBounds(325, 55, 255, 155);
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblSignUp = new JLabel("SIGN UP");
		lblSignUp.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblSignUp.setForeground(new Color(255, 255, 255));
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblSignUp);

		txtSignUpEmail = new JTextField();
		txtSignUpEmail.setColumns(20);
		panel_1.add(txtSignUpEmail);
		
		txtSignUpName = new JTextField();
		txtSignUpName.setColumns(20);
		panel_1.add(txtSignUpName);
		
		txtSignUpPassword = new JPasswordField();
		txtSignUpPassword.setColumns(20);
		panel_1.add(txtSignUpPassword);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setBackground(new Color(253, 174, 92));
		btnSignUp.setOpaque(true);
		btnSignUp.setBorderPainted(false);
		panel_1.add(btnSignUp);

		
		//------- Panel SIGNUP -----------
		
		
		//------- Panel QUIZ START ---------
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(75, 56, 210));
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(55, 215, 526, 72);
		contentPane.add(panel_2);

		txtQuizID = new JTextField();
		txtQuizID.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(txtQuizID);
		txtQuizID.setColumns(42);
		
		btnStart = new JButton("Start");
		btnStart.setForeground(new Color(255, 255, 255));
		btnStart.setBackground(new Color(253, 174, 92));
		btnStart.setOpaque(true);
		btnStart.setBorderPainted(false);
		panel_2.add(btnStart);

		
		//------- Panel QUIZ START ---------

	}
	
	public JPanel getContentPane() {
		return contentPane;
	}


	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}




	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getBtnSignIn() {
		return btnSignIn;
	}


	public void setBtnSignIn(JButton btnSignIn) {
		this.btnSignIn = btnSignIn;
	}


	public JButton getBtnSignUp() {
		return btnSignUp;
	}


	public void setBtnSignUp(JButton btnSignUp) {
		this.btnSignUp = btnSignUp;
	}


	public JButton getBtnStart() {
		return btnStart;
	}


	public void setBtnStart(JButton btnStart) {
		this.btnStart = btnStart;
	}


	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JTextField getTxtSignUpEmail() {
		return txtSignUpEmail;
	}

	public void setTxtSignUpEmail(JTextField txtSignUpEmail) {
		this.txtSignUpEmail = txtSignUpEmail;
	}

	public JTextField getTxtSignUpName() {
		return txtSignUpName;
	}

	public void setTxtSignUpName(JTextField txtSignUpName) {
		this.txtSignUpName = txtSignUpName;
	}

	public JTextField getTxtQuizID() {
		return txtQuizID;
	}

	public void setTxtQuizID(JTextField txtQuizID) {
		this.txtQuizID = txtQuizID;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JPasswordField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JPasswordField getTxtSignUpPassword() {
		return txtSignUpPassword;
	}

	public void setTxtSignUpPassword(JPasswordField txtSignUpPassword) {
		this.txtSignUpPassword = txtSignUpPassword;
	}

	
}
