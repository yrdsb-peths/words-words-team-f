import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TimerTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CountdownTimer extends Actor
{
    SimpleTimer timer = new SimpleTimer();
    private int countdownTime;
    private int remainingTime;
    public CountdownTimer(int seconds)
    {    
        countdownTime = seconds * 1000;
        remainingTime = countdownTime;
        timer.mark();
        updateTimer();
    }
    public void act()
    {
        if(timer.millisElapsed() >= 1000)
        {
            remainingTime -= 1000;
            timer.mark();
        }
        
        updateTimer();
    }
    private void updateTimer()
    {
        int secondsLeft = remainingTime / 1000;
        setImage(new GreenfootImage("Time: " + secondsLeft, 30, Color.BLACK, Color.WHITE));
    }
}
