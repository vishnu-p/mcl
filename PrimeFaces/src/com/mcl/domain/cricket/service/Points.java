package com.mcl.domain.cricket.service;

public interface Points {
	
	// BATTING POINTS
	
	static final float BATTING_BASE_POINTS = 1;
	static final float BATTING_MILESTONE_BONUS_POINTS = 10;
	static final int BATTING_MILESTONE_SCORE = 25;
	static final float BATTING_SIX_IMPACT_POINTS = 2;
	static final float BATTING_DUCK_IMPACT_POINTS = -5;
	
	// BOWLING POINTS
	
	static final float BOWLING_BASE_POINTS = 20;
	static final float BOWLING_ECONOMY_POINTS_MULTIPLIER = 1.5F;
	static final float BOWLING_MILESTONE_BONUS_POINTS = 10;
	static final float BOWLING_DOT_BALL_POINTS = 1;
	static final float BOWLING_MAIDEN_OVER_POINTS = 20;
	
	// FIELDING POINTS
	
	static final float FIELDING_CATCH_POINTS = 10;
	static final float FIELDING_STUMPING_POINTS = 15;
	static final float FIELDING_RUNOUT_POINTS = 10;
	static final float FIELDING_RUNOUT_DIRECT_HIT_POINTS = 15;
	
	// BONUS POINTS
	
	static final float BONUS_PLAYER_OF_THE_MATCH_POINTS = 25;
	static final float BONUS_LEAGUE_WINNING_PLAYER_POINTS = 5;
	static final float BONUS_PLAYOFF_WINNING_PLAYER_POINTS = 10;
	
	// OTHER POINTS
	
	static final float POWER_PLAYER_POINTS_MULTIPLIER = 2;	

}
