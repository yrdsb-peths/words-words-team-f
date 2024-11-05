import java.util.HashMap;
import java.util.Map;

public class HighScoreManager  
{
    private static Map<String, Integer> highScores = new HashMap<>();
    
    public static void addHighScore(String levelName, int score)
    {
        highScores.put(levelName, highScores.getOrDefault(levelName, 0) + score);
    }

    public static int getHighScore(String levelName)
    {
        return highScores.getOrDefault(levelName, 0); 
    }
    
    public static Map<String, Integer> getAllHighScores()
    {
        return new HashMap<>(highScores);  // Return a copy of all high scores
    }
 }
