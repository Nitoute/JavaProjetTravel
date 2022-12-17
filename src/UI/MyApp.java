package UI;

import java.sql.SQLOutput;
import java.util.*;

import domain.*;
import infra.RepositoryInMemory;

public class MyApp {

	public static void main(String[] args) throws Exception {
		Scanner console = new Scanner (System.in);
		/******
		 *
		 *
		 *
		 * Initialisation des vols, de l'agence, des hôtels, etc...
		 *
		 *
		 */
		Destination Paris = new Destination("Paris");
		Destination Bordeaux = new Destination("Bordeaux");
		Destination Canberra = new Destination("Canberra");
		Destination Tokyo = new Destination("Tokyo");
		Destination Delhi = new Destination("Delhi");
		
		Paris.ajouterDestination(Bordeaux);
		Paris.ajouterDestination(Canberra);
		Paris.ajouterDestination(Delhi);
		
		Bordeaux.ajouterDestination(Paris);
		Bordeaux.ajouterDestination(Tokyo);
		Bordeaux.ajouterDestination(Delhi);
		
		Canberra.ajouterDestination(Paris);
		Canberra.ajouterDestination(Tokyo);
		Canberra.ajouterDestination(Delhi);
		
		Tokyo.ajouterDestination(Paris);
		Tokyo.ajouterDestination(Bordeaux);
		Tokyo.ajouterDestination(Canberra);
		
		Delhi.ajouterDestination(Paris);	
		Delhi.ajouterDestination(Bordeaux);
		
		ArrayList<Destination> dests = new ArrayList<Destination>();
		
		dests.add(Paris);
		dests.add(Bordeaux);
		dests.add(Canberra);
		dests.add(Tokyo);
		dests.add(Delhi);

		Agence travelAlgerie = new Agence();
		CompagnieAerienne airAlgerie = new CompagnieAerienne("AirAlgerie");
		travelAlgerie.ajouterCompagnieAerienne(airAlgerie);

		Hotel Meridien = new Hotel("Méridien", 0, Paris);
		AgenceLocationVoiture Sixt = new AgenceLocationVoiture("Sixt", 125, Paris);
		travelAlgerie.ajouterHotel(Meridien);
		travelAlgerie.ajouterVoiture(Sixt);

		Hotel Continental = new Hotel("Continental", 130, Bordeaux);
		AgenceLocationVoiture Europcar = new AgenceLocationVoiture("Europcar", 50, Bordeaux);
		travelAlgerie.ajouterHotel(Continental);
		travelAlgerie.ajouterVoiture(Europcar);


		Hotel CrownePlaza = new Hotel("Crowne Plaza", 150, Canberra);
		AgenceLocationVoiture Hertz = new AgenceLocationVoiture("Hertz", 50, Canberra);
		travelAlgerie.ajouterHotel(CrownePlaza);
		travelAlgerie.ajouterVoiture(Hertz);

		Hotel Ayoama = new Hotel("Ayoama", 42, Tokyo);
		AgenceLocationVoiture RentACar = new AgenceLocationVoiture("Rent-A-Car", 200, Tokyo);
		travelAlgerie.ajouterHotel(Ayoama);
		travelAlgerie.ajouterVoiture(RentACar);

		Hotel TajPalace = new Hotel("Taj Palace", 100, Delhi);
		AgenceLocationVoiture Fabcars = new AgenceLocationVoiture("Fabcars", 150, Delhi);
		travelAlgerie.ajouterHotel(TajPalace);
		travelAlgerie.ajouterVoiture(Fabcars);


		
		Vol parisBordeaux = new Vol(Paris,Bordeaux,new Date("2022/12/31"),130);
		airAlgerie.ajouterVol(parisBordeaux);
		Vol parisCanberra = new Vol(Paris, Canberra, new Date("2022/12/30"), 145);
		airAlgerie.ajouterVol(parisCanberra);
		Vol parisDelhi = new Vol(Paris, Delhi, new Date("2023/01/05"), 170);
		airAlgerie.ajouterVol(parisDelhi);

		Vol bordeauxParis = new Vol(Bordeaux, Paris, new Date("2023/01/18"), 85);
		airAlgerie.ajouterVol(bordeauxParis);
		Vol bordeauxTokyo = new Vol(Bordeaux,Tokyo,new Date("2023/01/14"),250);
		airAlgerie.ajouterVol(bordeauxTokyo);
		Vol BordeauxDelhi = new Vol(Bordeaux, Delhi, new Date("2023/01/03"), 185);
		airAlgerie.ajouterVol(BordeauxDelhi);

		Vol canberraParis = new Vol(Canberra, Paris, new Date("2022/12/28"), 200);
		airAlgerie.ajouterVol(canberraParis);
		Vol canberraTokyo = new Vol(Canberra, Tokyo, new Date("2023/01/01"), 190);
		airAlgerie.ajouterVol(canberraTokyo);
		Vol canberraDelhi = new Vol(Canberra, Delhi, new Date("2023/01/10"), 140);
		airAlgerie.ajouterVol(canberraDelhi);

		Vol tokyoParis = new Vol(Tokyo, Paris, new Date("2023/01/10"), 200);
		airAlgerie.ajouterVol(tokyoParis);
		Vol tokyoBordeaux = new Vol(Tokyo, Bordeaux, new Date("2023/01/05"), 150);
		airAlgerie.ajouterVol(tokyoBordeaux);
		Vol tokyoCanberra = new Vol(Tokyo, Canberra, new Date("2023/01/03"), 220);
		airAlgerie.ajouterVol(tokyoCanberra);

		Vol delhiParis = new Vol(Delhi, Paris, new Date("2023/01/10"), 120);
		airAlgerie.ajouterVol(delhiParis);
		Vol delhiBordeaux = new Vol(Delhi,Bordeaux,new Date("2023/01/13"),100);
		airAlgerie.ajouterVol(delhiBordeaux);




		
		Repository repo = new RepositoryInMemory();

		/*****
		 *
		 *
		 *
		 * Début du programme principal
		 *
		 *
		 */

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
				System.out.println("Destination disponibles :");
				for (Destination i:dests){System.out.print(i.getLieu() + " ");}
				System.out.println("D'ou partez vous ?");
				String depart= console.nextLine();
				
				System.out.println("Ou allez vous ?");
				String arrive= console.nextLine();
				
				Destination desDepart = travelAlgerie.getDestinationFromString(depart);
				Destination desAr = travelAlgerie.getDestinationFromString(arrive);

				if(desDepart == null){
					System.out.println("Erreur, " + depart + " n'est pas une destination valable");
					continue;
				}
				if(desAr == null){
					System.out.println("Erreur, " + arrive + " n'est pas une destination valable");
					continue;
				}
				
				ArrayList<Destination> planDeVol = travelAlgerie.trouverDestination(desAr,desDepart);
				if(planDeVol == null){
					System.out.println("Il n'existe malheuresement aucun trajet possible vers cette destination à cette date");
					continue;
				}
				
				ArrayList<Vol> listVol = travelAlgerie.getVolWithDate(planDeVol, date);
				
				for (Vol v:listVol){
					System.out.println("Vol : de "+ v.getDepart().getLieu() +" à " + v.getDestination().getLieu() + " le " + v.getDate());
				}

				//System.out.println("Le vol est bon ?" + travelAlgerie.verifierListeVol(listVol, desDepart, desAr));
				if(listVol.size() == 0 || (travelAlgerie.verifierListeVol(listVol, desDepart, desAr)) == false){
					System.out.println("Il n'existe malheuresement aucun vol ou transit possible vers cette destination à cette date");
				}
				else {
					System.out.println("Voulez vous reservez ces vols ?");
					String decision= console.nextLine();
					
					if (decision.toLowerCase().equals("oui")){
						System.out.println("Quel type de service voulez vous ?");
						System.out.println("sans : vol");
						System.out.println("simple : vol + hotel + voiture (un seul lieu)");
						System.out.println("luxe : vol + hotel + voiture (différents lieux)");
						String service= console.nextLine().toLowerCase();
						switch(service){
							case "sans":
								Reservation reservation = new Reservation();
								reservation.setClient(cl);
								reservation.setDate(new Date());
								for (Vol v : listVol){
									System.out.println("Vol : de "+ v.getDepart().getLieu() +" à " + v.getDestination().getLieu() + " le " + v.getDate());
									System.out.println("Vous voulez un ticket premiere (1) classe ou seconde (2) classe ?");
									String classe= console.nextLine();
									TicketAvion currentTicket = travelAlgerie.genererTicket(v, Integer.parseInt(classe));//new TicketAvion(v,Integer.parseInt(classe));
									reservation.rajouterTicket(currentTicket);
									v.retirerPlace();
								}
								repo.save(reservation, cl);
								System.out.println("Cela vous coutera " + travelAlgerie.getPrice(reservation)+"€");
								break;

							case "simple":
								Reservation reservationSimple = new Reservation();
								Service serviceSimple = new ServiceSimple();
								reservationSimple.setClient(cl);
								reservationSimple.setDate(new Date());
								Hotel h = null;
								AgenceLocationVoiture a;
								boolean service_pris = false;
								boolean luxe;
								for (Vol v : listVol){
									System.out.println("Vol : de "+ v.getDepart().getLieu() +" à " + v.getDestination().getLieu() + " le " + v.getDate());
									System.out.println("Vous voulez un ticket premiere (1) classe ou seconde (2) classe ?");
									String classe= console.nextLine();
									TicketAvion currentTicket = travelAlgerie.genererTicket(v, Integer.parseInt(classe));//new TicketAvion(v,Integer.parseInt(classe));
									reservationSimple.rajouterTicket(currentTicket);
									v.retirerPlace();

									if(!service_pris){
										h = travelAlgerie.getHotel(v.getDestination()); //On cherche un hotel pour chaque destination
										if (h != null){
											System.out.println("Vous pouvez réserver une chambre à " + h + ", voulez vous la reserver (vous ne pourrez pas eb reserver d'autres) ?");
											decision = console.nextLine();
											if (decision.toLowerCase().equals("oui")) {
												System.out.println("Voulez vous les prestations luxueuses ?");
												classe = console.nextLine();
												if (classe.toLowerCase().equals("oui")) {
													luxe = true;
												} else {
													luxe = false;
												}
												reservationSimple.addHotel(h, luxe);
												service_pris=true;
											}
										}
										else{
											System.out.println("Il n'y a malheureusement pas d'hôtels disponible affilié à l'agence à " + v.getDestination());
										}
										a = travelAlgerie.getVoiture(v.getDestination());
										if(a != null){
											System.out.println("Voulez vous louez une voiture à l'agence" + a +" ?");
											decision = console.nextLine();
											if (decision.toLowerCase().equals("oui")) {
												reservationSimple.addAgenceLocation(a);
											}
											service_pris=true;
										}
										else{
											System.out.println("Il n'y a malheureusement pas d'agence de location affilié à l'agence disponible à " + v.getDestination());
										}
									}
								}
								System.out.println("Cela vous coutera " + travelAlgerie.getPrice(reservationSimple)+"€");
								repo.save(reservationSimple, cl);
								break;

							case "luxe":
								System.out.println("cc");
								Reservation reservationLuxe = new Reservation();
								ServiceLuxe s = new ServiceLuxe();
								for (Vol v : listVol){
									System.out.println("Vol : de "+ v.getDepart().getLieu() +" à " + v.getDestination().getLieu() + " le " + v.getDate());
									System.out.println("Vous voulez un ticket premiere (1) classe ou seconde (2) classe ?");
									String classe= console.nextLine();
									TicketAvion currentTicket = travelAlgerie.genererTicket(v, Integer.parseInt(classe));
									reservationLuxe.rajouterTicket(currentTicket);
									v.retirerPlace();
									h = travelAlgerie.getHotel(v.getDestination()); //On cherche un hotel pour chaque destination
									if (h != null){
										System.out.println("Vous pouvez réserver une chambre à " + h + ", voulez vous les prestations luxueuses ?");
										classe = console.nextLine();
										if(classe.toLowerCase().equals("oui")){
											luxe = true;
										}
										else{
											luxe = false;
										}
										reservationLuxe.addHotel(h, luxe);
									}
									else{
										System.out.println("Il n'y a malheureusement pas d'hôtels disponible affilié à l'agence à " + v.getDestination());
									}
									a = travelAlgerie.getVoiture(v.getDestination());
									if(a != null){
										System.out.println("Voulez vous louez une voiture à l'agence" + a +" ?");
										decision = console.nextLine();
										if (decision.toLowerCase().equals("oui")) {
											reservationLuxe.addAgenceLocation(a);
										}
									}
									else{
										System.out.println("Il n'y a malheureusement pas d'agence de location affilié à l'agence disponible à " + v.getDestination());
									}
								}
								System.out.println("Cela vous coutera " + travelAlgerie.getPrice(reservationLuxe) +"€");
								repo.save(reservationLuxe, cl);
								break;

						}
					}
				}
			}
		}
	}
}

