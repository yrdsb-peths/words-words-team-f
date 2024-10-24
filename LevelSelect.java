import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelSelect extends World
{
    private GreenfootImage background;
    private int scrollX;
    private int scrollY;
    private int counter;
    
    /**
     * Constructor for objects of class LevelSelect.
     * 
     */
    public LevelSelect()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        background = new GreenfootImage("newstripebg.png");
        scrollX = 0;
        scrollY = 0;
        counter = 0;
        
        
        //add buttons for the level select.
        addObject(new Button(this::goLevelOne, "levelOneButton.png"), getWidth()/2, getHeight()/2);
        
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
            scrollY += 1;   //scroll speed
            counter = 0; 
        }
        
        GreenfootImage scrolledImage = new GreenfootImage(getWidth(), getHeight());
        
        int imageWidth = background.getWidth();
        int imageHeight = background.getHeight();
        
        int x = scrollX % imageWidth; 
        int y = scrollY % imageHeight; 
        
        //drawing the image twice to cover the empty areas during scrolling animation
        scrolledImage. drawImage(background, -x, -y);
        scrolledImage.drawImage(background, -x + imageWidth, -y); 
        scrolledImage.drawImage(background, -x, -y + imageHeight); 
        scrolledImage.drawImage(background, -x + imageWidth, -y + imageHeight);
        
        //set the background to the scrolled image
        setBackground(scrolledImage); 
    }
    
    
    
    public void goLevelOne()
    {
        Greenfoot.setWorld(new LevelOne());
    }
    
    
}
