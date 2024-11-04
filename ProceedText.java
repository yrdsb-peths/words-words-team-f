import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ProceedText extends Actor
{
    private GreenfootImage proceedText;
    
    public ProceedText()
    {
        proceedText = new GreenfootImage("proceedFrom.png");
        proceedText.scale(proceedText.getWidth()*2, proceedText.getHeight()*2); 
        setImage(proceedText); 
    }

    
   
    public void act()
    {
        // Add your action code here.
    }
}