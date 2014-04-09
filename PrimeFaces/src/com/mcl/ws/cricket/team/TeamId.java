package com.mcl.ws.cricket.team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"status",
	"content"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class TeamId {
	
	@JsonProperty("status")
	private int status;
	@JsonProperty("content")
	private int content;
	@JsonProperty("status")
	public int getStatus() {
		return status;
	}
	@JsonProperty("status")
	public void setStatus(int status) {
		this.status = status;
	}
	@JsonProperty("content")
	public int getContent() {
		return content;
	}
	@JsonProperty("content")
	public void setContent(int content) {
		this.content = content;
	}

}
