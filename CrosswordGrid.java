import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JComponent;

public class CrosswordGrid extends JFrame {

    public CrosswordGrid() {
        setTitle("Crossword Puzzle");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new CrosswordComponent());
    }

    public static void main(String[] args) {
        JFrame frame = new CrosswordGrid();
        frame.setVisible(true);
    }
}

class CrosswordComponent extends JComponent {

    private final int cellSize = 30;
    private final char[][] grid = new char[50][50];

  
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        // Drawing out grid
        for (int i = 0; i <= 50; i++) {
            g2.drawLine(0, i * cellSize, 50 * cellSize, i * cellSize);
        }
        for (int i = 0; i <= 50; i++) {
            g2.drawLine(i * cellSize, 0, i * cellSize, 50 * cellSize);
        }

            }
    }







