import greenfoot.*;
import greenfoot.GreenfootImage;

public class ProceedWorld extends World
{
    private GreenfootImage background;
    private GreenfootImage proceedText;
    private int scrollX;
    private int counter;
    public ProceedWorld()
    {
        super(600,400,1);
        
        MusicManager.stopKitchenMus();
        MusicManager.stopPirateMus(); 
        
        background = new GreenfootImage("cyabStripeBg.png");
        //starting point for background2 hover
        scrollX = 0;
        
        //buttons for all functions
        addObject(new Button(this:: goLevelSelect, "levelSelect.png", "levelSelect.png"), getWidth()/2, getHeight()/2);
        addObject(new Button(this:: goBackMenu, "menu.png", "menu.png"), getWidth()/2, getHeight()/2 + 60);
        //addObject(new Button(this:: goReplay, "LevelOneButton.png", "LevelOneButton.png"), getWidth()/2, getHeight()/2 + 120);
        
        ProceedText here = new ProceedText();
        addObject(here, 300, 130);
    }
    
    public void act()
    {
        scrollBackground();
    }
    
    private void scrollBackground()
    {
        counter++; // increase the counter

        //update scroll position every 5 frames
        if(counter >= 5)
        {
            scrollX += 1;   //scroll speed
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
        MusicManager.playBgMusic();
        Greenfoot.setWorld(new LevelSelect());
    }
    
    private void goBackMenu()
    {
        MusicManager.playBgMusic();
        Greenfoot.setWorld(new MenuScreen());
    }
    
    private void goReplay()
    {
        //Greenfoot.setWorld(new LevelOne());
    }

    
}
