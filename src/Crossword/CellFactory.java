package Crossword;

public class CellFactory {
	
	
	public static GlobalCells createCell(String typeCell) {
		GlobalCells cell = null;
		
		switch(typeCell.substring(0,1)) {
		case "X":
			cell = new NullCell(); 
			break;
		case "O":
			cell= new RegularCell();
			
			break;
		case "S":
			cell= new GreySpecialCell();
			break;
		case "H":
			String helpLetter = typeCell.substring(2,3);
			cell = new HelpCell(helpLetter);
			break;
		default:
			System.out.println("Error: not valid type of cell");
			break;
			
			
		}
		
		return cell;
		
	}

	

}
