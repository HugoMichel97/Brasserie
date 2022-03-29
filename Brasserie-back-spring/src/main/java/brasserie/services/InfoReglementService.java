package brasserie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brasserie.exception.InfoReglementException;
import brasserie.model.Client;
import brasserie.model.InfoReglement;
import brasserie.repositories.InfoReglementRepository;

@Service
public class InfoReglementService {
	@Autowired
	private  InfoReglementRepository infoReglementRepository ;
	//@Autowired
	//private ReservationRepository reservationRepository;
	
	public void create(InfoReglement ir) {
		if (ir.getId() != null) {
			throw new InfoReglementException("L'id ne doit pas être defini.");
		}
		
		
		infoReglementRepository.save(ir);
	}

	public void update(InfoReglement ir) {
		if (ir.getId() == null) {
			throw new InfoReglementException("L'id doit etre defini.");
		}
		infoReglementRepository.save(ir);
	}

	public List<InfoReglement> getAll() {
		return infoReglementRepository.findAll();
	}

	public InfoReglement getById(Integer id) {
		return infoReglementRepository.findById(id).orElseThrow(() -> {
			throw new InfoReglementException("Id inconnu.");
		});
	}

	public InfoReglement getByIdWithClient(Integer id) {
		return infoReglementRepository.findByIdWithClients(id).orElseThrow(() -> {
			throw new InfoReglementException("Id inconnu.");
		});
	}

	public void delete(InfoReglement ir) {
		InfoReglement infoReglementEnBase = getById(ir.getId());
		//reservationRepository.deleteByClient(clientEnBase);
		infoReglementRepository.delete(infoReglementEnBase);
	}

	public void deleteByClient(Client c) {
		infoReglementRepository.deleteByClient(c);
	}
	public void deleteById(Integer id) {
		InfoReglement infoReglement = new InfoReglement();
		infoReglement.setId(id);
		delete(infoReglement);
	}
	public InfoReglement save(InfoReglement infoReglement) {
        if (infoReglement.getId() != null) {
        	InfoReglement infoReglementEnBase = getById(infoReglement.getId());
            infoReglement.setVersion(infoReglementEnBase.getVersion());
        }
        return infoReglementRepository.save(infoReglement);
    }

}
