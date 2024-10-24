import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerInput here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerInput extends Actor
{
    private String inputText = ""; 
    private GreenfootImage displayImage; 
    
    public PlayerInput()
    {
        displayImage = new GreenfootImage(200, 50); 
        updateDisplay(); 
        
    }
    
    private void updateDisplay()
    {
        displayImage.clear();
        
        displayImage.setFont(new Font("Arial", 24));
        displayImage.setColor(Color.BLACK);
        
        displayImage.drawString(inputText, 10, 30);
        
        setImage(displayImage);
    }
    
    
    public void act()
    {
        String key = Greenfoot.getKey(); 
        
        if(key != null)
        {
            if(key.equals("backspace") && inputText.length() > 0) 
            {
                inputText = inputText.substring(0, inputText.length() - 1);
            }
            else if (key.length() == 1)
            {
                inputText += key;
            }
            
            updateDisplay(); 
        }
    }
}
