package Main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Crossword.CellFactory;
import Crossword.GlobalCells;
import crossword_gui.CrosswordPanel;
import crossword_gui.InstructionsPanel;
import crossword_gui.SolutionPanel;

public class PlayCrossword {
	private int height;// height and width of crossword
	private int width;
	private String fileName;
	private String solution; //solution of the crossword
	private GlobalCells[][] gridCrossword; // store the crossword as an object cell matrix
	private GlobalCells [] solutionCells; // store the solution cells
	private ArrayList<String> instructionsAcross= new ArrayList<>();//store across clues
	private ArrayList<String> instructionsDown= new ArrayList<>();//store down clues
	
	
	public PlayCrossword() {
		// TODO Auto-generated constructor stub
		//read the config properties file to get solution and text file input
		Properties prop = new Properties();
		try(FileInputStream propInput = new FileInputStream("src/config.properties")){
			prop.load(propInput);
			this.solution = prop.getProperty("solution");
			this.solution=this.solution.toUpperCase();
			this.fileName= prop.getProperty("filename");
			
		} catch(FileNotFoundException notfound) {
			System.out.println("File could not be found" + notfound);
		} catch(IOException ioe) {
			System.out.println("Something went wrong while reading properties file" + ioe);
		}
		
		try {
			//read the text file with scanner object
			File myObj =new File("src/"+ this.fileName);
			Scanner sc = new Scanner(myObj);
			
			//read the dimensions of the crossword
			String dimensions = sc.nextLine();
			String [] widthHeight = dimensions.split(" ");
			this.height = Integer.parseInt(widthHeight[0]);
			this.width = Integer.parseInt(widthHeight[1]);
			
			System.out.println(this.height);
			System.out.println(this.width);
			
			//read the cells of the crossword
			gridCrossword = new GlobalCells [this.height][this.width];
			for (int i = 0; i < this.height; i++) {
		        String[] row = sc.nextLine().split(" ");
		        for (int j = 0; j < this.width; j++) {
		            this.gridCrossword[i][j] = CellFactory.createCell(row[j]);
		            System.out.println(row[j] + gridCrossword[i][j].getClass().getName());
		            System.out.println(gridCrossword[i][j].getPossibleLetters());
		        }
		    }
			
			//Read the instructions across
			sc.nextLine(); // this is the Across line
			while(sc.hasNextLine()) {
				String line= sc.nextLine();
				if(!(line.equals("DOWN"))){
					this.instructionsAcross.add(line);
				}else {
					break;
				}	
			}
			System.out.println(this.instructionsAcross);
			
			//Read the instructions down
			sc.nextLine(); // this is the Down line separator
			while(sc.hasNextLine()) {
				this.instructionsDown.add(sc.nextLine()); //
			}
			System.out.println(this.instructionsDown);
			
			//create the solutionCells matrix
			this.solutionCells = new GlobalCells[this.solution.length()];
			for (int i=0; i< this.solution.length(); i++) {
				this.solutionCells[i]= CellFactory.createCell("S");
			}
			sc.close();
		}catch (Exception e) {
			 e.printStackTrace();
		}
		
		//create frame 
		JFrame crossboardWindow = new JFrame();
		crossboardWindow.setLayout(new BorderLayout());
		crossboardWindow.setTitle("Swedish-Style");
		crossboardWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		crossboardWindow.setSize(2000,2000);
		
		//create panels
		JPanel crossWordPanel = new CrosswordPanel().CreateCrosswordPanel(gridCrossword);
		JPanel solutionPanel = new SolutionPanel().CreateSolutionPanel(solutionCells,solution);
		JPanel instructionPanel= new InstructionsPanel().CreateInstructionsPanel(instructionsAcross, instructionsDown);
		
		//add panels to frame
		crossboardWindow.add(crossWordPanel);
		crossboardWindow.add(solutionPanel,BorderLayout.SOUTH);
		crossboardWindow.add(instructionPanel,BorderLayout.WEST);
		
		crossboardWindow.pack();
		crossboardWindow.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		PlayCrossword swedishCrossword = new PlayCrossword(); 
	}

}
