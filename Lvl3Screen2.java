import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lvl1Screen6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lvl3Screen2 extends Levels
{

    /**
     * Constructor for objects of class Lvl1Screen6.
     * 
     */
    public Lvl3Screen2(int health)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        printLevel("Lvl 2");
        addHealth();
        updateHealthLevel(health);
        drawPath();
        addSlime();
        Princess princess = new Princess();       
        princess.setHealth(health);
        addObject(princess,600, 310);
    }
    
    public void drawPath(){
        int y=320;
        int x=10;
        for(int i = 0; i < 4
        ; i++){
            //starting platform
            addObject(new Ground(), x, y);
            addObject(new InnerBlock(), x, y+30);
            addObject(new InnerBlock(), x, y+50);
            addObject(new InnerBlock(), x, y+80);
            addObject(new InnerBlock(), x, y+110);
            x+=30;            
        }
        
        
        //starting platform corner stone
        Platform p1 = new Platform(true);
        p1.setImage(b8);
        addObject(p1, x, y);
        
        
        //starting platform right vertical stone
        for(int i=0; i < 10; i++){
            Platform p2 = new Platform(false);
            p2.setImage(b5);
            addObject(p2, x, y+=30);
        }
        

        
        
        //square 1
        Platform p5 = new Platform(true);
        p5.setImage(b11);
        addObject(p5, 210, 230);

        
        //square 2
        Platform p6 = new Platform(true);
        p6.setImage(b11);
        addObject(p6, 240, 200);
        
        //square 3
        Platform p6a = new Platform(true);
        p6a.setImage(b11);
        addObject(p6a, 360, 200);
        
        //square 4
        Platform p6b = new Platform(true);
        p6b.setImage(b11);
        addObject(p6b, 390, 170);
        
        //square 5
        Platform p6c = new Platform(true);
        p6c.setImage(b11);
        addObject(p6c, 420, 200);
        
        //square 6
        Platform p6d = new Platform(true);
        p6d.setImage(b11);
        addObject(p6d, 450, 230);
        
        //square 7
        Platform p6e = new Platform(true);
        p6e.setImage(b11);
        addObject(p6e, 480, 260);
        
        //bottom ground
        //bottom ground left corner stone
        x=570;
        y=350;
        Platform p7 = new Platform(true);
        p7.setImage(b7);
        addObject(p7, x, y);
        
        //bottom ground left vertical stone
        for(int i=0; i < 3; i++){
            Platform p7a = new Platform(false);
            p7a.setImage(b6);
            addObject(p7a, x, y+=30);
        }
        
        x=590;
        y=350;
        addObject(new Ground(), x, y);
        addObject(new InnerBlock(), x, y+30);
        addObject(new InnerBlock(), x, y+50);
        addObject(new InnerBlock(), x, y+80);
        addObject(new InnerBlock(), x, y+110);
        
        
        
        InvisiblePortal portal = new InvisiblePortal();
        addObject(new InvisiblePortal(), 10, 285);
        
    }
   
    
    public void addSlime(){
        Slime s1 = new Slime(1);
        addObject(s1, 240, 155);
        
        Slime s2 = new Slime(1);
        addObject(s2, 390, 125);
    }
    
    

}
