import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Actor
{
    private boolean canLand = false;
    
    public Platform(boolean top){
        canLand=top;
    }
    
    public Platform(boolean top, GreenfootImage image){
        canLand=top;
        setImage(image);
    }

    /**
     * Act - do whatever the Platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    
    public int getTop(){
        return getY() - getImage().getHeight() / 2;    
    }

    
    public boolean canLand(){
        return canLand;
    }
}
