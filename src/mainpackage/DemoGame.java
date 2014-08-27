package mainpackage;

public class DemoGame {

	public static void main(String[] args) {
		Puzzle puzz = new Puzzle();
		puzz.printmap();
		puzz.move("right");
		puzz.move("right");
		puzz.move("right");
		puzz.move("right");
		puzz.move("down");
		puzz.move("left");
		puzz.move("down");
		puzz.move("down");
		puzz.move("down");
		puzz.move("right");
		puzz.move("up");
		puzz.move("up");
		puzz.move("up");
		puzz.move("up");
		puzz.move("up");
		puzz.move("left");
		puzz.move("left");
		puzz.move("left");
		puzz.move("left");
		puzz.move("up");
		puzz.move("up");
	}
}
