
public class WordBank {

	private String word;
	private String hint;
	private int row;
	private int col;
	private boolean isHorizontal;
	private boolean isVertical;
	
	public WordBank(String word, String hint) {
		
		this.word = word;
		this.hint = hint;
		row = 0;
		col = 0;
		isHorizontal = false;
		isVertical = false;
		
		
	}
	
	public String getWord() {
		
		return word;
		
	}
	
	public String getHint() {
		
		return hint;
		
	}
	
	public int getRow()  {
		
		return row;
		
	}
	
	public void setRow(int num) {
		
		row = num;
		
	}
	
	public int getCol() {
		
		return col;
		
	}
	
	public void setCol(int num) {
		
		col = num;
		
		
	}
	
	public boolean isHorizontal() {
		
		return isHorizontal;
		
	}
	
	public void changeHorizontal() {
		
		if (isHorizontal == false) isHorizontal = true;
		else isHorizontal = false;
		
	}
	
	public boolean isVertical() {
		
		return isVertical;
		
		
	}
	
public void changeVertical() {
		
		if (isVertical == false) isVertical = true;
		else isVertical = false;
		
	}
	
}
