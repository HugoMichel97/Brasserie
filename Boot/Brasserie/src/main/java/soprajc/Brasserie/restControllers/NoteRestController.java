package soprajc.Brasserie.restControllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import soprajc.Brasserie.exception.NoteException;
import soprajc.Brasserie.exception.ReservationException;
import soprajc.Brasserie.model.JsonViews;
import soprajc.Brasserie.model.Note;
import soprajc.Brasserie.services.NoteService;

@RestController
@RequestMapping("/api/note")
public class NoteRestController {

	@Autowired 
	NoteService noteService;
	
	@JsonView(JsonViews.Note.class)
	@GetMapping("")
	public List<Note> getAll() {
		return noteService.getAll();
	}
	
	@JsonView(JsonViews.Note.class)
	@GetMapping("/{id}")
	public Note getById(@PathVariable Integer id) {
		return noteService.getById(id);
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		noteService.deleteById(id);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(JsonViews.Note.class)
	public Note create(@Valid @RequestBody Note note, BindingResult br) {
		if (br.hasErrors()) {
			throw new NoteException();
		}
		return save(note, br);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Note.class)
	public Note update(@PathVariable Integer id, @Valid @RequestBody Note note, BindingResult br) {
		note.setId_note(id);
		return save(note, br);
	}
	
	private Note save(Note note, BindingResult br) {
		if (br.hasErrors()) {
			throw new ReservationException();
		}
		return noteService.save(note);
	}
}
