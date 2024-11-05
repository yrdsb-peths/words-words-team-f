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
    private Actor noHighScoresText;
    
    
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
        
        int yPositionLevel1 = 150;
        int yPositionLevel2 = 200;
        int yPositionLevel3 = 250;
        
        if(highScores.isEmpty())
        {
            noHighScoresText = new Actor()
            {
                {
                    GreenfootImage image = new GreenfootImage("No highscores... clear some levels and check again!", 36, Color.BLACK, new Color(0, 0, 0, 0));
                    image.scale((int)(image.getWidth()/2), (int)(image.getHeight()/2));
                    setImage(image);
                }
            };
            
            addObject(noHighScoresText, getWidth()/2, getHeight()/2); 
        }
        else
        {
            if(noHighScoresText != null)
            {
                removeObject(noHighScoresText);
                noHighScoresText = null;
            }
            
            if (highScores.containsKey("Level 1"))
            {
                int clearCount = highScores.get("Level 1");
                showText("Level 1: " + clearCount + " clears", getWidth() / 2, yPositionLevel1);
            }
            
            if (highScores.containsKey("Level 2"))
            {
                int clearCount = highScores.get("Level 2");
                showText("Level 2: " + clearCount + " clears", getWidth() / 2, yPositionLevel2);
            }
            
            if (highScores.containsKey("Level 3"))
            {
                int clearCount = highScores.get("Level 3");
                showText("Level 3: " + clearCount + " clears", getWidth() / 2, yPositionLevel3);
            }
            
        }
        
    }
    
    private void goLevelSelect()
    {
        Greenfoot.setWorld(new LevelSelect());
    }
    
}
