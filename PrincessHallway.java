import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PrincessHallway here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PrincessHallway extends Levels
{
    private static final int BLOCK_SIZE = 32;
    private static final int TILE_H = 12;
    private static final int TILE_W  = 18;
    private static final GreenfootImage RL = new GreenfootImage("RugLeft.png");
    private static final GreenfootImage RM = new GreenfootImage("RugMid.png");
    private static final GreenfootImage RR  = new GreenfootImage("RugRight.png");

    /**
     * Constructor for objects of class PrincessHallway.
     * 
     */
    public PrincessHallway()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        printLevel("Lvl 1");
        drawPath();
        addHealth();
        updateHealthLevel(6);
        addObject(new DoorProp(), 120, 266);
        addObject(new Knight(),120,275);
        addObject(new InvisiblePortal(), 600, 400-120);
    }
    
    private void addP(Platform p, int x, int y) {
         int topOffset = -1*BLOCK_SIZE/2;
         addObject(p,x*32+BLOCK_SIZE/2,y*32+topOffset+BLOCK_SIZE/2);
    }
    
    public void drawPath(){
        int x, y, i;
        // border
        for (i=0; i<=TILE_W; i++) {
            addP(new Platform(false,b12),i,TILE_H);
            addP(new Platform(false,b12),i,TILE_H-1);
        }
        
        // floor
        for (i=0; i<= TILE_W; i++) {
            addP(new Platform(true,(Greenfoot.getRandomNumber(2)==0)?b1:b2),i,TILE_H-2);
        }
    }
   
    /*
    public void addSlime(){
        Slime s1 = new Slime();
        addObject(s1, 250, 290);
        
        Slime s2 = new Slime();
        addObject(s2, 480, 160);
    }
    */
    

}
