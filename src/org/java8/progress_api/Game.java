package org.java8.progress_api;

import java.util.Arrays;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        List<Resizable> list = Arrays.asList(new Ellipse(), new Ellipse());
        Utils.paint(list);
    }
}