
public class WordBank {

	private Words text;
	private String word;
	private String hint;
	private int row;
	private int col;
	private boolean isVertical;
	
	public WordBank(Words index) {
		
		this.text = index;
		this.word = text.getWord();
		this.hint = text.getHint();
		row = 0;
		col = 0;
		isVertical = false;
		
		
	}
	
	public Words getText() {
		
		return text;
		
	}
	
	public void setText(Words text) {
		
		this.text = text;
		word = text.getWord();
		hint = text.getHint();
		
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
	
	
	public boolean isVertical() {
		
		return isVertical;
		
		
	}
	
	public void changeVertical(boolean value) {
		
		isVertical = value;
		
	}
	
}
