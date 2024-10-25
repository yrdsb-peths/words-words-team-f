import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; 
import java.util.Arrays;
public class LevelOne extends World
{
    private ArrayList<String> words;
    private PlayerInput playerInput;
    public LevelOne()
    {
        super(600, 400, 1);
        
        int timeRemaining = 300; // 5 seconds (300 frames)
        ArrayList<String> words = new ArrayList<>();
        words.add("apple");
        words.add("banana");
        words.add("cherry");
        
        PlayerInput playerInput = new PlayerInput(timeRemaining, words);
        addObject(playerInput, 300, 350);
    }
}
