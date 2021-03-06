import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreenWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreenWorld extends World
{

    
    public TitleScreenWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        TitleScreen ts = new TitleScreen();
        addObject(ts, 300, 325);
    }
    
    public void act(){
        if(Greenfoot.getKey() != null){
            Greenfoot.setWorld(new Controls());
        }    
    }

}
