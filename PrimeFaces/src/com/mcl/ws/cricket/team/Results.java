package com.mcl.ws.cricket.team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"TeamProfile"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Results {
	
	@JsonProperty("TeamProfile")
	private Team team;
	@JsonProperty("TeamProfile")
	public Team getTeam() {
		return team;
	}
	@JsonProperty("TeamProfile")
	public void setTeam(Team team) {
		this.team = team;
	}	

}
