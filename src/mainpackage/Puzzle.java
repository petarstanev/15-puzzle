package mainpackage;

import java.util.Random;

/**
 * Puzzle of the game
 *
 * @author Petar
 */
public class Puzzle {
	private Square[] map;
	private int xPos = 0;

	/**
	 * Generate normal puzzle.From 0 to 16.
	 */
	public Puzzle() {
		map = new Square[16];
		for (int i = 0; i < 16; i++) {
			Square singlesquare = new Square(i);
			map[i] = singlesquare;
		}
	}

	/**
	 * Generate random puzzle.
	 * @param seed
	 */
	public Puzzle(String seed) {
		map = new Square[16];
		for (int i = 0; i < 16; i++) {
			Square singlesquare = new Square(i);
			map[i] = singlesquare;
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
	
	/**
	 * Move by given direction.
	 * 
	 * @param direction
	 * @return
	 */
	public boolean move(String direction) {
		int newPos = xPos;
		int oldPos = xPos;
		if (direction.equals("right")) {
			newPos++;
			// System.out.println("Going " + direction);
			if (newPos != 4 && newPos != 8 && newPos != 12 && newPos != 16) {
				actualMove(newPos, oldPos);
				return true;
			}
		} else if (direction.equals("left")) {
			newPos--;
			// System.out.println("Going " + direction);
			if (newPos != -1 && newPos != 3 && newPos != 7 && newPos != 11) {
				actualMove(newPos, oldPos);
				return true;
			}
		} else if (direction.equals("down")) {
			newPos += 4;
			// System.out.println("Going " + direction);
			if (newPos <= 15) {
				actualMove(newPos, oldPos);
				return true;
			}
		} else if (direction.equals("up")) {
			newPos -= 4;
			// System.out.println("Going " + direction);
			if (newPos >= 0) {
				actualMove(newPos, oldPos);
				return true;
			}
		}
		return false;
	}

	/**
	 * Make an actual move.
	 * 
	 * @param newPos
	 * @param oldPos
	 */
	private void actualMove(int newPos, int oldPos) {// 1
		System.out.println("newPos-" + newPos + " oldPos-" + oldPos);
		Square temp = map[newPos];
		map[newPos] = map[oldPos];

		map[oldPos] = temp;

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
}