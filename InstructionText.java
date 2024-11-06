import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class InstructionText extends Actor
{
    public InstructionText(String text)
    {
        GreenfootImage textImage = new GreenfootImage(text, 24, Color.BLACK, new Color(0, 0, 0, 0)); // 24 is font size, adjust if needed
        setImage(textImage);
    }
    
}
