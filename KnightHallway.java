import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KnightHallway here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KnightHallway extends Levels
{
    private static final int BLOCK_SIZE = 32;
    private static final int TILE_H = 12;
    private static final int TILE_W  = 18;
    private static final GreenfootImage RL = new GreenfootImage("RugLeft.png");
    private static final GreenfootImage RM = new GreenfootImage("RugMid.png");
    private static final GreenfootImage RR  = new GreenfootImage("RugRight.png");

    /**
     * Constructor for objects of class KnightHallway.
     * 
     */
    public KnightHallway()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        printLevel("Lvl 1");
        drawPath();
        addObject(new DoorProp(), 600-120, 266);
        addObject(new Spell(), 600-380, 230);
        addObject(new Knight(),30,275);
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
            addP(new Platform(true,(i%2==0)?b1:b2),i,TILE_H-2);
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
