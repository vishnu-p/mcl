package com.mcl.ws.cricket.team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"personid",
	"FirstName",
	"LastName"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Player {
	
	@JsonProperty("personid")
	private int personId;
	@JsonProperty("FirstName")
	private String firstName;
	@JsonProperty("LastName")
	private String lastName;
	
	@JsonProperty("personid")
	public int getPersonId() {
		return personId;
	}
	@JsonProperty("personid")
	public void setPersonId(int personId) {
		this.personId = personId;
	}
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

}
