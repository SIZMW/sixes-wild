package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GameApplication {

	private JFrame frame;
	private MainPanel mainPanel;
	//private LevelPanel levelPanel; TODO
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameApplication window = new GameApplication();
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
	public GameApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainPanel = new MainPanel();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(new BorderLayout(0,0));
		frame.setContentPane(contentPane);
		//Splash
		frame.getContentPane().add(mainPanel);
	}
	
	public JFrame getFrame(){
		return this.frame;
	}
	
	public MainPanel getMainPanel(){
		return this.mainPanel;
	}

}
