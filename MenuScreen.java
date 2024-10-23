import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuScreen extends World
{

    private GreenfootImage pressSpaceImage; 
    
    public MenuScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        //menuScreenbg
        setBackground(new GreenfootImage("menuScreenbg.png"));
        
        GreenfootImage pressSpaceImage = new GreenfootImage("pressSpace.png");
        getBackground().drawImage(pressSpaceImage, 250 , 331);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            //delay for sound effect to play and animation
            Greenfoot.delay(60);
            
            goLevelSelect();
        }
    }
    
    
    public void goLevelSelect()
    {
        Greenfoot.setWorld(new LevelSelect());
    }
    
}
