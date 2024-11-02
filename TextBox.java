import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class TextBox extends Actor
{
    private GreenfootImage textBoxImgOne;
    private GreenfootImage textBoxImgTwo;
    private GreenfootImage textBoxImgThree;
    
    private GreenfootImage normalImage; 
    
    private String word;
    public TextBox(String words)
    {
        textBoxImgOne = new GreenfootImage("textBoxOne.png"); 
        textBoxImgTwo = new GreenfootImage("textBoxTwo.png");
        textBoxImgThree = new GreenfootImage("textBoxThree.png");
        
        word = words;
        
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
       
    }
    
    public void showText(String text)
    {
        GreenfootImage img = new GreenfootImage(normalImage); 
        GreenfootImage textImage = new GreenfootImage(text, 20, Color.BLACK, new Color(0, 0, 0, 0));
        
        int x = (img.getWidth() - textImage.getWidth()) / 2;
        int y = (img.getHeight() - textImage.getHeight()) / 2;
        
        img.drawImage(textImage, x, y); 
        setImage(img);
    }
}