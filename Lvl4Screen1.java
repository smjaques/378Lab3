import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Lvl4Screen1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lvl4Screen1 extends Levels
{
    public int timer=80;
    /**
     * Constructor for objects of class Lvl4Screen1.
     * 
     */
    public Lvl4Screen1(int health)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        printLevel("Lvl 4");
        addHealth();
        updateHealthLevel(health);
        drawPath();
        addBats();
        Princess princess = new Princess();
        princess.setHealth(health);
        addObject(princess,585,126);
    }
    
    public void act(){
        timer-=1;
        if(timer==0){
            addObject(new Fireball(1),585, 145);
            //release fireball
            timer=50;
        }
        
        
        List<Fireball> fb = getObjects(Fireball.class);
        for (Fireball f : fb){
            f.setLocation(f.getX()-10, f.getY());
            if(f.getX() <=10){
                removeObject(f);
            }
        }        
    }
    
    public void drawPath(){
        int y=320;
        int x=10;
        for(int i = 0; i < 6; i++){
            addObject(new Ground(), x, y);
            addObject(new InnerBlock(), x, y+20);
            addObject(new InnerBlock(), x, y+50);
            addObject(new InnerBlock(), x, y+80);
            
            addObject(new Platform(true,b1), x, y-150);
            x+=30;            
        }
        x+=75;
        addObject(new Platform(true,b11), x, y);
        
        addObject(new Platform(true,b11), x,(y-120));

        x+=30;            
        
        x+=60;
        y-=50;
        addObject(new Platform(true,b11), x, y);

        x+=30;            

        x+=60;
        y-=50;
        addObject(new Platform(true, b11), x, y);

        
        
        
        x+=90;
        y-=50;
        for(int i=0; i < 4; i++){
            addObject(new Ground(), x, y);
            addObject(new InnerBlock(), x, y+20);
            addObject(new InnerBlock(), x, y+50);
            addObject(new InnerBlock(), x, y+80);
            x+=30; 
        }
        
        x=265;
        y=115;
        addObject(new Platform(true,b11), x, y);
        x=380;
        addObject(new Platform(true,b11), x, y);
        
        addObject(new Slime(2), 445, 175);


        InvisiblePortal portal = new InvisiblePortal();
        addObject(new InvisiblePortal(), 8, 277);
    }
    
    public void addBats(){
        Bat b1 = new Bat(1);
        addObject(b1, 30, 40);
        
        Bat b2 = new Bat(1);
        b2.setImage(new GreenfootImage("batFlyL1.png"));
        addObject(b2, 575, 90);
    }
}
