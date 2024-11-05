import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelOneTitle extends Actor {
    public LevelOneTitle() {
        setImage(createScaledImage("LevelOne.png", 1024/3, 228/3));  // Creates and sets the scaled image
    }
    
    private GreenfootImage createScaledImage(String filename, int width, int height) {
        GreenfootImage img = new GreenfootImage("LevelOne.png");
        img.scale(width, height);
        return img;
    }
}