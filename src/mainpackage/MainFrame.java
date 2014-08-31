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
	Puzzle puzzle = new Puzzle();
	JPanel gamejpanel = puzzle.PuzzletoPanel();

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
		setBounds(100, 100, 265, 310);
		contentPanel = new JPanel();
		contentPanel.setForeground(new Color(176, 224, 230));
		contentPanel.setVerifyInputWhenFocusTarget(false);

		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 250, 20);
		contentPanel.add(menuBar);

		JMenu gamemenu = new JMenu("Game");
		menuBar.add(gamemenu);

		final Panel panel = new Panel();

		// I use Panel, because when I use JPanel redraw is not working !
		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				String key = KeyEvent.getKeyText(e.getKeyCode());
				System.out.println("keyPressed=" + key);

				switch (key) {
				case "A":
					if (puzzle.move("left")) {
						gamejpanel = puzzle.PuzzletoPanel();
						panel.repaint();
						panel.add(gamejpanel, 2, 0);
					}
					break;
				case "D":
					if (puzzle.move("right")) {
						gamejpanel = puzzle.PuzzletoPanel();
						panel.repaint();
						panel.add(gamejpanel, 2, 0);
					}
					break;
				case "W":
					if (puzzle.move("up")) {
						gamejpanel = puzzle.PuzzletoPanel();
						panel.repaint();
						panel.add(gamejpanel, 2, 0);
					}
					break;
				case "S":
					if (puzzle.move("down")) {
						gamejpanel = puzzle.PuzzletoPanel();
						panel.repaint();
						panel.add(gamejpanel, 2, 0);
					}
					break;
				default:
					System.out.println("not moving");
				}
			}
		});
		panel.setBackground(new Color(176, 224, 230));// B0E0E6
		panel.setBounds(0, 20, 250, 250);

		contentPanel.add(panel, 1, 0);

		JButton btnNewGame = new JButton("New game");

		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				puzzle = new Puzzle();
				panel.repaint();
				panel.add(puzzle.PuzzletoPanel());

			}
		});
		gamemenu.add(btnNewGame);

	}
}
