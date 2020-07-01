package com.akivaGrobman.gameOfLife.frontend;

import javax.swing.*;
import java.awt.*;
import static com.akivaGrobman.gameOfLife.frontend.Window.*;

public class MyDisplayPanel extends JPanel {

    private final JLabel[][] board;

    public MyDisplayPanel(int width, int height) {
        board = new JLabel[height][width];
        setLayout(new GridLayout(width, height));
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                JLabel label = new JLabel();
                label.setSize(TILE_SIZE, TILE_SIZE);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.black));
                label.setOpaque(true);
                label.addMouseListener(new MyListeners.MyClickListener(x, y, this));
                board[y][x] = label;
                add(board[y][x]);
            }
        }
    }

    void addShape(int x, int y) {
        board[y][x].setBackground(blue);
    }

    void removeShape(int x, int y) {
        board[y][x].setBackground(green);
    }

    void clicked(int x, int y) {
        if(board[y][x].getBackground().equals(green)) {
            addShape(x, y);
        } else {
            removeShape(x, y);
        }
    }

}
