
public class WordBank {

	private Words text;
	private int row;
	private int col;
	private boolean isVertical;
	
	public WordBank(Words index) {
		
		this.text = index;
		row = 0;
		col = 0;
		isVertical = false;
		
		
	}
	
	public Words getText() {
		
		return text;
		
	}
	
	public void setText(Words text) {
		
		this.text = text;
		
	}
	
	public String getWord() {
		
		return text.getWord();
		
	}
	
	public String getHint() {
		
		return text.getHint();
		
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
