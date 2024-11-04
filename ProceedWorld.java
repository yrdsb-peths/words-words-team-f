import greenfoot.*;
import greenfoot.GreenfootImage;

public class ProceedWorld extends World
{
    private GreenfootImage background;
    private int scrollX;
    private int scrollY; 
    private int scrollZ;
    private int counter;
    public ProceedWorld()
    {
        super(600,400,1);
        background = new GreenfootImage("cyabStripeBg.png");
        //starting point for background hover
        scrollX = 0;
        scrollY = 0;
        scrollZ = 0;
        
        //buttons for all functions
        addObject(new Button(this:: goLevelSelect, "levelSelect.png", "levelSelect.png"), getWidth()/2, getHeight()/2);
        addObject(new Button(this:: goBackMenu, "menu.png", "menu.png"), getWidth()/2, getHeight()/2 + 60);
        addObject(new Button(this:: goReplay, "LevelOneButton.png", "LevelOneButton.png"), getWidth()/2, getHeight()/2 + 120);
    }
    
    public void act()
    {
        scrollBackGround();
    }
    private void goLevelSelect()
    {
        Greenfoot.setWorld(new LevelSelect());
    }
    private void goBackMenu()
    {
        Greenfoot.setWorld(new MenuScreen());
    }
    private void goReplay()
    {
        Greenfoot.setWorld(new LevelOne());
    }
    
    private void scrollBackGround()
    {
        counter++; // increase the counter
        
        if(counter >= 5)
        {
            scrollX += 1;
            scrollY += 1;  
            counter = 0; 
        }
        
        GreenfootImage scrolledImage = new GreenfootImage(getWidth(), getHeight());
        
        int imageWidth = background.getWidth();
        int imageHeight = background.getHeight();
        
        int x = scrollX % imageWidth; 
        int y = scrollY % imageHeight; 
        
        scrolledImage. drawImage(background, -x, -y);
        scrolledImage.drawImage(background, -x + imageWidth, -y); 
        scrolledImage.drawImage(background, -x, -y + imageHeight); 
        scrolledImage.drawImage(background, -x + imageWidth, -y + imageHeight);
        
        //set the background to the scrolled image
        setBackground(scrolledImage);
    }
}
