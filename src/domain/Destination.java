package domain;

import java.util.ArrayList;

public class Destination {
	
	ArrayList<Destination> destinationPossible;
	String lieu;
	
	public Destination(String lieu){
		destinationPossible = new ArrayList<Destination>();
		this.lieu = lieu;
	}
	
	public void ajouterDestination (Destination n){
		destinationPossible.add(n);
	}
	
	public void retirerDestination (Destination n){
		if (destinationPossible.contains(n)){
			destinationPossible.remove(n);
		}
	}
	
	public ArrayList<Destination> getDestinationPossible(){
		return this.destinationPossible;
	}
	
	public String getLieu(){
		return this.lieu;
	}
	
}
