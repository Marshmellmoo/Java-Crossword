
import java.util.ArrayList;
import java.util.Random;

public class CrosswordGenerator {

	private ArrayList<WordBank> words;
	private int maxWords;
	private char[][] grid;
	
	public CrosswordGenerator(ArrayList<WordBank> words, int maxWords) {
		
		this.words = words;
		this.maxWords = maxWords;
		int gridSize = maxWords * 10;
		this.grid = new char[gridSize][gridSize];
		
		//Fills every grid space with a space.
		for (int i = 0; i < grid.length; i++) {
			
			for (int j = 0; j < grid[0].length; j++) {
				
				grid[i][j] = 'x';
				
			}
			
		}
		
	}
	
	// Shuffles word bank given.
	public void shuffle() {
		
		Random r = new Random();
		for (int i = words.size() - 1; i > 0; i--) {
			
			int j = r.nextInt(i);
			WordBank temp = words.get(i);
			words.set(i, words.get(j));
			words.set(j, temp);
			
		}
		
	}
	
	// Places the first word on the grid.
	public void placeFirstWord() {
		
		shuffle();
		
		int middle = grid.length / 2;
		String first = words.get(0).getWord();
		words.get(0).changeHorizontal();

		for (int i = 0; i < first.length(); i++) {
			
			grid[middle][middle - first.length()/2 + i] = first.charAt(i);
			
		}		
		
	}
	
	//Checks if the word was added.
	//public boolean update() {}
	
	//Checks if a word can be placed.
	public void canBePlaced() {}
	
	//Checks if the cell has a letter.
	public boolean isLetter(int row, int col) {
		
		return grid[row][col] != 'x';
		
	}
	
	//Checks if the cell is empty.
	public boolean isEmpty(int row, int col) {
		
		return !isLetter(row, col);
		
	}
	
	// Checks if the word fits on the grid, and won't go out of bounds.
	public boolean fitsOnGrid(WordBank word) {
		
		if (word.isVertical()) {
			
			return word.getRow() + word.getWord().length() <= grid.length;
			
		} else {
			
			return word.getCol() + word.getWord().length() < grid.length;
			
		}
		
	}
	
	// Checks if 
	public boolean isValidPosition(int row, int col) {
		
		return (row >= 0 && row < grid.length) && (col >= 0 && col < grid.length);
		
	}
	
	pubilc boolean placementLegal(WordBank word, int row, int col) {
		
		boolean illegal = false;
		if (word.isVertical()) {
			
			illegal = isInterference(row, col) || 
					isInterference(row, col) || 
					overwritingVerticalWord(row, col) || 
					overlapping(word, row, col);
			
		} else {
			
			illegal = isInterference(row, col) ||
					isInterference(row, col) ||
					overwritingHorizontalWord(row, col) ||
					overlapping(word, row, col);
			
		}
		
		return !illegal;
		
	}
	
	public boolean canBePlaced(WordBank word) {
		
		boolean canBePlaced = true;
		if (isValidPosition(word.getRow(), word.getCol()) && fitsOnGrid(word)) {
			
			int index = 0;
			while (index < word.getWord().length()) {
				
				int currentRow;
				if (word.isVertical()) currentRow = word.getRow() + index;
				else currentRow = word.getRow();
				
				int currentColumn;
				if (!word.isVertical()) currentColumn = word.getCol() + index;
				else currentColumn = word.getCol();
				
				if ((word.getWord().charAt(index) == grid[currentRow][currentColumn] || ('x' == grid[currentRow][currentColumn])) && placementLegal(word, currentRow, currentColumn)) {
					
					//Nothing happens.
					
				} else {
					
					canBePlaced = false;
					
				}
				
				index++;
				
			}
	
			
		} else {
			
			canBePlaced = false;
			
		}
		
		return canBePlaced;
		
	}
	
	pubilc boolean overlapping(WordBank word, int row, int col) {
		
		boolean overlap = false;
		boolean empty = isEmpty(row, col);
		if (word.isVertical()) {
			
			boolean neighbors = ( doesCharacterExist(row, col - 1) ||
					doesCharacterExist(row, col + 1) ) ||
					endOfWord(word, row, col) && doesCharacterExist(row + 1, col);
			
			overlap = empty && neighbors;
			
		} else {
			
			boolean neighbors = ( doesCharacterExist(row - 1, col) ||
					doesCharacterExist(row + 1, col) ) ||
					endOfWord(word, row, col) && doesCharacterExist(row, col + 1);
			
			overlap = empty && neighbors;
			
		}
		
		return overlap;
		
		
	}
	
	public int endOfWord(WordBank word, int row, int col) {
		
		if (word.isVertical()) return word.getRow() + word.getWord().length() - 1;
		else return word.getCol() + word.getWord().length() - 1;
		
	}
	
	public boolean doesCharacterExist(int row, int col) {
		
		return isValidPosition(row, col) && isLetter(row, col);
		
	}
	
	public boolean overwritingHorizontalWord(int row, int col) {
		
		int leftCol = col - 1;
		return (isValidPosition(row, leftCol) && isLetter(row, col) &&
				isLetter(row, leftCol));
		
	}
	
	public boolean overwritingVerticalWord(int row, int col) {
		
		int rowUp = row - 1;
		return (isValidPosition(rowUp, col) && isLetter(row, col) &&
				isLetter(rowUp, col));
		
	}
	
	public boolean isInterference(int row, int col) {
		
		int nextRow = row + 1;
		int nextCol = col + 1;
		
		return isValidPosition(row, col) && isLetter(row, col) &&
				isValidPosition(nextRow, nextCol) && isLetter(nextRow, nextCol);
		
	}
	
	// For test printing the grid.
	public void printGrid() {
		placeFirstWord();
		for (char[] row : grid) {
			for (char col : row) {
				System.out.print(col);	
			}
			System.out.println();	
		}
	}


	
}
