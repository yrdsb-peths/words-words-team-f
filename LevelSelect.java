import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelSelect extends World
{

    /**
     * Constructor for objects of class LevelSelect.
     * 
     */
    public LevelSelect()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        //add scrolling inifnite bg 
        
        //add buttons for the level select.
        addObject(new Button(this::goLevelOne, "levelOneButton.png"), getWidth()/2, getHeight()/2);
        
    }
    
     
    public void goLevelOne()
    {
        Greenfoot.setWorld(new LevelOne());
    }
    
    
}
