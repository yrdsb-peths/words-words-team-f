import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;


public class MusicManager  
{
    public static GreenfootSound bgMusic = new GreenfootSound("Pokemon ORAS Soundtrack - Flight to Space (128kbps).mp3");
    
    public static void playMusic()
    {
        if(!bgMusic.isPlaying())
        {
            bgMusic.playLoop();
            bgMusic.setVolume(40);
        }
    }
    
    public static void stopMusic()
    {
        if(bgMusic.isPlaying())
        {
            bgMusic.pause(); 
        }
    }
    
    public static void pauseMusic()
    {
        if(bgMusic.isPlaying())
        {
            bgMusic.pause(); 
        }
    }
}
