package com.akivaGrobman.gameOfLife.frontend;

import com.akivaGrobman.gameOfLife.Main;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.akivaGrobman.gameOfLife.frontend.Window.clickedList;

public class MyListeners {

    static class MyClickListener implements MouseListener {

        private final Point position;
        private final MyDisplayPanel displayPanel;

        public MyClickListener(int x, int y, MyDisplayPanel displayPanel) {
            position = new Point(x, y);
            this.displayPanel = displayPanel;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            clickedList.add(position);
            displayPanel.clicked(position.x, position.y);
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    }

    static class PlayButtonListener implements ActionListener {

        private final JButton button;

        PlayButtonListener(JButton button) {
            this.button = button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(button.getText().equals("Play")) {
                button.setText("Pause");
            } else {
                button.setText("Play");
            }
            Main.updateNotPaused();
        }

    }

    static class MySliderChangeListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            int newValue = ((JSlider)e.getSource()).getValue() * 10;
            Main.changeDisplaySpeed(newValue);
        }

    }

}
