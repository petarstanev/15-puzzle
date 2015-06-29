package mainpackage;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Puzzle of the game
 *
 * @author Petar
 */
public class Puzzle extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int LINE_SIZE = 10;
	private Square[] map;
	private int xPos = 0;
	/**
	 * Generate normal puzzle.From 0 to 16.
	 */
	public Puzzle() {
		setResizable(false);
		setBounds(200, 200, 600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		getContentPane().setLayout(null);

		map = new Square[16];

		
		int x = LINE_SIZE;
		int y = LINE_SIZE;

		for (int i = 0; i < 16; i++) {
			Square singlesquare = new Square(i, x, y);
			map[i] = singlesquare;
			getContentPane().add(singlesquare);
			x += LINE_SIZE+Square.SIZE;
			if (x == LINE_SIZE*5+Square.SIZE*4) {
				x = LINE_SIZE;
				y += LINE_SIZE+Square.SIZE;
			}
		}
		addMovement();
	}

	public void random() {
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			int direction = random.nextInt(3);
			switch (direction) {
			case 0:
				move("right");
				break;
			case 1:
				move("left");
				break;
			case 2:
				move("down");
				break;
			case 3:
				move("up");
				break;
			}
		}
	}

	/**
	 * Move by given direction.
	 * 
	 * @param direction
	 * @return
	 */
	public void move(String direction) {
		int newPos = xPos;

		if (direction.equals("right")) {
			newPos++;
			if (newPos != 4 && newPos != 8 && newPos != 12 && newPos != 16) {
				changePositionInArray(newPos);
			}
		} else if (direction.equals("left")) {
			newPos--;
			if (newPos != -1 && newPos != 3 && newPos != 7 && newPos != 11) {
				changePositionInArray(newPos);
			}
		} else if (direction.equals("down")) {
			newPos += 4;
			if (newPos <= 15) {
				changePositionInArray(newPos);
			}
		} else if (direction.equals("up")) {
			newPos -= 4;
			if (newPos >= 0) {
				changePositionInArray(newPos);
			}
		}
	}

	/**
	 * Make an actual move.
	 * 
	 * @param newPos
	 * @param oldPos
	 */
	private void changePositionInArray(int newPos) {
		int tempNumber = map[newPos].getNumber();
		map[newPos].setNumber(map[xPos].getNumber());
		map[xPos].setNumber(tempNumber);
		xPos = newPos;
	}

	/**
	 * Print Puzzle to terminal.
	 */
	public void printmap() {
		for (int i = 0; i < 16; i++) {
			if (i % 4 == 0) {
				System.out.println();
			}
			System.out.print(" " + map[i].getNumber());
		}
		System.out.println("");
	}

	public void printRow() {
		for (int i = 0; i < 4; i++) {
			System.out.println(map[i].getNumber() + "- X " + map[i].getX()
					+ " Y " + map[i].getY());
		}
		System.out.println();
	}

	public void addMovement() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
					move("down");
				} else if (ke.getKeyCode() == KeyEvent.VK_UP) {
					move("up");
				} else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
					move("left");
				} else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
					move("right");
				}
				checkForWin();
			}
		});
	}
	
	public boolean checkForWin(){
		for (int i = 1; i < 15; i++) {
			Square square = map[i];
			if(square.getNumber() != i){
				return false;
			}
		}
		String name = JOptionPane.showInputDialog("What is your name?", null);
		return true;
	}
}