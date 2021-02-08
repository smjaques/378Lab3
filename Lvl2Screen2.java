import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lvl1Screen6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lvl2Screen2 extends Levels
{

    /**
     * Constructor for objects of class Lvl1Screen6.
     * 
     */
    public Lvl2Screen2(int health)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        printLevel("Lvl 2");
        addHealth();
        updateHealthLevel(health);
        drawPath();
        addSlime();
        Knight knight = new Knight();
        knight.setHealth(health);
        addObject(knight,20,78);
    }
    
    public void drawPath(){
        int y=120;
        int x=10;
        for(int i = 0; i < 2; i++){
            //starting platform
            addObject(new Ground(), x, y);
            addObject(new InnerBlock(), x, y+30);
            addObject(new InnerBlock(), x, y+50);
            addObject(new InnerBlock(), x, y+80);
            addObject(new InnerBlock(), x, y+110);
            addObject(new InnerBlock(), x, y+140);
            addObject(new InnerBlock(), x, y+170);
            addObject(new InnerBlock(), x, y+200);
            addObject(new InnerBlock(), x, y+230);
            addObject(new InnerBlock(), x, y+260);
            addObject(new InnerBlock(), x, y+290);
            addObject(new InnerBlock(), x, y+310);
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
        

        //second platform
        //second platform left vertical stone
        y=230;
        x=160;
        for(int i=0; i < 6; i++){
            Platform p3 = new Platform(false);
            p3.setImage(b6);
            addObject(p3, x, y+=30);
        }
        
        
        //second platform left corner stone
        Platform p3a = new Platform(true);
        p3a.setImage(b7);
        addObject(p3a, 160, 230);
       
        
        //second platform body
        y=230;
        x=190;
        //addObject(new Ground(), x, y);
        addObject(new InnerBlock(), x, y+30);
        addObject(new InnerBlock(), x, y+50);
        addObject(new InnerBlock(), x, y+80);
        addObject(new InnerBlock(), x, y+110);
        addObject(new InnerBlock(), x, y+140);
        addObject(new InnerBlock(), x, y+170);
        addObject(new InnerBlock(), x, y+200);
        addObject(new InnerBlock(), x, y+230);
        addObject(new InnerBlock(), x, y+260);
        addObject(new InnerBlock(), x, y+290);
        addObject(new InnerBlock(), x, y+310);
          
        
        //second platform right vertical stone
        for(int i=0; i < 2; i++){
            Platform p4 = new Platform(false);
            p4.setImage(b5);
            addObject(p4, x, y+=30);
        }
        
        //second platform right corner stone
        Platform p4a = new Platform(true);
        p4a.setImage(b8);
        addObject(p4a, 190, 230);
        
        //second platform body 2
        y=320;
        x=220;
        for(int i = 0; i < 4; i++){
            //addObject(new Ground(), x, y);
            Platform p4b = new Platform(true);
            p4b.setImage(b2);
            addObject(p4b, x, y);
            addObject(new InnerBlock(), x, y+30);
            addObject(new InnerBlock(), x, y+50);
            addObject(new InnerBlock(), x, y+80);
            addObject(new InnerBlock(), x, y+110);
            addObject(new InnerBlock(), x, y+140);
            addObject(new InnerBlock(), x, y+170);
            addObject(new InnerBlock(), x, y+200);
            addObject(new InnerBlock(), x, y+230);
            addObject(new InnerBlock(), x, y+260);
            addObject(new InnerBlock(), x, y+290);
            addObject(new InnerBlock(), x, y+310);
            x+=30;            
        }

        //second platform right corner stone 2
        Platform p4c = new Platform(true);
        p4c.setImage(b8);
        addObject(p4c, x, y);
        
        //second platform right vertical stone 2
        for(int i=0; i < 3; i++){
            Platform p4d = new Platform(false);
            p4d.setImage(b5);
            addObject(p4d, x, y+=30);
        }
        
        //top middle platform
        Platform p5 = new Platform(true);
        p5.setImage(b11);
        addObject(p5, 280, 170);

        
        //bottom middle platform
        Platform p6 = new Platform(true);
        p6.setImage(b11);
        addObject(p6, 420, 260);
        
        Platform p6a = new Platform(true);
        p6a.setImage(b11);
        addObject(p6a, 450, 230);
        
        Platform p6b = new Platform(true);
        p6b.setImage(b11);
        addObject(p6b, 480, 200);
        
        
        //bottom ground
        //bottom ground left corner stone
        x=570;
        y=320;
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
        y=320;
        addObject(new Ground(), x, y);
        addObject(new InnerBlock(), x, y+30);
        addObject(new InnerBlock(), x, y+50);
        addObject(new InnerBlock(), x, y+80);
        addObject(new InnerBlock(), x, y+110);
        
        
        
        InvisiblePortal portal = new InvisiblePortal();
        addObject(new InvisiblePortal(), 585, 280);
        
    }
   
    
    public void addSlime(){
        Slime s2 = new Slime(1);
        addObject(s2, 480, 155);
    }
    
    

}
