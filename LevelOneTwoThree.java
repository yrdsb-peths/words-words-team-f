import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelOneTwoThree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelOneTwoThree extends Actor
{
    private GreenfootImage levelOne;
    private GreenfootImage levelTwo;
    private GreenfootImage levelThree;
    private boolean imageSet = false; // To ensure the image is only set once

    public LevelOneTwoThree() {
        levelOne = new GreenfootImage("LevelOne.png");
        levelOne.scale(levelOne.getWidth() / 3, levelOne.getHeight() / 3);

        levelTwo = new GreenfootImage("LevelTwo.png");
        levelTwo.scale(levelTwo.getWidth() / 3, levelTwo.getHeight() / 3);

        levelThree = new GreenfootImage("LevelThree.png");
        levelThree.scale(levelThree.getWidth() / 3, levelThree.getHeight() / 3);
    }

    public void act() {
        if (!imageSet && getWorld() != null) {
            String worldName = getWorld().getClass().getSimpleName();
            if ("LevelOne".equals(worldName)) 
            {
                setImage(levelOne);
            } else if ("LevelTwo".equals(worldName)) 
            {
                setImage(levelTwo);
            } else if ("LevelThree".equals(worldName)) 
            {
                setImage(levelThree);
            }
            imageSet = true; // Prevents changing the image repeatedly
        }
    }
}