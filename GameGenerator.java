import java.util.Random;
import java.util.ArrayList;

public class GameGenerator {
	
	private final int attemptsMax = 1000;
	private final int trialGridMax = 10;
	private ArrayList<Words> words;
	private ArrayList<Words> wordsCopy;
	private ArrayList<Words> usedWords;
	private ArrayList<Character> startCharacters;
	private ArrayList<CrosswordGenerator> trialGrids;
	
	public GameGenerator(ArrayList<Words> words) {
		
		this.words = words;
		
		//Initialized wordsCopy so that words isn't referenced.
		ArrayList<Words> arrayList = (ArrayList<Words>)(words.clone());
		wordsCopy = arrayList;
		
		usedWords = new ArrayList<Words>();
		trialGrids = new ArrayList<CrosswordGenerator>();
		startCharacters = new ArrayList<Character>();
		
		
	}
	
	// Resets the temporary ArrayList.
	public void resetWordsCopy() {
		
		ArrayList<Words> arrayList = (ArrayList<Words>)(words.clone());
		wordsCopy = arrayList;
		
	}
	
	//
	public Words tryWord() {
		
		Words word = getRandomWord();
		boolean goodWord = isGoodWord(word);
		
		while (!goodWord || usedWords.contains(word)) {
			
			word = getRandomWord();
			goodWord = isGoodWord(word);
			
		}
		
		return word;
		
	}
	
	public boolean placeWord(CrosswordGenerator grid, WordBank word) {
	
		Words text = getRandomWord();
		for (int row = 0; row < grid.getGridSize(); row++) {
			
			for (int col = 0; col < grid.getGridSize(); col++) {
				
				word.setText(text);
				word.setRow(row);
				word.setCol(col);
				word.changeVertical(Math.random() >= 0.5);
				
				if (grid.isLetter(row, col)) {
					
					if (grid.update(word)) {
						
						updateUsedWordsList(word.getText());
						return true;
						
					}
					
				}
				
			}
			
		}
		
		return false;
		
	}
	
	public void generateTrialGrids() {
		
		for (int i = 0; i < trialGridMax; i++) {
			
			CrosswordGenerator grid = new CrosswordGenerator();
			WordBank word = new WordBank(getSpecificSize(7));
			
			grid.update(word);
			updateUsedWordsList(word.getText());
			
			int fails = 0;
			
			for (int attempts = 0; attempts < attemptsMax; attempts++) {
				
				boolean placed = placeWord(grid, word);
				
				if (placed) {
					
					fails = 0;
					
				} else {
					
					fails++;
					
				}
				
				if (fails > 450) {
					
					break;
					
				}
				
			}
			
			trialGrids.add(grid);
			
			resetWordsCopy();
			usedWords.clear();
			
			
		}
		
	}
	
	public CrosswordGenerator getBestGrid() {
		
		generateTrialGrids();
		
		CrosswordGenerator bestGrid = trialGrids.get(0);
		for (CrosswordGenerator index : trialGrids) {
			
			if (index.getIntersections() >= bestGrid.getIntersections()) {
				
				bestGrid = index;
				
			}
			
		}
		
		return bestGrid;
		
	}
	
	public boolean isGoodWord(Words word) {
		
		boolean goodWord = false;
				
		for (Character c : startCharacters) {
					
			if (c == word.getWord().charAt(0)) {
						
				goodWord = true;
				break;
						
			}
					
		}
		
		return goodWord;
		
	}

	// Adds the words that have been used to the "used words" list.
	public void updateUsedWordsList(Words word) {
		
		usedWords.add(word);
		boolean foundChar = false;
		for (int i = 0; i < startCharacters.size(); i++) {
			
			if (word.getWord().charAt(0) == startCharacters.get(i)) {
				
				foundChar = true;
				
			}
			
		}
		
		if (!foundChar) {
			
			startCharacters.add(word.getWord().charAt(0));
			
		}
		
		removeUsedWords();
		
	}
	
	// Updates the list when word needs to be removed.
	public void removeUsedWords() {
		
		for (int i = 0; i < wordsCopy.size(); i++) {
			
			for (int j = 0; j < usedWords.size(); j++) {
				
				if (wordsCopy.get(i).getWord().equals(usedWords.get(j).getWord())) {
					
					wordsCopy.remove(i);
					i--;
					
				}
				
			}
			
		}
		
	}
	
	// Gets a word of a specific size.
	public Words getSpecificSize(int wordLength) {
		
		removeUsedWords();
		ArrayList<Words> wordLengthWords = new ArrayList<Words>();
		
		for (int i = 0; i < wordsCopy.size(); i++) {
			
			if (wordsCopy.get(i).getWord().length() >= wordLength) {
				
				wordLengthWords.add(wordsCopy.get(i));
				
			}
			
		}
		
		return wordLengthWords.get(randomInteger(wordLengthWords.size()));
		
	}
	
	// Random word generator.
	public Words getRandomWord() {
		
		removeUsedWords();
		return wordsCopy.get(randomInteger(wordsCopy.size()));
		
	}
	
	// Random number generator.
	public int randomInteger(int max) {
		
		Random rand = new Random();
		return rand.nextInt(max);
		
	}
	
	public void displayGrid() {
		
		getBestGrid().printGrid();
		
	}
	
}
