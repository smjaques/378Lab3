import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lvl1Screen4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lvl1Screen4 extends Levels
{

    /**
     * Constructor for objects of class Lvl1Screen4.
     * 
     */
    public Lvl1Screen4(int health)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        printLevel("Lvl 1");
        addHealth();
        updateHealthLevel(health);
        drawPath();
        addBats();
        Knight knight = new Knight();
        addObject(knight,20,230);
    }
    
    public void drawPath(){
        int y=260;
        int x=10;
        for(int i = 0; i < 3; i++){
            addObject(new Ground(), x, y);
            addObject(new InnerBlock(), x, y+30);
            addObject(new InnerBlock(), x, y+50);
            addObject(new InnerBlock(), x, y+80);
            addObject(new InnerBlock(), x, y+110);
            addObject(new InnerBlock(), x, y+140);
            x+=30;            
        }
        
        addObject(new InnerBlock(), x, y+90);
        addObject(new InnerBlock(), x, y+120);
        addObject(new InnerBlock(), x, y+140);
        
        Platform p1 = new Platform(true);
        p1.setImage(b8);
        addObject(p1, x, y);
        
        for(int i=0; i < 2; i++){
            Platform p2 = new Platform(false);
            p2.setImage(b5);
            addObject(p2, x, y+=30);
        }
        
        Platform p3 = new Platform(true);
        p3.setImage(b11);
        addObject(p3, x+=30, y);
       
        addObject(new Platform(false), x, y+=30);
        addObject(new InnerBlock(), x, y+30);
        addObject(new InnerBlock(), x, y+60);
        addObject(new Platform(true), x+=30, y);
        addObject(new InnerBlock(), x, y+30);
        addObject(new InnerBlock(), x, y+60);
        Platform p4 = new Platform(true);
        p4.setImage(b8);
        addObject(p4, x+30, y);
        
        Platform p5 = new Platform(false);
        p5.setImage(b5);
        addObject(p5, x+30, y+=30);

        Platform p6 = new Platform(false);
        p6.setImage(b5);
        addObject(p6, x+30, y+30);
        
        //ceiling
        x=10;
        y=10;
        for(int i = 0; i < 8; i++){
            addObject(new InnerBlock(), x, y);
            Platform p7 = new Platform(false);
            p7.setImage(b3);
            addObject(p7, x, y+30);
            x+=30;
        }
        
        for(int i=0; i < 8; i++){
            addObject(new InnerBlock(), x, y);
            x+=30;
        }
        x=250;
        y+=30;
        for(int i=0; i < 6; i++){
            addObject(new InnerBlock(), x, y);
            x+=30;
        }
        
        x=250;
        Platform p8 = new Platform(false);
        p8.setImage(b6);
        addObject(p8, x, y+=30);
        
        for(int i=0; i < 5; i++){
            addObject(new InnerBlock(),x+=30, y); 
        }
        
        x-=150;
        
        Platform p9 = new Platform(false);
        p9.setImage(b10);
        addObject(p9, x, y+=30);

        for(int i=0; i < 5; i++){
            addObject(new InnerBlock(), x+=30, y);
        }
        
        x=280;
        y=130;
        for(int i=0; i < 3; i++){
            Platform p10 = new Platform(false);
            p10.setImage(b6);
            addObject(p10, x, y); 
            addObject(new InnerBlock(), x+30, y);
            addObject(new InnerBlock(), x+60, y);
            addObject(new InnerBlock(), x+90, y);            
            y+=30;
        }

        Platform p11 = new Platform(false);
        p11.setImage(b10);
        addObject(p11, x, y);
        
        for(int i=0; i < 2; i++){
            Platform p12 = new Platform(false);
            p12.setImage(b4);
            addObject(p12, x+=30, y);
        }
        
        Platform p13 = new Platform(false);
        p13.setImage(b9);
        addObject(p13, x+=30, y);
        
        for(int i = 0; i < 3; i++){
            Platform p14 = new Platform(false);
            p14.setImage(b5);
            addObject(p14, x, y-=30);
        }
        
        Platform p15 = new Platform(false);
        p15.setImage(b9);
        addObject(p15, x+=30, y-=30);
        
        Platform p16 = new Platform(false);
        p16.setImage(b5);
        addObject(p16, x, y-=30);
        
        addObject(new InnerBlock(), x, y-=30);
        
        Platform p17 = new Platform(false);
        p17.setImage(b3);
        addObject(p17, x+=30,  y);
        
        Platform p18 = new Platform(false);
        p18.setImage(b9);
        addObject(p18, x+=30, y);
        
        addObject(new InnerBlock(), x, y-=30);
        Platform p19 = new Platform(false);
        p19.setImage(b9);
        addObject(p19, x+=30, y);
        
        x=310;
        y=250;
        Platform p20 = new Platform(false);
        p20.setImage(b11);
        addObject(p20, x, y);
        
        x=290;
        y=350;
        Platform p21 = new Platform(true);
        p21.setImage(b11);
        addObject(p21, x, y);
        
        Platform p22 = new Platform(true);
        p22.setImage(b7);
        addObject(p22, x+=30, y);
        
        Platform p23 = new Platform(true);
        p23.setImage(b8);
        addObject(p23, x+=30, y);
        
        Platform p23_2 = new Platform(false);
        p23_2.setImage(b6);
        addObject(p23_2, x-30, y+30);
        addObject(new InnerBlock(), x-30, y+80);
        
        Platform p23_3 = new Platform(false);
        p23_3.setImage(b5);
        addObject(p23_3, x, y+30);
        addObject(new InnerBlock(), x, y+60);
        
        Platform p24 = new Platform(true);
        p24.setImage(b11);
        addObject(p24, x+=30, y);
        
        x=500;
        y=350;
        Platform p25 = new Platform(true);
        p25.setImage(b7);
        addObject(p25, x, y);
        
        Platform p26 = new Platform(false);
        p26.setImage(b6);
        addObject(p26, x, y+30);
        addObject(new InnerBlock(), x, y+60);
        
        //bottom right corner
        addObject(new Platform(true), x+=30, y);
        addObject(new InnerBlock(), x, y+30);
        addObject(new InnerBlock(), x, y+60);
        addObject(new Platform(true), x+=30, y);
        addObject(new InnerBlock(), x, y+30);
        addObject(new InnerBlock(), x, y+60);
        addObject(new Platform(false), x+=30, y);   
        addObject(new InnerBlock(), x, y+30);
        addObject(new InnerBlock(), x, y+60);

        
        Platform p27 = new Platform(false);
        p27.setImage(b4);
        addObject(p27, x, y-=30);
        
        Platform p28 = new Platform(false);
        p28.setImage(b10);
        addObject(p28, x-=30, y);
        
        Platform p29 = new Platform(true);
        p29.setImage(b7);
        addObject(p29, x, y-=30);
        addObject(new Platform(false), x+=30, y);
        
        Platform p30 = new Platform(false);
        p30.setImage(b10);
        addObject(p30, x, y-=30);
        
        for(int i=0; i < 2; i++){
            Platform p31 = new Platform(false);
            p31.setImage(b6);
            addObject(p31, x, y-=30);
        }
        
        Platform p32 = new Platform(false);
        p32.setImage(b7);
        addObject(p32, x, y-=30);
        
        Platform p33 = new Platform(false);
        p33.setImage(b3);
        addObject(p33, x, y-=30);
        
        Platform p34 = new Platform(false);
        p34.setImage(b10);
        addObject(p34, x-=30, y);
        
        Platform p35 = new Platform(true);
        p35.setImage(b11);
        addObject(p35, x-=30, y);
        
       
        Platform p36 = new Platform(true);
        p36.setImage(b7);
        addObject(p36, x+=30, y-=30);
        addObject(new Platform(true), x+=30, y);
        
        x=460;
        y=200;
        Platform p37 = new Platform(true);
        p37.setImage(b11);
        addObject(p37, x, y);
        
        InvisiblePortal portal = new InvisiblePortal();
        addObject(new InvisiblePortal(), 600, 70);
    }
    
    public void addBats(){
        Bat b1 = new Bat();
        addObject(b1, 30, 40);
        
        Bat b2 = new Bat();
        b2.setImage(new GreenfootImage("batFlyL1.png"));
        addObject(b2, 575, 90);
    }
}
