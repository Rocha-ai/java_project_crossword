package Crossword;

import java.util.ArrayList;

public class RegularCell extends Cell {
	//private ArrayList<String> possibleLetters = new ArrayList<String>();
	
	
	public RegularCell() {
		this.valueCell = "O";
		this.colorCell = "White";
		String[] letterTokens = alphabet.split(",");
		for (int i =0; i< letterTokens.length;i++) {
			possibleLetters.add(letterTokens[i]);
			//System.out.println(letterTokens[i]);
		}
		
	}


	//@Override
	//public void insertLetter(String letter) {
		// TODO Auto-generated method stub
		//this.letterCell = letter;
	//}

	//@Override
	//public ArrayList<String> getpossibleLetters() {
		// TODO Auto-generated method stub
		//return this.possibleLetters;
	//}

	//@Override
	//public void deleteLetter() {
		// TODO Auto-generated method stub
		//this.letterCell= null;
	//}

}
