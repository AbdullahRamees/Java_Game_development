     # Java_Game_development
      It's a repository for my jaa game development 

      -->intellij idea is use to create java codes

       -->game class structures
             ->Game files
             ->skeleton of the game
             ->Game states

             -->Game file structure
                 ---> Main_class ->the class that I run the game and
                   the rest of the classes are connected to the main
                   if User want to run the game he runs the main class
                 --->Game_play_class -> the main methods for running
                 --->game_picture -> use to game graphics
                 --->Game_audio -> use to play game audio


             --Skeleton of the game

                     --->main class
                                 --> public static void main
                                 --> JFrame()
                                 -->game play class obj
                     --->Game play class
                                 -->KeyListener()
                                 -->ActionListener()
                                 -->graphics2D()
                                 -->Jpanel()
                                 -->timer()
                                 -->Color()&font()
                     --->other classes
                                 -->Graphics2D()
                                 -->Color()&font()
                                 -->Enum(),For(),While


             --Game States

                     --initialize--> | intit'd |--start--> |Play| --GameOver/stop-->|game over|--Shutdown-->|destroy|

                         |play| --pause-->|paused|
                         |play| <--resume--|paused|

      -->Advanced methods and Packages
             ->Abstract Window toolKit(AWT)
             ->java Swing
             ->Input Output Stream and Sound

                    -->AWT
                     --java.awt.BasicStrocks
                     --java.awt.Color
                     --java.awt.Dimension
                     --java.awt.Event
                     --java.awt.Font
                     --java.awt.FontMetrics
                     --java.awt.Graphics
                     --java.awt.Graphics2D
                     --java.awt..Images
                     --java.awt.Toolkit
                     --java.awt.event.ActionEvent;
                     --java.awt.event.ActionListener
                     --java.awt.event.keyAdapter
                     --java.awt.event.KeyEvent

                   -->IO
                     --java.io.File
                     --java.io.FileInputStream
                     --java.io.InputStream

                   -->sound
                     --javax.sound.sampled.AudioinputStream
                     --javax.sound.sampled.AudioStream
                     --javax.sound.sampled.Clip

                   -->Swing
                     --javax.swing.Imageicon
                     --javax.swing.Joptionpane
                     --javax.swing.JPanel
                     --javax.swing.JFrame
                     --javax.swing.Timer


             ----->AWT :Java AWT (Abstract Window Toolkit) is an API to develop GUI or windows-based applications in Java.
                        Java AWT components are platform-dependent i.e. components are displayed according to the view of OS
                        AWT is heavy weight i.e. its components are using the resources of underlying OS

             ----->Swing:Java Swing is a part of Java Foundation Classes that is used to create window-based applications.
                         It is built on the top of AWT (Abstract Windowing Toolkit) API and entirely written in java.
                         Unlike AWT, Java Swing provides platform-independent and lightweight components.

      -->Coordinate System
             left side top corner is 0,0
                 --> left to right is  x+
                 --> Bottem is Y+


     --> Java Swing
             --JFrame :JFrame is responsible for only displaying the frame of the game.
             --Jpanel :is provice base in which an application can attach any other component.
                     //jpanel is added to JFrame to create GUI
             --Timer :it use to schedule tasks
                     --> timer declaration
                         ---->1. Import the timer class          import javax.swing.Timer;
                         ---->2.create a timer object            privete Timer timer; timer=new Timer(delay, this)
                         ---->3.Start the timer                  timer.start();
                         ---->4.Stop the timer                   timer.stop();
                         ---->5.Check if timer is running        timer.isrunning();

                         //timer is used to pause game .
                             eg. (key == keyEvent.VK_P){
                                       if (timer.isrunning()){
                                             timer.stop();
                                       }else{
                                             timer.start();
                                       }
                             }

             --imageIcon : ImageIcon is an implementation of the Icon interface that paints Icons from Images.
                             --image can be create using byte ,file or url.

                              --ImageIcon(byte[] imageData) : Creates an ImageIcon from an array of bytes
                              --ImageIcon(Image image)      : Creates an ImageIcon from an image object.
                              --ImageIcon(String filename)  : Creates an ImageIcon from the specified file.
                              --ImageIcon(URL location)     : Creates an ImageIcon from the specified URL.

                     -->ImageIcon Implementation
                             ---->1.Import ImageIcon class                 import javax.swing.ImageIcon;
                             ---->2.Create imageIcon object                private ImageIcon obj;
                             ---->3.Connect image to the ImaeIcon Object   obj= new ImageIcon("filename.png");
                             ---->4.print the JPanal with ImageIcon        obj.printIcon();


     --> Java Util
             --Random :The java.util.Random class instance is used to generate a stream of pseudorandom numbers

      -->Playing audio in java
             -- 1st --> input audio using IO
             -- 2nd --> use AudioInputSystem/AudioSystem : specify audio format and length
             -- 3rd --> using clip class we can control audio file

     Java AWT
             --Graphics : Graphics allows application to draw the component or on image
                         --drawString method : it used to draw a string
                         --setFont- provide font to string
             --Graphics2D: it inherits the Graphics class and give more control
             --Keylistener: interface for receive keyboard events
             --ActionListener: an action event occurs whenever an action is performed by user
                                 --->1.declare event handler
                                 --->2.register an instance of event handler class as listener on one or  more classes
                                 --->include code that implements the methods in listener interface


