package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Reservation {
	private static final AtomicInteger ID_RESERVATION = new AtomicInteger();
	private int id;
	private Date date;
	private ArrayList<TicketAvion> vols = new ArrayList<TicketAvion>();
	private Client client;

	private ArrayList<Hotel> hotels = new ArrayList<Hotel>();

	private ArrayList<Hotel> hotelsLuxe = new ArrayList<Hotel>();

	private ArrayList<AgenceLocationVoiture> aLV = new ArrayList<AgenceLocationVoiture>();
	
	public Reservation(){
		id = ID_RESERVATION.getAndIncrement();
	}

	public ArrayList<Hotel> getHotels() {
		return hotels;
	}

	public ArrayList<Hotel> getHotelsLuxe() {
		return hotelsLuxe;
	}

	public ArrayList<AgenceLocationVoiture> getaLV() {
		return aLV;
	}

	public ArrayList<TicketAvion> getVols() {
		return vols;
	}
	
	public void setClient(Client c){
		this.client = c;
	}
	
	public void rajouterTicket(TicketAvion v){
		vols.add(v);
	}

	public void setDate(Date d){
		this.date = d;
	}

	public void addAgenceLocation(AgenceLocationVoiture v){ this.aLV.add(v);}

	public void addHotel(Hotel h, boolean luxe){
		if(!luxe){
			this.hotels.add(h);}
		else{
			this.hotelsLuxe.add(h);}
		}


}
