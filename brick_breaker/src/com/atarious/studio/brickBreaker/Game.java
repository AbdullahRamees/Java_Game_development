package com.atarious.studio.brickBreaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;

public class Game extends JPanel implements KeyListener,ActionListener {

        //Game properties
        private boolean Play = false;                         //check is game is running
        private int scores = 0;                               //Score board
        private int TotalBrick = 21 ;                         //Total number of bricks in the game
        private Timer timer;                                  //pause and play
        private int Delay = 8;                                //Timer delay

        //player properties
        private int PlayerX = 310;                           //starting position of peddle
        private int playerMove = 20;                         //action position when user hit key

        //playable ball prob properties
        private int BallPosX = 120;                          //starting position of ball X axis
        private int BallPosY = 350;                          //starting position of Ball Y axis
        private int BallX = -1;                              //ball traverse distance along X axis
        private int BallY = -2;                              //Ball traverse distance along Y axis

        //constructor of Game class
        public Game (){
            addKeyListener(this);
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);
            timer = new Timer(Delay,this);
            timer.start();                                   //Game starts
        }
            //painting  frame using penal
        public void paint(Graphics graphics){
            //paint background of frame
            graphics.setColor(Color.gray);
            graphics.fillRect(1,1,692,592);

            //paint boarder of frame
            graphics.setColor(Color.red);
            graphics.fillRect(0,0,3,592);   //left boarder
            graphics.fillRect(0,0,692,3);   //top boarder
            graphics.fillRect(680,0,4,592); //Right boarder

            //paint paddle
            graphics.setColor(Color.blue);
            graphics.fillRect(PlayerX,550,100,8);
            //paint ball
            graphics.setColor(Color.green);
            graphics.fillOval(BallPosX,BallPosY,20,20);

            graphics.dispose();                                 //dispose graphic contexts & System resources that using

        }

        //peddle  movement  methods
        public void moveleft (){
            Play=true;
            PlayerX -= playerMove;
        }
        public void moveRight (){
            Play=true;
            PlayerX += playerMove;
        }




    //overriding abstract methods
        @Override
        public void actionPerformed(ActionEvent e) {
            //repainting the event action
            timer.start();
            repaint();

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            //Code for right Arrow
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                if (PlayerX>=600){                                //checking is paddle at right boarder
                    PlayerX=600;                                  //Making paddle stay at boarder
                }else {
                    moveRight();                                  //player can move right by this method
                }
            }

            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                if(PlayerX < 10){                                  //checking is paddle at left boarder
                    PlayerX=10;                                    //Making paddle stay at boarder
                }else{
                    moveleft();                                    //player can move left by this method
                }
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
}
