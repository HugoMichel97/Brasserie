package soprajc.Brasserie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.Brasserie.exception.ReservationException;
import soprajc.Brasserie.model.Client;
import soprajc.Brasserie.model.Evenement;
import soprajc.Brasserie.model.Reservation;
import soprajc.Brasserie.model.StatutResa;
import soprajc.Brasserie.repositories.ReservationRepository;
@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private EvenementService evtService;
	
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
		//modification du nb de places dans evt concerné en fonction du nb de participants et du statut = validé
		if(r.getStatut().equals(StatutResa.validee)) {
			Evenement evt = r.getEvt();
			evt.setNbPlaces(evt.getNbPlaces() - r.getNbParticipants());
			evtService.save(evt);
		}
		reservationRepository.save(r);
	}
	public List<Reservation> getAll() {
		return reservationRepository.findAll();
	}
	
	public List<Reservation> getByClient(Client c){
		return reservationRepository.findByClient(c);
	}
	
	public List<Reservation> getByEvt(Evenement evt){
		return reservationRepository.findByEvt(evt);
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
		reservationRepository.delete(reservationEnBase);
	}
	
	public void deleteById(Integer id) {
		reservationRepository.deleteById(id);
	}
	
	public void deleteByClient(Client c) {
		reservationRepository.deleteByClient(c);
	}
	
	public void deleteByEvt(Evenement evt) {
		reservationRepository.deleteByEvt(evt);
	}
	
	public Reservation save(Reservation reservation) {
        if (reservation.getId() != null) {
            Reservation resaEnBase = getById(reservation.getId());
            reservation.setVersion(resaEnBase.getVersion());
        }
        return reservationRepository.save(reservation);
    }

}
