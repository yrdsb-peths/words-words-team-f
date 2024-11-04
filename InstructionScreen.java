import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionScreen extends World
{
    private String levelName;
    private GreenfootImage background;
    
    private int scrollX;
    private int scrollY;
    private int counter;
    
    public InstructionScreen(String currentLevel)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        this.levelName = currentLevel;
        background = new GreenfootImage("InstructionScreen.png");
        showInstructions();
        addStartButton();
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
    public void showInstructions()
    {
        String instructions = "";
        if (levelName.equals("Level 1"))
        {
            LevelOneTitle = new GreenfootImage(".png");
            addObject(LevelOneTitle, getWidth()
            instructions = "\nMemorize the displayed words.\nAfter the timer ends,\ninput the words in the correct order.";
        } 
        else if (levelName.equals("Level 2"))
        {
            instructions = "\nMore words to memorize and less time!\nInput the words in the correct order after memorization.";
        } 
        else if (levelName.equals("Level 3"))
        {
            instructions = "\nChallenge mode! Be quick and precise.\nMemorize the words and type them in order correctly.";
        }
        showText(instructions, getWidth() / 2, getHeight() / 2);
    }
    private void addStartButton()
    {
        Button startButton = new Button(this::startLevel, "LetsCook.png", "LetsCook.png");
        addObject(startButton, getWidth() / 2, getHeight() - 100);
    }
    private void startLevel()
    {
        if (levelName.equals("Level 1"))
        {
            Greenfoot.setWorld(new LevelOne());
        } 
        else if (levelName.equals("Level 2"))
        {
            Greenfoot.setWorld(new LevelTwo());
        } 
        else
        {
            Greenfoot.setWorld(new LevelThree());
        }
    }
}
