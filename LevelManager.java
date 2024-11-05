import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class LevelManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelManager  
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class LevelManager
     */
    private static List<World> levels = new ArrayList<>(); //store levels as instances
    private static int currentLevel = 0;
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    //intialize levels as instances
    //the instances allow levels to have a copy of its data
    static
    {
        levels.add(new LevelOne());
        levels.add(new LevelTwo());
        levels.add(new LevelThree());
    }
    public static World getCurrentLevel()
    {
        if(currentLevel < levels.size())
        {
            return levels.get(currentLevel);
        }
        else
        {
            return new ProceedWorld();
        }
    }
    
    //advances to next level
    public static void nextLevel()
    {
        currentLevel++;
    }
}
