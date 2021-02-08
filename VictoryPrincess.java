import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VictoryPrincess here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VictoryPrincess extends Actor
{
    /**
     * Act - do whatever the VictoryPrincess wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] img = {new GreenfootImage("princessVictory1.png"), new GreenfootImage("princessVictory2.png")};
    public int timer = 30;
    public int imgNum = 0;
    
    public void act() 
    {
        if(timer==0){
            if(imgNum==1) imgNum=0;
            else imgNum++;
            this.setImage(img[imgNum]);
            timer=30;
        } else timer--;
        // Add your action code here.
    }    
}
