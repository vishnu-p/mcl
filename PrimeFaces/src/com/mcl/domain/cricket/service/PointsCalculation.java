package com.mcl.domain.cricket.service;

public class PointsCalculation implements Points {
	
	float points;
	public float battingPoints(int runs, int ballsFaced, int sixes, boolean isBatted) {
		points = 0.0F;
		if(isBatted) {
			if(runs == 0) {
				points = Points.BATTING_DUCK_IMPACT_POINTS;
			} else {
				points = runs + (runs - ballsFaced) + 
						(Points.BATTING_MILESTONE_BONUS_POINTS * (runs % Points.BATTING_MILESTONE_SCORE)) + 
						(Points.BATTING_SIX_IMPACT_POINTS * sixes); 
			}			
		}
		return points;
	}
	
	public float bowlingPoints(int wickets, int ballsBowled, int runsConceded, int maidenOvers, int dotBalls) {
		points = 0.0F;
		float economyRate = ((ballsBowled * Points.BOWLING_ECONOMY_POINTS_MULTIPLIER) - runsConceded);
		if(economyRate > 0) {
			economyRate *= 2;
		}
		float milestonePoints = 0.0F;
		if(wickets > 1) {
			milestonePoints = (Points.BOWLING_MILESTONE_BONUS_POINTS * wickets);
		}
		points = (wickets * Points.BOWLING_BASE_POINTS) + 
				economyRate + milestonePoints + 
				(dotBalls * Points.BOWLING_DOT_BALL_POINTS) + 
				(maidenOvers * Points.BOWLING_MAIDEN_OVER_POINTS);
		return points;
	}
	
	public float fieldingPoints(int catches, int stumpings, int runOuts, int directHits) {
		points = 0.0F;
		points = (catches * Points.FIELDING_CATCH_POINTS) + 
				(stumpings * Points.FIELDING_STUMPING_POINTS) + 
				(runOuts * Points.FIELDING_RUNOUT_POINTS) + 
				(directHits * Points.FIELDING_RUNOUT_DIRECT_HIT_POINTS);
		return points;
	}
	
	public float bonusPoints(boolean playerOfTheMatch, String matchType) {
		points = 0.0F;
		if(playerOfTheMatch) {
			points += Points.BONUS_PLAYER_OF_THE_MATCH_POINTS;			
		}
		if(matchType.equals("League")) {
			points += Points.BONUS_LEAGUE_WINNING_PLAYER_POINTS;
		} else if(matchType.equals("Playoffs")) {
			points += Points.BONUS_PLAYOFF_WINNING_PLAYER_POINTS;
		}
		return points;
	}

}
