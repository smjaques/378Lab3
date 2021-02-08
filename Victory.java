import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Victory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Victory extends World
{

    /**
     * Constructor for objects of class Victory.
     * 
     */
    public int timer = 950;

    public Victory()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        drawPath();
        addObject(new VictoryPrincess(), 285, 245);
        GreenfootImage c = new GreenfootImage("congrats.png");
        c.scale(500,150);
        getBackground().drawImage(c, 45, 40);
    }
    
    public void drawPath(){
        int x=15;
        int y=285;
        for(int i=0; i < 20; i ++){
            addObject(new Ground(), x, y);
            addObject(new InnerBlock(), x, y+30);
            addObject(new InnerBlock(), x, y+60);
            addObject(new InnerBlock(), x, y+90);
            addObject(new InnerBlock(), x, y+120);
            x+=30;      
        }
    }
    
    public void act(){
        if(timer==0) Greenfoot.setWorld(new Credits());
        else timer--;
    }
    

}
