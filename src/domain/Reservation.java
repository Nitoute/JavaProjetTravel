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
	private Service serv;
	
	public Reservation(){
		id = ID_RESERVATION.getAndIncrement();
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
	
	public void setService(Service s){
		this.serv = s;
	}
}
