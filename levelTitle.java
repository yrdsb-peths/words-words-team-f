import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelTitle extends Actor
{
    private GreenfootImage levelTitleText;
    
    public LevelTitle()
    {
        levelTitleText = new GreenfootImage("Each-level-has-a-unique-map-10-23-2024.png");
        levelTitleText.scale(levelTitleText.getWidth()/3, levelTitleText.getHeight()/3); 
        setImage(levelTitleText); 
    }

    
   
    public void act()
    {
        // Add your action code here.
    }
}
