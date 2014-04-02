package com.mcl.domain;

public class Player {
	
	private String name;
	private int number;
	private String image;
	private String team;
	
	public Player(String name, int number, String image, String team) {
		super();
		this.name = name;
		this.number = number;
		this.image = image;
		this.team = team;
	}
	
	public Player(String name, int number, String image) {
		super();
		this.name = name;
		this.number = number;
		this.image = image;
	}
	
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}	

}
