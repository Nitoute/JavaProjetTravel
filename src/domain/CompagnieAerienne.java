package domain;

import java.util.ArrayList;

public class CompagnieAerienne {
	String nomCompagnie;
	ArrayList<Vol> listeVol;
	
	public CompagnieAerienne(String nomC){
		listeVol = new ArrayList<Vol>();
		this.nomCompagnie = nomC;
	}
	
	public void ajouterVol(Vol v){
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
	
	Destination getDestinationFromString(String dest){
		for (Vol v:listeVol){
			if (v.getDepart().getLieu().equals(dest)){
				return v.getDepart();
			}
			if (v.getDestination().getLieu().equals(dest)){
				return v.getDestination();
			}
		}
		return null;
	}
}