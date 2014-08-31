package mainpackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuBar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;
import javax.swing.JToggleButton;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class MainFrame extends JFrame {
	Puzzle puzzle = new Puzzle();;
	JPanel gamepanel = puzzle.PuzzletoPanel();

	private JPanel contentPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					// Keyregister keyregister = new Keyregister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPanel = new JPanel();
		contentPanel.setVerifyInputWhenFocusTarget(false);

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 384, 20);
		contentPanel.add(menuBar);

		JMenu mnTestMenu = new JMenu("test menu");
		menuBar.add(mnTestMenu);

		final Panel panel = new Panel();

		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				String key = KeyEvent.getKeyText(e.getKeyCode());
				System.out.println("keyPressed=" + key);

				switch (key) {
				case "A":
puzzle.move("left");
					gamepanel = puzzle.PuzzletoPanel();
					panel.repaint();
					panel.add(gamepanel, 2, 0);					break;
				case "D":
					puzzle.move("right");
					gamepanel = puzzle.PuzzletoPanel();
					panel.repaint();
					panel.add(gamepanel, 2, 0);
					break;
				case "W":
					puzzle.move("up");
					gamepanel = puzzle.PuzzletoPanel();
					panel.repaint();
					panel.add(gamepanel, 2, 0);
					break;
				case "S":
					puzzle.move("down");
					gamepanel = puzzle.PuzzletoPanel();
					panel.repaint();
					panel.add(gamepanel, 2, 0);
					break;
				default:
					System.out.println("not moving");
				}
			}
		});
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 30, 400, 350);
		contentPanel.add(panel, 1, 0);
		JButton btnNewGame = new JButton("New game");

		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				puzzle = new Puzzle();
				panel.add(puzzle.PuzzletoPanel());
				contentPanel.repaint();
			}
		});
		mnTestMenu.add(btnNewGame);

	}
}
