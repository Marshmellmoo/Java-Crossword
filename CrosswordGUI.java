import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class CrosswordGUI implements ActionListener {

    public CrosswordGUI() {

        JFrame frame = new JFrame();
        JButton button = new JButton();
        JPanel panel = new JPanel();

        int size = 1000;

		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0, 1));

		button = new JButton("Create a Crossword");
		button.setBounds(30, 30, 80, 50);
		panel.add(button);
		button.addActionListener(this);

        frame.add(panel, BorderLayout.CENTER);
		frame.setSize(size, size);
		frame.setTitle("Java Crossword Generator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        
    }

    public static void main(String[] args) {

        new CrosswordGUI();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        CrosswordComponent component = new CrosswordComponent();
		JFrame frame = new JFrame();
		frame.add(component);
        frame.setSize(1750, 1000);
		frame.setTitle("Java Crossword Generated!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
