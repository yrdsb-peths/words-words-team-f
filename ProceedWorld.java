import greenfoot.*;
import greenfoot.GreenfootImage;

public class ProceedWorld extends World implements Scrollable
{
    private GreenfootImage background;
    private GreenfootImage proceedText;
    private int scrollX;
    private int counter;
    public static GreenfootSound proceedBg = new GreenfootSound("fullMoonMusic.mp3");

    
    public ProceedWorld()
    {
        super(600,400,1);
        
        MusicManager.stopKitchenMus();
        MusicManager.stopPirateMus(); 
        MusicManager.stopLevelThreeMus(); 
        
        
        proceedBg.stop();
        proceedBg.playLoop(); 

        background = new GreenfootImage("cyabStripeBg.png");
        //starting point for background2 hover
        scrollX = 0;
        
        //buttons for all functions
        //lets user decide which level they wanna play next
        addObject(new Button(this:: goLevelSelect, "levelSelect.png", "levelSelect.png"), getWidth()/2, getHeight()/2);
        //takes player back to menu screen
        addObject(new Button(this:: goBackMenu, "menu.png", "menu.png"), getWidth()/2, getHeight()/2 + 60);
        //tracks which level player is currently on and next level will take you to the next
        ProceedText here = new ProceedText();
        addObject(here, 300, 130);
    }
    
    public void act()
    {
        scrollBackground();
    }
    
    public void scrollBackground()
    {
        counter++; // increase the counter

        //update scroll position every 5 frames
        if(counter >= 5)
        {
            scrollX += 2;   //scroll speed
            counter = 0; 
        }

        GreenfootImage scrolledImage = new GreenfootImage(getWidth(), getHeight());

        int imageWidth = background.getWidth();
        int imageHeight = background.getHeight();

        int x = scrollX % imageWidth; 
        //drawing the image twice to cover the empty areas during scrolling animation
        scrolledImage. drawImage(background, -x, 0);
        scrolledImage.drawImage(background, -x + imageWidth, 0); 
        scrolledImage.drawImage(background, -x, 0); 
        scrolledImage.drawImage(background, -x + imageWidth, 0);

        //set the background to the scrolled image
        setBackground(scrolledImage); 
    }
    
    
    private void goLevelSelect()
    {
        proceedBg.stop();
        MusicManager.playBgMusic();
        Greenfoot.setWorld(new LevelSelect());
    }
    
    private void goBackMenu()
    {
        proceedBg.stop();
        MusicManager.playBgMusic();
        Greenfoot.setWorld(new MenuScreen());
    }
    
}
