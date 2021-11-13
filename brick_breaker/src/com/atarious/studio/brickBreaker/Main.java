package com.atarious.studio.brickBreaker;

import javax.swing.*;

public class Main {
    public static void main(String[] arg) {
        JFrame frame = new JFrame();                                //creating an object of JFrame class

        Game game = new Game();                                     //creating an object of game class

        //frame properties
        frame.setBounds(10, 10, 700, 600);           //boundaries of frame
        frame.setTitle("Atarious Studio's Brick Breaker");          //title of frame
        frame.setResizable(false);                                  //resizing the frame is false
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //exit when close button pressed
        frame.add(game);                                            //adding the penal
    }
}
