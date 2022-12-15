package domain;

import java.util.ArrayList;

public class CompagnieAerienne {
	String nomCompagnie;
	ArrayList<Vol> listeVol;
	
	public CompagnieAerienne(String nomC){
		listeVol = new ArrayList<Vol>();
		this.nomCompagnie = nomC;
	}
	
	void ajouterVol(Vol v){
		listeVol.add(v);
	}
	
	boolean destinationExiste(Destination dest){
		for(int i = 0; i< listeVol.size(); i++){
			if(listeVol.get(i).getDestination().equals(dest)){
				return true;
			}
		}
		return false;
	}
	
	ArrayList<Vol> getListeVol(){
		return listeVol;
	}
}