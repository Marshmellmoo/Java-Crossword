import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CrosswordComponent extends JComponent {
	
	private CrosswordGenerator crossword;
	private ArrayList<WordBank> wordBankList;
	
	public CrosswordComponent() {
		
		ArrayList<Words> wordList = new ArrayList<Words>();

		String path = "src/Words.csv";
          String line = "";  
          try {
            
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");
                wordList.add(new Words(values[0], values[1]));

            }

          } catch (FileNotFoundException e) {
            e.printStackTrace();
          } catch (IOException e) {
            e.printStackTrace();
		  }

		GameGenerator generate = new GameGenerator(wordList);
		
		crossword = generate.createGrid();
		wordBankList = crossword.getWordBankList();
		
	}
	
	public static void main(String[] args) {

		JFrame frame = new JFrame();

		int size = 1000;
		frame.setSize(size + 500, size);
		frame.setTitle("Java Crossword Generator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CrosswordComponent component = new CrosswordComponent();
		frame.add(component);
		frame.setVisible(true);

	}
	
	public void paintComponent(Graphics g) {
		
		Graphics g2 = (Graphics2D) g;

		// Colors
		Color black = new Color(0, 0, 0);

		// Coordinates

		int x = 0;
		int y = 0;
		int boxSize = (int)(1000 / crossword.getGridSize());

		crossword.printGrid();
		for (WordBank index : wordBankList) {

			System.out.println (index.getWord() + "  " + index.getHint());

		}

		// Draws boxes, and assigns numbers
		char[][] grid = crossword.getGrid();

		for (int row = 0; row < grid.length; row++) {

			for (int col = 0; col < grid[0].length; col++) {

				if (crossword.isEmpty(row, col)) {

					g2.setColor(black);
					g2.fillRect(x, y, boxSize, boxSize);

				} else {

					g2.setColor(black);
					g2.drawRect(x, y, boxSize, boxSize);
					g2.drawString(Character.toString(grid[row][col]), x + 10, y + boxSize - 10);

				}
				

				x += boxSize;

			}

			x = 0;
			y += boxSize;

		}

		x = 0;
		y = 0;

		/*
		int z = 20;
		int number = 1;

		for (int i = 0; i < wordBankList.size(); i++) {

			int num = i + 1;
			g2.setColor(Color.BLUE);
			g2.drawString(num + ". " + wordBankList.get(i).getHint(), 1000, z);
			z += 15;

		}

		for (int row = 0; row < grid.length - 1; row++) {

			for (int col = 0; col < grid[0].length - 1; col++) {

				x += boxSize;

			}

			x = 0;
			y += boxSize;

		}*/

		
	}
	

}
