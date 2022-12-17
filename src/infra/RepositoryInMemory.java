package infra;

import java.util.HashMap;

import domain.Repository;
import domain.Reservation;
import domain.Client;

public class RepositoryInMemory implements Repository{
	HashMap<Client,Reservation> mem;
	
	public RepositoryInMemory(){
		mem = new HashMap<Client,Reservation>();
	}

	@Override
	public Reservation findReservationByUser(Client id) throws Exception {
		if (mem.containsKey(id)){
			return mem.get(id);
		}else{
			throw new Exception("id not found please try another one");
		}
	}

	@Override
	public void save(Reservation r, Client id) {
		if (mem.containsKey(id)){
			mem.replace(id, r);
		}else{
			mem.put(id, r);
		}
	}
}
