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
    public int mspeed = 3;
    
    //animation stuff
    private GreenfootImage hop1L = new GreenfootImage("slimeHop1L.png");
    private GreenfootImage hop2L = new GreenfootImage("slimeHop2L.png");
    private GreenfootImage hop3L = new GreenfootImage("slimeHop3L.png");
    private GreenfootImage hop4L = new GreenfootImage("slimeHop4L.png");
    
    private GreenfootImage hop1R = new GreenfootImage("slimeHopR1.png");
    private GreenfootImage hop2R = new GreenfootImage("slimeHopR2.png");
    private GreenfootImage hop3R = new GreenfootImage("slimeHopR3.png");
    private GreenfootImage hop4R = new GreenfootImage("slimeHopR4.png");
    
    private int frame = 1;
    
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
        
        
        //move(direction);
        //slows down the speed of the slime
        if (mspeed < 0){
            mspeed = 3;
            move(direction);
            //hop animation   
            if(direction < 0)
            {
                animateLeft();
            }
            else
            {
                animateRight();
            }
        }
        else{
            mspeed--;
        }
        
        
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
    
        public void animateLeft()
    {
        if(frame == 1)
        {
            setImage(hop1L);
        }
        if(frame == 2)
        {
            setImage(hop2L);
        }
        if(frame == 3)
        {
            setImage(hop3L);
        }
        if(frame == 4)
        {
            setImage(hop4L);
            frame = 1;
        }
        frame++;
    }
    
    public void animateRight()
    {
        if(frame == 1)
        {
            setImage(hop1R);
        }
        if(frame == 2)
        {
            setImage(hop2R);
        }
        if(frame == 3)
        {
            setImage(hop3R);
        }
        if(frame == 4)
        {
            setImage(hop4R);
            frame = 1;
        }
        frame++;
    }
}
