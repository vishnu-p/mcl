package com.mcl.ws.cricket.team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({	
	"query"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Home {
	
	@JsonProperty("query")
	private Query query;

	@JsonProperty("query")
	public Query getQuery() {
		return query;
	}
	@JsonProperty("query")
	public void setQuery(Query query) {
		this.query = query;
	}	

}
