package com.mcl.ws.cricket.team;

import java.util.List;

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
	private List<Team> team;
	@JsonProperty("TeamProfile")
	public List<Team> getTeam() {
		return team;
	}
	@JsonProperty("TeamProfile")
	public void setTeam(List<Team> team) {
		this.team = team;
	}

}
