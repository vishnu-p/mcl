package com.mcl.ws.cricket.team.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({	
	"CountryCode"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class PlaceOfBirth {
	
	@JsonProperty("CountryCode")
	private String countryCode;

	@JsonProperty("CountryCode")
	public String getCountryCode() {
		return countryCode;
	}
	@JsonProperty("CountryCode")
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
