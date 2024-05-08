package Crossword;

import java.util.ArrayList;

public abstract class Cell extends GlobalCells{
	
	String alphabet = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
	
	//protected ArrayList<String> possibleLetters;
	
	public Cell() {};
	
	//allow each cell to insert one letter
	public void insertLetter(String letter) {
		this.letterCell = letter;
	}
	
	//delete letter
	public void deleteLetter() {
		this.letterCell= null;
	}
	

}
