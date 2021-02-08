import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
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
    public int timer = 45;

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
    public void act(){
        timer-=1;
        if(timer==0){
            addObject(new Fireball(1), 580, 320); //add fireball object
            //release fireball
            timer=50;
        }
        
        
        List<Fireball> fb = getObjects(Fireball.class);
        for (Fireball f : fb){
            f.setLocation(f.getX()-10, f.getY());
            if(f.getX() <=10){
                removeObject(f);
            }
        }      
    }   
    
    
    public void drawPath(){
        int x=15;
        int y=350;
        for(int i=0; i < 20; i++){
            addObject(new Ground(), x, y);
            addObject(new InnerBlock(), x, y+30);
            x+=30;
        }
        addObject(new InvisiblePortal(), 590, 310);
        
    }

    
    

}
