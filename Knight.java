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
            if(!hitWallLeft()) horizontalSpeed = -WALKING;
            else horizontalSpeed = 0;
        }
        if(Greenfoot.isKeyDown("right")){
            isKeyDown = true;
            if(!hitWallRight()) horizontalSpeed = WALKING;
            else horizontalSpeed = 0;

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
    
    public void setHealth(int h){
        healthLevel = h;
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
        int y = getY();
        if(!hitWallUp(y-(int)verticalSpeed)){
            setLocation(x, y-(int)verticalSpeed);
            return;
        }
        setLocation(x, y);
        
    }
    
    public void applyGravity(){
        int x = getX();
        int y = getY();
        boolean touchingGround = false;
        List<Platform> intersectingPlatforms = 
        (List<Platform>)getObjectsInRange(30, Platform.class);
        
        List<Ground> ground = this.getObjectsInRange(32, Ground.class);
        if((ground.size() > 0) && (Math.abs(ground.get(0).getTop() - this.getY())<=13)) {
            touchingGround = true;
            verticalSpeed=0;
            isJumping = false;
            setLocation(x, GROUND);
        }
        
        
        for (Platform plat : intersectingPlatforms) {
            if (verticalSpeed <= 0) {
                if ((Math.abs(this.getY() - plat.getTop()) <= 10) && plat.canLand()) {   
                    touchingGround = true;
                    y = plat.getTop()-13;
                    verticalSpeed = 0;
                    isJumping = false;
                    setLocation(x, y + 2);
                    return;
                
                }               
            }           
        }
        
        if(hitWallUp(y)){
            verticalSpeed = GRAVITY;
            y+=20;
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
            //play a dying sound for knight
            Greenfoot.playSound("Knight_Hurt.wav");
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
        
        if(this.getObjectsInRange(10, InvisiblePortal.class).size() > 0){
            if (getWorld() instanceof Lvl1Screen1) Greenfoot.setWorld(new Lvl1Screen2(healthLevel));
            else if (getWorld() instanceof Lvl1Screen2) Greenfoot.setWorld(new Lvl1Screen3(healthLevel));
            else if (getWorld() instanceof Lvl1Screen3) Greenfoot.setWorld(new Lvl1Screen4(healthLevel));
 
        }
    }
    
    public void checkHealthDecrement(){
        List<Enemy> touchingF = this.getObjectsInRange(20, Enemy.class);
        
        if(touchingF.size() > 0){
            decrementHealth();
            
            //this.getWorld().removeObject(touchingF.get(0));
        }
    }
    
    public boolean hitWallLeft(){
        //check if wall to the left of actor
        List<Platform> toLeft = this.getObjectsInRange(30, Platform.class);
        for(Platform p : toLeft){            
            if(p.getX() < this.getX() && Math.abs(p.getY()-this.getY()) < 20){
                return true;
            }
        }
        return false;
    }
    
    public boolean hitWallRight(){
        List<Platform> toRight = this.getObjectsInRange(30, Platform.class);
        for(Platform p : toRight){
            if(p.getX() > this.getX() && Math.abs(p.getY()-this.getY()) <= 20){
                return true;
            }
        }
        return false;        
    }
    
    public boolean hitWallUp(int y){
        List<Platform> touching = this.getObjectsInRange(30, Platform.class);
        for(Platform p : touching){
            if((y-p.getY()<30 && y-p.getY() > 0) && Math.abs(p.getX()-this.getX()) <= 20){
                return true;
            }
        }
        return false;         
    }
    
    
}
