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
    private int GROUND = 295;
    private int healthLevel = 6;
    private boolean invincible = false;
    private int invincibilityTimer = 20;
    
    // time allowed in air for single jump
    private boolean isJumping = false;
    private double verticalSpeed = 0;
    private int horizontalSpeed = 0;
    // height for jump
    private int JUMPVELOCITY = 14;
    private int GRAVITY = -7;
    private double GRAVITY_DELTA = 1;
    private int WALKING = 2;
       
    //ANIMATION
    private int changeAnimation = 5;
    private final int CHANGE = 5;
    private int lastDir = 1; //positive=right, neg=left
    
    //idle
    GreenfootImage[] idleL = {new GreenfootImage("knightIdleL1.png"), new GreenfootImage("knightIdleL2.png"), new GreenfootImage("knightIdleL3.png")};
    GreenfootImage[] idleR = new GreenfootImage[idleL.length];
    private int idleNum = 0;
    private int idleClock = 100;
    private int CLOCK = 100;
    
    //hurt
    GreenfootImage hurtL = new GreenfootImage("knightHurtL.png");
    GreenfootImage hurtR;
    
    //jump
    GreenfootImage[] jumpL = {new GreenfootImage("knightJumpL1.png"), new GreenfootImage("knightJumpL2.png"), new GreenfootImage("knightJumpL3.png")};
    GreenfootImage[] jumpR = new GreenfootImage[jumpL.length];
    private int jumpNum = 0;
    
    //run
    GreenfootImage[] runL = {new GreenfootImage("knightRunL1.png"), new GreenfootImage("knightRunL2.png"), new GreenfootImage("knightRunL3.png"), new GreenfootImage("knightRunL4.png")};
    GreenfootImage runR[] = new GreenfootImage[runL.length];   //declaring array
    private int runNum = 0;
    
    //trait
    GreenfootImage[] traitL = {new GreenfootImage("knightTraitL1.png"), new GreenfootImage("knightTraitL2.png"), new GreenfootImage("knightTraitL3.png"), new GreenfootImage("knightTraitL4.png"), new GreenfootImage("knightTraitL5.png"), new GreenfootImage("knightTraitL6.png")};
    GreenfootImage[] traitR = new GreenfootImage[traitL.length];
    private int traitNum = 0;
    
    //fight
    GreenfootImage[] fightL = {new GreenfootImage("knightFightL1.png"), new GreenfootImage("knightFightL2.png")};
    GreenfootImage[] fightR = new GreenfootImage[fightL.length];
    private int fightClock = 8;
    private boolean isFighting = false;
    GreenfootSound hit = new GreenfootSound("KnightAttack.wav");
    GreenfootSound hurtSound = new GreenfootSound("Knight_Hurt.wav");
    public Knight(){
        getMirrors();
        hit.setVolume(65);
        hurtSound.setVolume(85);
    }
    
    public void getMirrors(){
        //run
        for(int i=0; i < runL.length; i++){
            GreenfootImage img = new GreenfootImage(runL[i]);
            img.mirrorHorizontally();
            runR[i] = img;
        }
        
        //idle
        for(int i=0; i < idleL.length; i++){
            GreenfootImage img = new GreenfootImage(idleL[i]);
            img.mirrorHorizontally();
            idleR[i] = img;
        }
        
        //trait
        for(int i=0; i < traitL.length; i++){
            GreenfootImage img = new GreenfootImage(traitL[i]);
            img.mirrorHorizontally();
            traitR[i] = img;
        } 
        
        //hurt
        GreenfootImage img2 = new GreenfootImage(hurtL);
        img2.mirrorHorizontally();
        hurtR = img2;
        
        //jump
        for(int i=0; i < jumpL.length; i++){
            GreenfootImage img = new GreenfootImage(jumpL[i]);
            img.mirrorHorizontally();
            jumpR[i] = img;
        }
        
        //fight
        for(int i=0; i < fightL.length; i++){
            GreenfootImage img = new GreenfootImage(fightL[i]);
            img.mirrorHorizontally();
            fightR[i] = img;
        }        
        
    }
    

    public void act() 
    {
        processKeys();
        invincibility();
        updateHealth();
        applyMovement();
        applyGravity();
        checkIfDied();
        checkNextScreen();
        checkHealthDecrement();
    
    } 
    
    public void processKeys(){
        boolean isKeyDown = false;
        
        if(Greenfoot.isKeyDown("right")){
            isKeyDown = true;
            lastDir=1;
            if(!hitWallRight()){
                horizontalSpeed = WALKING;
                setRightRun();               
            }
            else {
                horizontalSpeed = 0;
                setIdle();
            }

        } else if(Greenfoot.isKeyDown("left")){
            isKeyDown = true;
            lastDir=-1;
            if(!hitWallLeft()) {
                horizontalSpeed = -WALKING;
                setLeftRun();
            }
            else{
                horizontalSpeed = 0;
                setIdle();
            }
        } else {
            horizontalSpeed = 0;
        }
        if(Greenfoot.isKeyDown("up")){
            isKeyDown = true;
            idleClock=CLOCK;
            jump();
                       
        }
        if(Greenfoot.isKeyDown("space")){ 
            hit.play();
            attack();
        }
        if (!isKeyDown){
            horizontalSpeed = 0;
            

            if(!isJumping && !isFighting){
                //check if been idling for long enough
                if(idleClock==0) setTraitIdle();
                else {
                    setIdle();
                    idleClock--;
                }
            }
            
            else if(isFighting){
                if(fightClock==0){
                    isFighting=false;
                    fightClock=8;
                } else fightClock--;    
                }
            
        }
        
       
        
    }
    
    public void updateHealth(){ 
        ((Levels)getWorld()).updateHealthLevel(healthLevel);
    }
    
    public void setHealth(int h){
        healthLevel = h;
    }
  
    
    public void decrementHealth(){
        if(!invincible){
            setHurt();
            hurtSound.play();
            healthLevel-=1;
            invincible = true;
        }
    }
    
    public void invincibility(){
        if(invincible){
            if(invincibilityTimer==0){
                invincible = false;
                invincibilityTimer = 20;
            }
            else invincibilityTimer--;
            
        }
    }
    
    public void jump(){
        if(verticalSpeed == 0 && !isJumping){
            //play jumping sound?
            //set jump animation
            setStartJump();
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
        (List<Platform>)getObjectsInRange(45, Platform.class);
        
        List<Ground> ground = this.getObjectsInRange(45, Ground.class);
        if((ground.size() > 0) && (Math.abs(ground.get(0).getTop() - this.getY())<=25)) {
            if(Math.abs(this.getX() - ground.get(0).getX()) <=30){            
                touchingGround = true;
                verticalSpeed=0;
                isJumping = false;
                setLocation(x, GROUND);
            }
        }
        
        
        for (Platform plat : intersectingPlatforms) {
            if (verticalSpeed <= 0) {
                if ((Math.abs(this.getY() - plat.getTop()) <= 25) && plat.canLand()) {
                    if(Math.abs(this.getX() - plat.getX()) <=30){
                        touchingGround = true;
                        y = plat.getTop()-25;
                        verticalSpeed = 0;
                        isJumping = false;
                        setLocation(x, y);
                        return;
                    }
                
                }               
            }           
        }
        
        if(hitWallUp(y)){
            verticalSpeed = GRAVITY;
            y+=20;
        }
        setLocation(x, y);
        if(!touchingGround) setMidJump();
        if (verticalSpeed > GRAVITY && !touchingGround) {
            //still going up
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
            hurtSound.play();
            resetLevel(); 
        }
        
        // if ran out of lives
        if(healthLevel == 0){
            //game over
            resetLevel();
        }
        
        if(isTouching(Spell.class)) {
            Spell spell = (Spell) getOneIntersectingObject(Spell.class);
            if (Math.abs(spell.getX()-getX()) < 10) {
                setLocation(spell.getX(),spell.getY());
                if (!spell.isActivated()) {
                    spell.activate(true);
                }
                if (spell.getAnimTimer() == 0) {
                    getImage().clear();
                    if (!spell.snd2.isPlaying()) {
                        Greenfoot.setWorld(new Dungeon());
                    }
                } else if (spell.getAnimTimer() < spell.DEF_ANIMTIMER/4) {
                    //getImage().setColor(Color.WHITE);
                    //getImage().fill();
                    getImage().setTransparency(100);
                }
                
            }
        }
        //add if touches spell class --> die
    }
    
    public void resetLevel(){
        if(this.getWorld().toString().contains("Lvl1")){
            Greenfoot.setWorld(new Lvl1Screen1());
        } else if(this.getWorld().toString().contains("Lvl2")){
            Greenfoot.setWorld(new Lvl2Screen1(6));
        }
    }
    
    public void checkNextScreen(){
        
        if(this.getObjectsInRange(10, InvisiblePortal.class).size() > 0){
            if (getWorld() instanceof Lvl1Screen1) Greenfoot.setWorld(new Lvl1Screen2(healthLevel));
            else if (getWorld() instanceof Lvl1Screen2) Greenfoot.setWorld(new Lvl1Screen3(healthLevel));
            else if (getWorld() instanceof Lvl1Screen3) Greenfoot.setWorld(new Lvl1Screen4(healthLevel));
            else if (getWorld() instanceof Lvl1Screen4) Greenfoot.setWorld(new Lvl2Screen1(healthLevel));
            else if (getWorld() instanceof Lvl2Screen1) Greenfoot.setWorld(new Lvl2Screen2(healthLevel));
            else if (getWorld() instanceof Lvl2Screen2) Greenfoot.setWorld(new Lvl2Screen3(healthLevel));
            else if (getWorld() instanceof Lvl2Screen3) Greenfoot.setWorld(new Lvl2Screen4(healthLevel));
            else if (getWorld() instanceof Lvl2Screen4) Greenfoot.setWorld(new KnightHallway());
        }
    }
    
    public void checkHealthDecrement(){
        List<Enemy> touchingF = this.getObjectsInRange(20, Enemy.class);
        
        if(touchingF.size() > 0){ //but not if attacking!
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
    
    public void attack(){ 
        isFighting=true;
        setAttack();
        List<Enemy> touching = this.getObjectsInRange(30, Enemy.class);
        for(Enemy e : touching){
            invincible=true;

            if(e.getLives()==0){
                getWorld().removeObject(e);
            }
            
        }
                
    }
    
    //ANIMATIONS
    public void setLeftRun(){
        if(changeAnimation!=0){
            changeAnimation--;
            return;
        }
        changeAnimation=CHANGE;
        setImage(runL[runNum]);
        if(runNum==3) runNum=0;
        else runNum++;
        traitNum=0;
        jumpNum=0;
        idleNum=0; 
        idleClock=CLOCK;
    }
    
    public void setRightRun(){
        if(changeAnimation!=0){
            changeAnimation--;
            return;
        }
        changeAnimation=CHANGE;
        setImage(runR[runNum]);
        if(runNum==3) runNum=0;
        else runNum++;
        traitNum=0;
        jumpNum=0;
        idleNum=0; 
        idleClock=CLOCK;
        
    }
    
    public void setIdle(){
        //check if ready to change image (can't be too fast)
        if(changeAnimation==0){
            changeAnimation=CHANGE;            
            //check way facing
            if(lastDir>0) setImage(idleR[idleNum]);
            else setImage(idleL[idleNum]);
            
            if(idleNum==idleL.length-1) idleNum=0;
            else idleNum++;
            runNum=0;
            traitNum=0;
            jumpNum=0;
        }
        else changeAnimation--;
    }
        
    public void setTraitIdle(){
        if(changeAnimation!=0){
            changeAnimation--;
            return;
        }
        changeAnimation=CHANGE;
        
        //check way facing
        if(lastDir>0) setImage(traitR[traitNum]);
        else setImage(traitL[traitNum]);
        
        if(traitNum==5) traitNum=0;
        else traitNum++;
        idleNum=0;
        runNum=0;
        jumpNum=0;
    }
    
    public void setStartJump(){
        if(lastDir>0) setImage(jumpR[0]);
        else setImage(jumpL[0]);  
        
        idleNum=0;
        runNum=0;
        traitNum=0;
        idleClock=CLOCK;
    }
    
    public void setMidJump(){
        if(lastDir>0) setImage(jumpR[1]);
        else setImage(jumpL[1]);         
    }
    
    public void setHurt(){
        if(lastDir>0) setImage(hurtR);
        else setImage(hurtL);  
        
        idleNum=0;
        runNum=0;
        traitNum=0;
        idleClock=CLOCK;       
    }
    
    public void setAttack(){
        if(lastDir>0) setImage(fightR[1]);
        else setImage(fightL[1]);  
        
        jumpNum=0;
        idleNum=0;
        runNum=0;
        traitNum=0;
        idleClock=CLOCK;        
    }
        
}
