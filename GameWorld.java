import greenfoot.*;
import java.util.Arrays;
import java.util.List;

public class GameWorld extends World {
    private List<String> words;
    private String[] wordsArray = {"apple", "banana", "cherry", "orange", "grape"};
    private boolean showingWords = true;
    private int timerSet = 200;
    private String userInput = "";
    private boolean isInputEnabled = false;
    private int timeLimit = 200;
    private int timeRemaining = timeLimit;

    public GameWorld() {
        super(600, 400, 1);
        words = Arrays.asList(wordsArray);
        showWordsToMemorize();
    }

    public void act() {
        updateTimer();

        if (showingWords) {
            if (timerSet > 0) {
                timerSet--;
            } else {
                clearScreen();
                showingWords = false;
                isInputEnabled = true;
            }
        } else {
            if (isInputEnabled) {
                handleUserTyping();
            }
        }
    }

    private void showWordsToMemorize() {
        StringBuilder displayText = new StringBuilder("Memorize these words:\n");
        for (String word : words) {
            displayText.append(word).append(" ");
        }
        showText(displayText.toString(), 300, 200);
    }

    private void clearScreen() {
        showText("", 300, 200);
    }

    private void handleUserTyping() {
        String[] possibleKeys = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "space"};
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
        showText("Typed: " + userInput, 300, 350);
    }

    private void updateTimer() {
        if (timeRemaining > 0) {
            timeRemaining--;
        }
    
        int secondsRemaining = timeRemaining / 60;
        showText("Time to memorize: " + secondsRemaining + "s", 300, 50);  // Display remaining time
    }
}