import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Credits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Credits extends World
{

    /**
     * Constructor for objects of class Credits.
     * 
     */
    public Credits()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage creds = new GreenfootImage("Credits.png");
        creds.scale(550,250);
        getBackground().drawImage(creds, 25, 85);
        
        GreenfootImage mcreds = new GreenfootImage("MusicCredit.png");
        getBackground().drawImage(mcreds, 28, 370);
    }
}
