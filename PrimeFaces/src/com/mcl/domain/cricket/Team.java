package com.mcl.domain.cricket;

import java.util.List;

public class Team {
	
	private int userId;
	private String teamName;
	private double teamBudget;
	private float points;
	private Player powerPlayer;
	private List<Player> players;
	
	public Team() {		
		this.teamBudget = Cricket.BUDGET;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public double getTeamBudget() {
		return teamBudget;
	}
	public void setTeamBudget(double teamBudget) {
		this.teamBudget = teamBudget;
	}
	public float getPoints() {
		return points;
	}
	public void setPoints(float points) {
		this.points = points;
	}
	public Player getPowerPlayer() {
		return powerPlayer;
	}
	public void setPowerPlayer(Player powerPlayer) {
		this.powerPlayer = powerPlayer;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
}
