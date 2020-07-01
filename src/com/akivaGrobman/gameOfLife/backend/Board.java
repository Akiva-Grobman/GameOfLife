package com.akivaGrobman.gameOfLife.backend;

import com.akivaGrobman.gameOfLife.frontend.Window;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Board {

    private final Window window;
    private boolean[][] board;
    private boolean[][] nextGenerationsBoard;
    private int generation;
    private boolean boardWasChanged;

    public Board(int height, int width) {
        window = new Window(width, height);
        generation = 0;
        boardWasChanged = false;
        initializeBoard(height, width);
    }

    public void displayBoard() {
        window.repaint();
    }

    public void setAlive(List<Point> positions) {
        for (Point position: positions) {
            nextGenerationsBoard[position.y][position.x] = true;
        }
    }

    public void updateGeneration() {
        window.nextGeneration();
        generation++;
    }

    public void updateBoard() {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                // update current game state
                board[y][x] = (nextGenerationsBoard[y][x]);
                // update on display game state
                window.setAlive(x, y, board[y][x]);
            }
        }
        // set next generations board
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                int liveNeighborCount = getLiveNeighborCount(x, y);
                if(liveNeighborCount > 3 || liveNeighborCount < 2) {
                    nextGenerationsBoard[y][x] = false;
                } else {
                    nextGenerationsBoard[y][x] = liveNeighborCount == 3 || board[y][x];
                }
                if(!boardWasChanged) {
                    boardWasChanged = board[y][x] != nextGenerationsBoard[y][x];
                }
            }
        }

    }

    public void addClickedTiles() {
        for (Point position: window.getClickedList()) {
            nextGenerationsBoard[position.y][position.x] = true;
        }
        window.resetClickedList();
    }

    private int getLiveNeighborCount(int x, int y) {
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if(i == 0 && j == 0) continue;
                if(isInBounds(x + i, board[0].length) && isInBounds(y + j, board.length)) {
                    if(board[y + j][x + i]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean getBoardWasChanged() {
        return boardWasChanged;
    }

    private boolean isInBounds(int position, int arrayLength) {
        return position >= 0 && position < arrayLength;
    }

    private void initializeBoard(int height, int width) {
        nextGenerationsBoard = new boolean[height][width];
        board = new boolean[height][width];
        for(boolean[] arr: nextGenerationsBoard) {
           Arrays.fill(arr, false);
        }
    }

    @Override
    public String toString() {
        StringBuilder boardAsString = new StringBuilder();
        boardAsString.append("Generation: ").append(generation).append('\n');
        StringBuilder line = new StringBuilder(" ");
        line.append("----".repeat(board[0].length));
        line.append("-\n");
        for (boolean[] row: board) {
            boardAsString.append(line);
            for (boolean column: row) {
                char c = (column)? '*' : ' ';
                boardAsString.append(" | ").append(c);
            }
            boardAsString.append(" |\n");
        }
        return boardAsString.toString() + line;
    }

}
