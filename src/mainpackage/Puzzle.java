package mainpackage;

import java.util.Random;
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
	
	Puzzle(long seed) {
		map = new HashMap<Integer, Square>();

		for (int i = 0; i < 16; i++) {
			Square singlesquare = new Square(i);
			map.put(i, singlesquare);
		}
		
		//removed seed just for testing
		Random random = new Random();
		
		for(int i =0; i<10000;i++){
			int direction = random.nextInt(3);
			switch (direction){
			case 0: this.move("right");
			break;
			case 1: move("left");
			break;
			case 2: move("down");
			break;
			case 3: move("up");
			break;
			}
		}
		printmap();
	}

	public void move(String direction) {
		int newPos = xPos;

		if (direction.equals("right")) {
			newPos++;
			System.out.println("Going " + direction);
			if (newPos != 4 && newPos != 8 && newPos != 12 && newPos != 16) {
				actualMove(newPos);
			}

		} else if (direction.equals("left")) {
			newPos--;
			System.out.println("Going " + direction);
			if (newPos != -1 && newPos != 3 && newPos != 7 && newPos != 11) {
				actualMove(newPos);
			}
		} else if (direction.equals("down")) {
			newPos += 4;
			System.out.println("Going " + direction);
			if (newPos <= 15) {
				actualMove(newPos);
			}
		} else if (direction.equals("up")) {
			newPos -= 4;
			System.out.println("Going " + direction);
			if (newPos >= 0) {
				actualMove(newPos);
			}
		}
	}

	private void actualMove(int newPos) {
		if (map.get(newPos) != null) {
			Square savesquare = map.get(xPos);
			map.put(xPos, map.get(newPos));

			map.put(newPos, savesquare);
			xPos = newPos;
			//printmap();
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
