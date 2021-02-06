import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class FireballSpawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireballSpawner extends Actor
{
    final int MAXTIMER;
    final boolean ISLEFT;
    final int SPEED = 10;
    int timer;
    List<Fireball> children;
    
    
    public FireballSpawner(boolean isLeft) {
        this.ISLEFT = isLeft;
        MAXTIMER = 50;
        timer = 50;
        children = new ArrayList<Fireball>();
    }
    
    public FireballSpawner(boolean isLeft, int timer) {
        this.ISLEFT = isLeft;
        MAXTIMER = timer;
        this.timer = timer;
        children = new ArrayList<Fireball>();
    }
    
    public FireballSpawner(boolean isLeft, int timer, int timeOffset) {
        this(isLeft, timer);
        this.timer += timeOffset;
    }
    
    public void act() 
    {
        timer--;
        
        // add fireballs
        if(timer==0){
            releaseFireball();
            //release fireball
            timer=MAXTIMER;
        }
        
        // Move children
        for (Fireball f : children){
            if (f.getWorld() != null) {
                f.setLocation(f.getX()+SPEED * (ISLEFT?-1:1), f.getY());
                if(f.isAtEdge()){
                    getWorld().removeObject(f);
                    //children.remove(f);
                }
            }
        }      
    }    
    
    public void releaseFireball(){
        Fireball fireball = new Fireball();
        getWorld().addObject(fireball, getX(), getY());
        children.add(fireball);
    }
}
