import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Arrays;

public class PlayerInput extends Actor
{
    private ArrayList<String> possibleKeys;
    private String userInput = "";
    private boolean isInputEnabled = false;
    private boolean showingWords = true;
    private ArrayList<String> words;
    private int timerSet = 200;

    private int timeLimit = 200;
    private int timeRemaining = timeLimit;
    
    
    public PlayerInput()
    {
        setImage((GreenfootImage) null);
        possibleKeys = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "space"));
        words = new ArrayList<>(Arrays.asList("apple", "banana", "cherry", "orange", "grape"));
    }
    
    public void act()
    {
        if(showingWords)
        {
            if(timerSet > 0)
            {
                timerSet--; 
            }
            else
            {
                clearScreen(); 
                showingWords = false; 
                isInputEnabled = true;
            }
        }
        else
        {
            if(isInputEnabled)
            {
                handleUserTyping();
            }
        }
        
        updateTimer(); 
    }
    
    
    
    private void handleUserTyping()
    {
        for(String key : possibleKeys)
        {
            if(Greenfoot.isKeyDown(key))
            {
                if(key.equals("space"))
                {
                    userInput += " ";
                }
                else
                {
                    userInput += key;
                }
                Greenfoot.delay(5);
            }
            if (Greenfoot.isKeyDown("backspace") && userInput.length() > 0)
            {
                userInput = userInput.substring(0, userInput.length() - 1);
                Greenfoot.delay(5);
            }
            if(Greenfoot.isKeyDown("enter"))
            {
                userInput = ""; // reset after enter key press
                Greenfoot.delay(5);
            }
            
            World world = getWorld(); 
            world.showText("Typed: " + userInput, 300, 350); 
        }
         
    }
        
    private void clearScreen()
    {
        getWorld().showText("", 300, 200); 
    }
    
    
    public void showWords()
    {
        StringBuilder displayText = new StringBuilder("Memorize these words:\n");
        for (String word : words)
        {
            displayText.append(word).append(" ");
        }
        getWorld().showText(displayText.toString(), 300, 200);
    }
    
    private void updateTimer()
    {
        if(timeRemaining > 0)
        {
            timeRemaining --; 
        }
        int secondsRemaining = timeRemaining / 60;
        getWorld().showText("Time to memorize: " + secondsRemaining + "s", 300, 50);
    }
}
