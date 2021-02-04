import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Levels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Levels extends World
{
    Health half1 = new Health();
    Health half2 = new Health();
    Health half3 = new Health();
    Health half4 = new Health();
    Health half5 = new Health();
    Health half6 = new Health();
    Health[] healthList = {half1, half2, half3, half4, half5, half6};
    

    /**
     * Constructor for objects of class Levels.
     * 
     */
    public Levels()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    
    public void printLevel(String lvl){
        GreenfootImage level = new GreenfootImage(lvl,12,Color.WHITE,null);
        level.setColor(Color.WHITE);
        getBackground().drawImage(level,5,0);    
    }
    
    public void addHealth(){
        int xCord = 550;
        addObject(half1, xCord, 10);
        half2.getImage().mirrorHorizontally();
        xCord+=7;
        addObject(half2, xCord, 10);
        xCord+=8;
        addObject(half3, xCord, 10);
        xCord+=7;
        half4.getImage().mirrorHorizontally();
        addObject(half4, xCord, 10);
        xCord+=8;
        addObject(half5, xCord, 10);
        xCord+=7;
        half6.getImage().mirrorHorizontally();
        addObject(half6, xCord, 10);
    }
    
    public void updateHealthLevel(int level){       
        if(level==6){
            //full health
            return;
        }
        else if(level==0){
            //game over
            return;
        }
        int l = 5;
        while(l >= level){
            if(healthList[l].getWorld() != null){
                removeObject(healthList[l]);
            }
            l--;
            
        }
    }
    
}
