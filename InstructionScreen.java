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
    
    public InstructionScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        this.levelName = levelName;
        setBackground(new GreenfootImage("InstructionScreen.jpg"));
    }
    public void showInstructions()
    {
        String instructions = "";
        switch(levelName)
        {
            case "Level 1":
                instructions = "Level 1: Memorize the displayed words.\nAfter the timer ends, input the words in the correct order.";
                break;
            case "Level 2":
                instructions = "Level 2: More words to memorize and less time!\nInput the words in the correct order after memorization.";
                break;
            case "Level 3":
                instructions = "Level 3: Challenge mode! Be quick and precise.\nMemorize the words and type them in order correctly.";
                break;
        }
    }
    private void addStartButton()
    {
        Button startButton = new Button(() -> startLevel(), "startButton.png", "startButton.png");
        addObject(startButton, getWidth() / 2, getHeight() - 50);
    }
    private void startLevel()
    {
        switch (levelName)
        {
            case "Level 1":
                Greenfoot.setWorld(new LevelOne());
                break;
            case "Level 2":
                Greenfoot.setWorld(new LevelTwo());
                break;
            case "Level 3":
                Greenfoot.setWorld(new LevelThree());
                break;
        }
    }
}
