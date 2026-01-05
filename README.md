# Sudoku-Solver-And-Generator

## Table of Contents

- [Overview](#overview)
- [Requirements](#requirements)
- [Setup](#setup)
- [Technical Overview](#technical-overview)

## Overview

This project implements a Sudoku Solver and Generator in Java for standard 9×9 Sudoku boards.
-The solver reads a Sudoku puzzle from a file, validates it, and solves it using depth-first search with backtracking.
-The generator creates a valid Sudoku board with a specified number of known cells, ensuring the puzzle has at least one valid solution.
All boards are stored and loaded using plain .txt files.

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
After running the file. The solved sudoku board will be print onto the terminal, and a **<sudokuFile>_solved.txt** will appead
in the directory. If no input sudoku file is passed, a default board will be used.

# Run the Sudoku Generator
```
java SudokuGenerator.java <optionalGeneratedFileName.txt>
```

## Technical Overview
The simulation uses a particle-based physics engine to model fluid-like behavior by updating forces, velocities, and positions for each particle. Particles are organized in a spatial grid to efficiently calculate interactions only with nearby neighbors. Real-time rendering is handled with Swing, and users can interact with the simulation using mouse events to attract or repel particles. Below are three images that demonstrate the simulation in action, showing particle movement, fluid-like interactions, and user-driven effects through mouse input.

 - Rendering: Swing (JFrame + JPanel)
 - Simulation Loop: Updates particles in real time at (Default: 120FPS)
 - Physics: Position, velocity, and force calculations
 - Interaction: UserMouseEvent to pass mouse input into the environment

