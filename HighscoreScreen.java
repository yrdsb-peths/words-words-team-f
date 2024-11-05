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

    /**
     * Constructor for objects of class HighscoreScreen.
     * 
     */
    public HighscoreScreen()
    {    
        
        super(600, 400, 1);
        displayHighScores(); 
        
    }
    
    private void displayHighScores()
    {
        Map<String, Integer> highScores = HighScoreManager.getAllHighScores();
        
        int yPosition = 100; 
        showText("HIGHSCORE:", getWidth()/2 , 100);
        
        for(Map.Entry<String, Integer> entry : highScores.entrySet())
        {
            String levelName = entry.getKey(); 
            int clearCount = entry.getValue();
            
            
            showText(levelName + ": " + clearCount + " clears", getWidth() / 2, yPosition);
            yPosition += 30;
        }
        
        
    }
    
}
