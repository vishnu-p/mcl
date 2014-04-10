package com.mcl.ws.cricket.team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"TeamId",
	"TeamName",
	"ShortName",
	"TeamFlagPath",
	"Players"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Team {
	
	@JsonProperty("TeamId")
	private TeamId teamId;
	@JsonProperty("TeamName")
	private String teamName;
	@JsonProperty("ShortName")
	private String shortName;
	@JsonProperty("TeamFlagPath")
	private String flagPath;
	@JsonProperty("Players")	
	private Players players;
	
	@JsonProperty("TeamId")
	public TeamId getTeamId() {
		return teamId;
	}
	@JsonProperty("TeamId")
	public void setTeamId(TeamId teamId) {
		this.teamId = teamId;
	}
	@JsonProperty("TeamName")
	public String getTeamName() {
		return teamName;
	}
	@JsonProperty("TeamName")
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	@JsonProperty("ShortName")
	public String getShortName() {
		return shortName;
	}
	@JsonProperty("ShortName")
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	@JsonProperty("TeamFlagPath")
	public String getFlagPath() {
		return flagPath;
	}
	@JsonProperty("TeamFlagPath")
	public void setFlagPath(String flagPath) {
		this.flagPath = flagPath;
	}
	@JsonProperty("Players")
	public Players getPlayers() {
		return players;
	}
	@JsonProperty("Players")
	public void setPlayers(Players players) {
		this.players = players;
	}
	
}
