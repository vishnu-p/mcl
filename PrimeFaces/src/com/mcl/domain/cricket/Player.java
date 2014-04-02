package com.mcl.domain.cricket;

public class Player {
	
	private int playerId;
	private String playerName;
	private Role role;
	private String team;
	private Type type;
	private double price;
	private float points;
	private String country;	
	
	public Player() {
		// TODO Auto-generated constructor stub
	}
	
	public Player(int playerId, String playerName, Role role, String team,
			Type type, double price, float points, String country) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.role = role;
		this.team = team;
		this.type = type;
		this.price = price;
		this.points = points;
		this.country = country;
	}
	
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public float getPoints() {
		return points;
	}
	public void setPoints(float points) {
		this.points = points;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}
