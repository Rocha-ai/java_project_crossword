package crossword_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Crossword.Cell;
import Crossword.GlobalCells;
import Crossword.NullCell;

public class CrosswordPanel{
	private Color color = null;
	public JPanel CreateCrosswordPanel(GlobalCells[][] cells) {
		JPanel crossword = new JPanel();
        crossword.setLayout(new GridLayout(cells[0].length,cells[1].length));
        crossword.setPreferredSize(new Dimension(450, 450));
    	crossword.setMaximumSize(new Dimension(450, 450));
    	crossword.setBorder(new LineBorder(Color.BLACK));
    	//create a button to each cell in the matrix
        for(int i = 0; i <cells[0].length; i++) {
        	for(int j = 0; j < cells[1].length; j++) {
        		GlobalCells cell = cells[i][j];
        		JButton button = new JButton();
        		
        		button.setMargin(new Insets(0, 0, 0, 0)); //button margin
        		//set color depending on class of cell
        		switch (cell.getColorCell()) {
        		case "White":
        		    color = Color.WHITE;
        		    break;
        		case "Blue":
        		    color = Color.blue; 
        		    break;
        		case "Grey":
        		    color = Color.GRAY; 
        		    break;
        		case "Black":
        		    color = Color.black; 
        		    break;
        		default:
        			System.out.println("Error: not valid type of color");
        		    break;
        		}
        		button.setBackground(color);
        		button.setPreferredSize(new Dimension(10,10));
        		//add an active listener only to cell class (null cells are not enabled)
        		if((cell instanceof Cell)) {
        			button.addActionListener(new PressCell((Cell) cell, button));
        		}else {
        			button.setEnabled(false);
        		}
        		
        		crossword.add(button);
        	}
        }
		
		return crossword;
		
	}
	 //create action perfomed when button is clicked
	public class PressCell implements ActionListener{
		private Cell cell;
		private JButton button;

		public PressCell(Cell cell, JButton button){
			// TODO Auto-generated constructor stub
			this.cell=cell;
			this.button=button;
			
		}
		//create a keyboard when the button is clicked passing along its button and cell
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//try {new Keyboard(cell).CreateKeyboard();
			new Keyboard(cell, button).CreateKeyboard();
				
			//}catch(Exception ex) {
				//System.out.println("hola1");
			//}
		}
		
	}
}


