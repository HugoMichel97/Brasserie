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

import brasserie.exception.ClientException;
import brasserie.model.Client;
import brasserie.model.JsonViews;
import brasserie.services.ClientService;
import brasserie.services.ReservationService;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {
	
	@Autowired 
	ClientService clientService;
	@Autowired 
	ReservationService reservationService;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Client> getAll() {
		return clientService.getAll();
	}
	
	@JsonView(JsonViews.ClientWithReservation.class)
	@GetMapping("/getResa")
	public List<Client> getAllWithResa(){
		return clientService.getAllWithResa();
	}
	
	@JsonView(JsonViews.ClientWithAchat.class)
	@GetMapping("/getAchat")
	public List<Client> getAllWithAchat(){
		return clientService.getAllWithAchat();
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Client getById(@PathVariable Integer id) {
		return clientService.getById(id);
	}
	
	@JsonView(JsonViews.ClientWithReservation.class)
	@GetMapping("/getResa/{id}")
	public Client getByIdWithResa(@PathVariable Integer id) {
		return clientService.getByIdWithReservation(id);
	}
	
	@JsonView(JsonViews.ClientWithAchat.class)
	@GetMapping("/getAchat/{id}")
	public Client getByIdWithAchat(@PathVariable Integer id) {
		return clientService.getByIdWithAchat(id);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		clientService.deleteById(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(JsonViews.Common.class)
	public Client create(@Valid @RequestBody Client client, BindingResult br) {
		if (br.hasErrors()) {
			throw new ClientException();
		}
		return save(client, br);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Client update(@PathVariable Integer id, @Valid @RequestBody Client client, BindingResult br) {
		client.setId(id);
		return save(client, br);
	}

	private Client save(Client client, BindingResult br) {
		if (br.hasErrors()) {
			throw new ClientException();
		}
		return clientService.save(client);
	}

}
