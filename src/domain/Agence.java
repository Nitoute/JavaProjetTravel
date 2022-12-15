package domain;

import java.util.ArrayList;

public class Agence {
	ArrayList<Client> clients;
	ArrayList<Service> service;
	ArrayList<AgenceLocationVoiture> agenceLocationVoiture;
	ArrayList<CompagnieAerienne> compagnieAerienne;
	ArrayList<Hotel> hotel;
			
	public Agence(){
		this.clients = new ArrayList<Client>();
		this.service = new ArrayList<Service>();
		this.agenceLocationVoiture = new ArrayList<AgenceLocationVoiture>();
		this.compagnieAerienne = new ArrayList<CompagnieAerienne>();
		this.hotel = new ArrayList<Hotel>();	
	}
	
	void ajouterClient(Client client){
		clients.add(client);
	}
	
	void ajouterVoyage(Service serv){
		service.add(serv);
	}
	
	void ajouterCompagnieAerienne(CompagnieAerienne c){
		compagnieAerienne.add(c);
	}
	
	ArrayList<Destination> trouverDestination(Destination dest, Destination depart){
		
		for (CompagnieAerienne i:compagnieAerienne){
			if (i.destinationExiste(dest)){
				ArrayList<Destination> planDeVol = new ArrayList<Destination>();
				planDeVol.add(depart);
				planDeVol = trouverTransit(dest, planDeVol);
				if(planDeVol.get(planDeVol.size()-1).equals(dest)){
					return planDeVol;
				}
				else{
					System.out.println("Impossible d'atteindre votre destination");
					return null;
				}
			}
		}
		return null;
	}
	
	ArrayList<Destination> trouverTransit(Destination dest, ArrayList<Destination> planDeVol){
		int size =  planDeVol.size();
		Destination act = planDeVol.get(size - 1);
		ArrayList<Destination> list = act.getDestinationPossible();
		if(list.indexOf(dest) != -1){
			planDeVol.add(list.get(list.indexOf(dest)));
			return planDeVol;
			}
		for(int i =0; i < list.size(); i++ ){
			if(size != 1){
				planDeVol.remove(size-1);}
			planDeVol.add(list.get(i));
			planDeVol = trouverTransit(dest, planDeVol);
			if(planDeVol.contains(dest)){
				return planDeVol;
			}
			else{
				planDeVol.remove(list.get(i));
				return planDeVol;
			}
		}
		return planDeVol;
	}
	
	ArrayList<CompagnieAerienne> getListeCompagnie(){
		return compagnieAerienne;
	}
}
