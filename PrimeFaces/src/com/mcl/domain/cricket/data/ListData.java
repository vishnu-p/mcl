package com.mcl.domain.cricket.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;  
import java.util.Iterator;
import java.util.List;  

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcl.domain.cricket.Player;
import com.mcl.domain.cricket.Role;
import com.mcl.domain.cricket.Type;
   
public class ListData {  
  
	
	
	private DualListModel<Player> players;	
    
    public ListData() {
    	
    	List<Player> source = new ArrayList<Player>();  
        List<Player> target = new ArrayList<Player>();  
    	
    	try {
    		URL url = new URL("http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20cricket.players%20where%20player_id%3D3676&format=json&diagnostics=true&env=store%3A%2F%2F0TxIGQMQbObzvU4Apia0V0&callback=");
    		//URL url = new URL("http://developer.yahoo.com/yql/console/?q=select * from cricket.players where player_id=2962");
    		
    		
    		
    		/*System.setProperty("http.proxyHost", "arihant-proxy");
    		System.setProperty("http.proxyPort", "80");*/
    		System.setProperty("java.net.useSystemProxies", "true");
    		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    		connection.setRequestMethod("GET");
    		connection.setRequestProperty("Accept", "application/json");
    		
    		connection.connect();
    		
    		if (connection.getResponseCode() != 200) {
    			throw new RuntimeException("Failed : HTTP error code : "
    					+ connection.getResponseCode());
    		}  		
    		
    		ObjectMapper mapper = new ObjectMapper();
    		BufferedReader fileReader = new BufferedReader(
    				new InputStreamReader(connection.getInputStream()));
    		
    		StringBuilder json = new StringBuilder();
    		
    		String output;
    		System.out.println("Output from Server .... \n");
    		while ((output = fileReader.readLine()) != null) {
    			json.append(output);
    			//System.out.println(output);
    		} 
    		
    		//System.out.println(json.toString());
    		
    		/*ObjectMapper mapper = new ObjectMapper();
			BufferedReader fileReader = new BufferedReader(new FileReader(
					"d:\\vishnu\\test.txt"));*/
			
    		String temp;    		
    		
			JsonNode rootNode = mapper.readTree(json.toString());
 
			// read			
			
			JsonNode results = rootNode.path("query").path("results");
			
			JsonNode player = results.path("Player");
			
			int playerId = player.path("personid").asInt();
			
			String playerName = player.path("PersonalDetails").path("FirstName").asText() + player.path("PersonalDetails").path("LastName").asText();
			
			Role role = getRole(player.path("Role").asText());
			
			String team;
					
			/*Iterator<JsonNode> teamloop = player.path("Team").elements();
			while(teamloop.hasNext()) {
				team.append(teamloop.next().asText());
			}*/
			
			Type type = getType(player.path("playerteam").asText());
	
		
			double price = 100000D;
			
			float points = 1000F;
			
			String country = player.path("playerteam").asText();
			
			team = player.path("PersonalDetails").path("PlayerThumbImgName").asText();
			
			for(int i=0;i<5;i++) {
				source.add(new Player(playerId, playerName, role, team.toString(), type, price, points, country));				
			}
			
			players = new DualListModel<Player>(source, target);  			
    			
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}  	  
        
    }    
   
    public DualListModel<Player> getPlayers() {  
        return players;  
    }  
    public void setPlayers(DualListModel<Player> players) {  
        this.players = players;  
    }      
    
	private Role getRole(String role) {
		
		if(role.equals("Batsman")) {
			return Role.BATSMAN;
		}
		
		return Role.ALLROUNDER;
	}
	
	private Type getType(String team) {
		
		if(team.equals("India")) {
			return Type.NORMAL;
		} else {
			return Type.OVERSEAS;
		}
    }
	
	public void onTransfer(TransferEvent event) {  
    	/*  StringBuilder builder = new StringBuilder();  
        for(Object item : event.getItems()) {  
            builder.append(((Player) item).getName()).append("<br />");  
        }            
       FacesMessage msg = new FacesMessage();  
        msg.setSeverity(FacesMessage.SEVERITY_INFO);  
        msg.setSummary("Items Transferred");  
        msg.setDetail(builder.toString());  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  */
    }    
	
	public void onClick() {  
    	/*  StringBuilder builder = new StringBuilder();  
        for(Object item : event.getItems()) {  
            builder.append(((Player) item).getName()).append("<br />");  
        }            
       FacesMessage msg = new FacesMessage();  
        displayPlayers.setSeverity(FacesMessage.SEVERITY_INFO);  
        msg.setSummary("Items Transferred");  
        msg.setDetail(builder.toString());  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  */
    }    
   
}  