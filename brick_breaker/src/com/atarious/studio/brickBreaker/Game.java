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

        private int BallPosX = 120;                              //starting position of ball X axis
        private int BallPosY = 350;                              //starting position of Ball Y axis
        private int BallMoveX = -1;                              //ball traverse distance along X axis
        private int BallMoveY = -2;                              //Ball traverse distance along Y axis

        private Level_00 map;

        //constructor of Game class
        public Game (){
            map=new Level_00(3,7);

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

            map.draw((Graphics2D) graphics);
          
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




    //overriding abstract methods
        @Override
        public void actionPerformed(ActionEvent e) {
            //repainting the event action
            timer.start();

            //ball movement
                if(Play){
                    if(new Rectangle(BallPosX,BallPosY,20,20).intersects
                            (new Rectangle(PlayerX,550,100,8))){
                        BallMoveY = -BallMoveY;
                    }
                    for (int i =0;i<map.Map.length;i++){
                        for(int j=0;j<map.Map[0].length;i++){
                           int brickX=map.MapWidth+80;
                           int brickY=map.mapheight+50;
                           int brickWidth=map.MapWidth;
                           int brickHeight=map.mapheight;

                           Rectangle rect=new Rectangle(brickX,brickY,brickWidth,brickHeight);
                           Rectangle ball=new Rectangle(BallPosX,BallPosY,20,20);
                           Rectangle brick=rect;

                           if(ball.intersects(brick)){
                               map.setbrickvalue(0,i,j);
                               TotalBrick--;
                               scores=+5;
                               if(BallPosX+19<=brick.x||BallPosX+1>= brick.x+brick.width){
                                   BallMoveX= -BallMoveX;
                               }else{
                                   BallMoveY= -BallMoveY;
                               }
                           }

                        }
                    }


                    BallPosX += BallMoveX;
                    BallPosY += BallMoveY;
                    if(BallPosX==10){
                        BallMoveX = -BallMoveX;
                    }
                    if(BallPosY==10){
                        BallMoveY = -BallMoveY;
                    }
                    if(BallPosX>670){
                        BallMoveX = -BallMoveX;
                    }
                }

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

        //peddle  movement  methods
        public void moveleft (){
            Play=true;
            PlayerX =PlayerX - playerMove;
        }
        public void moveRight (){
            Play=true;
            PlayerX =PlayerX + playerMove;
        }


    @Override
        public void keyReleased(KeyEvent e) {

        }
}
