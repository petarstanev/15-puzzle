package mainpackage;

import java.util.HashMap;

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
	}

	public void move(String direction) {
		int newxPos = xPos;

		if (direction.equals("right")) {
			newxPos++;

			if (newxPos != 4 && newxPos != 8 && newxPos != 12 && newxPos != 16) {
				actualMove(newxPos);
			}

		} else if (direction.equals("left")) {
			newxPos--;

			if (newxPos != -1 && newxPos != 3 && newxPos != 7 && newxPos != 11) {
				actualMove(newxPos);
			}
		}
	}

	private void actualMove(int newxPos) {
		if (map.get(newxPos) != null) {
			// System.out.println("xPos - " + xPos + "xPossquare num" +
			// map.get(xPos).getNumber());
			// System.out.println("newxPos - " + newxPos + "newxPossquare num" +
			// map.get(newxPos).getNumber());

			Square savesquare = map.get(xPos);
			map.put(xPos, map.get(newxPos));

			map.put(newxPos, savesquare);
			xPos = newxPos;
			printmap();
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
}
