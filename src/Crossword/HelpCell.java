package Crossword;

import java.util.ArrayList;
import java.util.Random;

public class HelpCell extends Cell{
	private final String helpLetter;
	
	public HelpCell(String helpLetter) {
		this.helpLetter= helpLetter;
		this.valueCell = "H";
		this.colorCell = "Blue";
		
		//create temp alphabet to create random selections of letters and delete them
		ArrayList<String> tempAlphabet = new ArrayList<String>();
		String[] letterTokens = alphabet.split(",");
		for (int i =0; i< letterTokens.length;i++) {
			tempAlphabet.add(letterTokens[i]);
			
		}
		
		Random rand = new Random();
		 
		// select 4 random letters of alphabet without replacement
        for (int i = 0; i < 4; i++) {
 
            // take a random index between 0 to size
            int randomIndex = rand.nextInt(tempAlphabet.size());
 
            // add element to possible letters
            this.possibleLetters.add(tempAlphabet.get(randomIndex));
 
            // Remove selected element from tempAlphabet
            tempAlphabet.remove(randomIndex);
        }
        possibleLetters.add(this.helpLetter); //add the help letter to the list of possibleLetters
        //System.out.println(this.possibleLetters);
	}


}
