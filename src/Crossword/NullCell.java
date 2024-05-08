package Crossword;

import java.util.ArrayList;

public class NullCell extends GlobalCells{
// this are the black cells which do not accept an input
	private ArrayList<String> possibleLetters = new ArrayList<String>();
	public NullCell(){
		this.valueCell = "X";
		this.colorCell = "Black";
		this.possibleLetters.add("");
		
	}
	
		
}
