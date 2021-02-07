import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lvl1Screen6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lvl2Screen4 extends Levels
{

    /**
     * Constructor for objects of class Lvl1Screen6.
     * 
     */
    public Lvl2Screen4(int health)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        printLevel("Lvl 2");
        addHealth();
        updateHealthLevel(health);
        drawPath();
        Knight knight = new Knight();
        knight.setHealth(health);
        addObject(knight,20,309);
    }
    
    public void drawPath(){
        int x=15;
        int y=350;
        for(int i=0; i < 20; i++){
            addObject(new Ground(), x, y);
            addObject(new InnerBlock(), x, y+30);
            x+=30;
        }
        addObject(new InvisiblePortal(), 600, 280);
        
    }
   
    /*
    public void addSlime(){
        Slime s1 = new Slime();
        addObject(s1, 250, 290);
        
        Slime s2 = new Slime();
        addObject(s2, 480, 160);
    }
    */
    

}
