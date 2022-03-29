package brasserie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brasserie.exception.ReservationException;
import brasserie.model.Reservation;
import brasserie.repositories.ReservationRepository;
@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	
	public void create(Reservation r) {
		if (r.getId() !=null) {
			throw new ReservationException("le numero ne doit pas etre defini");
		}
		reservationRepository.save(r);
	}
	public void update(Reservation r) {
		if (r.getId() == null) {
			throw new ReservationException("le numero doit etre defini");
		}
		reservationRepository.save(r);
	}
	public List<Reservation> getAll() {
		return reservationRepository.findAll();
	}

	public Reservation getById(Integer id) {
		return reservationRepository.findById(id).orElseThrow(() -> {
			throw new ReservationException("l'Id est inconnu");
		});
	}
	
	public Reservation getByNumeroWithClient(Integer numero) {
		return reservationRepository.findByIdWithClient(numero).orElseThrow(() -> {
			throw new ReservationException("l'Id est inconnu");
		});
	}
	public void delete(Reservation r) {
		Reservation reservationEnBase = getById(r.getId());
//		clientRepository.deleteByClient(reservationEnBase);
		reservationRepository.delete(reservationEnBase);
	}
	
	public void deleteById(Integer id) {
		Reservation reservation = new Reservation();
		reservation.setId(id);
		reservationRepository.delete(reservation);
	}
	
	public Reservation save(Reservation reservation) {
        if (reservation.getId() != null) {
            Reservation resaEnBase = getById(reservation.getId());
            reservation.setVersion(resaEnBase.getVersion());
        }
        return reservationRepository.save(reservation);
    }

}
