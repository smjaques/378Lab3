import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PrincessRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PrincessRoom extends Levels
{
    private static final int BLOCK_SIZE = 32;
    private static final int TILE_H = 12;
    private static final int TILE_W  = 18;
    private static final GreenfootImage RL = new GreenfootImage("RugLeft.png");
    private static final GreenfootImage RM = new GreenfootImage("RugMid.png");
    private static final GreenfootImage RR  = new GreenfootImage("RugRight.png");

    /**
     * Constructor for objects of class PrincessRoom.
     * 
     */
    public PrincessRoom()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        printLevel("Lvl 4");
        knightBackgroundMusic.stop();
     
        princessBackgroundMusic.playLoop();
        drawPath();
        //addSlime();
        addObject(new Princess(),120,(TILE_H-4)*BLOCK_SIZE+23);
        addObject(new InvisiblePortal(), 600-60, 400-120);
        setBackground(new GreenfootImage("BackgroundPrincess.png"));
        addObject(new GenericText("Nobody's coming... time to take care of this myself.",
            new Font("Georgia",22), Color.WHITE),57,350);
    }
    
    private void addP(Platform p, int x, int y) {
         int topOffset = -1*BLOCK_SIZE/2;
         addObject(p,x*32+BLOCK_SIZE/2,y*32+topOffset+BLOCK_SIZE/2);
    }
    
    public void drawPath(){
        int x, y, i;
        // border
        for (i=0; i<=TILE_W; i++) {
            addP(new Platform(false,b12),i,0);
            addP(new Platform(false,b12),i,1);
            addP(new Platform(false,b12),i,TILE_H);
            addP(new Platform(false,b12),i,TILE_H-1);
        }
        for (i=2; i<=TILE_W-2; i++) {
            addP(new Platform(false,b12),0,i);
            addP(new Platform(false,b12),1,i);
            addP(new Platform(false,b12),TILE_W,i);
            addP(new Platform(false,b12),TILE_W-1,i);
        }
        
        // floor
        addP(new Platform(true,RL),2,TILE_H-2);
        for (i=3; i<= TILE_W-3; i++) {
            addP(new Platform(true,RM),i,TILE_H-2);
        }
        addP(new Platform(true,RR),TILE_W-2,TILE_H-2);
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
