package domain;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		Agence travelAlgerie = new Agence();
		CompagnieAerienne airAlgerie = new CompagnieAerienne("AirAlgerie");
		travelAlgerie.ajouterCompagnieAerienne(airAlgerie);
		
		Vol parisBordeaux = new Vol(Paris,Bordeaux,1);
		Vol bordeauxTokyo = new Vol(Bordeaux,Tokyo,1);
		airAlgerie.ajouterVol(parisBordeaux);
		airAlgerie.ajouterVol(bordeauxTokyo);
		
		for (Destination i:travelAlgerie.trouverDestination(Tokyo, Delhi)){
			System.out.println("Finito : " + i.getLieu());
		}
		
	}

}
