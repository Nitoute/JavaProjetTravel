package domain;

public class AgenceLocationVoiture {
	private String nom;
	private int nbrVoiture;

	private Destination lieu;
	
	public AgenceLocationVoiture(String nom, int initVoiture, Destination lieu){
		this.nom = nom;
		this.nbrVoiture = initVoiture;
		this.lieu = lieu;
	}

	public Destination getLieu() {
		return this.lieu;
	}

	public boolean voitureDisponible(){
		if(this.nbrVoiture > 0){
			return true;
		}
		return false;
	}

	public void reserverVoiture(){
		if(this.nbrVoiture > 0){
			nbrVoiture --;
		}
	}

	public String toString(){
		return nom;
	}
}
