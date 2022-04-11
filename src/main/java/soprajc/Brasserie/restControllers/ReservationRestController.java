
package soprajc.Brasserie.restControllers;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
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

import soprajc.Brasserie.exception.ReservationException;
import soprajc.Brasserie.model.JsonViews;
import soprajc.Brasserie.model.Reservation;
import soprajc.Brasserie.services.ClientService;
import soprajc.Brasserie.services.EvenementService;
import soprajc.Brasserie.services.ReservationService;

@RestController
@RequestMapping("/api/reservation")
public class ReservationRestController {

	@Autowired 
	ReservationService reservationService;
	@Autowired
	ClientService clientService;
	@Autowired
	EvenementService evtService;

	@JsonView(JsonViews.Reservation.class)
	@GetMapping("")
	public List<Reservation> getAll() {
		return reservationService.getAll();
	}
	
	@JsonView(JsonViews.Reservation.class)
	@GetMapping("/{id}")
	public Reservation getById(@PathVariable Integer id) {
		return reservationService.getById(id);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		reservationService.deleteById(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(JsonViews.Reservation.class)
	public Reservation create(@Valid @RequestBody Reservation reservation, BindingResult br) {
		if (br.hasErrors()) {
			throw new ReservationException();
		}
		return save(reservation, br);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Reservation.class)
	public Reservation update(@PathVariable Integer id, @Valid @RequestBody Reservation reservation, BindingResult br) {
		reservation.setId(id);
		return save(reservation, br);
	}

	private Reservation save(Reservation reservation, BindingResult br) {
		if (br.hasErrors()) {
			throw new ReservationException();
		}
		return reservationService.save(reservation);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Reservation.class)
	public Reservation partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Reservation resa = reservationService.getById(id);
		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Reservation.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, resa, value);
		}); // seulement pour le statut, si on veut modifier l'evt on annule puis prend une nouvelle resa
		return reservationService.save(resa);
	}
}


