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
	private ArrayList<Words> wordBankList;
	
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
	
	public void paintComponent(Graphics g) {
		
		Graphics g2 = (Graphics2D) g;

		// Colors
		Color black = new Color(0, 0, 0);

		// Coordinates

		int x = 0;
		int y = 0;
		int boxSize = (int)(1000 / crossword.getGridSize());

		crossword.printGrid();
		for (Words index : wordBankList) {

			System.out.println (index.getWord() + "  " + index.getHint());

		}

		// Draws boxes
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

		x = 1010;
		y = 15;

		for (Words index : wordBankList) {

			g2.drawString(index.getWord() + "  " + index.getHint(), x, y);
			y += 20;

		}

		
	}

	

}
