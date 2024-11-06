import greenfoot.*;

/**
 * Write a description of class LevelLogo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class LevelLogo extends Actor
{
    
    public LevelLogo(String filename)
    {
        setImage(createScaledImage(filename, 1024 / 3, 228 / 3));
    }
    
    private GreenfootImage createScaledImage(String filename, int width, int height)
    {
        GreenfootImage img = new GreenfootImage(filename);
        img.scale(width, height);
        return img;
    }
    
}
