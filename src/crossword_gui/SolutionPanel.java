package crossword_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Crossword.Cell;
import Crossword.GlobalCells;
import crossword_gui.CrosswordPanel.PressCell;

public class SolutionPanel {
	private Color color = null;
	private GlobalCells solutionCells;
	private String solution;
	private JPanel solutionPanel= new JPanel();
	//private JPanel solutionPanel;
	
	public JPanel CreateSolutionPanel(GlobalCells[] solutionCells,String solution) {
		this.solution =solution;
		JPanel solutionPanel= new JPanel();
		solutionPanel.setLayout(new FlowLayout());
		solutionPanel.setPreferredSize(new Dimension(450, 100));
		solutionPanel.setMaximumSize(new Dimension(450, 100));
		solutionPanel.setBorder(new LineBorder(Color.BLACK));
		
		//create the buttons and action lister according to the solutionsCells matrix
		for(int i = 0; i < solutionCells.length; i++) {
			GlobalCells cell = solutionCells[i];
    		JButton button = new JButton();
    		button.setBackground(Color.GRAY);
    		button.setMargin(new Insets(0, 0, 0, 0));
    		button.setPreferredSize(new Dimension(33,33));
    		button.addActionListener(new PressCell((Cell) cell, button));
			solutionPanel.add(button);
		}
		
		//create button to check solution and add the action listener
		JButton check = new JButton("Check Solution");
		check.addActionListener(new SolutionCheck(solution, solutionCells));
		solutionPanel.add(check);
		
		
		return solutionPanel;
		
	}

	public class PressCell implements ActionListener{
		private Cell cell;
		private JButton button;

		public PressCell(Cell cell, JButton button){
			// TODO Auto-generated constructor stub
			this.cell=cell;
			this.button=button;
			
		}

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
	
	
	//action to perform when the button check solution is clicked
	public class SolutionCheck implements ActionListener{
		private String solution;
		private GlobalCells [] solutionCells;

		public SolutionCheck(String solution, GlobalCells [] solutionCells){
			// TODO Auto-generated constructor stub
			this.solution=solution;
			this.solutionCells=solutionCells;
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//try {new Keyboard(cell).CreateKeyboard();
			String verifySolution = "";
			//get the string solution according to the user inpt
			for(int i=0; i <solutionCells.length; i++) {
				verifySolution += solutionCells[i].getLetterCell();
			}
			//check if user solution is equal to true solution
			if (verifySolution.equals(solution)) {
				// show success popup window if equal
				JOptionPane.showMessageDialog(solutionPanel, "Congratulations, you did it!");
			}else {
				// show fail popup window if not equal
				JOptionPane.showMessageDialog(solutionPanel, "You failed, try again");
				
				
			}
				
			//}catch(Exception ex) {
				//System.out.println("");
			//}
		}
	}
	
}
