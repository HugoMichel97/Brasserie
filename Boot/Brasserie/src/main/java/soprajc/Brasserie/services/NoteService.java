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
		return noteRepository.findById(id).orElseThrow(()-> {throw new NoteException("Id inconnu");});
	}

	public void deleteById(Integer numero) { 
		noteRepository.deleteById(numero);

	}
	
	public Note save(Note note) {
        if (note.getId_note() != null) {
            Note noteEnBase = getById(note.getId_note());
            note.setVersion(noteEnBase.getVersion());
        }
        return noteRepository.save(note);
    }
	
	
}