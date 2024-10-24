import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelOne extends World
{
    
    public LevelOne()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
    
        setBackground(new GreenfootImage("map1bg.png")); 
        
        PlayerInput playerInput = new PlayerInput(); 
        addObject(playerInput, 300, 200); 
        
    }
}
