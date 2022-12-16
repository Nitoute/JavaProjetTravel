package domain;

import java.util.concurrent.atomic.AtomicInteger;

public class Client {
	private static final AtomicInteger ID_CLIENT = new AtomicInteger();
	int id;
	String nom;
	public Client(String nom){
		this.nom = nom;
		id = ID_CLIENT.getAndIncrement();
	}
	
	public int getId(){
		return this.id;
	}
}
