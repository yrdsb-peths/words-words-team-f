import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;


public class MusicManager  
{
    public static GreenfootSound bgMusic = new GreenfootSound("Pokemon ORAS Soundtrack - Flight to Space (128kbps).mp3");
    public static GreenfootSound bgPirateMusic = new GreenfootSound("Pirate Encounter - Pokémon Clover Soundtrack (128kbps).mp3");
    public static GreenfootSound bgLevelOne = new GreenfootSound("[YT2mp3.info] - Overcooked - Main Menu SONG (320kbps).mp3"); 
    
    public static void playKitchenMus()
    {
        if(!bgLevelOne.isPlaying())
        {
            bgLevelOne.playLoop();
            bgLevelOne.setVolume(40); 
        }
    }
    
    public static void stopKitchenMus()
    {
        if(bgLevelOne.isPlaying())
        {
            bgLevelOne.pause(); 
        }
    }
    
    public static void pauseKitchenMus()
    {
        if(bgLevelOne.isPlaying())
        {
            bgLevelOne.pause(); 
        }
    }
    
    
    public static void playPirateMus()
    {
        if(!bgPirateMusic.isPlaying())
        {
            bgPirateMusic.playLoop();
            bgPirateMusic.setVolume(40);
        }
    }
    
    
    public static void stopPirateMus()
    {
        if(bgPirateMusic.isPlaying())
        {
            bgPirateMusic.pause();
        }
    }
    
    public static void pausePirateMus()
    {
        if(bgPirateMusic.isPlaying())
        {
            bgPirateMusic.pause();
        }
    }
    
    
    public static void playBgMusic()
    {
        if(!bgMusic.isPlaying())
        {
            bgMusic.playLoop();
            bgMusic.setVolume(40);
        }
    }
    
    public static void stopBgMusic()
    {
        if(bgMusic.isPlaying())
        {
            bgMusic.pause(); 
        }
    }
    
    public static void pauseBgMusic()
    {
        if(bgMusic.isPlaying())
        {
            bgMusic.pause(); 
        }
    }
}
