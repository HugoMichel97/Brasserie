package soprajc.Brasserie.restControllers;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalTime;
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

import soprajc.Brasserie.exception.EvenementException;
import soprajc.Brasserie.model.Client;
import soprajc.Brasserie.model.Evenement;
import soprajc.Brasserie.model.JsonViews;
import soprajc.Brasserie.model.Reservation;
import soprajc.Brasserie.services.EvenementService;
import soprajc.Brasserie.services.ReservationService;

@RestController
@RequestMapping("/api/evenement")
@CrossOrigin(origins="*")
public class EvenementRestController {
	
	@Autowired 
	EvenementService evenementService;
	@Autowired
	ReservationService reservationService;
	
	@JsonView(JsonViews.Evenement.class)
	@GetMapping("")
	public List<Evenement> getAll() {
		return evenementService.getAll();
	}
	
	@JsonView(JsonViews.Evenement.class)
	@GetMapping("/byFidelite/{fidelite}")
	public List<Evenement> getAllByFidelite(@PathVariable int fidelite) {
		return evenementService.getAllByFidelite(fidelite);
	}

	@JsonView(JsonViews.Evenement.class)
	@GetMapping("/byDate/{year}/{month}/{day}")
	public List<Evenement> getAllByDate(@PathVariable int year, @PathVariable int month, @PathVariable int day) {
		return evenementService.getAllByDate(LocalDate.of(year, month, day));
	}
	
	@JsonView(JsonViews.Evenement.class)
	@GetMapping("/{id}")
	public Evenement getById(@PathVariable Integer id) {
		return evenementService.getById(id);
	}
	
	@JsonView(JsonViews.Reservation.class)
	@GetMapping("/{id}/getResa")
	public List<Reservation> getResa(@PathVariable Integer id){
		return reservationService.getByEvt(evenementService.getById(id));
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		evenementService.deleteById(id);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(JsonViews.Evenement.class)
	public Evenement create(@Valid @RequestBody Evenement evenement, BindingResult br) {
		return save(evenement, br);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Evenement.class)
	public Evenement update(@PathVariable Integer id, @Valid @RequestBody Evenement evenement, BindingResult br) {
		evenement.setId(id);
		return save(evenement, br);
	}

	private Evenement save(Evenement evenement, BindingResult br) {
		if (br.hasErrors()) {
			throw new EvenementException();
		}
		return evenementService.save(evenement);
	}
	
	@PatchMapping("/{id}")
	@JsonView(JsonViews.Evenement.class)
	public Evenement partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Evenement evt = evenementService.getById(id);
		fields.forEach((key, value) -> {
			if(key.equals("date")) {
				List<Integer> dateRecup = (List<Integer>) value;
				evt.setDate(LocalDate.of(dateRecup.get(0), dateRecup.get(1), dateRecup.get(2)));
			} else if (key.equals("heure")) {
				List<Integer> heureRecuperee = (List<Integer>) value;
				evt.setHeure(LocalTime.of(heureRecuperee.get(0), heureRecuperee.get(1)));
			} else {
				Field field = ReflectionUtils.findField(Client.class, key);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, evt, value);
			}
		});
		return evenementService.save(evt);
	}
}
