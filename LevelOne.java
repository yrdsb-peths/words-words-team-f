import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; 

public class LevelOne extends World
{
    private boolean gameStarted = false;
    private ArrayList<String> ingredients = new ArrayList<String>();
    private String[] userAnswers = new String[3]; 
    private int currentAnswerIndex = 0; 

    public LevelOne()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        super(600, 400, 1);         
        showText("this is level one", 300,200);
        //setImage(image);
        //setWords
        ingredients.add("tomato");
        ingredients.add("cucumber");
        ingredients.add("carrot");
        
        setBackground(new GreenfootImage("map1bg.png")); 
        
        PlayerInput playerInput = new PlayerInput(); 
        addObject(playerInput, 300, 200); 
        
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
    }
    private void showWords()
    {
        showText("[" + ingredients.get(0) + "] [" + ingredients.get(1) + "] [" + ingredients.get(2) + "]", 300,200);
    }
}
