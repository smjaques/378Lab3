import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ControlInfo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlInfo extends Actor
{
    /**
     * Act - do whatever the ControlInfo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ControlInfo(){
        GreenfootImage txt = getImage();
        txt.scale(550,250);
        setImage(txt);    
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
