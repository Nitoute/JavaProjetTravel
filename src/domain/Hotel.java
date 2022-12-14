package domain;

public class Hotel {
	String nom;
	int nbrChambre;
	String adresse;
	
	public Hotel(String nom, int nbrPlaceInit, String adresse){
		this.nom = nom;
		this.nbrChambre = nbrPlaceInit;
		this.adresse = adresse;
	}
}
