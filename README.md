
# Group Members
- Ryan Ho 
- Scarlett Ho 
- Nicholas Chau

# Data Structures used and summary of its purpose.

[List]

1. We used the `List` data structure to create a `WordList`/`Word pool`, the list of words is in a TXT file and it can be seen in use throughout Levels One, Two, and Three. It includes an array list and is divided to correspond to the three levels which have different ingredients. Using `List` is important in creating more organized and efficient code since the words are stored in one file and are made accessible to other worlds. The different levels will be listed in the following: 
- Level 1: Kitchen
- Level 2: Pirate ship
- Level 3: Spaceship

[Map]

2. The `Hashmap` data structure was used to create a tracker that tracks the levels the player has cleared so far. The code can be found in the `HighscoreScreen` world, and the purpose of the `HighscoreScreen` is to show players the number of times a level is cleared in that specific level. 
- When there are no levels cleared it will display a "No high scores" text
- When a certain level is cleared, it will display (e.g. Level 1: 2 clears)

# Additional information (Features)
1. Music Manager 
- The `MusicManager` is a separate class that manages all in-game music
- it uses methods like `.playLoop` or `.setVolume`
2. Randomized textbox colors
- Every time a level is constructed, the textbox colors are randomized
- this segment of code uses a `.getRandomNumber` method
3. Count down timer
- Within `LevelOne`, `LevelTwo`, and `LevelThree` a memorizationPhase is present to set up a `memorizationTime`. A countdown timer is displayed for the player.
4. Buttons
- This object is used mostly before and after the game's content (after a level is finished).
- Button plays a sound effect when selected
- Button increases in size when hovered over
- `public Button (Runnable action, String imageName, String hoveringName)`
5. Scrolling background
- For the background image of `LevelSelect`, `ProceedWorld`, `InstructionScreen`and `InstructionWorld`. A scrolling background is used.
6. Interfaces
- Levels 1, 2, and 3 implement `loadable`, `showable`, `clearable`, and `startable`
7. Level clear conditions
- More than half correct = A clear
- Less than half correct = A fail




# Set up Greenfoot for VSCode

[Mac]
1. Open `Finder` and navigate to the Applications folder.
2. Right-click on the Greenfoot app and select `Show Package Contents`.
3. In the opened folder, go to `Contents -> Resources -> Java` and find the `greenfoot.jar` file.
4. Copy this `greenfoot.jar` to the `/lib` Folder in this project.

[Windows]
1. Open `File Explorer` and navigate to `C:\Program Files\Greenfoot` and locate the `greenfoot.jar` file.
2. Copy this `greenfoot.jar` to the `\lib` Folder in this project.

<br>
<br>
# project.greenfoot
Copy the `project.greenfoot.md` file and rename it to `project.greenfoot`
# Learn Markdown Basics
[Markdown basics](https://www.markdownguide.org/getting-started/)
