package domain;

import java.util.Date;

public class Vol {
	int numeroVol;
	Destination depart;
	Destination destination;
	//Date date;
	int nbrPlace;
	
	public Vol(Destination depart, Destination destination/*, Date date*/, int nbrPlaceInit){
		this.depart = depart;
		this.destination = destination;
		//this.date = date;
		this.nbrPlace = nbrPlaceInit;
	}
	
	public Destination getDestination(){
		return this.destination;
	}

}
