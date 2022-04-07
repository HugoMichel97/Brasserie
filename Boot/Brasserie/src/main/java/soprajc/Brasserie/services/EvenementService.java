package soprajc.Brasserie.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListenerMethodProcessor;
import org.springframework.stereotype.Service;

import soprajc.Brasserie.exception.ClientException;
import soprajc.Brasserie.exception.EvenementException;
import soprajc.Brasserie.model.Client;
import soprajc.Brasserie.model.Evenement;
import soprajc.Brasserie.repositories.EvenementRepository;

@Service
public class EvenementService {
	@Autowired
	private EvenementRepository evenementRepository;
	@Autowired
	private ReservationService resaService;


	public void create(Evenement e) {
		evenementRepository.save(e);
	}

	public void update(Evenement e) {
		evenementRepository.save(e);
	}

	public List<Evenement> getAll() {
		return evenementRepository.findAll();
	}

	public List<Evenement> getAllWithResa() {
		return evenementRepository.findAllWithReservation();
	}

	public List<Evenement> getAllByFidelite(int fidelite) {
		return evenementRepository.findAllByFidelite(fidelite);
	}

	public List<Evenement> getAllByDate(LocalDate date) {
		return evenementRepository.findAllByDate(date);
	}

	public Evenement getById(Integer id) {
		return evenementRepository.findById(id).orElseThrow(()-> {throw new EvenementException("Numero inconnu");});
	}

	public Evenement getByIdWithReservation(Integer id) {
		return evenementRepository.findByIdWithReservations(id).orElseThrow(() -> {
			throw new EvenementException("Id inconnu.");
		});
	}

	public void delete(Evenement e) {
		Evenement evtEnBase = getById(e.getId());
		resaService.deleteByEvt(evtEnBase);
		evenementRepository.delete(evtEnBase);
	}

	public void deleteById(Integer id) {
		Evenement evt = getById(id);
		delete(evt);
	}

	public Evenement save(Evenement evenement) {
		if (evenement.getId() != null) {
			Evenement evtEnBase = getById(evenement.getId());
			evenement.setVersion(evtEnBase.getVersion());
		}
		return evenementRepository.save(evenement);
	}

}

