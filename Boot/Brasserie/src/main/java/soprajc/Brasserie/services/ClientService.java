package soprajc.Brasserie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.Brasserie.exception.ClientException;
import soprajc.Brasserie.model.Client;
import soprajc.Brasserie.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	//@Autowired
	//private ReservationRepository reservationRepository;
	
	public void create(Client c) {
		if (c.getId() != null) {
			throw new ClientException("L'id ne doit pas �tre defini.");
		}
		if (c.getMail() == null || c.getMail().isEmpty()) {
			throw new ClientException("Le mail doit etre defini.");
		}
		clientRepository.save(c);
	}

	public void update(Client c) {
		if (c.getId() == null) {
			throw new ClientException("L'id doit etre defini.");
		}
		if (c.getMail() == null ||c.getMail().isEmpty()) {
			throw new ClientException("Le mail doit etre defini.");
		}
		clientRepository.save(c);
	}

	public List<Client> getAll() {
		return clientRepository.findAll();
	}

	public Client getById(Integer id) {
		return clientRepository.findById(id).orElseThrow(() -> {
			throw new ClientException("Id inconnu.");
		});
	}

	public Client getByIdWithReservation(Integer id) {
		return clientRepository.findByIdWithReservations(id).orElseThrow(() -> {
			throw new ClientException("Id inconnu.");
		});
	}
	
	public Client getByFidelite(int fidelite) {
		return clientRepository.findByFidelite(fidelite).orElseThrow(() -> {
			throw new ClientException("Pas de client avec "+fidelite+" points de fid�lit�.");
		});
	}
	
	public Client getByFideliteSup(int fidelite) {
		return clientRepository.findByFideliteSup(fidelite).orElseThrow(() -> {
			throw new ClientException("Pas de client avec plus de "+fidelite+" points de fid�lit�.");
		});
	}
	
	public Client getByFideliteInf(int fidelite) {
		return clientRepository.findByFideliteSup(fidelite).orElseThrow(() -> {
				throw new ClientException("Pas de client avec moins de "+fidelite+" points de fid�lit�.");
			});
	}

	public void delete(Client c) {
		Client clientEnBase = getById(c.getId());
		//reservationRepository.deleteByClient(clientEnBase);
		clientRepository.delete(clientEnBase);
	}

	public void deleteById(Integer id) {
		Client client = new Client();
		client.setId(id);
		delete(client);
	}

}
