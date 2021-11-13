package com.atarious.studio.brickBreaker;


import java.awt.*;

public class Level_00 {
    public int [][] Map ;
    public int MapWidth;
    public int mapheight;

    public Level_00 (int row, int column) {
        Map = new int[row][column];
        for(int i=0; i<Map.length ;i++){
            for(int j = 0; j<Map[0].length ; j++){
                Map[i][j]= 1;

            }
        }

        MapWidth = 540/column;
        mapheight = 150/row;
    }
    public void draw(Graphics2D G2D){
        for(int i=0; i<Map.length ;i++){
            for(int j = 0; j<Map[0].length ; j++){
                if(Map[i][j]>0){
                    G2D.setColor(Color.black);
                    G2D.fillRect(j*MapWidth+80,i*mapheight+50,MapWidth,mapheight);

                    G2D.setStroke(new BasicStroke(3));
                    G2D.setColor(Color.gray);
                    G2D.drawRect(j*MapWidth+80,i*mapheight+50,MapWidth,mapheight);
                }

            }
        }

    }

    public void setbrickvalue(int value ,int row , int column){
        Map[row][column]=value;

    }
}
