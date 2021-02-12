import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class ApproachingCastle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lvl4Screen4 extends Levels
{
    Health half1 = new Health();
    Health half2 = new Health();
    Health half3 = new Health();
    Health half4 = new Health();
    Health half5 = new Health();
    Health half6 = new Health();
    Health[] healthList = {half1, half2, half3, half4, half5, half6};
    
    public int timer = 300;
    public int FBX = 650;
    public int FBY = 310;

    public Lvl4Screen4(int health)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(); 
        printLevel("Lvl 4");
        addHealth();
        updateHealthLevel(health);       
        drawPath();
        Princess princess = new Princess();
        addObject(princess,585,120);
    }
    
    public void act(){
        /*
        timer-=1;
        if(timer==0){
            releaseFireball(); //add fireball object
            //release fireball
            timer=300;
        }
        
        
        List<Fireball> fb = getObjects(Fireball.class);
        for (Fireball f : fb){
            f.setLocation(f.getX()-10, f.getY());
            if(f.getX() <=10){
                removeObject(f);
            }
        }
        */
    }
    
    public void drawPath(){
        int y=339;
        int x=10;
        for(int i = 0; i < 7; i++){
            addObject(new Ground(), x, y);
            addObject(new InnerBlock(), x, y+30);
            addObject(new InnerBlock(), x, y+60);
            x+=30;            
        }
        x+=70;
        for(int i=0; i < 11; i++){
            addObject(new Ground(), x, y);
            addObject(new InnerBlock(), x, y+30);
            addObject(new InnerBlock(), x, y+60);
            x+=30;
            
        }
        x=430;
        y-=95;
        for(int i=0; i < 3; i++){
            addObject(new Platform(true), x, y);
            x+=30;
        }
        x+=30;
        y-=80;
        for(int i=0; i < 3; i++){
            addObject(new Platform(true), x, y);
            x+=30;
        }
        
        InvisiblePortal portal = new InvisiblePortal();
        addObject(portal,10, 295);
        
        addObject(new Slime(1), 435, 200);
    }
    
    public void releaseFireball(){
        Fireball fireball = new Fireball(1);
        addObject(fireball, FBX, FBY);
    }
    
    public void updateHealthLevel(int lvl){
        super.updateHealthLevel(lvl);
    }
}
