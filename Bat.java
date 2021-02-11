import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bat extends Enemy
{
    GreenfootImage flyL1 = new GreenfootImage("batFlyL1.png");
    GreenfootImage flyL2 = new GreenfootImage("batFlyL2.png");
    GreenfootImage flyL3 = new GreenfootImage("batFlyL3.png");
    GreenfootImage flyL4 = new GreenfootImage("batFlyL4.png");
    GreenfootImage[] leftFlying = {flyL1, flyL2, flyL3, flyL4};
    
    GreenfootImage flyR1 = new GreenfootImage("batFlyR1.png");
    GreenfootImage flyR2 = new GreenfootImage("batFlyR2.png");
    GreenfootImage flyR3 = new GreenfootImage("batFlyR3.png");
    GreenfootImage flyR4 = new GreenfootImage("batFlyR4.png");
    GreenfootImage[] rightFlying = {flyR1, flyR2, flyR3, flyR4}; 
    
    private int direction = 1;
    private int spriteImage = 1;
    private int changeImage = 4;
    
    private int lives;
    
    public int bspeed;
    
    
    public Bat(int lives){
        lives=lives;
        
    }
    
    
    /**
     * Act - do whatever the Bat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        fly();
 
        // Add your action code here.
    }
    
    public void fly(){
        
        if(isAtEdge()) direction*=-1;
        
        if(changeImage==0){
            if(direction>0) setImage(rightFlying[spriteImage-1]);
            else setImage(leftFlying[spriteImage-1]);
            changeImage=4;
        } else changeImage--;

        
        if(spriteImage==4) spriteImage=1;
        else spriteImage++;
        
        int x = (getX()+8) * direction;
        //setLocation(x, getY());
        
        
        //slows down the speed of the bat
        if (bspeed < 0){
            bspeed = 1;
            setLocation(x, getY());
        }
        else{
            bspeed--;
        }
        
        
        //if not at edge of screen, fly in same direction
        //if at edge, flip sprite, change direction
        
        
    }
    
    public void attacked(){
        lives--;
        if(lives==0){
            getWorld().removeObject(this);
        }
    }
    

}
