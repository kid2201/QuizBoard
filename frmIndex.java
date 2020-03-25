package quizboard.server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class frmIndex {
	
	private JFrame frame;
	private JPanel contentPane;
	private JButton btnAddQuiz;
	private JButton btnAddQuestion;
	private JButton btnDeleteQuiz;
	private JButton btnDeleteQuestion;
	private JButton btnLogout;
	private JTable tableQuiz;
	private JTable tableQuestion;

	public JTable getTableQuiz() {
		return tableQuiz;
	}

	public void setTableQuiz(JTable tableQuiz) {
		this.tableQuiz = tableQuiz;
	}

	public JTable getTableQuestion() {
		return tableQuestion;
	}

	public void setTableQuestion(JTable tableQuestion) {
		this.tableQuestion = tableQuestion;
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

	public JButton getBtnAddQuiz() {
		return btnAddQuiz;
	}

	public void setBtnAddQuiz(JButton btnAddQuiz) {
		this.btnAddQuiz = btnAddQuiz;
	}

	public JButton getBtnAddQuestion() {
		return btnAddQuestion;
	}

	public void setBtnAddQuestion(JButton btnAddQuestion) {
		this.btnAddQuestion = btnAddQuestion;
	}

	public JButton getBtnDeleteQuiz() {
		return btnDeleteQuiz;
	}

	public void setBtnDeleteQuiz(JButton btnDeleteQuiz) {
		this.btnDeleteQuiz = btnDeleteQuiz;
	}

	public JButton getBtnDeleteQuestion() {
		return btnDeleteQuestion;
	}

	public void setBtnDeleteQuestion(JButton btnDeleteQuestion) {
		this.btnDeleteQuestion = btnDeleteQuestion;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public void setBtnLogout(JButton btnLogout) {
		this.btnLogout = btnLogout;
	}

	/**
	 * Create the frame.
	 */
	public frmIndex() {
		//--------- MAIN PANEL ----------
		contentPane = new JPanel();
		contentPane.setBackground(new Color(75, 56, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		//--------- MAIN PANEL ----------
		
		//--------- INIT FRAME ----------
		frame = new JFrame("Quiz Board");		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 564, 587);
		frame.setLocationRelativeTo(null);
		frame.setContentPane(contentPane);
		//--------- INIT FRAME ----------
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 29, 379, 230);
		contentPane.add(scrollPane);
		
		tableQuiz = new JTable();
		tableQuiz.setRowSelectionAllowed(false);
		tableQuiz.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Quiz ID"
			}
		));
		scrollPane.setViewportView(tableQuiz);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 282, 379, 246);
		contentPane.add(scrollPane_1);
		
		tableQuestion = new JTable();
		tableQuestion.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Question ID", "Question"
			}
		));
		scrollPane_1.setViewportView(tableQuestion);
		
		btnAddQuiz = new JButton("Add Quiz");
		btnAddQuiz.setBounds(425, 29, 115, 21);
		contentPane.add(btnAddQuiz);
		
		btnDeleteQuiz = new JButton("Delete Quiz");
		btnDeleteQuiz.setBounds(425, 60, 115, 21);
		contentPane.add(btnDeleteQuiz);
		
		btnAddQuestion = new JButton("Add Question");
		btnAddQuestion.setBounds(425, 282, 115, 21);
		contentPane.add(btnAddQuestion);
		
		btnDeleteQuestion = new JButton("Delete Question");
		btnDeleteQuestion.setBounds(425, 313, 115, 21);
		contentPane.add(btnDeleteQuestion);
		
		btnLogout = new JButton("Log out");
		btnLogout.setBounds(425, 507, 115, 21);
		contentPane.add(btnLogout);
	}
}
