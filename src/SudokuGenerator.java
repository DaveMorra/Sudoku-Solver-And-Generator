import java.util.Random;
import models.SudokuBoard;

//this class will generate a 9x9 Sudoku board
public class SudokuGenerator {
    
    //main function that generates a Sudoku board
    public static void main(String[] args) {
    
        //initialize board generator
        String fileName;
        int knownNumbers = 40;
        SudokuBoard generatedBoard = new SudokuBoard();
        if(args.length == 0) {fileName = "SudokuGeneratorTest/test3_generated.txt";}
        else {fileName = args[0];}

        //accept the total number of found squares that are generated
        if(args.length == 2) {knownNumbers = Integer.valueOf(args[1]);}

        //generate board, then save and print it
        if(!generate(generatedBoard, knownNumbers)) {                                                 //generate board, if an error occurs, return
            System.out.println("Error: Cant generate a board");
            return;
        }
        if(!generatedBoard.writeFile(fileName, ".txt")) {return;};                   //write solution to file, if an error occures return
        generatedBoard.print();                                                                        //print solution

    }

    //iteratively add random numbers to the generated board, while ensuring the board has at least one solution
    public static boolean generate(SudokuBoard generatedBoard, int knownNumbers) {

        //initialize temp board
        SudokuBoard seedBoard = new SudokuBoard();
        SudokuSolver sudokuSolver = new SudokuSolver();
        int currentAmountOfNumbers = 81;
        Random rand = new Random();
        int index;

        //generate full board with at least one solution
        for(int n = 0; n < 12;) {
            index = rand.nextInt(81);
            if(seedBoard.board[index/9][index%9] != 0) {continue;}
            seedBoard.board[index/9][index%9] = rand.nextInt(9) + 1;
            if(seedBoard.isValid() && sudokuSolver.solve(generatedBoard, seedBoard)) {n++;}
            else {seedBoard.board[index/9][index%9] = 0;}
        }

        //if a board cant be generated, then return false
        if(!generatedBoard.isSolved()) {return false;}

        //remove all nums until knownnumbers is reatched
        while(knownNumbers < currentAmountOfNumbers){
            index = rand.nextInt(81);
            if(generatedBoard.board[index/9][index%9] == 0) {continue;}
            generatedBoard.board[index/9][index%9] = 0;
            currentAmountOfNumbers--;
        }

        //if no faults occure, return true
        return true;
    }

}
