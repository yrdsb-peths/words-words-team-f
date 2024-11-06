import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelSelect extends World implements Scrollable
{
    private GreenfootImage background;
    private GreenfootImage differentMapText;
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
        background = new GreenfootImage("blueStripeBg.png");
        
        scrollX = 0;
        scrollY = 0;
        counter = 0;
        
        // buttons for the level select
        addObject(new Button(this::goLevelOne, "levelOneButton.png", "levelOneButton.png"), getWidth()/2, getHeight()/2);
        addObject(new Button(this::goLevelTwo, "levelbutton2.png", "levelbutton2.png"), getWidth()/2, getHeight()/2 + 60); 
        addObject(new Button(this::goLevelThree, "levelbutton3.png", "levelbutton3.png"), getWidth()/2, getHeight()/2 + 120);
        
        addObject(new Button(this::goHighScore, "highScoreButton.png", "highScoreButton.png"), 102, 371);
        
        LevelTitle title = new LevelTitle(); 
        addObject(title, 300, 130); 
        
        //back to menu button
        addObject(new Button(this::goMenu, "returnButton.png", "returnButton.png"), 110, 45);
        
        //new instructions screen button
        addObject(new Button(this::goInstructions, "instructions.png","instructions.png"), 499,371);
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
            scrollY += 2;   //scroll speed
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
    
    private void goHighScore()
    {
        Greenfoot.setWorld(new HighscoreScreen());
    }
    
    private void goLevelOne()
    {
        Greenfoot.setWorld(new LoadScreen("Level 1"));
    }
    
    private void goLevelTwo()
    {
        Greenfoot.setWorld(new LoadScreen("Level 2")); 
    }
    
    private void goLevelThree()
    {
        Greenfoot.setWorld(new LoadScreen("Level 3"));
    }
    
    private void goMenu()
    {
        Greenfoot.setWorld(new MenuScreen());
    }
    
    private void goInstructions()
    {
        Greenfoot.setWorld(new InstructionWorld()); 
    }
}
