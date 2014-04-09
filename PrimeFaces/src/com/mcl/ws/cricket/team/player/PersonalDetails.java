package com.mcl.ws.cricket.team.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({	
	"FirstName",
	"LastName",
	"PlaceOfBirth",
	"PlayerLargeImgName"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class PersonalDetails {
	
	@JsonProperty("FirstName")
	private String firstName;
	@JsonProperty("LastName")
	private String lastName;
	@JsonProperty("PlaceOfBirth")
	private PlaceOfBirth placeOfBirth;
	@JsonProperty("PlayerLargeImgName")
	private String playerImage;
	
	@JsonProperty("FirstName")
	public String getFirstName() {
		return firstName;
	}
	@JsonProperty("FirstName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@JsonProperty("LastName")
	public String getLastName() {
		return lastName;
	}
	@JsonProperty("LastName")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@JsonProperty("PlaceOfBirth")
	public PlaceOfBirth getPlaceOfBirth() {
		return placeOfBirth;
	}
	@JsonProperty("PlaceOfBirth")
	public void setPlaceOfBirth(PlaceOfBirth placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	@JsonProperty("PlayerLargeImgName")
	public String getPlayerImage() {
		return playerImage;
	}
	@JsonProperty("PlayerLargeImgName")
	public void setPlayerImage(String playerImage) {
		this.playerImage = playerImage;
	}

}
