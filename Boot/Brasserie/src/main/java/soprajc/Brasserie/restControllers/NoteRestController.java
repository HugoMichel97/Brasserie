package soprajc.Brasserie.restControllers;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
import soprajc.Brasserie.model.Biere;
import soprajc.Brasserie.model.Client;
import soprajc.Brasserie.model.JsonViews;
import soprajc.Brasserie.model.Note;
import soprajc.Brasserie.model.Produit;
import soprajc.Brasserie.services.ClientService;
import soprajc.Brasserie.services.NoteService;
import soprajc.Brasserie.services.ProduitService;

@RestController
@RequestMapping("/api/note")
@CrossOrigin(origins = "*")
public class NoteRestController {

	@Autowired 
	NoteService noteService;
	@Autowired
	ProduitService produitService;
	
	@Autowired
	ClientService clientService;

	@JsonView(JsonViews.Note.class)
	@GetMapping("")
	public List<Note> getAll() {
		return noteService.getAll();
	}
	
	@JsonView(JsonViews.Note.class)
	@GetMapping("/{id_biere}/byBieres")
	public List<Note> getByBiere(@PathVariable Integer id_biere){
		Produit p = produitService.getById(id_biere);
		if (p instanceof Biere) {
			return noteService.getByBiere((Biere) p);
		} else {
			throw new NoteException("Pas d'évaluation pour les snacks");
		}
	}
	
	@JsonView(JsonViews.Note.class)
	@GetMapping("/{id_client}/byClient")
	public List<Note> getByClient(@PathVariable Integer id_client) {
		Client c = clientService.getById(id_client);
		return noteService.getByClient(c);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id_biere}/moyenne")
	public double[] getMoyenneByBiere(@PathVariable Integer id_biere){
		Produit p = produitService.getById(id_biere);
		if (p instanceof Biere) {
			List<Note> notes = noteService.getByBiere((Biere) p);
			double[] mean = {0, notes.size()};
			for(Note n : notes) {
				mean[0] += n.getNote();
			}
			mean[0] = mean[0]/mean[1];
			return mean;
		} else {
			throw new NoteException("Pas d'évaluation pour les snacks");
		}
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

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Note.class)
	public Note partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Note note = noteService.getById(id);
		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Note.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, note, value);
		});
		return noteService.save(note);
	}
}
