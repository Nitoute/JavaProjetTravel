package domain;

public interface Repository {
	Reservation findReservationByUser (Client cl) throws Exception;
	void save(Reservation r,Client cl);
}
