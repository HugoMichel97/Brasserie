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

import soprajc.Brasserie.exception.AchatException;
import soprajc.Brasserie.exception.ReservationException;
import soprajc.Brasserie.model.Achat;
import soprajc.Brasserie.model.JsonViews;
import soprajc.Brasserie.services.AchatService;

@RestController
@RequestMapping("/api/achat")
public class AchatRestController {

	@Autowired
	AchatService achatService;
	
	@JsonView(JsonViews.Achat.class)
	@GetMapping("")
	public List<Achat> getAll() {
		return achatService.getAll();
	}
	
	@JsonView(JsonViews.Achat.class)
	@GetMapping("/{id}")
	public Achat getById(@PathVariable Integer id) {
		return achatService.getById(id);
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		achatService.deleteById(id);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(JsonViews.Achat.class)
	public Achat create(@Valid @RequestBody Achat achat, BindingResult br) {
		if (br.hasErrors()) {
			throw new AchatException();
		}
		return save(achat, br);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Achat.class)
	public Achat update(@PathVariable Integer id, @Valid @RequestBody Achat achat, BindingResult br) {
		achat.setId_achat(id);
		return save(achat, br);
	}
	
	private Achat save(Achat achat, BindingResult br) {
		if (br.hasErrors()) {
			throw new ReservationException();
		}
		return achatService.save(achat);
	}


}
