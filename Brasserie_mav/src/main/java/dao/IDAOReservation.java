package dao;

import model.Reservation;

public interface IDAOReservation extends IDAO <Reservation, Integer>{
	public void confirmerResa();
	public void annulerResa();
}
