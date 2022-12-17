package domain;

import java.util.ArrayList;

public class ServiceLuxe extends Service{

	private ArrayList<Hotel> hotels;
	private ArrayList<AgenceLocationVoiture> voitures;

	private int nbHotelLuxes;
	
	public ServiceLuxe(){
		this.hotels = new ArrayList<Hotel>();
		this.voitures = new ArrayList<AgenceLocationVoiture>();
		this.nbHotelLuxes = 0;
	}

	public void addHotel(Hotel h, boolean luxe){

		this.hotels.add(h);
		if(luxe){
			nbHotelLuxes++;
		}
	}

	public void addVoiture(AgenceLocationVoiture a){
		this.voitures.add(a);
	}

	public ArrayList<Hotel> getHotels(){
		return this.hotels;
	}

	public ArrayList<AgenceLocationVoiture> getVoitures() {
		return this.voitures;
	}

	@Override
	public int getPrice() {

		System.out.println("Nb luxe : " + nbHotelLuxes);
		return 32;
	}
	
}
