import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lvl1Screen6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lvl3Screen2 extends Levels
{

    /**
     * Constructor for objects of class Lvl1Screen6.
     * 
     */
    public Lvl3Screen2(int health)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        printLevel("Lvl 3");
        addHealth();
        updateHealthLevel(health);
        drawPath();
        Princess princess = new Princess();
        addObject(princess,575,310);
    }
    
    public void drawPath(){
        int x=15;
        int y=350;
        for(int i=0; i < 20; i++){
            addObject(new Ground(), x, y);
            addObject(new InnerBlock(), x, y+30);
            x+=30;
        }
        addObject(new InvisiblePortal(), 8, 310);
        
    }
   

    

}
