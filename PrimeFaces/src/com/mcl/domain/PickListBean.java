package com.mcl.domain;

import java.util.ArrayList;  
import java.util.List;  
import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext;  
import org.primefaces.event.TransferEvent;  
  
import com.mcl.domain.Player;  
import org.primefaces.model.DualListModel;  
  
public class PickListBean {  
  
    private DualListModel<Player> players;  
      
    private DualListModel<String> cities;  
  
    public PickListBean() {  
        //Players  
        List<Player> source = new ArrayList<Player>();  
        List<Player> target = new ArrayList<Player>();  
          
        source.add(new Player("Messi", 10, "messi.jpg"));  
        source.add(new Player("Iniesta", 8, "iniesta.jpg"));  
        source.add(new Player("Villa", 7, "villa.jpg"));  
        source.add(new Player("Alves", 2, "alves.jpg"));  
        source.add(new Player("Xavi", 6, "xavi.jpg"));  
        source.add(new Player("Puyol", 5, "puyol.jpg"));      
          
        players = new DualListModel<Player>(source, target);  
          
        //Cities  
        List<String> citiesSource = new ArrayList<String>();  
        List<String> citiesTarget = new ArrayList<String>();  
          
        citiesSource.add("Istanbul");  
        citiesSource.add("Ankara");  
        citiesSource.add("Izmir");  
        citiesSource.add("Antalya");  
        citiesSource.add("Bursa");  
          
        cities = new DualListModel<String>(citiesSource, citiesTarget);  
    }  
      
    public DualListModel<Player> getPlayers() {  
        return players;  
    }  
    public void setPlayers(DualListModel<Player> players) {  
        this.players = players;  
    }  
      
    public DualListModel<String> getCities() {  
        return cities;    
}  
    public void setCities(DualListModel<String> cities) {  
        this.cities = cities;  
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
}  