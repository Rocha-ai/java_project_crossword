package Crossword;

import java.util.ArrayList;

public class GreySpecialCell extends Cell{
	
	
	public GreySpecialCell() {
		this.valueCell = "S";
		this.colorCell = "Grey";
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
