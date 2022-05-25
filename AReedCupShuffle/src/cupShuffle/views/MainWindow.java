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
import javax.swing.SwingUtilities;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import cupShuffle.common.Game;
import java.util.*;
import java.lang.Thread;
import java.lang.reflect.InvocationTargetException;

public class MainWindow {
	private Game game;
	
	private JFrame frame;
	private JButton startBtn;
	private JPanel startPanel;
	private JPanel gamePanel;
	private JLabel scoreLabel;
	private JButton guessBtn1;
	private JButton guessBtn2;
	private JButton guessBtn3;
	private JLayeredPane layeredPane_1;
	private JLabel cupImg1;
	private JLabel cupImg2;
	private JLabel cupImg3;
	private JLabel marbleImg1;
	private JLabel marbleImg2;
	private JLabel marbleImg3;
	private JButton exitBtn;
	private JButton shuffleBtn;

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
		
		game = new Game();
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
		startPanel.setBounds(0, 0, 434, 260);
		layeredPane.add(startPanel);
		
		startBtn = new JButton("Start!");
		startBtn.setBackground(Color.GREEN);
		GroupLayout gl_startPanel = new GroupLayout(startPanel);
		gl_startPanel.setHorizontalGroup(
			gl_startPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_startPanel.createSequentialGroup()
					.addGap(186)
					.addComponent(startBtn)
					.addContainerGap(187, Short.MAX_VALUE))
		);
		gl_startPanel.setVerticalGroup(
			gl_startPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_startPanel.createSequentialGroup()
					.addContainerGap(128, Short.MAX_VALUE)
					.addComponent(startBtn)
					.addGap(109))
		);
		startPanel.setLayout(gl_startPanel);
		
		gamePanel = new JPanel();
		gamePanel.setBounds(0, 0, 434, 260);
		layeredPane.add(gamePanel);
		
		layeredPane_1 = new JLayeredPane();
		GroupLayout gl_gamePanel = new GroupLayout(gamePanel);
		gl_gamePanel.setHorizontalGroup(
			gl_gamePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_gamePanel.createSequentialGroup()
					.addComponent(layeredPane_1, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_gamePanel.setVerticalGroup(
			gl_gamePanel.createParallelGroup(Alignment.LEADING)
				.addComponent(layeredPane_1, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
		);
		
		guessBtn3 = new JButton("Guess!");
		guessBtn3.setBounds(178, 148, 63, 21);
		layeredPane_1.add(guessBtn3);
		
		guessBtn2 = new JButton("Guess!");
		guessBtn2.setBounds(285, 148, 63, 21);
		layeredPane_1.add(guessBtn2);
		
		shuffleBtn = new JButton("Shuffle!");
		shuffleBtn.setBounds(169, 197, 82, 21);
		layeredPane_1.add(shuffleBtn);
		
		guessBtn1 = new JButton("Guess!");
		guessBtn1.setBounds(74, 148, 63, 21);
		layeredPane_1.add(guessBtn1);
		
		scoreLabel = new JLabel("Score: 0");
		scoreLabel.setBounds(378, 0, 56, 39);
		layeredPane_1.add(scoreLabel);
		
		cupImg1 = new JLabel("");
		cupImg1.setIcon(new ImageIcon(MainWindow.class.getResource("/cupShuffle/resources/cup.png")));
		cupImg1.setBounds(74, 54, 63, 84);
		layeredPane_1.add(cupImg1);
		
		cupImg2 = new JLabel("");
		cupImg2.setIcon(new ImageIcon(MainWindow.class.getResource("/cupShuffle/resources/cup.png")));
		cupImg2.setBounds(178, 54, 63, 85);
		layeredPane_1.add(cupImg2);
		
		cupImg3 = new JLabel("");
		cupImg3.setIcon(new ImageIcon(MainWindow.class.getResource("/cupShuffle/resources/cup.png")));
		cupImg3.setBounds(285, 54, 63, 84);
		layeredPane_1.add(cupImg3);
		
		marbleImg1 = new JLabel("");
		marbleImg1.setVisible(false);
		marbleImg1.setIcon(new ImageIcon(MainWindow.class.getResource("/cupShuffle/resources/marble.png")));
		marbleImg1.setBounds(87, 83, 38, 29);
		layeredPane_1.add(marbleImg1);
		
		marbleImg2 = new JLabel("");
		marbleImg2.setVisible(false);
		marbleImg2.setIcon(new ImageIcon(MainWindow.class.getResource("/cupShuffle/resources/marble.png")));
		marbleImg2.setBounds(191, 83, 38, 29);
		layeredPane_1.add(marbleImg2);
		
		marbleImg3 = new JLabel("");
		marbleImg3.setVisible(false);
		marbleImg3.setIcon(new ImageIcon(MainWindow.class.getResource("/cupShuffle/resources/marble.png")));
		marbleImg3.setBounds(298, 83, 38, 29);
		layeredPane_1.add(marbleImg3);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBackground(Color.RED);
		exitBtn.setBounds(349, 239, 85, 21);
		layeredPane_1.add(exitBtn);
		guessBtn1.setVisible(false);
		guessBtn2.setVisible(false);
		guessBtn3.setVisible(false);
		gamePanel.setLayout(gl_gamePanel);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private void createEvents() {
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startPanel.setVisible(false);
				gamePanel.setVisible(true);
			}
		});
		
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gamePanel.setVisible(false);
				startPanel.setVisible(true);
			}
		});
		
		shuffleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shuffleCups();
			}
		});
	}
	
	public void shuffleCups() {
		marbleImg2.setVisible(true);
		
		Runnable uiUpdate = new Runnable() {
			public void run() {
				System.out.println("Updating...");
				
				cupImg2.setLocation(cupImg2.getX(), 25);
			}
		};
		
		Thread uiThread = new Thread() {
			public void run() {
				try {
					SwingUtilities.invokeAndWait(uiUpdate);
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				waitMillis(3000);
				
				System.out.println("Updated!");
			}
		};
		
		uiThread.start();
		
		try {
			uiThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		while (cupImg2.getY() > 25) {
//			cupImg2.setLocation(cupImg2.getX(), cupImg2.getY() - 1);
//			
//			System.out.println("Test");
//			
//			waitMillis(1000);
//		}
//		
//		while (cupImg2.getY() < 54) {
//			cupImg2.setLocation(cupImg2.getX(), cupImg2.getY() + 1);
//			
//			waitMillis(1000);
//		}
		
//		
//		for (int i = 0; i < 10; i++) {
//			int cupOne = (int) ((Math.random() * 3) + 1);
//			int cupTwo = (int) ((Math.random() * 3) + 1);
//			
//			while (cupTwo == cupOne) {
//				cupTwo = (int) ((Math.random() * 3) + 1);
//			}
//			
//			JLabel labelOne = null;
//			JLabel labelTwo = null;
//			
//			if (cupOne == 1) {
//				labelOne = cupImg1;
//			}
//			else if (cupOne == 2) {
//				labelTwo = cupImg2;
//			}
//		}
	}
	
	public void waitMillis(long millis) {
		long currTime = System.currentTimeMillis();
		long waitTime = currTime + millis;
		
		while (currTime < waitTime) {
			currTime = System.currentTimeMillis();
		}
	}
}
