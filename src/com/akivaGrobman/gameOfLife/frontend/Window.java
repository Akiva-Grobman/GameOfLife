package com.akivaGrobman.gameOfLife.frontend;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Window extends JFrame {

    public static final Color blue = new Color(11, 93, 137);
    public static final Color green = new Color(3, 43, 23);
    public static final int TILE_SIZE = 20;
    public static List<Point> clickedList;
    private final MyDisplayPanel displayPanel;
    private final MyDisplayBar displayBar;

    public Window(int width, int height) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Game Of Life - By Akiva Grobman");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        displayPanel = new MyDisplayPanel(width, height);
        add(displayPanel, BorderLayout.CENTER);
        displayBar = new MyDisplayBar();
        add(displayBar, BorderLayout.SOUTH);
        clickedList = new ArrayList<>();
        setVisible(true);
    }

    public void setAlive(int x, int y, boolean isAlive) {
        if(isAlive) {
            displayPanel.addShape(x, y);
        } else {
            displayPanel.removeShape(x, y);
        }
    }

    public void nextGeneration() {
        displayBar.updateGeneration();
    }

    public void resetClickedList() {
        clickedList = new ArrayList<>();
    }

    public List<Point> getClickedList() {
        return clickedList;
    }

}
