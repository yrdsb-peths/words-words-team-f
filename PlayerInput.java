import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Arrays;

public class PlayerInput extends Actor
{
    private ArrayList<String> wordsToMemorize;
    private ArrayList<String> userInputs;
    private boolean inputEnabled = false;
    private int wordYPosition = 200; 
    
    private String currentWord = "";  // Store the current word the user is typing
    private int currentWordIndex = 0;
    
    private World levelWorld;
    
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
        
         //display current word being typed
        world.showText("(type here): " + currentWord, 300, wordYPosition + 110);
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
                world.showText("(Correct)", xPosition, yPosition);
                correctAnswers++;
            } else {
                world.showText("(Incorrect)", xPosition, yPosition);
            }
        }
    
        world.showText("Correct Ingredients: " + correctAnswers + " out of " + wordsToMemorize.size(), 300, wordYPosition + 130);
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
}
