
package brasserieFront.restcontrollers;

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

import brasserie.exception.ReservationException;
import brasserie.model.JsonViews;
import brasserie.model.Reservation;
import brasserie.services.ReservationService;




@RestController
@RequestMapping("/api/reservation")
public class ReservationRestController {

	@Autowired 
	ReservationService reservationService;

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

}


