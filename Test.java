import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		ArrayList<WordBank> bank = new ArrayList<WordBank>();
		bank.add(new WordBank("JAVA", "A high level language."));
		bank.add(new WordBank("BOOLEAN", "A variable that takes true or false"));
		bank.add(new WordBank("INTEGER", "A variable that takes only whole numbers"));
		
		CrosswordGenerator crossword = new CrosswordGenerator(bank, 3);
		crossword.printGrid();
		
	}

}
