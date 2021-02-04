import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lvl1Screen2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lvl1Screen2 extends Levels
{

    /**
     * Constructor for objects of class Lvl1Screen2.
     * 
     */
    public Lvl1Screen2(int health)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        printLevel("Lvl 1");
        addHealth();
        updateHealthLevel(health);
        drawPath();
        Knight knight = new Knight();
        addObject(knight,20,310);
    }
    
    public void drawPath(){
        GreenfootImage b1 = new GreenfootImage("BlocksSimple1.png");
        GreenfootImage b2 = new GreenfootImage("BlocksSimple2.png");
        GreenfootImage b3 = new GreenfootImage("BlocksSimple3.png");
        GreenfootImage b4 = new GreenfootImage("BlocksSimple4.png");
        GreenfootImage b5 = new GreenfootImage("BlocksSimple5.png");
        GreenfootImage b6 = new GreenfootImage("BlocksSimple6.png");
        GreenfootImage b7 = new GreenfootImage("BlocksSimple7.png");
        GreenfootImage b8 = new GreenfootImage("BlocksSimple8.png");
        GreenfootImage b9 = new GreenfootImage("BlocksSimple9.png");
        GreenfootImage b10 = new GreenfootImage("BlocksSimple10.png");
        GreenfootImage b11 = new GreenfootImage("BlocksSimple11.png");
        GreenfootImage b12 = new GreenfootImage("BlocksSimple12.png");       
        
        
        int y=339;
        int x=10;
        for(int i = 0; i < 21; i++){
            addObject(new Ground(), x, y);
            addObject(new InnerBlock(), x, y+20);
            addObject(new InnerBlock(), x, y+50);
            x+=30;            
        }
        
        x=200;
        y=307;
        Platform p1 = new Platform();
        p1.setImage(b10);
        addObject(p1, x, y);
        
        x+=30;
        for(int i=0; i < 2; i++){
            InnerBlock ib = new InnerBlock();
            ib.setImage(b4);
            addObject(ib, x, y);
            x+=30;
        }
        
        Platform p2 = new Platform();
        p2.setImage(b9);
        addObject(p2, x, y);
        y-=30;
        
        Platform p3 = new Platform();
        p3.setImage(b8);
        addObject(p3, x, y);
        x-=30;
        for(int i=0; i < 2; i++){
            InnerBlock ib = new InnerBlock();
            ib.setImage(b2);
            addObject(ib, x, y);
            x-=30;
        }
        
        Platform p4 = new Platform();
        p4.setImage(b7);
        addObject(p4, x, y);
        x+=30;
        y-=30;
        
        Platform p5 = new Platform();
        p5.setImage(b10);
        addObject(p5, x, y);
        
        Platform p6 = new Platform();
        p6.setImage(b9);
        addObject(p6, x+30, y);
        
        Platform p7 = new Platform();
        p7.setImage(b5);
        addObject(p7, x+30, y-30);
        
        Platform p8 = new Platform();
        p8.setImage(b8);
        addObject(p8, x+30, y-60);
       
        Platform p9 = new Platform();
        p9.setImage(b7);
        addObject(p9, x, y-60);

        Platform p10 = new Platform();
        p10.setImage(b6);
        addObject(p10, x, y-30);
        
        x=100;
        y=215;
        Platform p11= new Platform();
        p11.setImage(b11);
        addObject(p11, x, y);
        
        Platform p12 = new Platform();
        p12.setImage(b11);
        addObject(p12, x-30, y);
    }
}
