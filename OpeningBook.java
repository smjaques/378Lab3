import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OpeningBook extends Levels
{
    public boolean open = false;
    private GreenfootSound snd1 = new GreenfootSound("Page_Flip.wav");

    public OpeningBook()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        setBackground(new GreenfootImage("openingBook.png"));
        knightBackgroundMusic.play();
    }

    
    public void act(){
        if (!open) {
            Greenfoot.delay(40);
            snd1.play();
            Greenfoot.delay(20);
            openBook();
        } else if(Greenfoot.isKeyDown("space")){
            snd1.play();
            Greenfoot.setWorld(new Lvl1Screen1());
        }
    }
    
    private void openBook() {
        open = true;
        setBackground(new GreenfootImage("openBook.png")); 
        // LeftBook left = new LeftBook();
        // addObject(left, 160, 180);
        // RightBook right = new RightBook();
        // addObject(right,440,180);
        Font defFont = new Font("Georgia",21);
        Font defBold = new Font("Georgia",true,false,21);
        addObject(new GenericText("Once upon a time, in a \nKingdom long forgotten, \n"+
            "a princess lies trapped in \na fortress built by the very \nsubjects she would rule.",
            defFont, Color.BLACK),36,25);
        addObject(new GenericText("As per the laws of their \nland, the next king shall be \ndecided by a test of might \nand honor. "+
            "Whoever frees\nthe princess will have her\nhand in marriage.",
            defFont, Color.BLACK),36,180);
        addObject(new GenericText("For days there has been\nnothing but failure after\nfailure, but this time is\ndifferent.",
            defFont, Color.BLACK),323,25);
        addObject(new GenericText("Now it is your turn, and\nnobody can best your\nswordsmanship and wit.",
            defFont, Color.BLACK),323,150);
        addObject(new GenericText("Nobody.",
            defBold, Color.BLACK),323,160+65);
        addObject(new GenericText("Press space to start your\nquest.",
            defFont, Color.BLACK),323,280);
    }
    
    public void stopBRM(){
        knightBackgroundMusic.stop();
    }
}
