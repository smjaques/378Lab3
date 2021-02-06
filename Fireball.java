import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fireball extends Enemy
{
    /**
     * Act - do whatever the Fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Fireball(int l){
        GreenfootImage fireball = getImage();
        fireball.scale(40,20);
        setImage(fireball); 
        setLives(l);
    }
    public void act() 
    {
        // Add your action code here.
    } 
    
    
}
