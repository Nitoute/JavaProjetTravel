package domain;

public interface Repository {
	Reservation findReservationByUser (int id) throws Exception;
	void save(Reservation r,int id);
}
