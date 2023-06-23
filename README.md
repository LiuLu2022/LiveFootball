# LiveFootball
The Live Football is a simple Java program that provides functionality to track ongoing football matches, update scores, and generate a summary of matches based on their total score.

Features
--------
Start a new match with an initial score of 0 - 0 and add it to the scoreboard.
Update the score of a match by providing the home team score and the away team score.
Finish a match currently in progress and remove it from the scoreboard.
Generate a summary of ongoing matches ordered by their total score. Matches with the same total score are ordered by the most recently started match.

Usage
--------
The Scoreboard class can be used to interact with the Live Football World Cup Scoreboard. Here's an example of how to use the library:

Scoreboard scoreboard = new Scoreboard();

// Start a new match

scoreboard.startMatch("Mexico", "Canada");

// Update the score of a match

scoreboard.updateScore("Mexico", "Canada", 0, 5);

// Finish a match

scoreboard.finishMatch("Mexico", "Canada");

// Get a summary of ongoing matches

List<Match> summary = scoreboard.getSummary();

// Print the summary

  int rank = 1;
  for (Match match : summary) {
    System.out.println(rank + ". " + match);
    rank++;
}

  The output will display the summary of ongoing matches in the desired order based on their total score.

Testing
-----------------
  
The project includes unit tests for the Scoreboard class. These tests ensure the proper functioning of the library and can be found in the ScoreboardTest class. You can run the tests using a testing framework like JUnit.

Contributing
  -------------------
  
Contributions to the Live Football World Cup Scoreboard Library are welcome! If you have any ideas, bug reports, or feature requests, please open an issue or submit a pull request on the project's GitHub repository.

License
  -------------
  
The Live Football World Cup Scoreboard Library is open-source and available under the MIT License. You are free to use, modify, and distribute the library in accordance with the terms of the license.

Credits
  -----------
The Live Football World Cup Scoreboard Library was developed by Lu Liu.
