import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class TextBox extends Actor
{
    private GreenfootImage textBoxImgOne;
    private GreenfootImage textBoxImgTwo;
    private GreenfootImage textBoxImgThree;
    
    private GreenfootImage normalImage; 
    private GreenfootImage hoverImage;
    
    private String typedText = "";
    private boolean isTyping = false;
    
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
        
        hoverImage = new GreenfootImage(normalImage); // Create hover image based on normal image
        hoverImage.scale((int)(hoverImage.getWidth() + 20), (int)(hoverImage.getHeight() + 10));
        
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
    
    public void act()
    {
        if (Greenfoot.mouseMoved(this)) {
            setImage(hoverImage); // Set hover image when mouse is over
        } else if (Greenfoot.mouseMoved(null)) {
            setImage(normalImage); // Revert to normal image when mouse moves away
        }
        
        if(Greenfoot.mouseClicked(this))
        {
            isTyping = true;
        }
        
        if(isTyping)
        {
            handleTyping();
        }
    }
    
    private void handleTyping()
    {
        String key = Greenfoot.getKey();
        if(key != null)
        {
            if(key.equals("enter"))
            {
                isTyping = false;
            } else if(key.equals("backspace") && typedText.length() > 0) {
                typedText = typedText.substring(0, typedText.length() - 1);  // Remove last character
            } else if (key.length() == 1) {
                typedText += key;  // Add character to typed text
            }
            
            updateTextDisplay(); 
        }
    }
    private void updateTextDisplay() {
        // Create a new image to display the text over the text box
        GreenfootImage textImage = new GreenfootImage(normalImage);  // Copy original image
        GreenfootImage textOverlay = new GreenfootImage(typedText, 20, Color.BLACK, new Color(0, 0, 0, 0));

        // Draw the text overlay on the image, centered
        int x = (textImage.getWidth() - textOverlay.getWidth()) / 2;
        int y = (textImage.getHeight() - textOverlay.getHeight()) / 2;
        textImage.drawImage(textOverlay, x, y);

        setImage(textImage);  // Update the image of the TextBox
    }
}
