import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LevelTwo extends World
{
    private boolean gameStarted = false;
    private boolean memorizationPhase = true;
    private int memorizationTime = 420; // 7 seconds (7 * 60 FPS)
    private ArrayList<String> wordsToMemorize;
    private PlayerInput playerInput;
    private ArrayList<String> wordPool;  // Larger pool of words to choose from
    //
    // High score map
    private static Map<String, Integer> highScores = new HashMap<>();
    private int correctAnswers = 0;
    

    public LevelTwo() {    
        super(600, 400, 1);         
    
        MusicManager.stopMusic();
        setBackground(new GreenfootImage("map2bg.png"));

        //public vpo
        wordPool = new ArrayList<>(Arrays.asList("tomato", "cucumber", "carrot", "egg", "flour", "milk", "love", "sugar"));
        Collections.shuffle(wordPool);  // Shuffle the word pool  
        wordsToMemorize = new ArrayList<>(wordPool.subList(0, 5));
    
        TextBox textBox = new TextBox(wordsToMemorize.get(0));
        TextBox textBoxTwo = new TextBox(wordsToMemorize.get(1));
        TextBox textBoxThree = new TextBox(wordsToMemorize.get(2)); 
        TextBox textBoxFour = new TextBox(wordsToMemorize.get(3)); 
        TextBox textBoxFive = new TextBox(wordsToMemorize.get(4)); 
        
        addObject(textBox, 104, 165);
        addObject(textBoxTwo, 307, 165);
        addObject(textBoxThree, 503, 165);
        addObject(textBoxFour, 210, 310);
        addObject(textBoxFive, 410, 310);
      
        playerInput = new PlayerInput(wordsToMemorize, this);
        addObject(playerInput, 300, 350);
    
        showWords(wordsToMemorize);  // Display the words to memorize
    }
    
    public void act()
    {
        if (memorizationPhase)
        {
            // Timer to hide the words after the memorization time
            if (memorizationTime > 0)
            {
                memorizationTime--;
                int secondsRemaining = memorizationTime / 60;
                showText("Time remaining: " + secondsRemaining + "s", 300, 50);
            }
            else
            {
                memorizationPhase = false;
                clearWords();
                startInputPhase();
            }
            
        }
    }
    
    private void showWords(ArrayList<String> words)
    {
        TextBox textBox = (TextBox)getObjects(TextBox.class).get(0);
        TextBox textBoxTwo = (TextBox)getObjects(TextBox.class).get(1);
        TextBox textBoxThree = (TextBox)getObjects(TextBox.class).get(2);
        
        textBox.showText(words.get(0)); 
        textBoxTwo.showText(words.get(1));
        textBoxThree.showText(words.get(2));
    }
    
    private void clearWords()
    {
        // Clear the text in each TextBox
        TextBox textBox = (TextBox)getObjects(TextBox.class).get(0);
        TextBox textBoxTwo = (TextBox)getObjects(TextBox.class).get(1);
        TextBox textBoxThree = (TextBox)getObjects(TextBox.class).get(2);
        TextBox textBoxFour = (TextBox)getObjects(TextBox.class).get(3);
        TextBox textBoxFive = (TextBox)getObjects(TextBox.class).get(4);
        
        textBox.showText("");  // Clear the text in the first box
        textBoxTwo.showText("");  // Clear the text in the second box
        textBoxThree.showText("");  // Clear the text in the third box
        
        // Clear the timer and other text on the screen
        showText("", 300, 50);  // Clear the timer
    }

    private void startInputPhase() 
    {
        showText("Fill the boxes with the ingredients that you remember\nORDER MATTERS!", 300, 100);
        playerInput.enableInput();
    }
    
}