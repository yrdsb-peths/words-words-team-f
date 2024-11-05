import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;

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
    private int animationStep = 0; //frame count
    
    private int pulseAni = 0; // breathing effect for press space
    private boolean growing = true; 
    
    private int originalWidth = 130; //original width for the press start image
    private int originalHeight = 44; //original height for the press start image
    private double scaleVar = 1.0; 
    
    private Boolean musicPlaying = false;
    
    private GreenfootSound selectSound = new GreenfootSound("menuSelectSound.mp3");
    
    
    private GreenfootImage whiteOverlay;
    private int fadeOpacity = 225; //225 is the max opacity
    public MenuScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        //menuScreenbg
        setBackground(new GreenfootImage("menuScreenbg.png"));
        
        pressSpaceImage = new GreenfootImage("pressSpace.png");
        getBackground().drawImage(pressSpaceImage, 250 , 331);
        
        whiteOverlay = new GreenfootImage(getWidth(), getHeight());
        whiteOverlay.setColor(Color.WHITE); 
        whiteOverlay.fill(); 
        
        LevelManager levelManager = new LevelManager();
        //Greenfoot.setWorld(new LevelOne(levelManager));
    }
    
    
    public void act()
    {   
        if(!spacePressed)
        {
            animateBreathingSpace(); 
        }
        
        
        if(Greenfoot.isKeyDown("space") && !spacePressed)
        {
            spacePressed = true; 
        }
        
        if(spacePressed)
        {
            selectSound.play(); 
            animatePressedSpace(); 
        }
        
        //white fade in for intro
        if(fadeOpacity > 0)
        {
            fadeInEffect(); 
        }
        
    }
    
    
    
    public void started()
    {
        MusicManager.playBgMusic(); 
    }
    
    
    public void stopped()
    {
        MusicManager.pauseBgMusic(); 
    }
    
    
    private void fadeInEffect()
    {
        whiteOverlay.setTransparency(fadeOpacity); 
        getBackground().drawImage(whiteOverlay, 0, 0); 
        
        fadeOpacity -= 3; //basically speed of fade out
        
        if(fadeOpacity < 0)
        {
            fadeOpacity = 0;
        }
        
        
    }
    
    private void animateBreathingSpace()
    {
        if(growing)
        {
            scaleVar += 0.005;
            if(scaleVar >= 1.1) //once it is at 1.1x, start shrinking again
            {
                growing = false;
            }
        }
        else
        {
            scaleVar -= 0.005; 
            if(scaleVar <= 0.9) //once it is at 0.9, set growing to true so it will continue growing
            {
                growing = true; 
            }
        }
        
        int scaledWidth = (int)(originalWidth * scaleVar); 
        int scaledHeight = (int)(originalHeight * scaleVar); 
        
        GreenfootImage scaledImage = new GreenfootImage(pressSpaceImage); 
        scaledImage.scale(scaledWidth, scaledHeight); //create scaled ver of press space image
        
        getBackground().clear(); 
        setBackground(new GreenfootImage("menuScreenbg.png"));
        
        int xPos = 250 - (scaledWidth - originalWidth) / 2;
        int yPos = 331 - (scaledHeight - originalHeight) / 2; 
        getBackground().drawImage(scaledImage, xPos, yPos); 
        
    }

    
    private void animatePressedSpace()
    {
        if(animationStep < 60) //60 so one second (60) frames
        {
            double scaleVar = 1 + 0.02 * animationStep; // 2% each increment 
            //2% because out of 60 frames (1 second)
            
            int scaledWidth = (int)(originalWidth * scaleVar); 
            int scaledHeight = (int) (originalHeight * scaleVar); 
            
            int opacity = Math.max(0, 225 - (int)(4.25 * animationStep));
            //225 is max opacity, 225 / 60 is 4.25
            
            GreenfootImage scaledImage = new GreenfootImage(pressSpaceImage);
            scaledImage.scale(scaledWidth, scaledHeight);
            scaledImage.setTransparency(opacity); 
            
            
            //clear current frame and draw the next one
            getBackground().clear(); 
            setBackground(new GreenfootImage("menuScreenbg.png")); 
            
            int xPos = 250 - (scaledWidth - originalWidth) / 2; 
            int yPos = 331 - (scaledHeight - originalHeight) / 2;
            
            getBackground().drawImage(scaledImage, xPos, yPos); 
            
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
