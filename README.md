# 🌈 Rainbow Puzzle Solver

A fully interactive 2x6 tile puzzle game and AI-powered solver built in Java. Users can manipulate a colorful grid by swapping columns and shifting rows with simple keystrokes. The game challenges players to restore the board to a “rainbow order” state, and includes a solver that intelligently reverse-engineers the shortest path to the goal using breadth-first search (BFS) and custom board hashing.

---

## 🧩 Objective

Solve a 2-row, 6-column board such that:
- Each column contains two matching colors.
- The colors from left to right match the rainbow order:  
  `RED → ORANGE → YELLOW → GREEN → BLUE → VIOLET`.

Example solved state:

---

## ⚙️ Game Controls

| Key | Action                      |
|-----|-----------------------------|
| 1–6 | Swap top and bottom tile of the column |
| a   | Shift the **top row left**  |
| b   | Shift the **top row right** |
| c   | Shift the **bottom row left** |
| d   | Shift the **bottom row right** |

---

## 🧠 Core Features

### 🎮 Gameplay (Interactive)

- Console-based UI using `Princeton StdIn/StdOut` for input/output
- Real-time updates of the game board after each move
- Prevents infinite loops by checking for previously seen board states using a hash map
- Automatically detects and ends the game when a winning configuration or repetition is reached

### 🧠 Solver (AI Engine)

- Precomputes **all board configurations up to 12 moves away** using **Breadth-First Search (BFS)**
- Efficiently tracks and avoids duplicate states with custom hash functions and deep equality checks
- Stores move history using a `StateNode` class to reconstruct the optimal solution path
- Capable of solving any reachable configuration within the 12-move boundary
- Reversible-move logic (e.g. `a` ⇄ `b`, `c` ⇄ `d`) ensures minimal computation and accurate path recovery

---

## 🛠️ Technologies & Concepts

| Tech/Concept | Usage |
|--------------|-------|
| **Java**     | Core programming language |
| **AWT**      | For color representation of tiles |
| **Princeton StdLib** | For clean console input/output & data structures |
| **BFS (Breadth-First Search)** | Solver algorithm for state-space traversal |
| **HashMap**  | Fast duplicate detection of board states |
| **Custom Hashing** | Generates compact unique keys for board states |
| **OOP Design** | Clean separation of game, board, and solver logic into modular classes |

---

## 🚀 Running the Project

### 📦 Prerequisites
- Java 8 or higher
- Download [`algs4.jar`](https://algs4.cs.princeton.edu/code/algs4.jar)

### 💻 To Run the Game
```bash
javac -cp ".:algs4.jar" p1/Game.java
java -cp ".:algs4.jar" p1.Game

### 💻 To Run the Solver
javac -cp ".:algs4.jar" p2/Solver.java
java -cp ".:algs4.jar" p2.Solver
