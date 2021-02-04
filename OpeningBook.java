import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OpeningBook extends World
{

    public OpeningBook()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
    }

    
    public void act(){
        Greenfoot.delay(40);
        setBackground(new GreenfootImage("openBook.png")); 
        LeftBook left = new LeftBook();
        addObject(left, 160, 180);
        RightBook right = new RightBook();
        addObject(right,440,180);
        if(Greenfoot.getKey() != null){
            Greenfoot.setWorld(new Lvl1Screen1());
        }
        
    }
}
