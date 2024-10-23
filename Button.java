import greenfoot.*;


public class Button extends Actor {
    private Runnable action;


    public Button(Runnable action, String imageName) {
        this.action = action;


        //Load the button image
        GreenfootImage buttonImage = new GreenfootImage(imageName);


        // Set combined image as the actor's image
        setImage(buttonImage);
    }

    //check if user clicked on (this) obeject. 
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (action != null) {
                action.run();
            }
        }
    }
}
