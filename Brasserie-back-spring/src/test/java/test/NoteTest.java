package test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import brasserie.config.SpringConfig;
import brasserie.model.Biere;
import brasserie.model.Note;
import brasserie.services.NoteService;
import brasserie.services.ProduitService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
class NoteTest {

	@Autowired
	NoteService noteService;
	
	@Autowired
	ProduitService produitService;
	
	@Test //Test fonctionnel !
	@Disabled
	void creationNoteTest() {
		Biere b = (Biere) produitService.getById(12);
		noteService.create(new Note(b, 5.0));
	}
	
	@Test //Test fonctionnel !
	@Disabled
	void updateNoteTest() {
		Note n = noteService.getById(2);
		n.setNote(3.5);
		noteService.update(n);
	}
	
	@Test //Test fonctionnel ! 
	@Disabled
	void getAllNoteTest() {
		noteService.getAll().stream().forEach(n -> {System.out.println(n.getNote());});
	}
	
	@Test //Test fonctionnel ! 
	@Disabled
	void deleteNoteTest() {
		noteService.deleteById(3);
	}

}
