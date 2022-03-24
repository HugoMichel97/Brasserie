package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import brasserie.model.Reservation;
import brasserie.repositories.ReservationRepository;
import brasserie.model.Brasseur;
import brasserie.model.Evenement;
import brasserie.model.Client;

public class ReservationRepoTest {

	@Autowired
	ReservationRepository reservationRepository;
	private Client client2 = new Client("Jane.Doe@test", "test");
	@Test
	void injectionTest() {
		assertNotNull(reservationRepository);
	}
	
	@Test
	@Commit
	void insertTest() {
		Client client1 = new Client("Jane.Doe@client", "client");
		Client client2 = new Client("Jane.Doe@test", "test");
		Client client3 = new Client("Jane.Doe@test1", "test1");
		Brasseur brasseur = new Brasseur("Arthur@test1", "brasseur");
		Evenement evt = new Evenement(LocalDate.now(), LocalTime.now(), "test", 13.8, 0, null, brasseur, null);
		Reservation r = new Reservation(client1,evt);
		reservationRepository.save(r);
		List<Reservation> reservations = Arrays.asList(new Reservation(client2, evt),
				new Reservation(client3, evt));
		reservationRepository.saveAll(reservations);
		
		
	}

	@Test
	@Commit
	void deleteTest() {
		long nbreLigne = reservationRepository.count();
		reservationRepository.deleteById(4);
		assertNotEquals(nbreLigne, reservationRepository.count());
		List<Integer> ids = Arrays.asList(9, 10);
		reservationRepository.deleteAllById(ids);
		assertNotEquals(nbreLigne, reservationRepository.count());
	}
	
	
	@Test
	@Commit
	void updateTest() {
		Reservation r = reservationRepository.findById(4).get();
		r.setClient(client2);
		reservationRepository.save(r);
	}


	@Test
	void equalsTest() {
		Reservation r = reservationRepository.findById(5).orElseThrow();
		Reservation r2 = reservationRepository.findById(5).orElseThrow();
		assertEquals(r, r2);
	}
	
	
//	@Test
//	void selectTest() {
//
//		Optional<Reservation> opt = reservationRepository.findById(4);
//		if (opt.isPresent()) {
//			assertNotNull(opt.get());
//		}
//
//		assertEquals(Optional.empty(), reservationRepository.findById(100));
//
//		assertNotNull(reservationRepository.findById(1).orElseThrow());
//		assertThrows(NoResultException.class, () -> {
//			reservationRepository.findById(100).orElseThrow(NoResultException::new);
//		});
//	}





}

