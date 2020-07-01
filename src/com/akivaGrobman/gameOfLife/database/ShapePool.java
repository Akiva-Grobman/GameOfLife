package com.akivaGrobman.gameOfLife.database;

import java.awt.*;
import java.util.List;

public class ShapePool {

    public static java.util.List<Point> getGun() {
        return java.util.List.of(
                new Point(1, 5), new Point(2, 5), new Point(1, 6), new Point(2, 6),
                new Point(11, 5), new Point(11, 6), new Point(11, 7), new Point(12, 4), new Point(12, 8), new Point(13, 3), new Point(13, 9), new Point(14, 3), new Point(14, 9), new Point(15, 6), new Point(16, 4), new Point(16, 8), new Point(17, 5), new Point(17, 6), new Point(17, 7), new Point(18, 6),
                new Point(21, 3), new Point(21, 4), new Point(21, 5), new Point(22, 3), new Point(22, 4), new Point(22, 5), new Point(23, 2), new Point(23, 6), new Point(25, 1), new Point(25, 2), new Point(25, 6), new Point(25, 7),
                new Point(35, 3), new Point(35, 4), new Point(36, 3), new Point(36, 4)
        );
    }

    public static java.util.List<Point> getFirstTry() {
        return List.of(new Point(7, 6),
                new Point(6, 7), new Point(7, 7), new Point(8, 7),
                new Point(5, 8), new Point(6, 8), new Point(7, 8), new Point(8, 8), new Point(9, 8),
                new Point(5, 15), new Point(6, 15), new Point(7, 15), new Point(8, 15), new Point(9, 15),
                new Point(6, 16), new Point(7, 16), new Point(8, 16),
                new Point(7, 17),

                new Point(17, 6),
                new Point(16, 7), new Point(17, 7), new Point(18, 7),
                new Point(15, 8), new Point(16, 8), new Point(17, 8), new Point(18, 8), new Point(19, 8),
                new Point(15, 15), new Point(16, 15), new Point(17, 15), new Point(18, 15), new Point(19, 15),
                new Point(16, 16), new Point(17, 16), new Point(18, 16),
                new Point(17, 17));
    }

}
