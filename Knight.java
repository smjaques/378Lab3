import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Knight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knight extends Actor
{
    private int Xcord = 20;
    private int Ycord = 230;
    private int GROUND = 230;
    private int healthLevel = 6;
    
    // time allowed in air for single jump
    private boolean isJumping = false;
    private double verticalSpeed = 0;
    private int horizontalSpeed = 0;
    // height for jump
    private int JUMPVELOCITY = 14;
    private int GRAVITY = -7;
    private double GRAVITY_DELTA = 1;
    private int WALKING = 2;
    
    //moving
    
    public Knight(){
        GreenfootImage knight = getImage();
        knight.scale(140,140);
        setImage(knight);    
    }
    public void act() 
    {
        //setLocation(Xcord, Ycord);
        processKeys();
        updateHealth();
        applyMovement();
        applyGravity();
        checkIfDied();
        checkNextScreen();
        checkHealthDecrement();
    
    } 
    
    public void processKeys(){
        boolean isKeyDown = false;
        
        if(Greenfoot.isKeyDown("left")){
            isKeyDown = true;
            horizontalSpeed = -WALKING;           
        }
        if(Greenfoot.isKeyDown("right")){
            isKeyDown = true;;
            horizontalSpeed = WALKING;
        }
        if(Greenfoot.isKeyDown("up")){
            isKeyDown = true;
            jump();
                       
        }
        if (!isKeyDown){
            horizontalSpeed = 0;
            //idle animation
        }
       
        
    }
    
    public void updateHealth(){
        
        ((Levels)getWorld()).updateHealthLevel(healthLevel);
    }
   
    
    public void decrementHealth(){
        // hit or fall causes health to decrease
        Greenfoot.playSound("Knight_Hurt.wav");
        healthLevel-=1;
    }
    
    public void jump(){
        if(verticalSpeed == 0 && !isJumping){
            //play jumping sound?
            verticalSpeed = JUMPVELOCITY;
            isJumping = true;
        }
        
    }
    
    public void applyMovement(){
        int x = getX() + horizontalSpeed;
        int y = getY() - (int)verticalSpeed;
        setLocation(x, y);
    }
    
    public void applyGravity(){
        int x = getX();
        int y = getY();
        boolean touchingGround = false;
        List<Platform> intersectingPlatforms = 
        (List<Platform>)getObjectsInRange(32, Platform.class);
        
        List<Ground> ground = this.getObjectsInRange(32, Ground.class);
        if((ground.size() > 0) && (Math.abs(ground.get(0).getTop() - this.getY())<=13)) {
            touchingGround = true;
            verticalSpeed=0;
            isJumping = false;
            setLocation(x, GROUND);
        }
        
        
        for (Platform plat : intersectingPlatforms) {
            if (verticalSpeed <= 0) {
                if (Math.abs(this.getY() - plat.getTop()) <= 13) {
                    touchingGround = true;
                    y = plat.getTop()-13;
                    verticalSpeed = 0;
                    isJumping = false;
                    setLocation(x, y + 2);
                    return;
                
                }               
            }           
        }        
        setLocation(x, y);
       
        if (verticalSpeed > GRAVITY && !touchingGround) {
            verticalSpeed = verticalSpeed - GRAVITY_DELTA;
        }        

    }
    
    public int getBottom() {
        return getY() + getImage().getHeight() / 2;
    }
    
    public void checkIfDied(){
        // if touching lower edge
        if(this.getY() >= 388){
            resetLevel();            
        }
        
        // if ran out of lives
        if(healthLevel == 0){
            //game over
            resetLevel();
            
        }
        
    }
    
    public void resetLevel(){
        if(this.getWorld().toString().contains("Lvl1")){
            Greenfoot.setWorld(new Lvl1Screen1());
        }        
    }
    
    public void checkNextScreen(){
        if(this.getX() >= 580){
            if (getWorld() instanceof Lvl1Screen1) Greenfoot.setWorld(new Lvl1Screen2(healthLevel));
 
        }
    }
    
    public void checkHealthDecrement(){
        List<Fireball> touchingF = this.getObjectsInRange(20, Fireball.class);
        
        if(touchingF.size() > 0){
            decrementHealth();
            this.getWorld().removeObject(touchingF.get(0));
        }
    }
    
}
