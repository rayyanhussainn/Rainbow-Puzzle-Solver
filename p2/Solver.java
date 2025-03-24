package p2;

import java.awt.Color;
import java.util.Map;          // Use the Map interface
import java.util.HashMap;      // For HashMap implementation
import java.util.TreeMap;
import edu.princeton.cs.algs4.Queue;

public class Solver {

    // The solved configuration for the puzzle (goal state)
    private Color[][] goalConfig = {
        {Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET},
        {Display.RED, Display.ORANGE, Display.YELLOW, Display.GREEN, Display.BLUE, Display.VIOLET}
    };

    // A map that records each board state (via its hash) and a corresponding StateNode
    private Map<Long, StateNode> stateMap;

    // Helper inner class that stores the move applied and the move count from the goal state.
    private static class StateNode {
        char moveApplied; // Move that led from the parent state
        int movesCount;   // Number of moves from the solved (goal) board

        StateNode(char moveApplied, int movesCount) {
            this.moveApplied = moveApplied;
            this.movesCount = movesCount;
        }
    }

    // Constructor: precomputes all board states (up to 12 moves away) from the solved configuration.
    public Solver() {
        stateMap = new HashMap<>();
        // stateMap = new TreeMap<>();
        Board solved = new Board(goalConfig);
        Queue<Board> boardQueue = new Queue<>();

        boardQueue.enqueue(solved);
        stateMap.put(solved.hash(), new StateNode('0', 0));  // The goal board has no move

        // Perform BFS until all states within 12 moves have been explored.
        while (!boardQueue.isEmpty()) {
            Board currentBoard = boardQueue.dequeue();
            long currentHash = currentBoard.hash();
            StateNode currentNode = stateMap.get(currentHash);
            int movesSoFar = currentNode.movesCount;

            if (movesSoFar >= 12) continue;

            for (char action : new char[] {'1', '2', '3', '4', '5', '6', 'a', 'b', 'c', 'd'}) {
                currentBoard.move(action); // Apply a move
                long newHash = currentBoard.hash();

                if (!stateMap.containsKey(newHash)) {
                    boardQueue.enqueue(new Board(currentBoard.getGrid()));
                    stateMap.put(newHash, new StateNode(action, movesSoFar + 1));
                }
                currentBoard.move(reverseMove(action)); // Undo the move to restore state
            }
        }
    }

    // Returns the sequence of moves (as a char array) to solve the given puzzle configuration.
    public char[] solve(Color[][] startConfig) {
        // If the board is already solved (note: using reference equality)
        if (startConfig.equals(goalConfig)) {
            return new char[0];
        }
        return reconstructPath(startConfig);
    }

    // Reconstructs the move sequence from the given board back to the solved board.
    public char[] reconstructPath(Color[][] initialConfig) {
        StringBuilder moveSequence = new StringBuilder();
        Board tempBoard = new Board(initialConfig);
        long stateHash = tempBoard.hash();

        while (stateMap.containsKey(stateHash)) {
            StateNode node = stateMap.get(stateHash);
            if (node.movesCount == 0) break; // Reached the goal state
            moveSequence.append(reverseMove(node.moveApplied));
            tempBoard.move(reverseMove(node.moveApplied));
            stateHash = tempBoard.hash();
        }
        return moveSequence.toString().toCharArray();
    }

    // Returns the reverse (inverse) of a move: row shifts reverse ('a' <-> 'b', 'c' <-> 'd'),
    // while column swaps are self-inverse.
    public char reverseMove(char action) {
        switch (action) {
            case 'a': return 'b';
            case 'b': return 'a';
            case 'c': return 'd';
            case 'd': return 'c';
            default:  return action;
        }
    }

    // Main method for testing the solver.
    public static void main(String[] args) {
        Color[][] testConfig = {
            {Display.VIOLET, Display.RED, Display.GREEN, Display.YELLOW, Display.GREEN, Display.BLUE},
            {Display.ORANGE, Display.YELLOW, Display.ORANGE, Display.BLUE, Display.VIOLET, Display.RED}
        };

        Solver solverInstance = new Solver();
        char[] solutionMoves = solverInstance.solve(testConfig);
        for (char move : solutionMoves) {
            System.out.print(move);
        }
    }
}
