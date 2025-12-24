package models;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//this class is a int matrix that repersents the sudoku board
public class SudokuBoard {

    //hold current board postion
    public int[][] board;

    //initialization of empty board
    public SudokuBoard() {
        this.board = new int[9][9];
    }
    
    //open and read file
    public boolean readFile(String fileName) {
        
        try (FileReader file = new FileReader(fileName)) {

            int value, i = 0;
            while ((value = file.read()) != -1) {
                if((int) value == 13 || (int) value == 10 || (int) value == 32) {continue;} //ignore spaces and new lines
                if((char) value == '-') {board[i/9][i++%9] = 0;}
                else {board[i/9][i++%9] = ((int) value) - 48;}
            }
            return true;

        } catch(Exception e) { 
            System.out.println("Error: " + e);
            return false;
        }

    }

    //open and write to file
    public boolean writeFile(String fileName, String suffixIdentifier) {
        
        try (FileWriter file = new FileWriter(new File(fileName.replace(".txt", "") + suffixIdentifier))) {

            for(int y = 0; y < 9; y++) {
                for(int x = 0; x < 9; x++) {
                    if(board[y][x] != 0) {file.write(String.valueOf(board[y][x]));}
                    else {file.write("-");}
                }
                file.write("\n");
            }
            return true;

        } catch(Exception e) { 
            System.out.println("Error: " + e);
            return false;
        }

    }

    //print current board
    public void print() {
        
        System.out.printf("\n\nSudoku Board:");
        for(int y = 0; y < 9; y++) {
            if(y%3 == 0 && y != 0) {System.out.printf("\n------+-------+------");}
            System.out.printf("\n");
            for(int x = 0; x < 9; x++) {
                if(x%3 == 0 && x != 0) {System.out.printf("| ");}
                if(board[y][x] == 0) {System.out.printf("- "); }
                else { System.out.printf("%d ", board[y][x]); }
            }
        }

    }

    //return true/false if the board is fully solved
    public boolean isSolved() {

        //if not all the squares are filled return false
        for(int y = 0; y < 9; y++) {
            for(int x = 0; x < 9; x++) {
                if(board[y][x] == 0) {return false;}
            }
        }

        //return if the board is valid
        return isValid();
    }

    //return true/false if the board is currently valid
    public boolean isValid() {
        boolean[] numtaken = new boolean[10];
        for(int n = 0; n < 9; n++) {numtaken[n] = false;}

        //see if rows are valid with no repeat of numbers 1-9
        for(int y = 0; y < 9; y++) {
            for(int n = 0; n < 10; n++) {numtaken[n] = false;}
            for(int x = 0; x < 9; x++) {
                if(board[y][x] == 0) {continue;} //ignore -1
                if(numtaken[board[y][x]]) {return false;}
                numtaken[board[y][x]] = true;
            }
        }

        //see if columns are valid with no repeat of numbers 1-9
        for(int x = 0; x < 9; x++) {
            for(int n = 0; n < 10; n++) {numtaken[n] = false;}
            for(int y = 0; y < 9; y++) {
                if(board[y][x] == 0) {continue;} //ignore -1
                if(numtaken[board[y][x]]) {return false;}
                numtaken[board[y][x]] = true;
            }
        }

        //see if each square is valid with no repeat of numbers 1-9
        for(int x = 0; x < 9; x += 3) {
            for(int y = 0; y < 9; y += 3) {
                for(int n = 0; n < 10; n++) {numtaken[n] = false;}
                for(int n = 0; n < 9; n++) {
                    if(board[y+(n/3)][x+(n%3)] == 0) {continue;} //ignore -1
                    if(numtaken[board[y+(n/3)][x+(n%3)]]) {return false;}
                    numtaken[board[y+(n/3)][x+(n%3)]] = true;
                }
            }
        }
        
        return true;
    }

}
