package UI;

import java.util.*;

import domain.*;
import infra.RepositoryInMemory;

public class MyApp {

	public static void main(String[] args) throws Exception {
		Scanner console = new Scanner (System.in);
		
		Destination Paris = new Destination("Paris");
		Destination Bordeaux = new Destination("Bordeaux");
		Destination Camberra = new Destination("Camberra");
		Destination Tokyo = new Destination("Tokyo");
		Destination Delhi = new Destination("Delhi");
		
		Paris.ajouterDestination(Bordeaux);
		Paris.ajouterDestination(Camberra);
		Paris.ajouterDestination(Delhi);
		
		Bordeaux.ajouterDestination(Paris);
		Bordeaux.ajouterDestination(Tokyo);
		Bordeaux.ajouterDestination(Delhi);
		
		Camberra.ajouterDestination(Paris);
		Camberra.ajouterDestination(Tokyo);
		Camberra.ajouterDestination(Delhi);
		
		Tokyo.ajouterDestination(Paris);
		Tokyo.ajouterDestination(Bordeaux);
		Tokyo.ajouterDestination(Camberra);
		
		Delhi.ajouterDestination(Paris);	
		Delhi.ajouterDestination(Bordeaux);
		
		ArrayList<Destination> dests = new ArrayList<Destination>();
		
		dests.add(Paris);
		dests.add(Bordeaux);
		dests.add(Camberra);
		dests.add(Tokyo);
		dests.add(Delhi);
		
		Agence travelAlgerie = new Agence();
		CompagnieAerienne airAlgerie = new CompagnieAerienne("AirAlgerie");
		travelAlgerie.ajouterCompagnieAerienne(airAlgerie);
		
		Vol parisBordeaux = new Vol(Paris,Bordeaux,new Date("2022/12/31"),10);
		Vol bordeauxTokyo = new Vol(Bordeaux,Tokyo,new Date("2023/01/14"),11);
		Vol delhiBordeaux = new Vol(Delhi,Bordeaux,new Date("2023/01/13"),5);
		airAlgerie.ajouterVol(delhiBordeaux);
		airAlgerie.ajouterVol(parisBordeaux);
		airAlgerie.ajouterVol(bordeauxTokyo);
		
		Repository repo = new RepositoryInMemory();
		
		boolean quit = false;
		while (quit != true){
			System.out.println("Nom du client ? / quit");
			String nomC = console.nextLine();
			if (nomC.equals("quit")){
				quit=true;
			}else{
				Client cl = new Client(nomC);
				
				System.out.println("Quand souhaitez vous partir ? Commencez par donner l'année puis le mois puis le jour");			
				Date date = new Date(console.nextLine() + "/" + console.nextLine() + "/" +console.nextLine());
				System.out.println(date);
				System.out.println("D'ou partez vous ?");
				String depart= console.nextLine();
				
				System.out.println("Ou allez vous ?");
				String arrive= console.nextLine();
				
				Destination desDepart = travelAlgerie.getDestinationFromString(depart);
				Destination desAr = travelAlgerie.getDestinationFromString(arrive);
				
				ArrayList<Destination> planDeVol = travelAlgerie.trouverDestination(desAr,desDepart);
				
				ArrayList<Vol> listVol = travelAlgerie.getVolWithDate(planDeVol, date);
				
				for (Vol v:listVol){
					System.out.println("Vol : de "+ v.getDepart().getLieu() +" à " + v.getDestination().getLieu() + " le " + v.getDate());
				}
				
				System.out.println("Le vol est bon ?" + travelAlgerie.verifierListeVol(listVol, desDepart, desAr));
				if (travelAlgerie.verifierListeVol(listVol, desDepart, desAr)){
					System.out.println("Voulez vous reservez ces voles ?");
					String decision= console.nextLine();
					
					if (decision.equals("oui")){
						System.out.println("Quel type de service voulez vous ?");
						System.out.println("simple : vol");
						System.out.println("luxe : vol + hotel + voiture");
						String service= console.nextLine();
						switch(service){
							case "simple":
								Reservation simpleReservation = new Reservation();
								simpleReservation.setClient(cl);
								simpleReservation.setDate(new Date());
								for (Vol v : listVol){
									System.out.println("Vol : de "+ v.getDepart().getLieu() +" à " + v.getDestination().getLieu() + " le " + v.getDate());
									System.out.println("Vous voulez un ticket premiere (1) classe ou seconde (2) classe ?");
									String classe= console.nextLine();
									TicketAvion currentTicket = new TicketAvion(v,Integer.parseInt(classe));
									simpleReservation.rajouterTicket(currentTicket);
									repo.save(simpleReservation, cl.getId());
								}
						}
					}
				}
			}
		}
	}
}

