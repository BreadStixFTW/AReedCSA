package cupShuffle.views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;

import cupShuffle.resources.*;
import javax.swing.ImageIcon;

public class MainWindow {
	
	private JFrame frame;
	private JButton btnNewButton;
	private JPanel startPanel;
	private JPanel gamePanel;
	private JLabel scoreLabel;
	private JButton guessBtn1;
	private JButton guessBtn2;
	private JButton guessBtn3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		createComponents();
		createEvents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void createComponents() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		
		startPanel = new JPanel();
		startPanel.setBounds(0, 0, 14, 12);
		layeredPane.add(startPanel);
		
		btnNewButton = new JButton("Start!");
		btnNewButton.setBackground(Color.GREEN);
		GroupLayout gl_startPanel = new GroupLayout(startPanel);
		gl_startPanel.setHorizontalGroup(
			gl_startPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_startPanel.createSequentialGroup()
					.addGap(186)
					.addComponent(btnNewButton)
					.addContainerGap(187, Short.MAX_VALUE))
		);
		gl_startPanel.setVerticalGroup(
			gl_startPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_startPanel.createSequentialGroup()
					.addContainerGap(128, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(109))
		);
		startPanel.setLayout(gl_startPanel);
		
		gamePanel = new JPanel();
		gamePanel.setVisible(false);
		gamePanel.setBounds(0, 0, 434, 260);
		layeredPane.add(gamePanel);
		
		scoreLabel = new JLabel("Score: 0");
		
		guessBtn1 = new JButton("Guess!");
		guessBtn1.setVisible(false);
		
		guessBtn2 = new JButton("Guess!");
		guessBtn2.setVisible(false);
		
		guessBtn3 = new JButton("Guess!");
		guessBtn3.setVisible(false);
		
		JButton shuffleBtn = new JButton("Shuffle!");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/cupShuffle/resources/cup.png")));
		GroupLayout gl_gamePanel = new GroupLayout(gamePanel);
		gl_gamePanel.setHorizontalGroup(
			gl_gamePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gamePanel.createSequentialGroup()
					.addContainerGap(357, Short.MAX_VALUE)
					.addComponent(scoreLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_gamePanel.createSequentialGroup()
					.addGap(75)
					.addComponent(guessBtn1)
					.addGap(40)
					.addComponent(guessBtn2)
					.addGap(47)
					.addComponent(guessBtn3)
					.addContainerGap(83, Short.MAX_VALUE))
				.addGroup(gl_gamePanel.createSequentialGroup()
					.addGap(167)
					.addComponent(shuffleBtn, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(185, Short.MAX_VALUE))
				.addGroup(gl_gamePanel.createSequentialGroup()
					.addGap(84)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(241, Short.MAX_VALUE))
		);
		gl_gamePanel.setVerticalGroup(
			gl_gamePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gamePanel.createSequentialGroup()
					.addComponent(scoreLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
					.addGroup(gl_gamePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(guessBtn2)
						.addComponent(guessBtn1)
						.addComponent(guessBtn3))
					.addGap(18)
					.addComponent(shuffleBtn)
					.addGap(39))
		);
		gamePanel.setLayout(gl_gamePanel);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private void createEvents() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startPanel.setVisible(false);
				gamePanel.setVisible(true);
			}
		});
	}
}
