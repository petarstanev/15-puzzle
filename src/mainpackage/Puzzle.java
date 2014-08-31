package mainpackage;

import java.awt.Color;
import java.util.Random;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

/*This is class for the actual puzzle.
 */
public class Puzzle {
	HashMap<Integer, Square> map;
	int xPos = 0;

	Puzzle() {
		map = new HashMap<Integer, Square>();

		for (int i = 0; i < 16; i++) {
			Square singlesquare = new Square(i);
			map.put(i, singlesquare);
		}
		PuzzletoPanel();
	}

	Puzzle(long seed) {
		map = new HashMap<Integer, Square>();

		for (int i = 0; i < 16; i++) {
			Square singlesquare = new Square(i);
			map.put(i, singlesquare);
		}

		// removed seed just for testing
		Random random = new Random();

		for (int i = 0; i < 10000; i++) {
			int direction = random.nextInt(3);
			switch (direction) {
			case 0:
				this.move("right");
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
		printmap();
	}

	public boolean move(String direction) {
		int newPos = xPos;

		if (direction.equals("right")) {
			newPos++;
			// System.out.println("Going " + direction);
			if (newPos != 4 && newPos != 8 && newPos != 12 && newPos != 16) {
				actualMove(newPos);
				return true;
			}

		} else if (direction.equals("left")) {
			newPos--;
			// System.out.println("Going " + direction);
			if (newPos != -1 && newPos != 3 && newPos != 7 && newPos != 11) {
				actualMove(newPos);
				return true;
			}
		} else if (direction.equals("down")) {
			newPos += 4;
			// System.out.println("Going " + direction);
			if (newPos <= 15) {
				actualMove(newPos);
				return true;
			}
		} else if (direction.equals("up")) {
			newPos -= 4;
			// System.out.println("Going " + direction);
			if (newPos >= 0) {
				actualMove(newPos);
				return true;
			}
		}
		return false;
	}

	private void actualMove(int newPos) {
		if (map.get(newPos) != null) {
			System.out.println("xPos-" + xPos + " newPos-" + newPos);
			Square saveblacksquare = map.get(xPos);
			map.put(xPos, map.get(newPos));

			map.put(newPos, saveblacksquare);
			xPos = newPos;
		}
	}

	public void printmap() {
		for (int i = 0; i < map.size(); i++) {
			if (i % 4 == 0) {
				System.out.println();
			}
			System.out.print(" " + map.get(i).getNumber());
		}
		System.out.println("");
	}

	public JPanel PuzzletoPanel() {
		JPanel jpanel = new JPanel();
		int x = 0;
		int y = 0;
		int squareCounter = 0;
		for (int i = 0; i < 4; i++) {
			x = 0;
			for (int e = 0; e < 4; e++) {
				Square square = map.get(squareCounter);
				if(square == null){
					System.out.println("NO SQUARE");
				}
				
				square.setCoordinates(x, y);
				JLabel label = square.getJLabel();
				jpanel.add(label, 3, 0);

				squareCounter++;
				x += 60;
			}
			y += 60;
		}
		jpanel.setBounds(10, 10, 230, 230);
		jpanel.setBackground(new Color(176, 224, 230));
		return jpanel;
	}
}
