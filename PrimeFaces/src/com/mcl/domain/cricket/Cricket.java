package com.mcl.domain.cricket;

import com.mcl.domain.Game;

public class Cricket extends Game {
	
	static final double BUDGET = 10000000;
	static final int MINIMUM_BATSMANS = 4; 
	static final int BOWLERS = 2; 
	static final int MINIMUM_ALL_ROUNDERS = 1; 
	static final int WIKCET_KEEPER = 1;  
	static final int MINIMUM_BOWLERS = 5; // including bowlers + all-rounders
	static final int MINIMUM_OVERSEAS_PLAYERS = 4; 
	static final int MINIMUM_UNCAPPED_PLAYERS = 1; 
	static final int MAXIMUM_PLAYERS_OF_SAME_FRANCHISE = 6; 
	static final int TOTAL_PLAYERS_IN_TEAM = 11; 
	
	public Cricket() {		
		gameName = "Cricket";		
	}
	
}
