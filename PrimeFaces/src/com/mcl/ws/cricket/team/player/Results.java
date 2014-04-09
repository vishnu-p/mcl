package com.mcl.ws.cricket.team.player;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({	
	"Player"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Results {
	
	@JsonProperty("Player")
	private List<Player> player;
	@JsonProperty("Player")
	public List<Player> getPlayer() {
		return player;
	}
	@JsonProperty("Player")
	public void setPlayer(List<Player> player) {
		this.player = player;
	}

}
