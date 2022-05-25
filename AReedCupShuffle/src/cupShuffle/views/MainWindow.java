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
	private JButton guessBtn3;
	private JButton guessBtn2;
	private JLayeredPane layeredPane_1;
	private JLabel cupImg1;
	private JLabel cupImg2;
	private JLabel cupImg3;
	private JLabel marbleImg1;
	private JLabel marbleImg2;
	private JLabel marbleImg3;
	private JButton exitBtn;
	private JButton shuffleBtn;
	private JLabel successLabel;
	
	private Runnable showShuffleBtn;
	private Runnable hideShuffleBtn;
	private Runnable showExitBtn;
	private Runnable hideExitBtn;
	private Runnable showMarble1;
	private Runnable hideMarble1;
	private Runnable showMarble2;
	private Runnable hideMarble2;
	private Runnable showMarble3;
	private Runnable hideMarble3;
	private Runnable showGuessBtn1;
	private Runnable hideGuessBtn1;
	private Runnable showGuessBtn2;
	private Runnable hideGuessBtn2;
	private Runnable showGuessBtn3;
	private Runnable hideGuessBtn3;
	private Runnable marbleCupUp;
	private Runnable marbleCupDown;
	private Runnable allCupsUp;
	private Runnable allCupsDown;
	private Runnable successMsg;
	private Runnable failMsg;
	private Runnable clearMsg;
	private Runnable updateScore;

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
		createFunctors();
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
		
		guessBtn2 = new JButton("Guess!");
		guessBtn2.setBounds(147, 148, 128, 21);
		layeredPane_1.add(guessBtn2);
		
		guessBtn3 = new JButton("Guess!");
		guessBtn3.setBounds(285, 148, 139, 21);
		layeredPane_1.add(guessBtn3);
		
		shuffleBtn = new JButton("Shuffle!");
		shuffleBtn.setVisible(false);
		shuffleBtn.setBounds(169, 197, 82, 21);
		layeredPane_1.add(shuffleBtn);
		
		guessBtn1 = new JButton("Guess!");
		guessBtn1.setBounds(10, 148, 127, 21);
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
		exitBtn.setVisible(false);
		exitBtn.setBackground(Color.RED);
		exitBtn.setBounds(349, 239, 85, 21);
		layeredPane_1.add(exitBtn);
		
		successLabel = new JLabel("");
		successLabel.setBounds(179, 229, 58, 14);
		layeredPane_1.add(successLabel);
		guessBtn1.setVisible(false);
		guessBtn3.setVisible(false);
		guessBtn2.setVisible(false);
		gamePanel.setLayout(gl_gamePanel);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private void createFunctors() {
		showShuffleBtn = new Runnable() {
			public void run() {
				shuffleBtn.setVisible(true);
			}
		};
		
		hideShuffleBtn = new Runnable() {
			public void run() {
				shuffleBtn.setVisible(false);
			}
		};
		
		showExitBtn = new Runnable() {
			public void run() {
				exitBtn.setVisible(true);
			}
		};
		
		hideExitBtn = new Runnable() {
			public void run() {
				exitBtn.setVisible(false);
			}
		};
		
		showMarble1 = new Runnable() {
			public void run() {
				marbleImg1.setVisible(true);
			}
		};
		
		hideMarble1 = new Runnable() {
			public void run() {
				marbleImg1.setVisible(false);
			}
		};
		
		showMarble2 = new Runnable() {
			public void run() {
				marbleImg2.setVisible(true);
			}
		};
		
		hideMarble2 = new Runnable() {
			public void run() {
				marbleImg2.setVisible(false);
			}
		};
		
		showMarble3 = new Runnable() {
			public void run() {
				marbleImg3.setVisible(true);
			}
		};
		
		hideMarble3 = new Runnable() {
			public void run() {
				marbleImg3.setVisible(false);
			}
		};
		
		showGuessBtn1 = new Runnable() {
			public void run() {
				guessBtn1.setVisible(true);
			}
		};
		
		hideGuessBtn1 = new Runnable() {
			public void run() {
				guessBtn1.setVisible(false);
			}
		};
		
		showGuessBtn2 = new Runnable() {
			public void run() {
				guessBtn3.setVisible(true);
			}
		};
		
		hideGuessBtn2 = new Runnable() {
			public void run() {
				guessBtn3.setVisible(false);
			}
		};
		
		showGuessBtn3 = new Runnable() {
			public void run() {
				guessBtn2.setVisible(true);
			}
		};
		
		hideGuessBtn3 = new Runnable() {
			public void run() {
				guessBtn2.setVisible(false);
			}
		};
		
		marbleCupUp = new Runnable() {
			public void run() {
				cupImg2.setLocation(cupImg2.getX(), cupImg2.getY() - 1);
			}
		};
		
		marbleCupDown = new Runnable() {
			public void run() {
				cupImg2.setLocation(cupImg2.getX(), cupImg2.getY() + 1);
			}
		};
		
		allCupsUp = new Runnable() {
			public void run() {
				cupImg1.setLocation(cupImg1.getX(), cupImg1.getY() - 1);
				cupImg2.setLocation(cupImg2.getX(), cupImg2.getY() - 1);
				cupImg3.setLocation(cupImg3.getX(), cupImg3.getY() - 1);
			}
		};
		
		allCupsDown = new Runnable() {
			public void run() {
				cupImg1.setLocation(cupImg1.getX(), cupImg1.getY() + 1);
				cupImg2.setLocation(cupImg2.getX(), cupImg2.getY() + 1);
				cupImg3.setLocation(cupImg3.getX(), cupImg3.getY() + 1);
			}
		};
		
		successMsg = new Runnable() {
			public void run() {
				successLabel.setText("You Won!");
			}
		};
		
		failMsg = new Runnable() {
			public void run() {
				successLabel.setText("You Lost!");
			}
		};
		
		clearMsg = new Runnable() {
			public void run() {
				successLabel.setText("");
			}
		};
		
		updateScore = new Runnable() {
			public void run() {
				scoreLabel.setText("Score: " + game.getScore());
			}
		};
	}
	
	private void createEvents() {
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startPanel.setVisible(false);
				gamePanel.setVisible(true);
				
				shuffleBtn.setVisible(true);
				exitBtn.setVisible(true);
			}
		});
		
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gamePanel.setVisible(false);
				startPanel.setVisible(true);
				
				shuffleBtn.setVisible(false);
				exitBtn.setVisible(false);
			}
		});
		
		shuffleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shuffleCups();
			}
		});
		
		guessBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showResult(1);
			}
		});
		
		guessBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showResult(2);
			}
		});
		
		guessBtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showResult(3);
			}
		});
	}
	
	public void shuffleCups() {
		Thread uiThread = new Thread() {
			public void run() {
				try {
					SwingUtilities.invokeAndWait(hideShuffleBtn);
					
					SwingUtilities.invokeAndWait(hideExitBtn);
					
					SwingUtilities.invokeAndWait(clearMsg);
					
					SwingUtilities.invokeAndWait(showMarble2);
					
					while (cupImg2.getY() > 10) {
						SwingUtilities.invokeAndWait(marbleCupUp);
						
						waitMillis(50);
					}
					
					while (cupImg2.getY() < 54) {
						SwingUtilities.invokeAndWait(marbleCupDown);
						
						waitMillis(50);
					}
					
					SwingUtilities.invokeAndWait(hideMarble2);
					
					for (int i = 0; i < 10; i++) {
						int cupOne = (int) ((Math.random() * 3) + 1);
						int cupTwo = (int) ((Math.random() * 3) + 1);
						
						while (cupTwo == cupOne) {
							cupTwo = (int) ((Math.random() * 3) + 1);
						}
						
						if (cupTwo < cupOne) {
							int temp = cupOne;
							cupOne = cupTwo;
							cupTwo = temp;
						}
						
						Runnable switchCups = null;
						
						JLabel labelOne = null;
						JLabel labelTwo = null;
						
						int xOne = 0;
						int xTwo = 0;
						
						if (cupOne == 1 && cupTwo == 2) {
							xOne = cupImg1.getX();
							xTwo = cupImg2.getX();
							
							labelOne = cupImg1;
							labelTwo = cupImg2;
							
							switchCups = new Runnable() {
								public void run() {
									cupImg1.setLocation(cupImg1.getX() + 1, cupImg1.getY());
									cupImg2.setLocation(cupImg2.getX() - 1, cupImg2.getY());
								}
							};
						}
						else if (cupOne == 1 && cupTwo == 3) {
							xOne = cupImg1.getX();
							xTwo = cupImg3.getX();
							
							labelOne = cupImg1;
							labelTwo = cupImg3;
							
							switchCups = new Runnable() {
								public void run() {
									cupImg1.setLocation(cupImg1.getX() + 1, cupImg1.getY());
									cupImg3.setLocation(cupImg3.getX() - 1, cupImg3.getY());
								}
							};
						}
						else if (cupOne == 2 && cupTwo == 3) {
							xOne = cupImg2.getX();
							xTwo = cupImg3.getX();
							
							labelOne = cupImg2;
							labelTwo = cupImg3;
							
							switchCups = new Runnable() {
								public void run() {
									cupImg2.setLocation(cupImg2.getX() + 1, cupImg2.getY());
									cupImg3.setLocation(cupImg3.getX() - 1, cupImg3.getY());
								}
							};
						}
						
						while (labelOne.getX() < xTwo && labelTwo.getX() > xOne) {
							SwingUtilities.invokeAndWait(switchCups);
							
							waitMillis(5);
						}
						
						if (cupOne == 1 && cupTwo == 2) {
							JLabel temp = cupImg1;
							cupImg1 = cupImg2;
							cupImg2 = temp;
						}
						else if (cupOne == 1 && cupTwo == 3) {
							JLabel temp = cupImg1;
							cupImg1 = cupImg3;
							cupImg3 = temp;
						}
						else if (cupOne == 2 && cupTwo == 3) {
							JLabel temp = cupImg2;
							cupImg2 = cupImg3;
							cupImg3 = temp;
						}
						
						boolean[] cups = game.getCups();
						
						boolean temp = cups[cupOne - 1];
						cups[cupOne - 1] = cups[cupTwo - 1];
						cups[cupTwo - 1] = temp;
					}
					
					SwingUtilities.invokeAndWait(showGuessBtn1);
					SwingUtilities.invokeAndWait(showGuessBtn2);
					SwingUtilities.invokeAndWait(showGuessBtn3);
				} 
				catch (InvocationTargetException e) {
					e.printStackTrace();
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		uiThread.start();
	}
	
	public void showResult(int pos) {
		Thread uiUpdate = new Thread() {
			public void run() {
				try {
					SwingUtilities.invokeAndWait(hideGuessBtn1);
					SwingUtilities.invokeAndWait(hideGuessBtn2);
					SwingUtilities.invokeAndWait(hideGuessBtn3);
					
					boolean[] cups = game.getCups();
					int cupPos = 0;
					
					for (int i = 0; i < cups.length; i++) {
						if (cups[i]) {
							cupPos = i + 1;
						}
					}
					
					if (cupPos == 1) {
						SwingUtilities.invokeAndWait(showMarble1);
					}
					else if (cupPos == 2) {
						SwingUtilities.invokeAndWait(showMarble2);
					}
					else if (cupPos == 3) {
						SwingUtilities.invokeAndWait(showMarble3);
					}
					
					if (pos == cupPos) {
						SwingUtilities.invokeAndWait(successMsg);
						
						game.increaseScore();
						
						SwingUtilities.invokeAndWait(updateScore);
					}
					else {
						SwingUtilities.invokeAndWait(failMsg);
					}
					
					while (cupImg1.getY() > 10) {
						SwingUtilities.invokeAndWait(allCupsUp);
						
						
						waitMillis(50);
					}
					
					while (cupImg1.getY() < 54) {
						SwingUtilities.invokeAndWait(allCupsDown);
						
						waitMillis(50);
					}
					
					if (cupPos == 1) {
						SwingUtilities.invokeAndWait(hideMarble1);
					}
					else if (cupPos == 2) {
						SwingUtilities.invokeAndWait(hideMarble2);
					}
					else if (cupPos == 3) {
						SwingUtilities.invokeAndWait(hideMarble3);
					}
					
					game.setCups(new boolean[]{false, true, false});
					
					SwingUtilities.invokeAndWait(showShuffleBtn);
					
					SwingUtilities.invokeAndWait(showExitBtn);
				}
				catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		uiUpdate.start();
	}
	
	public void waitMillis(long millis) {
		long currTime = System.currentTimeMillis();
		long waitTime = currTime + millis;
		
		while (currTime < waitTime) {
			currTime = System.currentTimeMillis();
		}
	}
}
