package com.mcl.ws.cricket.team.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({	
	"Batting",
	"Bowling"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Style {
	
	@JsonProperty("Batting")
	private String batting;
	@JsonProperty("Bowling")
	private String bowling;
	
	@JsonProperty("Batting")
	public String getBatting() {
		return batting;
	}
	@JsonProperty("Batting")
	public void setBatting(String batting) {
		this.batting = batting;
	}
	@JsonProperty("Bowling")
	public String getBowling() {
		return bowling;
	}
	@JsonProperty("Bowling")
	public void setBowling(String bowling) {
		this.bowling = bowling;
	}

}
