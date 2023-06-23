import org.example.Match;
import org.example.Scoreboard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ScoreboardTest {
    private Scoreboard scoreboard;

    @BeforeEach
    void setUp() {
        scoreboard = new Scoreboard();
    }

    @Test
    void testStartMatch() {
        scoreboard.startMatch("Mexico", "Canada");

        List<Match> matches = scoreboard.getSummary();
        Assertions.assertEquals(1, matches.size());

        Match match = matches.get(0);
        Assertions.assertEquals("Mexico", match.getHomeTeam());
        Assertions.assertEquals("Canada", match.getAwayTeam());
        Assertions.assertEquals(0, match.getTotalScore());
    }

    @Test
    void testUpdateScore() {
        scoreboard.startMatch("Mexico", "Canada");
        scoreboard.updateScore("Mexico", "Canada", 2, 1);

        List<Match> matches = scoreboard.getSummary();
        Assertions.assertEquals(1, matches.size());

        Match match = matches.get(0);
        Assertions.assertEquals(3, match.getTotalScore());
    }

    @Test
    void testFinishMatch() {
        scoreboard.startMatch("Mexico", "Canada");
        scoreboard.finishMatch("Mexico", "Canada");

        List<Match> matches = scoreboard.getSummary();
        Assertions.assertEquals(0, matches.size());
    }

    @Test
    void testGetSummary() {
        scoreboard.startMatch("Mexico", "Canada");
        scoreboard.startMatch("Spain", "Brazil");
        scoreboard.startMatch("Germany", "France");
        scoreboard.updateScore("Mexico", "Canada", 2, 1);
        scoreboard.updateScore("Spain", "Brazil", 3, 3);
        scoreboard.updateScore("Germany", "France", 1, 0);

        List<Match> matches = scoreboard.getSummary();
        Assertions.assertEquals(3, matches.size());

        Assertions.assertEquals("Spain 3 - Brazil 3", matches.get(0).toString());
        Assertions.assertEquals("Mexico 2 - Canada 1", matches.get(1).toString());
        Assertions.assertEquals("Germany 1 - France 0", matches.get(2).toString());
    }
}
