package Crossword;

import java.util.ArrayList;

public abstract class GlobalCells {
	
	protected String valueCell = null; // type of cell regular, help etc
	protected String letterCell; //letter inside the cell
	protected String colorCell; //color of the cell
	protected ArrayList<String> possibleLetters = new ArrayList<String>();
	
	public String getLetterCell() {
        return this.letterCell;
    }
	
	public String getValueCell() {
        return this.valueCell;
    }
	
	public String getColorCell() {
        return this.colorCell;
    }

	public ArrayList<String> getPossibleLetters() {
		return this.possibleLetters;
	}
}
