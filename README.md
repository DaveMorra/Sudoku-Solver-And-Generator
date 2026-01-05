# Sudoku-Solver-And-Generator

## Table of Contents

- [Overview](#overview)
- [Requirements](#requirements)
- [Setup](#setup)
- [Demonstration](#Demonstration)

## Overview

This project implements a Sudoku Solver and Generator in Java for standard 9×9 Sudoku boards. The solver reads a Sudoku puzzle from a file, then solves it using depth-first search with backtracking. The generator creates a valid Sudoku board with a specified number of known cells, ensuring the puzzle has at least one valid solution. All boards are stored and loaded using plain .txt files.

## Requirements

Before running this project, ensure that you meet the following requirements:

### Software Dependencies
1. **Java 19.0.0 (or later)**: Be sure to use Java 19 or newer.

## Setup

### Step 1: Clone the Repository
First, clone or download this repository to your local machine:
```
git clone https://github.com/DaveMorra/Sudoku-Solver-And-Generator
```
Then, navigate to the source directory:
```
cd Sudoku-Solver-And-Generator/src
```

### Step 2: Compile and Run
Quickly build and run the project in any IDE that supports java (e.g. IntelliJ IDEA, Eclipse).
Alternatively, you can compile and run it directly from the command line on any system with a built-in Java compiler.

### Compile sudoku board model:
```
javac models/SudokuBoard.java
```

### Run the Sudoku Solver
```
java SudokuSolver.java <optionalSudokuFile.txt>
```
After running the file. The solved sudoku board will be printed onto the terminal, and a **sudokuFile_solved.txt** will appead
in the directory. If no input sudoku file is passed, a default board will be used.

### Run the Sudoku Generator
```
java SudokuGenerator.java <optionalGeneratedFileName.txt>
```
After running the file. The Generated sudoku board will be printed onto the terminal, and a **generatedFileName.txt** will appead
in the directory. If no input sudoku file is passed, a default file name will be used.

## Demonstration
Solved Sudoku Board using **SudokuSolver.java**:

![alt text](https://github.com/DaveMorra/Sudoku-Solver-And-Generator/blob/main/images/image1.png)

Generated Sudoku Board using **SudokuGenerator.java**:

![alt text](https://github.com/DaveMorra/Sudoku-Solver-And-Generator/blob/main/images/image2.png)
