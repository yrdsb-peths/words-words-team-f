import greenfoot.*;
import java.util.ArrayList;
import java.util.Arrays;
public class PlayerInput extends Actor {
    private String userInput = "";
    private ArrayList<String> words;
    private ArrayList<String> possibleKeys;
    private int timeRemaining; // Time in frames to memorize
    private boolean isMemorizing = true;
    private boolean wordsShown = false;
    
    public PlayerInput(int timeRemaining, ArrayList<String> words) {
        this.timeRemaining = timeRemaining;
        this.words = words;
        setImage((GreenfootImage)null);
    }

    public void act() {
        if (!wordsShown && getWorld() != null) {
            showWords();
            wordsShown = true;
        }
        if (isMemorizing) {
            updateTimer();
        } else {
            handleUserTyping();
        }
    }

    private void showWords() {
        StringBuilder displayText = new StringBuilder("Memorize these words:\n");
        for (String word : words) {
            displayText.append(word).append(" ");
        }
        getWorld().showText(displayText.toString(), 300, 200);
    }

    private void updateTimer() {
        if (timeRemaining > 0) {
            timeRemaining--;  // Countdown
            int secondsRemaining = timeRemaining / 60;
            getWorld().showText("Time to memorize: " + secondsRemaining + "s", 300, 50);  // Show remaining time
        } else {
            isMemorizing = false;
            getWorld().showText("", 300, 50); // Clear the timer
            getWorld().showText("", 300, 200); // Clear the words
        }
    }

    private void handleUserTyping() {
        possibleKeys = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "space"));
        for (String key : possibleKeys) {
            if (Greenfoot.isKeyDown(key)) {
                if (key.equals("space")) {
                    userInput += " ";
                } else {
                    userInput += key;
                }
                Greenfoot.delay(5);
            }
        }
        if (Greenfoot.isKeyDown("backspace") && userInput.length() > 0) {
            userInput = userInput.substring(0, userInput.length() - 1);
            Greenfoot.delay(5);
        }
        if (Greenfoot.isKeyDown("enter")) {
            userInput = "";
            Greenfoot.delay(5);
        }
        getWorld().showText("Typed: " + userInput, 300, 350);
    }
}