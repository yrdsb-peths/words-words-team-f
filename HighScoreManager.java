import java.util.HashMap;
import java.util.Map;

public class HighScoreManager  
{
    private static Map<String, Integer> highScores = new HashMap<>();
    
    public static void addHighScore(String level, int score)
    {
        highScores.put(level, highScores.getOrDefault(level, 0) + score);
    }

    public static int getHighScore(String level)
    {
        return highScores.getOrDefault(level, 0); 
    }
    
    public static Map<String, Integer> getAllHighScores()
    {
        return new HashMap<>(highScores);  // Return a copy of all high scores
    }
 }
