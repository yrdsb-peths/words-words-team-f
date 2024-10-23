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
    private boolean spacePressed = false;
    private int animationStep = 0; 
    
    
    
    public MenuScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        //menuScreenbg
        setBackground(new GreenfootImage("menuScreenbg.png"));
        
        pressSpaceImage = new GreenfootImage("pressSpace.png");
        getBackground().drawImage(pressSpaceImage, 250 , 331);
    }
    
    public void act()
    {   
        if(Greenfoot.isKeyDown("space") && !spacePressed)
        {
            spacePressed = true; 
        }
        
        if(spacePressed)
        {
            animatePressedSpace(); 
        }
        
    }
    
    private void animatePressedSpace()
    {
        if(animationStep < 60) //60 so one second (60) frames
        {
            int scale = (int)(pressSpaceImage.getWidth() * (1 + 0.02 * animationStep));
            int opacity = Math.max(0, 225 - (int)(4.25 * animationStep));
            
            GreenfootImage scaledImage = new GreenfootImage(pressSpaceImage);
            scaledImage.scale(scale, scale);
            scaledImage.setTransparency(opacity); 
            
            //clear current frame and draw the next one
            
            getBackground().clear(); 
            setBackground(new GreenfootImage("menuScreenbg.png")); 
            getBackground().drawImage(scaledImage, 250 - (scale - pressSpaceImage.getWidth()) / 2, 331 - (scale - pressSpaceImage.getHeight()) / 2); 
            
            // to next frame
            animationStep++; 
        }
        else
        {
            goLevelSelect(); 
        }
    }
    
    
    public void goLevelSelect()
    {
        Greenfoot.setWorld(new LevelSelect());
    }
    
}
