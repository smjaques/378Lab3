import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GenericText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GenericText extends Actor
{
    private String text;
    private Font font;
    private GreenfootImage image;
    private Color color;
    private int width;
    private int height;
    
    public GenericText(String text, int w, int h, Font font, Color color) {
        width = w;
        height = h;
        image = new GreenfootImage(width, height);
        setImage(image);
        if (font != null) {
            this.font = font;
            image.setFont(font);
        }
        this.color = color;
        image.setColor(color);
        this.text = text;
    }
    
    public GenericText(String text, int w, int h) {
        this(text,w,h,new Font(12), Color.WHITE);
    }
    
    public GenericText(String text, Font font, Color color) {
        this(text,1600,800,font,color);
    }
    
    public GenericText(String text) {
        this(text,1600,800);
    }
    
    public void addedToWorld(World w) {
        image.drawString(text,width/2,height/2+font.getSize());
    }
}
