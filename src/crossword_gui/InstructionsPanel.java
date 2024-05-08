package crossword_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class InstructionsPanel {
	
	private JPanel instructionsPanel = new JPanel();
	
	public JPanel CreateInstructionsPanel(ArrayList<String> instructionsAcross,ArrayList<String> instructionsDown) {
		instructionsPanel.setLayout(new GridLayout(39,1));
		instructionsPanel.setBackground(Color.WHITE);
		instructionsPanel.setPreferredSize(new Dimension(300, 300));
		instructionsPanel.setMaximumSize(new Dimension(450, 450));
		//format the instructions jlabel and add it to the panel
		JLabel instruc = new JLabel("Crossword Puzzle Instructions");
		instruc.setFont(new Font("Arial", Font.BOLD, 12));
		instruc.setForeground(Color.blue);
		instructionsPanel.add(instruc);// add instructions
		
		//format the clues across jlabel and add it to the panel
		JLabel across = new JLabel("Across");
		across.setFont(new Font("Arial", Font.BOLD, 12));
		across.setForeground(Color.red);
		instructionsPanel.add(across);
		for (int i =0; i< instructionsAcross.size(); i++ ) {
			String clue = instructionsAcross.get(i);
			JLabel text = new JLabel(clue);
			text.setFont(new Font("Arial", Font.ROMAN_BASELINE, 11));
			instructionsPanel.add(text);	
		}
		
		//format the clues down jlabel and add it to the panel
		JLabel down = new JLabel("Down");
		down.setFont(new Font("Arial", Font.BOLD, 12));
		down.setForeground(Color.red);
		instructionsPanel.add(down);
		
		for (int i =0; i< instructionsDown.size(); i++ ) {
			String clue = instructionsDown.get(i);
			JLabel text = new JLabel(clue);
			text.setFont(new Font("Arial", Font.ROMAN_BASELINE, 11));
			instructionsPanel.add(text);
			
		}
		
		//JScrollPane scrollPane = new JScrollPane(instructionsPanel);
		
		return instructionsPanel;
		
		
	}
}
