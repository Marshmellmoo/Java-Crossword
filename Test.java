import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		ArrayList<WordBank> bank = new ArrayList<WordBank>();
		bank.add(new WordBank("JAVA", "A high level language."));
		bank.add(new WordBank("BOOLEAN", "A variable that takes true or false."));
		bank.add(new WordBank("INTEGER", "A variable that takes only whole numbers."));
		bank.add(new WordBank("CONSTRUCTOR", "A method that initializes a newly instantiated object."));
		bank.add(new WordBank("OVERLOADING", "A method with the same name, but different arguments."));
		bank.add(new WordBank("OVERRIDING", "Redefining a method in a subclass")); 
		bank.add(new WordBank("STRING", "A sequence of characters that exists as an object.")); //
		bank.add(new WordBank("ARRAYS", "A container object that holds a fixed number of values of a single type.")); 
		bank.add(new WordBank("PRIVATE", "A keyword used in a method or variable declaration that signifies that the method/variable can only be accessed by other elements of its class."));
		bank.add(new WordBank("VOID", "A keyword that specifies that the method doesn't return any value."));
		bank.add(new WordBank("DOUBLE", "A data type used for numbers with decimal places."));
		bank.add(new WordBank("REFERENCE", "A value that denotes the location of an object in memory."));
		bank.add(new WordBank("NESTED", "A type of loop that is contained within another loop."));
		bank.add(new WordBank("MAIN", "Class type that contains the public static void main() functions."));
		bank.add(new WordBank("IS-A", "The relationship that a child class and a parent class share."));
		bank.add(new WordBank("HAS-A", "The relationship that a Animal and a Zoo share.")); 
		bank.add(new WordBank("LOOP", "A statement that repeatedly checks a condition and runs specified code if the condition is true."));
		bank.add(new WordBank("TYPECASTING", "Changing the way that the computer looks at a specific variable."));
		bank.add(new WordBank("MUTATOR", "Changes the state of an object by modifying at least one of its instance variables."));
		bank.add(new WordBank("ACCESSOR", "Returns information about an object without altering the object."));
		bank.add(new WordBank("SCOPE", "The region in which that variable or method is visible and can be accessed."));
		bank.add(new WordBank("COMMENT", "Text within source code that is ignored by the compiler and is used to make notes about the workings of the class."));
		bank.add(new WordBank("DECREMENT", "An operator (--) that decreases the value of a numerical variable by one."));
		bank.add(new WordBank("CHAR", "A primitive data type that represents an character."));
		bank.add(new WordBank("FLOAT", "A primitive data type that represents numbers with a decimal point. Cannot hold numbers as large or as precise as double, but takes up less memory."));
		bank.add(new WordBank("RESERVED", "Words in Java that have special meaning and therefore cannot be used as identifiers.")); 
		bank.add(new WordBank("RETURN", "The keyword used to send a value back to a method's caller."));
		bank.add(new WordBank("PARAMETER", "The identifier used to handle a passed in value."));
		bank.add(new WordBank("PSEUDOCODE", "A mixture of English and source code used to study algorithms before actual coding is started."));
		bank.add(new WordBank("API", "Documents that give details on how to use a class."));
		bank.add(new WordBank("FINAL", "An identifier with this keyword cannot change its value after it has been initialized.")); 
		bank.add(new WordBank("IF-ELSE", "A two way selection structure."));
		bank.add(new WordBank("RECURSION", "The process of a method calling itself in order to solve a problem."));
		bank.add(new WordBank("SUPER", "A reference by a child class to the parent class."));
		bank.add(new WordBank("ARRAYLIST", "A data structure that can hold varying numbers of objects that can be referenced by an index."));
		bank.add(new WordBank("INDEX", "The location of a given piece of data in a list.")); 
		bank.add(new WordBank("BINARY", "A search that has an order of O(log2N); an efficient algorithm for finding an item from a sorted list of items."));
		bank.add(new WordBank("SEQUENTIAL", "A search that has an order of O(N); a method for finding an element within a list."));
		bank.add(new WordBank("INITIALIZATION", "The concept of giving variables a starting value."));
		bank.add(new WordBank("SCANNER", "The class we use to make objects which can accept input from the user."));
		bank.add(new WordBank("SEMICOLON", "Used to mark the end of a line of code.")); 
			
		CrosswordGenerator crossword = new CrosswordGenerator(bank, 3);
		crossword.printGrid();
		
	}

}
