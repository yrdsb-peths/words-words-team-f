import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;

public class LevelTwo extends World implements LevelInterface
{
    private boolean gameStarted = false;
    private boolean memorizationPhase = true;
    private int memorizationTime = 600; // 10 seconds (10 * 60 FPS)
    
    private ArrayList<String> wordsToMemorize;
    private PlayerInput playerInput;
    private List<String> wordPool;  // Larger pool of words to choose from
    
    
    // High score map
    
    private int correctAnswers = 0;

    public LevelTwo() {    
        super(600, 400, 1);     
        
        //music stop and start 
        MusicManager.stopBgMusic();
        MusicManager.restartPirateMus(); 
    
        
        setBackground(new GreenfootImage("map2bg.png"));

       
        wordPool = new ArrayList<>();
        loadWordsFromFile("levelTwoList.txt");
        
        Collections.shuffle(wordPool);  // Shuffle the word pool  
        wordsToMemorize = new ArrayList<>(wordPool.subList(0, 5));
    
        TextBox textBox = new TextBox(wordsToMemorize.get(0), 110, 150);
        TextBox textBoxTwo = new TextBox(wordsToMemorize.get(1), 110, 150);
        TextBox textBoxThree = new TextBox(wordsToMemorize.get(2), 110, 150); 
        TextBox textBoxFour = new TextBox(wordsToMemorize.get(3), 110, 150); 
        TextBox textBoxFive = new TextBox(wordsToMemorize.get(4), 110, 150); 
        
        
        addObject(textBox, 104, 221);
        addObject(textBoxTwo, 210, 221);
        addObject(textBoxThree, 307, 221);
        addObject(textBoxFour, 410, 221);
        addObject(textBoxFive, 503, 221);
      
        playerInput = new PlayerInput("Level 2",wordsToMemorize, this);
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
    
    public void loadWordsFromFile(String filename)
    {
        try{
            Scanner scan = new Scanner(new File(filename));
            while(scan.hasNextLine())
            {
                String word = scan.nextLine();
                if(!word.isEmpty())
                {
                    wordPool.add(word); 
                }
            }
            scan.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found: " + filename); 
        }
    }
    
    
    public void showWords(ArrayList<String> words)
    {
        TextBox textBox = (TextBox)getObjects(TextBox.class).get(0);
        TextBox textBoxTwo = (TextBox)getObjects(TextBox.class).get(1);
        TextBox textBoxThree = (TextBox)getObjects(TextBox.class).get(2);
        TextBox textBoxFour = (TextBox)getObjects(TextBox.class).get(3);
        TextBox textBoxFive = (TextBox)getObjects(TextBox.class).get(4);
        
        textBox.showText(words.get(0)); 
        textBoxTwo.showText(words.get(1));
        textBoxThree.showText(words.get(2));
        textBoxFour.showText(words.get(3));
        textBoxFive.showText(words.get(4));
    }

    
    public void clearWords()
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
        textBoxFour.showText("");  // Clear the text in the fourth box
        textBoxFive.showText(""); //Clear the text in the fifth box
        
        // Clear the timer and other text on the screen
        showText("", 300, 50);  // Clear the timer
    }

    public void startInputPhase() 
    {
        showText("Fill the boxes with the ingredients that you remember\nORDER MATTERS!", 300, 100);
        playerInput.enableInput();
    }
    
}