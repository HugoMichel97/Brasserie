package brasserie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import test.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}
