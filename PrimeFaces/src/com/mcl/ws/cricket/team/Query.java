package com.mcl.ws.cricket.team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"count",
	"created",
	"lang",
	"results"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Query {
	
	@JsonProperty("count")
	private int count;
	@JsonProperty("created")
	private String created;
	@JsonProperty("lang")
	private String lang;
	@JsonProperty("results")
	private Results results;
	
	@JsonProperty("count")
	public int getCount() {
		return count;
	}
	@JsonProperty("count")
	public void setCount(int count) {
		this.count = count;
	}
	@JsonProperty("created")
	public String getCreated() {
		return created;
	}
	@JsonProperty("created")
	public void setCreated(String created) {
		this.created = created;
	}
	@JsonProperty("lang")
	public String getLang() {
		return lang;
	}
	@JsonProperty("lang")
	public void setLang(String lang) {
		this.lang = lang;
	}
	@JsonProperty("results")
	public Results getResults() {
		return results;
	}
	@JsonProperty("results")
	public void setResults(Results results) {
		this.results = results;
	}
	
}
