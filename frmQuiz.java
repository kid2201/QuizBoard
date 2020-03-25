package quizboard.server;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import quizboard.model.Answer;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class frmQuiz{

	private JFrame frame;
	private JPanel contentPane;
	private JPanel panel_1;
	private JLabel lblQuestionHere;
	private JLabel lblTime;
	private ArrayList<Color> answerColors;
	private JButton btnNextQuestion;
	/**
	 * Create the frame.
	 */
	public frmQuiz() {
		contentPane = new JPanel();
		contentPane.setBackground(new Color(75, 56, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		answerColors = new ArrayList<Color>();
		answerColors.add(new Color(19,104,206));
		answerColors.add(new Color(226,27,60));
		answerColors.add(new Color(216,158,0));
		answerColors.add(new Color(38,137,12));

		//--------- INIT FRAME ----------
		frame = new JFrame("Quiz Board");		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 706, 502);
		frame.setLocation(200, 200);
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);				
		
		//--------- INIT FRAME ----------		
		
		//--------- QUESTION PART ---------
		lblQuestionHere = new JLabel("Question Here");
		lblQuestionHere.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestionHere.setBackground(new Color(75, 56, 210));
		lblQuestionHere.setForeground(Color.WHITE);
		lblQuestionHere.setFont(new Font("Helvetica", Font.PLAIN, 20));
		lblQuestionHere.setBounds(0, 42, 706, 184);
		lblQuestionHere.setOpaque(true);
		contentPane.add(lblQuestionHere);
		
		btnNextQuestion = new JButton("Next Question");
		btnNextQuestion.setBounds(0, 444, 706, 36);
		btnNextQuestion.setForeground(new Color(255, 255, 255));
		btnNextQuestion.setBackground(new Color(253, 174, 92));
		btnNextQuestion.setOpaque(true);
		btnNextQuestion.setBorderPainted(false);
		btnNextQuestion.setVisible(false);
		contentPane.add(btnNextQuestion);
		
		lblTime = new JLabel("");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setOpaque(true);
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Helvetica", Font.PLAIN, 20));
		lblTime.setBackground(new Color(75, 56, 210));
		lblTime.setBounds(0, 0, 706, 42);
		contentPane.add(lblTime);

		//--------- QUESTION PART ---------
		
		//--------- ANSWER PART -----------
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(75, 56, 210));
		panel_1.setBounds(0, 226, 706, 218);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		//--------- ANSWER PART -----------
	}

	public JButton getBtnNextQuestion() {
		return btnNextQuestion;
	}

	public void setBtnNextQuestion(JButton btnNextQuestion) {
		this.btnNextQuestion = btnNextQuestion;
	}

	public JButton addAnswer(Answer answer) {
		int ind = panel_1.getComponentCount() + 1;
		JButton btnAnswer = new JButton(ind+" - "+answer.getAnswer());
		btnAnswer.setFont(new Font("Helvetica", Font.PLAIN, 20));
		btnAnswer.setForeground(new Color(255, 255, 255));
		btnAnswer.setBackground(answerColors.get(ind % 4));
		btnAnswer.setOpaque(true);
		btnAnswer.setBorderPainted(false);
		panel_1.add(btnAnswer);
		
		return btnAnswer;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public void setPanel_1(JPanel panel_1) {
		this.panel_1 = panel_1;
	}

	public JLabel getLblQuestionHere() {
		return lblQuestionHere;
	}

	public void setLblQuestionHere(JLabel lblQuestionHere) {
		this.lblQuestionHere = lblQuestionHere;
	}

	public JLabel getLblTime() {
		return lblTime;
	}

	public void setLblTime(JLabel lblTime) {
		this.lblTime = lblTime;
	}

	public ArrayList<Color> getAnswerColors() {
		return answerColors;
	}

	public void setAnswerColors(ArrayList<Color> answerColors) {
		this.answerColors = answerColors;
	}
}
