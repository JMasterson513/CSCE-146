//Joseph Masterson


public class MineCounterTester {

	public static final int ARRAY_SIZE = 10;
	public static final int NUM_MINES = 10;
	public static void main(String[] args) {
		
		MineCounter mine = new MineCounter(ARRAY_SIZE);
		
		System.out.println("Creating Empty Board:");
		mine.emptyBoard();
		mine.printMines();
		
		System.out.println("Placing Mines:");
		mine.setMines(NUM_MINES);
		mine.printMines();
		
		System.out.println("Performing Mine Count:");
		mine.getCount();
		mine.printMines();
	}

}
