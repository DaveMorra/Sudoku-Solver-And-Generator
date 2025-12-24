import models.SudokuBoard;

//this class will solve a given 9x9 Sudoku board
class SudokuSolver {

    //main function that solves a Sudoku board
    public static void main(String[] args) {

        //read file name and make boards
        String fileName;
        SudokuBoard originalBoard = new SudokuBoard();
        SudokuBoard solvedBoard = new SudokuBoard();
        if(args.length == 0) {fileName = "SudokuSolverTest/test2.txt";}
        else {fileName = args[0];}
        
        //read original board
        if(!originalBoard.readFile(fileName)) {return;}                                             //read board from file, if an error occures return
        originalBoard.print();                                                                      //print original board
        if(!originalBoard.isValid()) {                                                              //see if original board is solvable, if not return with error
            System.out.println("Error: Input baord is illegal");
            return;
        }                                                      

        //solve and write solution
        if(!solve(solvedBoard, originalBoard)) {return;}                                            //solve board using DFS with backtracking, if error then return
        if(!solvedBoard.writeFile(fileName, "_solved.txt")) {return;}              //write solution to file, if an error occures return
        solvedBoard.print();                                                                        //print solution

    }

    //method override to include a recursive starting postion at zero, and error handling
    public static boolean solve(SudokuBoard solvedBoard, SudokuBoard originalBoard) {
        for(int n = 0; n < 81; n++) {solvedBoard.board[n/9][n%9] = originalBoard.board[n/9][n%9];}
        return solve(solvedBoard, originalBoard, 0);
    }

    //use backtraking depth first search to find valid postions until the board is solved
    private static boolean solve(SudokuBoard solvedBoard, SudokuBoard originalBoard, int index) {

        //base case
        if(index > 81 || !solvedBoard.isValid()) {return false;}
        if(solvedBoard.isSolved()) {return true;}

        //recucsive case 1, postion already determined
        if(originalBoard.board[index/9][index%9] != 0) {return solve(solvedBoard, originalBoard, index + 1);}

        //recucsive case 2, postion undetermined
        for(int n = 1; n < 10; n++) {
            solvedBoard.board[index/9][index%9] = n;
            if(solve(solvedBoard, originalBoard, index + 1)) {return true;}
        }
        
        //backtrack is no valid number is found in given poition
        solvedBoard.board[index/9][index%9] = 0;
        return false;
    }

}