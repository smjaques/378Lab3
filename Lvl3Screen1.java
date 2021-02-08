import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Lvl1Screen6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lvl3Screen1 extends Levels
{

    public int timer = 30;
    public Lvl3Screen1(int health)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        printLevel("Lvl 3");
        addHealth();
        updateHealthLevel(health);
        drawPath();
        Princess princess = new Princess();
        princess.setHealth(health);
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
    

}
