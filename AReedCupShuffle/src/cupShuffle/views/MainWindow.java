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

public class MainWindow {
	
	private JFrame frame;
	private JButton btnNewButton;
	private JPanel startPanel;
	private JPanel gamePanel;

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
		startPanel.setBounds(0, 0, 434, 260);
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
		GroupLayout gl_gamePanel = new GroupLayout(gamePanel);
		gl_gamePanel.setHorizontalGroup(
			gl_gamePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 434, Short.MAX_VALUE)
		);
		gl_gamePanel.setVerticalGroup(
			gl_gamePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 260, Short.MAX_VALUE)
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
