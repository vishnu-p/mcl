package com.mcl.domain.cricket.data;

import java.util.ArrayList;  
import java.util.List;  

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.DragDropEvent;
import org.primefaces.event.TransferEvent;

import com.mcl.domain.cricket.Player;
import com.mcl.domain.cricket.Role;
import com.mcl.domain.cricket.Type;
   
public class ListData {  
  
	private final static String[] team;  
	private final static String[] country;
	
	static {  
        team = new String[10];  
        team[0] = "Black";  
        team[1] = "White";  
        team[2] = "Green";  
        team[3] = "Red";  
        team[4] = "Blue";  
        team[5] = "Orange";  
        team[6] = "Silver";  
        team[7] = "Yellow";  
        team[8] = "Brown";  
        team[9] = "Maroon";  
  
        country = new String[10];  
        country[0] = "Mercedes";  
        country[1] = "BMW";  
        country[2] = "Volvo";  
        country[3] = "Audi";  
        country[4] = "Renault";  
        country[5] = "Opel";  
        country[6] = "Volkswagen";  
        country[7] = "Chrysler";  
        country[8] = "Ferrari";  
        country[9] = "Ford";  
    }    
  
    private List<Player> allPlayers;  
    
    private List<Player> droppedPlayers;    
    
    public ListData() {         
    	allPlayers = new ArrayList<Player>();
    	droppedPlayers = new ArrayList<Player>();    	
        populateRandomPlayers(allPlayers, 9);  
    }  
    
    public static String[] getTeam() {
		return team;
	}

	public static String[] getCountry() {
		return country;
	}

	public void setAllPlayers(List<Player> allPlayers) {
		this.allPlayers = allPlayers;
	}

	public void setDroppedPlayers(List<Player> droppedPlayers) {
		this.droppedPlayers = droppedPlayers;
	}	
    
    private void populateRandomPlayers(List<Player> list, int size) {
    	System.out.println("Working");
        for(int i = 0 ; i < size ; i++) { 
            list.add(new Player(i,"Player"+i,getRandomRole(),getRandomTeam(),getRandomType(),getRandomPrice(),getRandomPoints(),getRandomCountry()));
            System.out.println(list.get(i).getPlayerName());
        }
    }   
  
    public List<Player> getAllPlayers() {
		return allPlayers;
	}

	public List<Player> getDroppedPlayers() {
		return droppedPlayers;
	}

	private Role getRandomRole() {
		
		return Role.ALLROUNDER;
	}
	
	private Type getRandomType() {
		
		return Type.NORMAL;
    } 
  
    private String getRandomTeam() {  
        return team[(int) (Math.random() * 10)];  
    }  
  
    private String getRandomCountry() {  
        return country[(int) (Math.random() * 10)];  
    }  
  
    private double getRandomPrice() {  
        return (double) (Math.random() * 10000);  
    }  
    
    private float getRandomPoints() {  
        return (float) (Math.random() * 100);  
    }  
  
    public void onPlayerDrop(DragDropEvent ddEvent) {  
        Player player = ((Player) ddEvent.getData());  
        droppedPlayers.add(player);  
        allPlayers.remove(player);  
    }  
    
    public void onTransfer(TransferEvent event) {  
        StringBuilder builder = new StringBuilder();  
        for(Object item : event.getItems()) {  
            builder.append(((Player)item).getPlayerName()).append("<br />");  
        }  
          
        FacesMessage msg = new FacesMessage();  
        msg.setSeverity(FacesMessage.SEVERITY_INFO);  
        msg.setSummary("Items Transferred");  
        msg.setDetail(builder.toString());  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
  
   
}  