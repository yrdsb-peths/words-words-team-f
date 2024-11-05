import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Map;

/**
 * Write a description of class HighscoreScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighscoreScreen extends World
{
    private GreenfootImage background;
    /**
     * Constructor for objects of class HighscoreScreen.
     * 
     */
    public HighscoreScreen()
    {    
        
        super(600, 400, 1);
        displayHighScores(); 
        background = new GreenfootImage("checkScore.png");
        setBackground(background);
        
        addObject(new Button(this::goLevelSelect, "small button_.png","small button_.png"), 35,45);

    }
    
    private void displayHighScores()
    {
        Map<String, Integer> highScores = HighScoreManager.getAllHighScores();
        
        int yPosition = 100; 
        for(Map.Entry<String, Integer> entry : highScores.entrySet())
        {
            String levelName = entry.getKey(); 
            int clearCount = entry.getValue();
            
            
            showText(levelName + ": " + clearCount + " clears", getWidth() / 2, getHeight()/2);
            yPosition += 30;
        }
        
        
    }
    
    private void goLevelSelect()
    {
        Greenfoot.setWorld(new LevelSelect());
    }
    
}
