import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lvl1Screen5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lvl2Screen1 extends Levels
{
    private static final int BLOCK_SIZE = 32;
    private static final int TILE_H = 12;
    private static final int TILE_W  = 18;
    /**
     * Constructor for objects of class Lvl1Screen5.
     * 
     */
    public Lvl2Screen1(int health)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();

        addHealth();
        updateHealthLevel(health);
        drawPath();
        //addBats();
        addObject(new Knight(),20,280);
        addObject(new InvisiblePortal(), 600, 64+16);
        addObject(new FireballSpawner(true,100), 580, 230);
        addObject(new FireballSpawner(true,100,50), 580, 160);
        printLevel("Lvl 2");
    }
    
    private void addP(Platform p, int x, int y) {
         int topOffset = -1*BLOCK_SIZE/2;
         addObject(p,x*32+BLOCK_SIZE/2,y*32+topOffset+BLOCK_SIZE/2);
    }
    
    public void drawPath(){
        int y, x, i;
        // TOP PILLARS
        for (i=0;i<4;i++) {
            addP(new Platform(false,b6), 1, i);
            addP(new Platform(false,b5), 2, i);
        }
        addP(new Platform(false,b10), 1, 4);
        addP(new Platform(false,b9), 2, 4);
        
        addP(new Platform(false,b6), 5, 0);
        addP(new Platform(false,b5), 6, 0);
        addP(new Platform(false,b10), 5, 1);
        addP(new Platform(false,b9), 6, 1);
        
        for (i=0; i<2; i++) {
            addP(new Platform(false,b10), 9+i*4, 0);
            addP(new Platform(false,b9), 10+i*4, 0);
        }
        
        // BOTTOM PILLARS
        for (i=TILE_H;i>TILE_H-2;i--) {
            addP(new Platform(false,b6), 0, i);
            addP(new Platform(false,b5), 1, i);
        }
        
        for (i=TILE_H;i>TILE_H-4 ;i--) {
            addP(new Platform(false,b6), 5, i);
            addP(new Platform(false,b5), 6, i);
            addP(new Platform(false,b6), 5+4, i);
            addP(new Platform(false,b5), 6+4, i);
            addP(new Platform(false,b6), 5+8, i);
            addP(new Platform(false,b5), 6+8, i);
            addP(new Platform(false,b6), 5+12, i);
            addP(new Platform(false,b5), 6+12, i);
        }
        
        for (i=TILE_H-4;i>TILE_H-6 ;i--) {
            addP(new Platform(false,b6), 5+4, i);
            addP(new Platform(false,b5), 6+4, i);
            addP(new Platform(false,b6), 5+8, i);
            addP(new Platform(false,b5), 6+8, i);
            addP(new Platform(false,b6), 5+12, i);
            addP(new Platform(false,b5), 6+12, i);
        }
        
        // BOTTOM PILLAR TOPS
        addP(new Platform(true,b7), 0, TILE_H-2);
        addP(new Platform(true,b8), 1, TILE_H-2);
        addP(new Platform(true,b11), 2, TILE_H-2); 
        
        addP(new Platform(true,b7), 5, TILE_H-4);
        addP(new Platform(true,b8), 6, TILE_H-4);
        
        addP(new Platform(true,b7), 9, TILE_H-6);
        addP(new Platform(true,b8), 10, TILE_H-6);
        
        for (i=1; i<3; i++) {
            addP(new Platform(false,b7), 9+i*4, TILE_H-6);
            addP(new Platform(false,b8), 10+i*4, TILE_H-6);
        }
        
        // Horizontal Block
        for (i=TILE_W; i>TILE_W-5; i--) {
            addP(new Platform(true,b1), i, 4);
            addP(new Platform(false,b3), i, 5);
        }
        addP(new Platform(true,b7), TILE_W-5, 4);
        addP(new Platform(false,b10), TILE_W-5, 5);
    }
    
}
