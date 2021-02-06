import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    private int lives;
    public Enemy(){
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    
    public void attacked(Actor a){
        lives--;
        if(lives==0){
            getWorld().removeObject(a);
        }
    }
    
    public void setLives(int l){
        lives=l;
    }
    
    public int getLives(){
        return lives;
    }
}
