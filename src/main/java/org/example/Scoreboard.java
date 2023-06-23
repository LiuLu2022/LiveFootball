package org.example;

import java.util.*;

public class Scoreboard {
    private List<Match> matches;

    public Scoreboard() {
        this.matches = new ArrayList<>();
    }

    //Start a new match
    public void startMatch(String homeTeam, String awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        matches.add(match);
    }

    /*
    Update score. This should receive a pair of absolute scores: home team score and away
    team score
     */
    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        for (Match match : matches) {
            if (match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam)) {
                match.updateScore(homeScore, awayScore);
                break;
            }
        }
    }

    /*
     * Finish match currently in progress. This removes a match from the scoreboard.
     */
    public void finishMatch(String homeTeam, String awayTeam) {
        Match matchToRemove = null;
        for (Match match : matches) {
            if (match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam)) {
                matchToRemove = match;
                break;
            }
        }
        if (matchToRemove != null) {
            matches.remove(matchToRemove);
        }
    }

    /*
     Get a summary of matches in progress ordered by their total score. The matches with the
     same total score will be returned ordered by the most recently started match in the
     scoreboard
     */
    public List<Match> getSummary() {
        List<Match> sortedMatches = new ArrayList<>(matches);
        sortedMatches.sort(Comparator.comparingInt(Match::getTotalScore).reversed()
                .thenComparing(Comparator.comparingInt(matches::indexOf).reversed()));
        return sortedMatches;
    }
}
