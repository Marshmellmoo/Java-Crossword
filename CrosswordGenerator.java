
import java.util.ArrayList;
import java.util.Random;

public class CrosswordGenerator {

	private char[][] grid;
	private final char emptyCell = 'x';
	private int gridSize;
	
	public CrosswordGenerator() {
		
		gridSize = 30;
		this.grid = new char[gridSize][gridSize];
		
		//Fills every grid space with a space.
		for (int i = 0; i < grid.length; i++) {
			
			for (int j = 0; j < grid[0].length; j++) {
				
				grid[i][j] = emptyCell;
				
			}
			
		}
		
	}
	
	public int getGridSize() {
		
		return gridSize;
		
	}
	
	//Checks if the word was added.
	public boolean update(WordBank word) {
		
		boolean updated = false;
		if (canBePlaced(word)) {
			
			placeWord(word);
			updated = true;
			
		}
		
		return updated;
		
	}
	
	// Adds a word to the grid.
	public void placeWord(WordBank word) {
		
		for (int i = 0; i < word.getWord().length(); i++) {
			
			int row = word.getRow();
			int col = word.getCol();
			
			if (word.isVertical()) row += i;
			else col += i;
			
			grid[row][col] = word.getWord().charAt(i);
			
		}
		
	}
	
	public int getIntersections() {
		
		int intersections = 0;
		for (int row = 1; row < grid.length; row++) {
			
			for (int col = 1; col < grid[0].length; col++) {
				
				if (isLetter(row, col)) {
					
					if(isValidPosition(row - 1, col) && isValidPosition(row + 1, col) &&
							isValidPosition(row, col - 1) && isValidPosition(row, col + 1) &&
							isLetter(row - 1, col) && isLetter(row + 1, col) &&
							isLetter(row, col - 1) && isLetter(row, col + 1)) {
						
						intersections++;
						
					}
					
				}
				
			}
			
		}
		
		return intersections;
		
	}
	
	//Checks if the cell has a letter.
	public boolean isLetter(int row, int col) {
		
		return grid[row][col] != emptyCell;
		
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
	
	// Checks if the bounds are within the grid.
	public boolean isValidPosition(int row, int col) {
		
		return (row >= 0 && row < grid.length) && (col >= 0 && col < grid.length);
		
	}
	
	public boolean placementLegal(WordBank word, int row, int col) {
		
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
	
	//Checks if the word can be added to the grid without complications.
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
	
	// Checks if the word will be directly next to another word on the grid.
	public boolean overlapping(WordBank word, int row, int col) {
		
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
	
	public boolean isInterference(int row, int col) {
		
		int nextRow = row + 1;
		int nextCol = col + 1;
		
		return isValidPosition(row, col) && isLetter(row, col) &&
				isValidPosition(nextRow, nextCol) && isLetter(nextRow, nextCol);
		
	}
	
	// Checks if the character chosen is the end of the word.
	public boolean endOfWord(WordBank word, int row, int col) {
		
		if (word.isVertical()) return word.getRow() + word.getWord().length() - 1 == row;
		else return word.getCol() + word.getWord().length() - 1 == col;
		
	}
	
	// Checks if there's a character at a certain position on the grid.
	public boolean doesCharacterExist(int row, int col) {
		
		return isValidPosition(row, col) && isLetter(row, col);
		
	}
	
	// *** Checks if the word is replacing another, both horizontal and vertical. *** //
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
	
	
	// For test printing the grid.
	public void printGrid() {
		
		
		for (char[] row : grid) {
			
			for (char col : row) {
				
				System.out.print(col);
				
			}
			
			System.out.println();
			
		}
		
	}
	
	
}
