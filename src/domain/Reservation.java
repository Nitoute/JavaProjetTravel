package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Reservation {
	private static final AtomicInteger ID_RESERVATION = new AtomicInteger();
	int id;
	Date date;
	ArrayList<Vol> vols = new ArrayList<Vol>();
	Client client;
	
	public Reservation(){
		id = ID_RESERVATION.getAndIncrement();
	}
	
	public void setClient(Client c){
		this.client = c;
	}
	
	public void rajouterVol(Vol v){
		vols.add(v);
	}
}
