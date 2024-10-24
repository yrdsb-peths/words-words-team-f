import greenfoot.*;
import java.util.Arrays;
import java.util.List;

public class GameWorld extends World {
    private List<String> wordsToMemorize;  // List of words
    private String[] wordsArray = {"apple", "banana", "cherry", "orange", "grape"};  // Example words
    private int currentWordIndex = 0;  // Index to track which word is being checked
    private boolean showingWords = true;
    private int timer = 100;  // Countdown timer to show the words
    private String userInput = "";  // To store typed characters
    private boolean isInputEnabled = false;

    public GameWorld() {
        super(600, 400, 1);
        wordsToMemorize = Arrays.asList(wordsArray);  // Convert array to list
        showWordsToMemorize();  // Show the words at the start
    }

    public void act() {
        if (showingWords) {
            if (timer > 0) {
                timer--;  // Countdown to hide the words
            } else {
                clearScreen();  // Hide words after the timer ends
                showingWords = false;  // Stop showing words
                isInputEnabled = true;  // Enable input
            }
        } else {
            if (isInputEnabled) {
                handleUserTyping();  // Capture keyboard input if enabled
            }
        }
    }

    // Display words to memorize
    private void showWordsToMemorize() {
        StringBuilder displayText = new StringBuilder("Memorize these words:\n");
        for (String word : wordsToMemorize) {
            displayText.append(word).append(" ");
        }
        showText(displayText.toString(), 300, 200);  // Show the words in the middle of the screen
    }

    // Clear the screen
    private void clearScreen() {
        showText("", 300, 200);  // Clear the words from the screen
    }

    // Handle the typing input from the player
    private void handleUserTyping() {
        // Loop through possible characters to check if a key is pressed
        String[] possibleKeys = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m","n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "space"};
        for (String key : possibleKeys) {
            if (Greenfoot.isKeyDown(key)) {
                if (key.equals("space")) {
                    userInput += " ";  // Add space if spacebar is pressed
                } else {
                    userInput += key;  // Add the pressed key to the input
                }
                Greenfoot.delay(5);  // Slight delay to prevent rapid input
            }
        }
        if(Greenfoot.isKeyDown("backspace") && userInput.length() > 0)
        {
            userInput = userInput.substring(0, userInput.length() - 1);
            Greenfoot.delay(10);
        }
        // Check if Enter is pressed to submit the input
        if (Greenfoot.isKeyDown("enter")) {
            userInput = "";  // Reset the input after checking
            Greenfoot.delay(10);  // Delay to avoid multiple entries
        }

        // Display the typed text on the screen
        showText("Typed: " + userInput, 300, 350);  // Show typed characters at the bottom
    }
}