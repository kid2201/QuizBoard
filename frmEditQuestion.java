package quizboard.server;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class frmEditQuestion {
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtQuestion;
	private JTextField txtQTime;
	private JTextField txtAnsTime;
	private JTextField txtScore;
	private JButton btnOK;

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JTextField getTxtQuestion() {
		return txtQuestion;
	}

	public void setTxtQuestion(JTextField txtQuestion) {
		this.txtQuestion = txtQuestion;
	}

	public JTextField getTxtQTime() {
		return txtQTime;
	}

	public void setTxtQTime(JTextField txtQTime) {
		this.txtQTime = txtQTime;
	}

	public JTextField getTxtAnsTime() {
		return txtAnsTime;
	}

	public void setTxtAnsTime(JTextField txtAnsTime) {
		this.txtAnsTime = txtAnsTime;
	}

	public JTextField getTxtScore() {
		return txtScore;
	}

	public void setTxtScore(JTextField txtScore) {
		this.txtScore = txtScore;
	}

	public JButton getBtnOK() {
		return btnOK;
	}

	public void setBtnOK(JButton btnOK) {
		this.btnOK = btnOK;
	}

	
	public frmEditQuestion() {
		
		frame = new JFrame("QuizBoard");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 775, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtQuestion = new JTextField();
		txtQuestion.setBounds(320, 99, 324, 35);
		contentPane.add(txtQuestion);
		txtQuestion.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Question");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(116, 96, 105, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblQuestionTime = new JLabel("Question Time");
		lblQuestionTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuestionTime.setBounds(116, 182, 105, 37);
		contentPane.add(lblQuestionTime);
		
		JLabel lblAnswerTime = new JLabel("Answer Time");
		lblAnswerTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnswerTime.setBounds(116, 266, 105, 37);
		contentPane.add(lblAnswerTime);
		
		JLabel lblScore = new JLabel("Score");
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblScore.setBounds(116, 347, 105, 37);
		contentPane.add(lblScore);
		
		txtQTime = new JTextField();
		txtQTime.setColumns(10);
		txtQTime.setBounds(320, 184, 324, 35);
		contentPane.add(txtQTime);
		
		txtAnsTime = new JTextField();
		txtAnsTime.setColumns(10);
		txtAnsTime.setBounds(320, 266, 324, 35);
		contentPane.add(txtAnsTime);
		
		txtScore = new JTextField();
		txtScore.setColumns(10);
		txtScore.setBounds(320, 347, 324, 35);
		contentPane.add(txtScore);
		
		JButton btnOK = new JButton("OK");
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOK.setBounds(559, 405, 85, 21);
		contentPane.add(btnOK);
	}
}
