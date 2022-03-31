package soprajc.Brasserie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.Brasserie.exception.NoteException;
import soprajc.Brasserie.model.Note;
import soprajc.Brasserie.repositories.NoteRepository;

@Service
public class NoteService {

	@Autowired
	NoteRepository noteRepository;

	public void create(Note n) {

		noteRepository.save(n);
	}

	public void update(Note n) {
		noteRepository.save(n);
	}

	public List<Note> getAll(){
		return noteRepository.findAll();
	}
	
	public Note getById(Integer id) {
		return noteRepository.findById(id).orElseThrow(()-> {throw new NoteException("Numero inconnu");});
	}

	public void deleteByNumero(Integer numero) { 
		noteRepository.deleteById(numero);

	}
}