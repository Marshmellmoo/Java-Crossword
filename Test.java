import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		ArrayList<WordBank> bank = new ArrayList<WordBank>();
		bank.add(new WordBank("JAVA", "A high level language."));
		bank.add(new WordBank("BOOLEAN", "A variable that takes true or false"));
		bank.add(new WordBank("INTEGER", "A variable that takes only whole numbers"));
		bank.add(new WordBank("CONSTRUCTOR", "A method that initializes a newly instantiated object"));
		bank.add(new WordBank("OVERLOADING", "A method with the same name, but different arguments."));
		bank.add(new WordBank("OVERRIDING", "Redefining a method in a subclass")); 
		bank.add(new WordBank("STRING", "A sequence of characters that exists as an object ")); //
		bank.add(new WordBank("ARRAYS", "A container object that holds a fixed number of values of a single type.")); 
		bank.add(new WordBank("PRIVATE", "A keyword used in a method or variable declaration that signifies that the method/variable can only be accessed by other elements of its class."));
		bank.add(new WordBank("VOID", "A keyword that specifies that the method doesn't return any value."));
		bank.add(new WordBank("DOUBLE", "A data type used for numbers with decimal places."));
		
		CrosswordGenerator crossword = new CrosswordGenerator(bank, 3);
		crossword.printGrid();
		
	}

}
