package mainpackage;



public class MainFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		Puzzle puzzle = new Puzzle("asd");
		
		puzzle.move("right");
		puzzle.printmap();
		puzzle.move("right");
		puzzle.printmap();
		puzzle.move("left");
		puzzle.printmap();
		puzzle.move("down");
		puzzle.printmap();
	}
}