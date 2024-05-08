package crossword_gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import Crossword.Cell;
import crossword_gui.CrosswordPanel.PressCell;

public class Keyboard {
	private final String[] keys = {"A", "B", "C","D","E",
                "F","G","H","I", "J", "K", "L", "M",
                "N", "O", "P", "Q","R","S","T",
                "U","V","W","X","Y","Z"};
	
	
	private Cell cell;
	private JButton button;
	
	public Keyboard(Cell cell, JButton button) {
		// TODO Auto-generated constructor stub
		this.cell=cell;
		this.button=button;
	}

	public void CreateKeyboard(){
		ArrayList<String> possibleLetters = new ArrayList<String>();
		JFrame keyboardFrame= new JFrame("Enter a letter");
		keyboardFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        keyboardFrame.setSize(700, 250);
        keyboardFrame.setLayout(new FlowLayout());
        keyboardFrame.setVisible(true);
        //if((cell instanceof Cell)) {
        	//this.possibleLetters = cell.getpossibleLetters();
		//}else {
			//possibleLetters.add(" ");
		//}
        // get posible letters depending on the instance class cell
        possibleLetters = cell.getPossibleLetters();
        System.out.println(possibleLetters);
        
        for (String letter : keys){
            JButton key = new JButton(letter);
            
            key.setPreferredSize(new Dimension(50,50));
            // an active listener is added to the button when a key which is part of the possible letters is clicked
            if (possibleLetters.contains(letter)){
                key.addActionListener(new PressKey(cell, letter, button, keyboardFrame));
            }else {key.setEnabled(false);
            }
            
            keyboardFrame.add(key);
        }
		
	}
	
	////create action perfomed when button is clicked
	private class PressKey implements ActionListener{
		private Cell cell;
		private String letter;
		private JFrame keyboardFrame;
		private JButton button;

		public PressKey(Cell cell, String letter,JButton button, JFrame keyFrame) {
			// TODO Auto-generated constructor stub
			this.cell=cell;
			this.keyboardFrame= keyFrame;
			this.letter=letter;
			this.button=button;
		}
		
		//when the key is clicked, the letter cell variable is changed and the text of the button is set
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//try {
			cell.insertLetter(letter); // change letter variable
			button.setText(cell.getLetterCell());
			button.setFont(new Font("Arial", Font.PLAIN, 15));
			keyboardFrame.dispose();
			System.out.println();
			//}catch(Exception ex) {
				
			//}
		}
		
	}
	
	
	

}
