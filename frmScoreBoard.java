package quizboard.server;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;

public class frmScoreBoard {

	private JFrame frame;
	private JPanel contentPane;
	private JButton btnStart;
	private JPanel panel;
	private ArrayList<Color> btnColors;

	/**
	 * Create the frame.
	 */
	public frmScoreBoard() {
		contentPane = new JPanel();
		contentPane.setBackground(new Color(75, 56, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		btnColors = new ArrayList<Color>();
		btnColors.add(new Color(19,104,206));
		btnColors.add(new Color(226,27,60));
		btnColors.add(new Color(216,158,0));
		btnColors.add(new Color(38,137,12));
		
		//--------- INIT FRAME ----------
		frame = new JFrame("Quiz Board");		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 296, 502);
		frame.setLocation(950, 200);
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(23, 39, 253, 397);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
				
		JLabel lblNewLabel = new JLabel("SCORE BOARD");
		lblNewLabel.setFont(new Font("Helvetica", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(86, 9, 121, 22);
		contentPane.add(lblNewLabel);
		
		btnStart = new JButton("START");
		btnStart.setBounds(90, 443, 117, 29);
		btnStart.setForeground(new Color(255, 255, 255));
		btnStart.setBackground(new Color(253, 174, 92));
		btnStart.setOpaque(true);
		btnStart.setBorderPainted(false);
		contentPane.add(btnStart);
		
		//--------- INIT FRAME ----------		
	}
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public void addPlayer(String player)
	{
		JButton btnNewButton = new JButton(player);
		btnNewButton.setFont(new Font("Helvetica", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(btnColors.get(new Random().nextInt(4)));
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false);
		panel.add(btnNewButton);
//		return btnNewButton;
	}

	public JButton getBtnStart() {
		return btnStart;
	}

	public void setBtnStart(JButton btnStart) {
		this.btnStart = btnStart;
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
}
