package domain;

import java.util.*;

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
		
		Vol parisBordeaux = new Vol(Paris,Bordeaux,new Date("2022/12/31"),1);
		Vol bordeauxTokyo = new Vol(Bordeaux,Tokyo,new Date("2023/01/12"),1);
		airAlgerie.ajouterVol(parisBordeaux);
		airAlgerie.ajouterVol(bordeauxTokyo);
		
		for (Destination i:travelAlgerie.trouverDestination(Tokyo, Delhi)){
			System.out.println("Finito : " + i.getLieu());
		}
		
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
				
				Destination desDepart = null;
				Destination desAr = null;
				
				for (Destination dep:dests){
					if (dep.lieu.equals(depart)){
						desDepart = dep;
						for (Destination ar:dests){
							if (ar.lieu.equals(arrive)){
								desAr = ar;
							}
						}
					}
				}
				
				if (desDepart!=null && desAr!=null){
					ArrayList<Vol> volPerso = new ArrayList<Vol>();
					
					for(int i=0; i<travelAlgerie.trouverDestination(Tokyo, Delhi).size();i++){
						for (CompagnieAerienne ar:travelAlgerie.compagnieAerienne){
							for (Vol v : ar.listeVol){
								if (v.depart.equals(travelAlgerie.trouverDestination(Tokyo, Delhi).get(i))){
									if(v.destination.equals(travelAlgerie.trouverDestination(Tokyo, Delhi).get(i+1))){
										volPerso.add(v);
									}
								}
							}
						}
					}
					for (Vol v:volPerso){
						System.out.println(v.depart.getLieu());
						System.out.println(v.destination.getLieu());
					}
				}
			}
		}
	}
}
