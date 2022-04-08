package soprajc.Brasserie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.Brasserie.exception.ClientException;
import soprajc.Brasserie.model.Client;
import soprajc.Brasserie.model.Note;
import soprajc.Brasserie.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ReservationService resaService;
	@Autowired
	private InfoReglementService infoRegService;
	@Autowired
	private AchatService achatService;
	@Autowired
	private NoteService noteService;
	
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
	
	public List<Client> getByFidelite(int fidelite) {
		return clientRepository.findByFidelite(fidelite);
	}
	public List<Client> getByFideliteSup(int fidelite) {
		return clientRepository.findByFideliteSup(fidelite);
	}
	
	public List<Client> getByFideliteInf(int fidelite) {
		return clientRepository.findByFideliteSup(fidelite);
	}

	public Client getById(Integer id) {
		return clientRepository.findById(id).orElseThrow(() -> {
			throw new ClientException("Id inconnu.");
		});
	}

	public void delete(Client c) {
		Client clientEnBase = getById(c.getId());
		resaService.deleteByClient(clientEnBase);
		infoRegService.deleteByClient(clientEnBase);
		achatService.deleteByClient(clientEnBase);
		List<Note> notes = noteService.getByClient(clientEnBase);
		for(Note n : notes) {
			n.setClient(null);
			noteService.save(n);
		}
		clientRepository.delete(clientEnBase);
	}

	public void deleteById(Integer id) {
		Client client = new Client();
		client.setId(id);
		delete(client);
	}

	public Client save(Client client) {
		if(client.getId() != null) {
			Client clientEnBase = getById(client.getId());
			client.setVersion(clientEnBase.getVersion());
		}
		return clientRepository.save(client);
	}
}
