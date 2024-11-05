import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;


public class PlayerInput extends Actor
{
    private ArrayList<String> wordsToMemorize;
    private ArrayList<String> userInputs;
    private boolean inputEnabled = false;
    private int wordYPosition = 200; 
    
    private String currentWord = "";  // Store the current word the user is typing
    private int currentWordIndex = 0;
    
    private World levelWorld;
    private boolean buttonCreated = false;
    
    private Actor levelClearActor = null;
    private Actor levelFailActor = null;
    
    private int fadeOpacity = 255;
    private int levelFailOpacity = 255;
    
    
    
    public PlayerInput(ArrayList<String> words, World levelWorld)
    {
        setImage((GreenfootImage) null);
        this.wordsToMemorize = words;
        this.userInputs = new ArrayList<>();
        this.levelWorld = levelWorld;
        
        // Initialize user input slots to empty strings
        for (int i = 0; i < words.size(); i++) {
            userInputs.add("");  // Create empty strings for user input
        }
        
        
    }
    
    public void act()
    {
        if (inputEnabled)
        {
            handleUserTyping();
        }
        
        if(levelClearActor!= null && fadeOpacity > 0)
        {
            fadeOpacity -= 1;
            
            if(fadeOpacity < 0)
            {
                fadeOpacity = 0; 
            }
            
            levelClearActor.getImage().setTransparency(fadeOpacity);
            
            if(fadeOpacity == 0)
            {
                levelWorld.removeObject(levelClearActor); 
                levelClearActor = null;
            }
        }
        
        
        if(levelFailActor != null && levelFailOpacity > 0)
        {
            levelFailOpacity -= 1;
            if(levelFailOpacity < 0) levelFailOpacity = 0;
            levelFailActor.getImage().setTransparency(levelFailOpacity);
            if(levelFailOpacity == 0)
            {
                levelWorld.removeObject(levelFailActor);
                levelFailActor = null;
            }
        }
    
        
    }
    
    public void enableInput()
    {
        inputEnabled = true;  // Enable user typing
        showTextForInput();  // Display empty input fields at the beginning
    }
    
    private void handleUserTyping()
    {
        String key = Greenfoot.getKey();
        
        if (key != null)
        {
            // If the input is space or enter, store the current word
            if (key.equals("space") || key.equals("enter"))
            {
                for (int i = 0; i < userInputs.size(); i++)
                {
                    if (userInputs.get(i).isEmpty())
                    {
                        userInputs.set(i, currentWord);
                        currentWord = "";  // Reset current word
                        showTextForInput();
                        break;
                    }
                }
                // Check if all words are entered
                if (allWordsFilled())
                {
                    inputEnabled = false;  // Disable further input
                    checkUserAnswers();
                }
            }
            else if (key.equals("backspace") && currentWord.length() > 0)
            {
                currentWord = currentWord.substring(0, currentWord.length() - 1);
            }
            else if (key.length() == 1)
            {
                currentWord += key;
            }
            
            showTextForInput(); 
        }
    }
    
    private void showTextForInput()
    {
        // Display the user's inputs centered in the text boxes
        World world = getWorld(); 
        int screenWidth = world.getWidth(); 
        int numWords = userInputs.size(); 
        int spacing = screenWidth / (numWords - 1); 
        double scaleFactor = 0.73; //reduce the spacing by this amount 
        int adjustedSpacing = (int)(spacing * scaleFactor);
        
        //display words at specific positions
        for(int i = 0; i < userInputs.size(); i++)
        {
            int xPosition =  adjustedSpacing * i; // even spacing along the width of screen
            int yPosition = wordYPosition;  // vertical spacing
            world.showText(userInputs.get(i), xPosition + 78, yPosition);
        }
        
        if (!allWordsFilled())
        {
            world.showText("(type here): " + currentWord, 300, wordYPosition + 110);
        }
        else
        {
            world.showText("", 300, wordYPosition + 110); // Clear the "(type here):" text
        }
    }
    
    private void checkUserAnswers()
    {
        World world = getWorld();
        int correctAnswers = 0;
    
        // Loop through user inputs and check against the correct answers
        for (int i = 0; i < userInputs.size(); i++)
        {
            String input = userInputs.get(i);
            String correctWord = wordsToMemorize.get(i);
    
            // Calculate the position to display "Correct" or "Incorrect" based on the current text box
            int xPosition = (world.getWidth() / (userInputs.size() + 1)) * (i + 1);
            int yPosition = wordYPosition + 30;  // Slightly below the current word
    
            // Display correct or incorrect for each word
            if (correctWord.equals(input)) {
                world.showText("(YES)", xPosition, yPosition);
                correctAnswers++;
            } else {
                world.showText("(NO)", xPosition, yPosition);
            }
        }
    
        world.showText("Correct Ingredients: " + correctAnswers + " out of " + wordsToMemorize.size(), 300, wordYPosition + 130);
        
        int passThreshold = (wordsToMemorize.size() + 1) / 2;
        
        if(correctAnswers >= passThreshold && levelClearActor == null)
        {
            HighScoreManager.addHighScore("globalHighScore", 1); 
            
    
            GreenfootImage levelClearText = new GreenfootImage("levelClearText.png");
            levelClearText.scale(400, 38);
            levelClearText.setTransparency(fadeOpacity);
            
            levelClearActor = new LevelClearActor(levelClearText);
            
            world.addObject(levelClearActor, world.getWidth() / 2, world.getHeight() / 2);

        }
        else if (correctAnswers < passThreshold && levelFailActor == null)// if half the answers are wrong it is considered a fail
        {
            GreenfootImage levelFailText = new GreenfootImage("levelFailed.png");
            levelFailText.scale(400, 38);
            levelFailText.setTransparency(levelFailOpacity);
            levelFailActor = new LevelFailActor(levelFailText);
            world.addObject(levelFailActor, world.getWidth() / 2, world.getHeight() / 2);
        }
        getWorld().addObject(new Button(this:: goProceed, "proceed.png", "proceed.png"), world.getWidth()/2, world.getHeight()/2 + 170); 
        
    }

    private boolean allWordsFilled()
    {
        for (String input : userInputs)
        {
            if (input.isEmpty())
            {
                return false; 
            }
        }
        return true; 
    }
    
    private void goBackMenu()
    {
        Greenfoot.setWorld(new MenuScreen());
    }

    private void goReplay()
    {
        Greenfoot.setWorld(new LevelOne());
    }
    

    private void goProceed()
    {
        Greenfoot.setWorld(new ProceedWorld());
    }
}
