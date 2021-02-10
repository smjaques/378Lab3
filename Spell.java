import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spell extends Actor
{
    public final GreenfootImage s1 = new GreenfootImage("Spell1.png");
    public final GreenfootImage s2 = new GreenfootImage("Spell2.png");
    public final GreenfootImage s3 = new GreenfootImage("Spell3.png");
    public final GreenfootImage s4 = new GreenfootImage("Spell4.png");
    public final GreenfootSound snd1 = new GreenfootSound("Spell_Trigger.wav");
    public final GreenfootSound snd2 = new GreenfootSound("Teleport.wav");
    public final int DEF_ANIMTIMER = 100;
    
    private int animTimer;
    private boolean activated;
    
    private int debugtime = 80;
    
    public Spell() {
        animTimer = DEF_ANIMTIMER;
        activated = false;
        setImage(s1);
    }
    
    public void act() 
    {
        if (activated && animTimer > 0) {
            animTimer--;
            if (animTimer == DEF_ANIMTIMER/2) {
                setImage(s3);
            } else if (animTimer == 0) {
                setImage(s4);
                snd2.play();
            }
        }
    }    
    
    public void activate(boolean enable) {
        activated = enable;
        if (enable) {
            setImage(s2);
            snd1.play();
        } else {
            animTimer = DEF_ANIMTIMER;
            setImage(s1);
        }
    }
    
    public int getAnimTimer() {
        return animTimer;
    }
    
    public boolean isActivated() {
        return activated;
    }
}
