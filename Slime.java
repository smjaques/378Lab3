import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Slime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Slime extends Enemy
{
    /**
     * Act - do whatever the Slime wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int lives;
    public int direction = 5;
    public boolean isDying = false;
    
    GreenfootImage[] dyingL = {new GreenfootImage("slimeDeath1L.png"), new GreenfootImage("slimeDeath2L.png"), new GreenfootImage("slimeDeath3L.png"), new GreenfootImage("slimeDeath4L.png")};
    GreenfootImage[] dyingR = new GreenfootImage[dyingL.length];
    public int dyingNum = 0;
    public int changeTime = 5;
    
    public Slime(int lives){
        lives=lives+1;
        getMirror();
    }
    public void act() 
    {
        if(!isDying) move();
        else setDying();
        // Add your action code here.
    } 
    
    public void getMirror(){
          for(int i=0; i < dyingL.length; i++){
            GreenfootImage img = new GreenfootImage(dyingL[i]);
            img.mirrorHorizontally();
            dyingR[i] = img;
        }      
    }
    
    public void move(){
        
        //if hits something, turn around
        //if the floor goes away (platform ends), drop
        List<Ground> ground = this.getObjectsInRange(50, Ground.class);
        List<Platform> plats = this.getObjectsInRange(47, Platform.class);

        if(ground.size()==0 && plats.size()==0){
            direction*=-1;
        }
        
        move(direction);
    }
    public void attacked(){
        lives--;
        if(lives==1){
            lives=2;
            //set dying images
            isDying=true;
        }
    }
    
    //THIS DOESN'T WORK BECAUSE OF THE ATTACK()
    //CLASS IN KNIGHT THAT REMOVES ACTOR IF LIVES==0
    public void setDying(){
        if(changeTime !=0){
            changeTime--;
            return;
        }
        
        if(dyingNum==dyingL.length){
            getWorld().removeObject(this);
        }
        
        else if(direction>0){
            setImage(dyingR[dyingNum]);
        }
        else{
           setImage(dyingL[dyingNum]);
        }
        dyingNum++;
    }
}
