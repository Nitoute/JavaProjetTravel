package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Agence {
	ArrayList<Client> clients;
	ArrayList<Service> service;
	ArrayList<AgenceLocationVoiture> agenceLocationVoiture;
	ArrayList<CompagnieAerienne> compagnieAerienne;
	ArrayList<Hotel> hotels;

	HashMap<Vol, Integer> pooltickets;

	public Agence(){
		this.clients = new ArrayList<Client>();
		this.service = new ArrayList<Service>();
		this.agenceLocationVoiture = new ArrayList<AgenceLocationVoiture>();
		this.compagnieAerienne = new ArrayList<CompagnieAerienne>();
		this.hotels = new ArrayList<Hotel>();
		this.pooltickets = new HashMap<Vol, Integer>();
	}
	
	void ajouterClient(Client client){
		clients.add(client);
	}
	
	void ajouterVoyage(Service serv){
		service.add(serv);
	}

	public void ajouterHotel(Hotel h){
		this.hotels.add(h);
	}

	public void ajouterVoiture(AgenceLocationVoiture a){
		this.agenceLocationVoiture.add(a);
	}
	
	public void ajouterCompagnieAerienne(CompagnieAerienne c){
		compagnieAerienne.add(c);
	}
	
	public ArrayList<Destination> trouverDestination(Destination dest, Destination depart){
		
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
	
	public Destination getDestinationFromString(String dest){
		Destination destinationFinal = null;
		for (CompagnieAerienne ca: compagnieAerienne){
			destinationFinal = ca.getDestinationFromString(dest);
		}
		return destinationFinal;
	}
	
	public ArrayList<Vol> getVolWithDate(ArrayList<Destination> listDest, Date date){
		ArrayList<Vol> volFinal = new ArrayList<Vol>();
		for (int i=0; i<listDest.size()-1; i++){
			for (CompagnieAerienne ca:compagnieAerienne){
				for (Vol v : ca.listeVol){
					if(v.getDate().after(date)){
						if(v.getDepart().equals(listDest.get(i))){
							if(v.getDestination().equals(listDest.get(i+1))){
								if(v.getNbrPlace()>0){
									//if (volFinal.get(volFinal.size()-1).getDate().before(v.getDate()))
									volFinal.add(v);
									date = v.getDate();
								}
							}
						}
					}
				}
			}
		}
		return volFinal;
	}
	
	public boolean verifierListeVol(ArrayList<Vol> lstVol, Destination depart, Destination arriver){
		return(lstVol.get(0).getDepart().equals(depart) && lstVol.get(lstVol.size()-1).getDestination().equals(arriver));
	}

	public Hotel getHotel(Destination lieu){
		for(Hotel h: hotels){
			if(h.getLieu().equals(lieu)){
				if(h.chambreDisponible()){
					return h;
				}
			}
		}
		return null;
	}

	public AgenceLocationVoiture getVoiture(Destination lieu){
		for(AgenceLocationVoiture a: agenceLocationVoiture){
			if(a.getLieu().equals(lieu)) {
				if (a.voitureDisponible()) {
					return a;
				}
			}
		}
		return null;
	}
	
	public TicketAvion genererTicket(Vol v,int classe){
		if(pooltickets.containsKey(v)){
			int nb = pooltickets.get(v);
			if(nb >0){
				nb--;
				System.out.println("Vous êtes parmis les 20 premières personnes à prendre ce vol, vous bénificiez d'une réduction de 20%");
				pooltickets.replace(v, nb);
				return new TicketAvion(v, classe, true);
			}
			return new TicketAvion(v, classe, false);
		}
		pooltickets.put(v, 19);
		return new TicketAvion(v,classe, true);
	}

	public int getPrice(Reservation reservation){
		int price = 0;
		for(Hotel h: reservation.getHotels()){
			price += 150;
		}
		for(Hotel h: reservation.getHotelsLuxe()){
			price += 180;
		}
		for(AgenceLocationVoiture a: reservation.getaLV()){
			price += 50;
		}
		for(TicketAvion t : reservation.getVols()){
			price += 200;
			if(!t.prixReduit()){
				price += 50;
			}
			if(t.getClasse() == 1){
				price += 75;
			}
		}
		return price;
	}
	
	ArrayList<CompagnieAerienne> getListeCompagnie(){
		return compagnieAerienne;
	}

}
