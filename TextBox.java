import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextBox extends Actor
{
    private GreenfootImage textBoxImgOne;
    private GreenfootImage textBoxImgTwo;
    private GreenfootImage textBoxImgThree;
    
    private GreenfootImage normalImage; 
    private GreenfootImage hoverImage;
    
    public TextBox()
    {
        textBoxImgOne = new GreenfootImage("textBoxOne.png"); 
        textBoxImgTwo = new GreenfootImage("textBoxTwo.png");
        textBoxImgThree = new GreenfootImage("textBoxThree.png");
        
        setRandomImage(); 
        
    }
    
    private void setRandomImage()
    {
        int random = Greenfoot.getRandomNumber(3);
        
        if(random == 0)
        {
            normalImage = textBoxImgOne;
        }
        else if(random == 1)
        {
            normalImage = textBoxImgTwo;
        }
        else
        {
            normalImage = textBoxImgThree;
        }
        
        setImage(normalImage); 
        
        hoverImage = new GreenfootImage(normalImage); 
        hoverImage.scale((int)(hoverImage.getWidth() + 20), (int)(hoverImage.getHeight() + 10));
    }
    
    public void act()
    {
        if (Greenfoot.mouseMoved(this)) 
        {
            setImage(hoverImage); // Set hover image when mouse is over the button
        } 
        else if (Greenfoot.mouseMoved(null)) 
        {
            setImage(normalImage); // Set normal image when mouse is not over the button
        }
    }
}
