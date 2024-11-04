import greenfoot.*;
import greenfoot.GreenfootImage;

public class ProceedWorld extends World
{
    private GreenfootImage background;
    
    public ProceedWorld()
    {
        super(600,400,1);
        background = new GreenfootImage("cyabStripeBg.png");
        
        scroll x = 0;
    }
    
    public void act()
    {
        
    }
    private void nextLevel()
    {
        //buttons
        //addObject(new Button(this:: goLevelSelect, "LevelOneButton.png", "LevelOneButton.png"), getWidth()/2, getHeight()/2);
    }
    private void goLevelSelect()
    {
        Greenfoot.setWorld(new LevelSelect());
    }

    private void backMenu()
    {
        //addObject(new Button(this:: goBackMenu, "LevelOneButton.png", "LevelOneButton.png"), getWidth(), getHeight());
    }
    private void goBackMenu()
    {
        Greenfoot.setWorld(new MenuScreen());
    }
    
    private void replay()
    {
        //addObject(new Button(this:: goReplay, "LevelOneButton.png", "LevelOneButton.png"), getWidth(), getHeight());
    }
    private void goReplay()
    {
        Greenfoot.setWorld(new LevelOne());
    }
}
