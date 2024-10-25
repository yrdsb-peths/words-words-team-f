import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; 
import java.util.Arrays;
public class LevelOne extends World
{
    private boolean gameStarted = false;
    private boolean showingWords = true;
    private boolean isInputEnabled = false;
    private ArrayList<String> ingredients = new ArrayList<String>();
    private ArrayList<String> words;
    private ArrayList<String> possibleKeys;
    private String[] userAnswers = new String[3];
    private String userInput = "";
    private int currentAnswerIndex = 0; 
    private int timerSet = 200;
    private int timeLimit = 200;
    private int timeRemaining = timeLimit;
    public LevelOne()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        super(600, 400, 1);         
        
        MusicManager.stopMusic();
        
        showText("this is level one", 300,200);
        //setImage(image);
        //setWords
        ingredients.add("tomato");
        ingredients.add("cucumber");
        ingredients.add("carrot");
        
        setBackground(new GreenfootImage("map1bg.png")); 
        
        TextBox textBox = new TextBox();
        TextBox textBoxTwo = new TextBox();
        TextBox textBoxThree = new TextBox(); 
        
        addObject(textBox, 104, 308);
        addObject(textBoxTwo, 307, 308);
        addObject(textBoxThree, 503, 308);
        
        words = new ArrayList<>(Arrays.asList("apple", "banana", "cherry", "orange", "grape"));
        possibleKeys = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "space"));
        
        showWords();
    }
    
    public void act()
    {
        if(!gameStarted)
        {
            //loading screen
            if (Greenfoot.isKeyDown("enter"))
            {
                showText("", 300, 200);  // Clear the intro text
                gameStarted = true;
                showWords();
            }
        }
        updateTimer();

        if (showingWords) {
            if (timerSet > 0) {
                timerSet--;
            } else {
                clearScreen();
                showingWords = false;
                isInputEnabled = true;
            }
        } else {
            if (isInputEnabled) {
                handleUserTyping();
            }
        }
    }
    
    private void showWords() {
        StringBuilder displayText = new StringBuilder("Memorize these words:\n");
        for (String word : words) {
            displayText.append(word).append(" ");
        }
        showText(displayText.toString(), 300, 200);
    }

    private void clearScreen() {
        showText("", 300, 200);
    }

    private void handleUserTyping() {
        for (String key : possibleKeys) {
            if (Greenfoot.isKeyDown(key)) {
                if (key.equals("space")) {
                    userInput += " ";
                } else {
                    userInput += key;
                }
                Greenfoot.delay(5);
            }
        }
        if (Greenfoot.isKeyDown("backspace") && userInput.length() > 0) {
            userInput = userInput.substring(0, userInput.length() - 1);
            Greenfoot.delay(5);
        }
        if (Greenfoot.isKeyDown("enter")) {
            userInput = "";
            Greenfoot.delay(5);
        }
        showText("Typed: " + userInput, 300, 350);
    }

    private void updateTimer() {
        if (timeRemaining > 0) {
            timeRemaining--;
        }
    
        int secondsRemaining = timeRemaining / 60;
        showText("Time to memorize: " + secondsRemaining + "s", 300, 50);  // Display remaining time
    }
}
