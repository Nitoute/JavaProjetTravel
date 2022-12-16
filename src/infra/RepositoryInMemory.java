package infra;

import java.util.HashMap;

import domain.Repository;
import domain.Reservation;

public class RepositoryInMemory implements Repository{
	HashMap<Integer,Reservation> mem;
	
	public RepositoryInMemory(){
		mem = new HashMap<Integer,Reservation>();
	}

	@Override
	public Reservation findReservationByUser(int id) throws Exception {
		if (mem.containsKey(id)){
			return mem.get(id);
		}else{
			throw new Exception("id not found please try another one");
		}
	}

	@Override
	public void save(Reservation r, int id) {
		if (mem.containsKey(id)){
			mem.replace(id, r);
		}else{
			mem.put(id, r);
		}
	}
}
