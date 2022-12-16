package domain;

import java.util.Date;

public class Vol {
	private int numeroVol;
	private Destination depart;
	private Destination destination;
	private Date date;
	private int nbrPlace;
	
	public Vol(Destination depart, Destination destination, Date date, int nbrPlaceInit){
		this.depart = depart;
		this.destination = destination;
		this.date = date;
		this.nbrPlace = nbrPlaceInit;
	}
	
	public Destination getDepart(){
		return depart;
	}
	
	public Destination getDestination(){
		return this.destination;
	}
	
	public Date getDate(){
		return this.date;
	} 
	
	public int getNbrPlace(){
		return this.nbrPlace;
	}
	
	public void retirerPlace(){
		this.nbrPlace=this.nbrPlace-1;
	}
	
	public int getNumeroVol(){
		return this.numeroVol;
	}

}
