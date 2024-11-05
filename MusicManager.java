import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;


public class MusicManager  
{
    public static GreenfootSound bgMusic = new GreenfootSound("pokemonspacemusic.mp3");
    public static GreenfootSound bgPirateMusic = new GreenfootSound("piratepokemon.mp3");
    public static GreenfootSound bgLevelOne = new GreenfootSound("overcookmusic.mp3"); 
    public static GreenfootSound bgLevelThree = new GreenfootSound("rainbowRoadMusic.mp3");
    
    
    //methods for level 3 music
    public static void playLevelThreeMus()
    {
        if(!bgLevelThree.isPlaying())
        {
            bgLevelThree.playLoop();
            bgLevelThree.setVolume(40); 
        }
    }
    
    public static void stopLevelThreeMus()
    {
        if(bgLevelThree.isPlaying())
        {
            bgLevelThree.pause(); 
        }
    }
    
    public static void pauseLevelThreeMus()
    {
        if(bgLevelThree.isPlaying())
        {
            bgLevelThree.pause(); 
        }
    }
    
    
    public static void restartLevelThreeMus()
    {
        bgLevelThree.stop();
        bgLevelThree.playLoop();
        bgLevelThree.setVolume(40);
    }
    
    
    
    
    //methods for level 1 music
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
    
    
    public static void restartKitchenMus()
    {
        bgLevelOne.stop();
        bgLevelOne.playLoop();
        bgLevelOne.setVolume(40);
    }
    
    
    //methods for level 2 music
    
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
    
    
    public static void restartPirateMus()
    {
        bgPirateMusic.stop();
        bgPirateMusic.playLoop();
        bgPirateMusic.setVolume(40);
    }
    
    
    //methods for menu bg music
    
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
    
    public static void restartBgMusic()
    {
        bgMusic.stop();
        bgMusic.playLoop();
        bgMusic.setVolume(40);
    }
    
}
