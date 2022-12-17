package domain;

public class Hotel {
	String nom;
	int nbrChambre;
	Destination lieu;
	
	public Hotel(String nom, int nbrPlaceInit, Destination lieu){
		this.nom = nom;
		this.nbrChambre = nbrPlaceInit;
		this.lieu = lieu;
	}

	public void reserverChambre(){
		if(this.nbrChambre >0){
			this.nbrChambre --;
		}
	}

	public Destination getLieu() {
		return this.lieu;
	}

	public boolean chambreDisponible(){
		if(this.nbrChambre >0){
			return true;
		}
		return false;
	}

	public String toString(){
		return this.nom;
	}
}
