
# Group Members
- Ryan Ho 
- Scarlett Ho 
- Nicholas Chau

# Data Structures used and summary of its purpose.

[List]
1. We used the `List` data structure to create a `WordList`/`Word pool`, the list of words are in a TXT file and it can be seen in use throughout Level One, Two and Three. It includes an arrayList and is divided to correspond to the three levels which have differnt ingredients. Using `List` is important in creating more organized and efficient code since the words are stored in one class and is made accessible to other worlds. The different levels will be listed in the following: 
- Level 1: Kitchen
- Level 2: Pirate ship
- Level 3: Spaceship

[Map]
2. The `Hashmap` data structure was used to create a tracker that tracks the levels the player has cleared so far. The code can be found in the `HighscoreScreen` world, and the purpose of the `HighscoreScreen` is to show players the amount of times a level is cleared in that speific level. 
- When theres no levels cleared it will display a "No highscores" text
- When a certain level is cleared, it will display (e.g. Level 1: 2 clears)

# Additional information (Features)
1. Music Manager 
- The `MusicManager` is a separate class that manages all in game music
- it uses methods like `.playLoop` or `.setVolume`
2. Randomized textbox colors
- Every time a level is constructed, the textbox colors are randomized
- this segment of code uses a `.getRandomNumber` method
3. Count down timer
- Within `LevelOne`, `LevelTwo` and `LevelThree` a memorizationPhase is present to set up a `memorizationTime`. A countdown timer is displayed for the player.
4. Buttons
- 




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
