package com.akivaGrobman.gameOfLife;

import com.akivaGrobman.gameOfLife.backend.Board;
import static com.akivaGrobman.gameOfLife.database.ShapePool.*;

public class Main {

    private static boolean notPaused;
    private static int displayRefreshSpeed;

    public static void main(String[] args) throws InterruptedException {
        notPaused = true;
        displayRefreshSpeed = 100;
        boolean boardWasChanged = true;
        Board board = new Board(40, 40);
        board.setAlive(getGun());
        do {
            if(notPaused) {
                board.addClickedTiles();
                board.updateGeneration();
                board.updateBoard();
                board.displayBoard();
                boardWasChanged = board.getBoardWasChanged();
            }
            Thread.sleep(displayRefreshSpeed);
        } while (boardWasChanged);
    }

    public static void updateNotPaused() {
        notPaused = !notPaused;
    }

    public static void changeDisplaySpeed(int newSpeed) {
        displayRefreshSpeed = newSpeed;
    }

}
