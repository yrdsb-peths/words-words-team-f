import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionWorld extends World
{
    private String levelName;
    private GreenfootImage background;
    
    private int scrollX;
    private int counter;
    
    public InstructionWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        background = new GreenfootImage("InstructionScreen.png");
        showInstructions();
        addObject(new Button(this::goLevelSelect, "small button_.png","small button_.png"), 35,45);
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
        String instructions = "Your job is to memorize all the ingredients,\n\n and repeat them in the given order!\n<ENTER> to finish the word\n<BACKSPACE> to undo!\nAfter the timer ends, Start Typing!\n\nget more than half to pass the level!\nGoodluck Chef! Let's start this fiesta!";
        
        InstructionText instructionText = new InstructionText(instructions);
        addObject(instructionText, getWidth() / 2, getHeight() / 2); 
    }

    private void goLevelSelect()
    {
        Greenfoot.setWorld(new LevelSelect());
    }
}
