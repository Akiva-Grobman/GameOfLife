package com.akivaGrobman.gameOfLife.frontend;

import static com.akivaGrobman.gameOfLife.frontend.Window.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MyDisplayBar extends JPanel {

    private int generation;
    private final JLabel textDisplay;

    MyDisplayBar() {
        generation = 1;
        textDisplay = new JLabel(String.valueOf(generation));
        setPreferredSize(new Dimension(0, 100));
        setLayout(new BorderLayout());
        setBackground(green);
        Font font = new Font("arial", Font.ITALIC, 50);
        setFont(font);
        textDisplay.setForeground(blue);
        textDisplay.setBorder(new EmptyBorder(0, 250, 0, 0));
        add(textDisplay, BorderLayout.WEST);
        JButton playButton = new JButton();
        playButton.setFont(font);
        playButton.setForeground(green);
        playButton.setBackground(blue);
        playButton.setFocusPainted(false);
        playButton.setText("Pause");
        playButton.addActionListener(new MyListeners.PlayButtonListener(playButton));
        add(playButton, BorderLayout.EAST);
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 50, 10);
        slider.setBackground(green);
        slider.setForeground(blue);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.addChangeListener(new MyListeners.MySliderChangeListener());
        add(slider, BorderLayout.CENTER);
    }

    void updateGeneration() {
        generation++;
        textDisplay.setText("Generation: " + generation + "                                                   ");
    }

}
