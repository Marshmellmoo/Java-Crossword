
import java.util.ArrayList;
import java.util.Random;

public class CrosswordGenerator {

	private ArrayList<WordBank> words;
	private int maxWords;
	private int gridSize = maxWords * 8;
	private String[][] grid;
	
	public CrosswordGenerator(ArrayList<WordBank> words, int maxWords) {
		
		this.words = words;
		this.maxWords = maxWords;
		this.grid = new String[gridSize][gridSize];
		
		//Fills every grid space with a space.
		for (int i = 0; i < grid.length; i++) {
			
			for (int j = 0; j < grid[0].length; j++) {
				
				grid[i][j] = " ";
				
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
	
	public void placeFirstWord() {
		
		shuffle();
		
		int middle = gridSize / 2;
		String q = words.get(0).getWord().substring(0, 1);;
		
		grid[middle][middle] = q;
		
	}
	
	public void printGrid() {
		
		placeFirstWord();
		
		for (int i = 0; i < grid.length; i++) {
			
			for (int j = 0; i < grid[0].length; i++) {
				
				System.out.print(grid[i][j]);
				
			}
			
			System.out.println();
			
		}
		
	}
	
	
}
