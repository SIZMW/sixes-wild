Sixes Wild
==============

Authors: Team Mimas
* Marco Duran
* Cameron Jones
* Yahel Nachum
* Aditya Nivarthi
* Joey Perez

Purpose:
* This is a course project for a software engineering course (CS 3733) at Worcester Polytechnic Institute.

Description:
* This project consists of a playable game called Sixes Wild Game, and an accompanying Sixes Wild Level Builder.
* The Sixes Wild Game is a tile selection based game. The goal in each level is to create selections of tiles that add to a sum of six (6). Tiles have number values that represent how much they contribute towards a sum of six during a move, as well as a multiplier to increase the move's score.
* The level builder is used to create playable levels with tiles that can be added into the game.

The Game:
* There are four level types:
  * Puzzle: The goal in this level type to score as many points in the number of moves given for that level.
  * Lightning: The goal is to score as many points in the allotted time for the level.
  * Release: There are six tiles, denoted with a '6 T'. These tiles must land in the target tiles, denoted by 'X'. To complete the level, all the target tiles must be filled by a six tile before the number of moves has depleted.
  * Elimination: To complete the level, every square position on the board must be marked, or used in a move, before the number of moves is depleted.
* There are four special moves, in addition to selecting tiles normally:
  * Reset Board: This move shuffles the tiles on the board.
  * Swap Tile: This move allows 2 tiles to be selected which will be swapped.
  * Remove Tile: This move allows a tile to be selected which will be removed.
  * XStacy Move: This move adds 20 seconds in time or 10 moves to the current level.
* To unlock the next level, the game must be completed, in its own specified way. In addition, the score achieved must meet or beat the one star threshold for that level.
* Badges are achievements that can be attained through playing various levels. Some are dependent on reaching a specific score value, some are for achieving a certain star count, and there is a badge for unlocking all the story levels.

The Game Application:
* The game consists of multiple menus.
  * The Story Levels are prebuilt levels that are to be played in succession to unlock the next level.
    * Each level can be selected to view a preview, and if unlocked, is highlighted and can be played.
    * When selected, each preview for a level will show to highest achieved star count for that level.
  * The User Levels are levels that are created in the Level Builder and are also played in succession to unlock the next level.
  * The Badges menu handles previewing all the achieved badged. Badges that are unlocked display their preview in the right panel.
  * The Options menu is where users can log in to create and load profiles, change the visual aesthetics, and read the rules.
  * The Credits menu is where the contributors to the project are listed.
  * The Level View is the display that appears when a level is being played.
    * The left side has the current progress in points and star count achieved.
    * The number of moves remaining, or the amount of time left in Lightning levels, is displayed below the points and stars achieved.
    * The top menu displays the special move buttons and their respective counts for the move remaining of each type.

The Level Builder:
* The level builder is used to create user levels that can be played in the game application. The builder allows all settings in a level to be modified to the user's preference.
  * The left panel allows adjustment of all level attributes, including:
    * Name
    * Move or timer amount
    * Tile frequency percentages (as a decimal from 0.0 to 1.0) for each tile
    * Multiplier frequency percentages (as a decimal from 0.0 to 1.0) for the 2x and 3x multipliers (the 1x is calculated from the other 2)
    * Point thresholds for 1, 2 and 3 star levels
  * For the tile type, selecting the type allows placing of that type of tile on the board. The preview is generated live as tiles are placed.
  * To update the frequencies, pressing 'ENTER' in any frequency field will update the board accordingly.
  * The top menu has options to create a new level, save the current level, open an existing user level to edit, or delete a user level. The level listings are populated as files are deleted or added by the builder.
  * Placing the tiles has an undo/redo feature. Tile placement can be undone using 'CTRL + Z', and redoing placements can be done with 'CTRL + SHIFT + Z'.

User Profile:
* To load your user profile or create one simply enter the name associated to the profile in the options panel.
* If no user profile is loaded or created a default one will be made.
* Aesthetics can be tied to a user profile so that when it is loaded it automatically changes the aesthetic to the user's chosen one.
* User profiles are saved when the game application is exited.

Execution:
* To run the level builder, run the main class called "BuilderMain.java". This will open a window that allows user interaction for the builder.
* To run the game application, run the main class called "GameMain.java". This will open a window that allows user interaction for the game.

Testing:
* All testing is done using the JUnit framework.
* For testing GUI interaction and controller coverage, the Robot class is used simulate events. These events are simulated on the default window size. 
Extra Features:
* XStacy Move:
  * A special move that adds extra moves/time depending on the level type.
* Live Preview:
  * The level builder application automatically shows a live preview of the values given after hitting the enter key.
* User Profiles:
  * Multiples users can have independent profiles to track their personal progress in the game.
* Badges:
  * Achievements that the player has earned due to their performance/progress in the game.
* Aesthetics:
  * The color layout of the puzzles.
* Resizable Window:
  * Objects within the window will resize if the window changes size.
* Copy and Delete Levels:
  * A user can copy a user level to use for a new one or delete a user level if they do not want it anymore.
* Logging Output:
  * File output for debugging purposes.
