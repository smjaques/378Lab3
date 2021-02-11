import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dungeon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dungeon extends Levels
{

    /**
     * Constructor for objects of class Dungeon.
     * 
     */
    public Dungeon()
    {
        Knight knight = new Knight();
        knight.setImage(new GreenfootImage("knightHurtL.png"));
        addObject(knight, 300, 310);
        
        GreenfootImage script = new GreenfootImage("dungeonScript.png");
        script.scale(410,110);
        getBackground().drawImage(script, 95, 135);
    }
    public void act(){
        knightBackgroundMusic.stop();
        Greenfoot.delay(480);
        Greenfoot.setWorld(new PrincessRoom());   
    }    
    
}
