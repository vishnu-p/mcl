package com.mcl.ws.cricket.team.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({	
	"personid",
	"PersonalDetails",
	"Role",
	"Style",
	"playerteam"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Player {
	
	@JsonProperty("personid")
	private int playerId;
	@JsonProperty("PersonalDetails")
	private PersonalDetails personalDetails;
	@JsonProperty("Role")
	private String role;
	@JsonProperty("Style")
	private Style style;
	@JsonProperty("playerteam")
	private String playerTeam;
	
	@JsonProperty("personid")
	public int getPlayerId() {
		return playerId;
	}
	@JsonProperty("personid")
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	@JsonProperty("PersonalDetails")
	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}
	@JsonProperty("PersonalDetails")
	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}
	@JsonProperty("Role")
	public String getRole() {
		return role;
	}
	@JsonProperty("Role")
	public void setRole(String role) {
		this.role = role;
	}
	@JsonProperty("Style")
	public Style getStyle() {
		return style;
	}
	@JsonProperty("Style")
	public void setStyle(Style style) {
		this.style = style;
	}
	@JsonProperty("playerteam")
	public String getPlayerTeam() {
		return playerTeam;
	}
	@JsonProperty("playerteam")
	public void setPlayerTeam(String playerTeam) {
		this.playerTeam = playerTeam;
	}
	
	
}
