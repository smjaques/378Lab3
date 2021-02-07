import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lvl1Screen4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lvl1Screen4 extends Levels
{

    /**
     * Constructor for objects of class Lvl1Screen4.
     * 
     */
    public Lvl1Screen4(int health)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        printLevel("Lvl 1");
        addHealth();
        updateHealthLevel(health);
        drawPath();
        addBats();
        Knight knight = new Knight();
        addObject(knight,20,277);
    }
    
    public void drawPath(){
        int y=320;
        int x=10;
        for(int i = 0; i < 6; i++){
            addObject(new Ground(), x, y);
            addObject(new InnerBlock(), x, y+20);
            addObject(new InnerBlock(), x, y+50);
            addObject(new InnerBlock(), x, y+80);
            x+=30;            
        }
        x+=85;
        for(int i = 0; i < 6; i++){
            addObject(new Ground(), x, y);
            addObject(new InnerBlock(), x, y+20);
            addObject(new InnerBlock(), x, y+50);
            addObject(new InnerBlock(), x, y+80);
            x+=30;            
        }
        
        InvisiblePortal portal = new InvisiblePortal();
        addObject(new InvisiblePortal(), 600, 70);
    }
    
    public void addBats(){
        Bat b1 = new Bat(1);
        addObject(b1, 30, 40);
        
        Bat b2 = new Bat(1);
        b2.setImage(new GreenfootImage("batFlyL1.png"));
        addObject(b2, 575, 90);
    }
}
