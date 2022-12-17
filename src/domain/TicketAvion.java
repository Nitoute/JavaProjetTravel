package domain;

public class TicketAvion {
	Vol vol;
	int classe;

	boolean prixreduit;
	public TicketAvion(Vol vol, int classe, boolean prixreduit){
		this.vol = vol;
		this.classe = classe;
		this.prixreduit = prixreduit;
	}

	public boolean prixReduit(){
		return prixreduit;
	}

	public int getClasse() {
		return classe;
	}
}
