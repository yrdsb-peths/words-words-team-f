import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;

public class LevelThree extends World implements Loadable, Showable, Clearable, Startable
{
    private boolean gameStarted = false;
    private boolean memorizationPhase = true;
    private int memorizationTime = 1200; // 20 seconds (20 * 60 FPS)
    
    private ArrayList<String> wordsToMemorize;
    private PlayerInput playerInput;
    private List<String> wordPool;  // Larger pool of words to choose from
    //
    // High score map
    
    private int correctAnswers = 0;
    
    
    public LevelThree() {    
        super(600, 400, 1);         
    
        MusicManager.stopBgMusic();
        MusicManager.restartLevelThreeMus();
       
        
        setBackground(new GreenfootImage("map3bg.png"));
    
        //public vpo
        wordPool = new ArrayList<>(); 
        loadWordsFromFile("levelThreeList.txt");
        
        Collections.shuffle(wordPool);  // Shuffle the word pool  
        wordsToMemorize = new ArrayList<>(wordPool.subList(0, 7));
    
        TextBox textBox = new TextBox(wordsToMemorize.get(0), 85, 150);
        TextBox textBoxTwo = new TextBox(wordsToMemorize.get(1), 85, 150);
        TextBox textBoxThree = new TextBox(wordsToMemorize.get(2), 85, 150); 
        TextBox textBoxFour = new TextBox(wordsToMemorize.get(3), 85, 150); 
        TextBox textBoxFive = new TextBox(wordsToMemorize.get(4), 85, 150);
        TextBox textBoxSix = new TextBox(wordsToMemorize.get(5), 85, 150);
        TextBox textBoxSeven = new TextBox(wordsToMemorize.get(6), 85, 150);
        
        addObject(textBox, 45, 221);
        addObject(textBoxTwo, 134, 221);
        addObject(textBoxThree, 223, 221);
        addObject(textBoxFour, 309, 221);
        addObject(textBoxFive, 391, 221);
        addObject(textBoxSix, 476, 221);
        addObject(textBoxSeven, 562 , 221);
        
        playerInput = new PlayerInput("Level 3", wordsToMemorize, this);
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
        for (int i = 0; i < words.size(); i++)
        {
            TextBox textBox = (TextBox) getObjects(TextBox.class).get(i);
            textBox.showText(words.get(i));
        }
    }
    
    public void clearWords()
    {
        for (int i = 0; i < getObjects(TextBox.class).size(); i++)
        {
            TextBox textBox = (TextBox) getObjects(TextBox.class).get(i);
            textBox.showText("");
        }
        
        // Clear the timer and other text on the screen
        showText("", 300, 50);  // Clear the timer
    }
    
    public void startInputPhase() 
    {
        showText("Fill the boxes with the ingredients that you remember\nORDER MATTERS!", 300, 100);
        playerInput.enableInput();
    }

}